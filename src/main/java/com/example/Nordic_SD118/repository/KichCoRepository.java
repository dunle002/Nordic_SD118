package com.example.Nordic_SD118.repository;


import com.example.Nordic_SD118.entity.ChatLieu;
import com.example.Nordic_SD118.entity.KichCo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KichCoRepository extends JpaRepository<KichCo,Integer> {
}
