package com.example.Nordic_SD118.sevice.imlp;

import com.example.Nordic_SD118.entity.DeGiay;
import com.example.Nordic_SD118.repository.DeGiayRepository;
import com.example.Nordic_SD118.sevice.DeGiaySevice;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeGiayImlp implements DeGiaySevice {

    @Autowired
    DeGiayRepository repository;

    @Override
    public List<DeGiay> getAll() {
        return repository.findAll();
    }

    @Override
    public DeGiay getOne(Integer id) {
        Optional<DeGiay> kichCo = repository.findById(id);
        if (kichCo.isPresent()) {
            return kichCo.get();
        } else {
            return null;
        }
    }

    @Override
    public boolean add(DeGiay id) {
        DeGiay kichCo = new DeGiay();
        kichCo.setId(id.getId());
        kichCo.setLoaiDe(id.getLoaiDe().trim());
        kichCo.setMa(generateUniqueProductCode());
        kichCo.setTrangThai(id.getTrangThai());
        if (repository.existsByLoaiDeLike(kichCo.getLoaiDe().trim())) {
            if(kichCo.getId()==null){
                return false;
            }else{
                repository.save(kichCo);
            }

        }
        else {
            repository.save(kichCo);

        }
        return true;
    }

    @Override
    public void remove(DeGiay id) {
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
