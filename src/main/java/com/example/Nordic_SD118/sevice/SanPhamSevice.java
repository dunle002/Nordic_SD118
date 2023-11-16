package com.example.Nordic_SD118.sevice;

import com.example.Nordic_SD118.entity.MauSac;
import com.example.Nordic_SD118.entity.SanPham;
import java.util.List;
import java.util.Optional;

public interface SanPhamSevice {
    public List<SanPham> getAll();
    public Optional<SanPham> getOne(Integer id);
    public  void delete (SanPham id);
    public SanPham SaveOrUpdate(SanPham sanPham);
}
