package com.example.Nordic_SD118.repository;


import com.example.Nordic_SD118.entity.ChatLieu;
import com.example.Nordic_SD118.entity.MauSac;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MauSacRepository extends JpaRepository<MauSac,Integer> {
}
