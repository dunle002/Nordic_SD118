package com.example.Nordic_SD118.service;

import com.example.Nordic_SD118.entity.KichCo;
import java.util.List;
import java.util.Optional;

public interface KichCoSevice {
    public List<KichCo> getAll();
    public Optional<KichCo> getOne(Integer id);
}