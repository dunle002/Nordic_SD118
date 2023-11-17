package com.example.Nordic_SD118.sevice;

import com.example.Nordic_SD118.entity.MauSac;
import com.example.Nordic_SD118.entity.SanPham;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SanPhamSevice {
    public Page<SanPham> getAll(Pageable pageable);
    public SanPham getOne(Integer id);
    public  void delete (SanPham id);
    public SanPham SaveOrUpdate(SanPham sanPham);
}
