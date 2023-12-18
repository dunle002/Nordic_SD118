package com.example.Nordic_SD118.service;


import com.example.Nordic_SD118.entity.ChiTietSanPham;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductDetailSevice {
    public List<ChiTietSanPham> getAll();
    public ChiTietSanPham getOne(Integer id);
    public  void delete (ChiTietSanPham id);
    public ChiTietSanPham Save(ChiTietSanPham detail);
    public ChiTietSanPham update(ChiTietSanPham detail);
}
