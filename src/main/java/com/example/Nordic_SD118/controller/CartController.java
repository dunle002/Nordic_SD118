//package com.example.Nordic_SD118.controller;
//
//import com.example.Nordic_SD118.entity.ChiTietSanPham;
//import com.example.Nordic_SD118.entity.GioHang;
//import com.example.Nordic_SD118.entity.GioHangChiTiet;
//import com.example.Nordic_SD118.entity.SanPham;
//import com.example.Nordic_SD118.repository.ChiTietSPRepository;
//import com.example.Nordic_SD118.repository.GioHangCTRepository;
//import com.example.Nordic_SD118.sevice.GioHangService;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//
//import java.math.BigDecimal;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//import java.util.logging.Logger;
//
//@Controller
//public class CartController {
//    @Autowired
//    private GioHangService gioHangService;
//
//    public String viewCart(Model model){
//        GioHang gioHang = gioHangService.getCurrentTrue();
//        model.addAttribute("cart", gioHang);
//        return "cart";
//    }
//
//
//
//}
