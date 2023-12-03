package com.example.Nordic_SD118.sevice;

import com.example.Nordic_SD118.entity.ChiTietSanPham;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ChiTietSanPhamService {
    public int add(ChiTietSanPham chiTietSanPham);
    public int remove(int id);
    public List<ChiTietSanPham> getAll();
    public ChiTietSanPham findChiTietSanPhamById(int id);
}
