package com.example.Nordic_SD118.sevice;

import com.example.Nordic_SD118.entity.KichCo;
import com.example.Nordic_SD118.entity.LoaiGiay;
import java.util.List;
import java.util.Optional;

public interface LoaiGiaySevice {
    public List<LoaiGiay> getAll();
    public Optional<LoaiGiay> getOne(Integer id);
    public boolean add(LoaiGiay id);
    public void remove(LoaiGiay id);
}
