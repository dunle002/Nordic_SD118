package com.example.Nordic_SD118.sevice.imlp;

import com.example.Nordic_SD118.entity.MauSac;
import com.example.Nordic_SD118.repository.MauSacRepository;
import com.example.Nordic_SD118.sevice.MauSacSevice;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MauSacImlp implements MauSacSevice {

    @Autowired
    MauSacRepository repository;

    @Override
    public List<MauSac> getAll() {
        return repository.findAll();
    }

    @Override
    public MauSac getOne(Integer id) {
        Optional<MauSac> kichCo = repository.findById(id);
        if (kichCo.isPresent()) {
            return kichCo.get();
        } else {
            return null;
        }
    }

    @Override
    public boolean add(MauSac id) {
        MauSac kichCo = new MauSac();
        kichCo.setId(id.getId());
        kichCo.setTenMau(id.getTenMau().trim());
        kichCo.setMa(generateUniqueProductCode());
        kichCo.setTrangThai(id.getTrangThai());
        if (repository.existsByTenMauLike(kichCo.getTenMau().trim())) {
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
    public void remove(MauSac id) {
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
