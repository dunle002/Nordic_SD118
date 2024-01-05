package com.example.Nordic_SD118.repository;

import com.example.Nordic_SD118.entity.LoaiGiay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoaiGiayRepository extends JpaRepository<LoaiGiay,Integer> {
    boolean existsByTenTheLoaiLike(String s);
    boolean existsByMa(String ma);
}
