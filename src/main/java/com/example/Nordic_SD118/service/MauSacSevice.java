package com.example.Nordic_SD118.service;

import com.example.Nordic_SD118.entity.MauSac;
import java.util.List;
import java.util.Optional;

public interface MauSacSevice {
    public List<MauSac> getAll();
    public Optional<MauSac> getOne(Integer id);
}
