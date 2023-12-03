package com.example.Nordic_SD118.repository;

import com.example.Nordic_SD118.entity.GioHangChiTiet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GioHangCTRepository extends JpaRepository<GioHangChiTiet,Integer> {
//    void deleteById(String keyword);
}
