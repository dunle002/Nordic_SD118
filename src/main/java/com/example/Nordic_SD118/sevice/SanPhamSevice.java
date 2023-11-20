package com.example.Nordic_SD118.sevice;


import com.example.Nordic_SD118.entity.SanPham;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SanPhamSevice {
    public Page<SanPham> getAll(Pageable pageable);
    public List<SanPham> getAll();
    public SanPham getOne(Integer id);
    public  void delete (SanPham id);
    public SanPham Save(SanPham sanPham);
    public SanPham update(SanPham sanPham);
}
