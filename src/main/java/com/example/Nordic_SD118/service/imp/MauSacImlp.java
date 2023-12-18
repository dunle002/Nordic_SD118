package com.example.Nordic_SD118.service.imp;

import com.example.Nordic_SD118.entity.MauSac;
import com.example.Nordic_SD118.repository.MauSacRepository;
import com.example.Nordic_SD118.service.MauSacSevice;
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
    public Optional<MauSac> getOne(Integer id) {
        return repository.findById(id);
    }
}
