package com.example.Nordic_SD118.repository;

import com.example.Nordic_SD118.entity.NguoiDung;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NguoiDungRepository extends JpaRepository<NguoiDung,Integer> {
    NguoiDung findByHoTen(String hoTen);
}
