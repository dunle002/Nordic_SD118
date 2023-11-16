package com.example.Nordic_SD118.sevice.imlp;

import com.example.Nordic_SD118.entity.DeGiay;
import com.example.Nordic_SD118.entity.MauSac;
import com.example.Nordic_SD118.repository.DeGiayRepository;
import com.example.Nordic_SD118.repository.MauSacRepository;
import com.example.Nordic_SD118.sevice.DeGiaySevice;
import com.example.Nordic_SD118.sevice.MauSacSevice;
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
    public Optional<DeGiay> getOne(Integer id) {
        return repository.findById(id);
    }
}
