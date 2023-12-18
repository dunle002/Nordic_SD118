package com.example.Nordic_SD118.repository;


import com.example.Nordic_SD118.entity.DeGiay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeGiayRepository extends JpaRepository<DeGiay,Integer> {
}
