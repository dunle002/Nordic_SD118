package com.example.Nordic_SD118.sevice.imlp;

import com.example.Nordic_SD118.entity.KichCo;
import com.example.Nordic_SD118.repository.KichCoRepository;
import com.example.Nordic_SD118.sevice.KichCoSevice;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KichCoImlp implements KichCoSevice {

    @Autowired
    KichCoRepository repository;

    @Override
    public List<KichCo> getAll() {
        return repository.findAll();
    }

    @Override
    public KichCo getOne(Integer id) {
        Optional<KichCo> kichCo = repository.findById(id);
        if (kichCo.isPresent()) {
            return kichCo.get();
        } else {
            return null;
        }

    }

    @Override
    public boolean add(KichCo id) {
        KichCo kichCo = new KichCo();
        kichCo.setId(id.getId());
        kichCo.setSize(id.getSize().trim());
        kichCo.setMa(generateUniqueProductCode());
        kichCo.setTrangThai(id.getTrangThai());
        if (repository.existsBySizeLike(kichCo.getSize().trim())) {
            if (kichCo.getId() == null) {
                return false;
            } else {
                repository.save(kichCo);
            }
        } else {
            repository.save(kichCo);

        }
        return true;
    }

    @Override
    public void remove(KichCo id) {
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
