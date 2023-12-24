package com.example.Nordic_SD118.repository;

import com.example.Nordic_SD118.entity.SanPham;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SanPhamRepository extends JpaRepository<SanPham,Integer> {
    boolean existsByMa(String ma);
}
