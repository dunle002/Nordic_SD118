package com.example.Nordic_SD118.sevice.imlp;

import com.example.Nordic_SD118.entity.LoaiGiay;
import com.example.Nordic_SD118.repository.LoaiGiayRepository;
import com.example.Nordic_SD118.sevice.LoaiGiaySevice;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoaiGiayImlp implements LoaiGiaySevice {

    @Autowired
    LoaiGiayRepository repository;

    @Override
    public List<LoaiGiay> getAll() {
        return repository.findAll();
    }

    @Override
    public LoaiGiay getOne(Integer id) {
        Optional<LoaiGiay> kichCo = repository.findById(id);
        if (kichCo.isPresent()) {
            return kichCo.get();
        } else {
            return null;
        }
    }

    @Override
    public boolean add(LoaiGiay id) {
        LoaiGiay kichCo = new LoaiGiay();
        kichCo.setId(id.getId());
        kichCo.setTenTheLoai(id.getTenTheLoai().trim());
        kichCo.setMa(generateUniqueProductCode());
        kichCo.setTrangThai(id.getTrangThai());
        if (repository.existsByTenTheLoaiLike(kichCo.getTenTheLoai().trim())) {
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
    public void remove(LoaiGiay id) {
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
