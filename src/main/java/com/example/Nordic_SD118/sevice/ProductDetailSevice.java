package com.example.Nordic_SD118.sevice;


import com.example.Nordic_SD118.entity.ChiTietSanPham;
import com.example.Nordic_SD118.entity.SanPham;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductDetailSevice {
    public List<ChiTietSanPham> getAll();
    public Page<ChiTietSanPham> getAll(Pageable pageable);
    public ChiTietSanPham getOne(Integer id);
    public  void delete (ChiTietSanPham id);
    public ChiTietSanPham Save(ChiTietSanPham detail);
    public ChiTietSanPham update(ChiTietSanPham detail);
}
