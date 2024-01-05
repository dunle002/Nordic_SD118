package com.example.Nordic_SD118.repository;

import com.example.Nordic_SD118.entity.ChatLieu;
import com.example.Nordic_SD118.entity.ChiTietSanPham;
import com.example.Nordic_SD118.entity.DeGiay;
import com.example.Nordic_SD118.entity.KichCo;
import com.example.Nordic_SD118.entity.MauSac;
import com.example.Nordic_SD118.entity.SanPham;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDetailRepositori extends JpaRepository<ChiTietSanPham, Integer> {
    ChiTietSanPham findBySanPhamAndMauSacAndKichCoAndChatLieuAndDeGiay(SanPham sanPham, MauSac mauSac, KichCo kichCo, ChatLieu chatLieu, DeGiay deGiay);
}
