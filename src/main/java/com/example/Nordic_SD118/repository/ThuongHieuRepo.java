package com.example.Nordic_SD118.repository;

import com.example.Nordic_SD118.entity.ThuongHieu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ThuongHieuRepo extends JpaRepository<ThuongHieu, Integer> {
    boolean existsByTenThuongHieuLike(String s);
}
