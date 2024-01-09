package com.example.Nordic_SD118.repository;

import com.example.Nordic_SD118.entity.ChiTietSanPham;
import com.example.Nordic_SD118.entity.Images;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepositoriy extends JpaRepository<Images,Integer> {
    List<Images> findByDetail(ChiTietSanPham chiTietSanPham);
}
