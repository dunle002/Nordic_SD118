package com.example.Nordic_SD118.sevice;

import com.example.Nordic_SD118.entity.DeGiay;
import com.example.Nordic_SD118.entity.MauSac;
import java.util.List;
import java.util.Optional;

public interface DeGiaySevice {
    public List<DeGiay> getAll();
    public Optional<DeGiay> getOne(Integer id);
}
