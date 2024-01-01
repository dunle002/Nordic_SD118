package com.example.Nordic_SD118.repository;

import com.example.Nordic_SD118.entity.NguoiDung;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NguoiDungRepository extends JpaRepository<NguoiDung,Integer> {
    NguoiDung findByHoTen(String hoTen);
    @Query("SELECT u FROM NguoiDung u WHERE u.email = ?1")
    NguoiDung findByEmail(String email);

}
