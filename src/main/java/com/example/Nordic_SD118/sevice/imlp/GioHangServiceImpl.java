package com.example.Nordic_SD118.sevice.imlp;

import com.example.Nordic_SD118.entity.GioHang;
import com.example.Nordic_SD118.entity.SanPham;
import com.example.Nordic_SD118.repository.GioHangRepository;
import com.example.Nordic_SD118.repository.SanPhamRepository;
import com.example.Nordic_SD118.sevice.GioHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GioHangServiceImpl implements GioHangService {
    @Autowired
    private SanPhamRepository sanPhamRepository;

//    @Override
//    public void addToCart(Integer productId) {
//        SanPham sanPham = sanPhamRepository.findById(productId).orElse(null);
//        if (sanPham != null) {
//            GioHang gioHang = get
//        }
//    }
}
