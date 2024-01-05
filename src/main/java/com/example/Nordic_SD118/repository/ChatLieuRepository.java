package com.example.Nordic_SD118.repository;


import com.example.Nordic_SD118.entity.ChatLieu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatLieuRepository extends JpaRepository<ChatLieu,Integer> {
    boolean existsByTenChatLieuIsLike(String s);
    boolean existsByMa(String ma);
}
