package com.example.Nordic_SD118.sevice.imlp;

import com.example.Nordic_SD118.entity.ChatLieu;
import com.example.Nordic_SD118.repository.ChatLieuRepository;
import com.example.Nordic_SD118.sevice.ChatLieuSevice;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChatLieuImlp implements ChatLieuSevice {

    @Autowired
    ChatLieuRepository repository;

    @Override
    public List<ChatLieu> getAll() {
        return repository.findAll();
    }

    @Override
    public ChatLieu getOne(Integer id) {
        Optional<ChatLieu> kichCo = repository.findById(id);
        if (kichCo.isPresent()) {
            return kichCo.get();
        } else {
            return null;
        }
    }

    @Override
    public boolean add(ChatLieu id) {
        ChatLieu kichCo = new ChatLieu();
        kichCo.setId(id.getId());
        kichCo.setTenChatLieu(id.getTenChatLieu().trim());
        kichCo.setMa(generateUniqueProductCode());
        kichCo.setTrangThai(id.getTrangThai());
        if (repository.existsByTenChatLieuIsLike(kichCo.getTenChatLieu().trim())) {
            if(kichCo.getId()==null){
                return false;
            }else{
                repository.save(kichCo);
            }
        } else {
            repository.save(kichCo);
        }
        return true;
    }

    @Override
    public void remove(ChatLieu id) {
        repository.delete(id);
    }

    public String generateUniqueProductCode() {
        String prefix = "SP";
        String productCode;
        do {
            String randomCode = generateRandomCode();
            productCode = prefix + randomCode;
        } while (repository.existsByMa(productCode));

        return productCode;
    }

    private String generateRandomCode() {
        String numbers = "0123456789";
        String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        StringBuilder randomCode = new StringBuilder();

        // Sinh ra 2 số ngẫu nhiên
        for (int i = 0; i < 5; i++) {
            int randomIndex = (int) (Math.random() * numbers.length());
            randomCode.append(numbers.charAt(randomIndex));
        }

        // Sinh ra 2 chữ ngẫu nhiên
        for (int i = 0; i < 5; i++) {
            int randomIndex = (int) (Math.random() * letters.length());
            randomCode.append(letters.charAt(randomIndex));
        }

        return randomCode.toString();

    }
}
