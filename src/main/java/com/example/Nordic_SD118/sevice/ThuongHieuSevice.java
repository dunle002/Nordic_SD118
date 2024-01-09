package com.example.Nordic_SD118.sevice;

import com.example.Nordic_SD118.entity.DeGiay;
import com.example.Nordic_SD118.entity.MauSac;
import com.example.Nordic_SD118.entity.ThuongHieu;
import java.util.List;
import java.util.Optional;

public interface ThuongHieuSevice {
    public List<ThuongHieu> getAll();
    public ThuongHieu getOne(Integer id);
    public boolean add(ThuongHieu id);
    public void remove(ThuongHieu id);
}
