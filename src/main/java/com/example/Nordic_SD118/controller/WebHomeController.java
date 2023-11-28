package com.example.Nordic_SD118.controller;

import com.example.Nordic_SD118.entity.ChiTietSanPham;
import com.example.Nordic_SD118.entity.GioHang;
import com.example.Nordic_SD118.entity.GioHangChiTiet;
import com.example.Nordic_SD118.entity.SanPham;


import com.example.Nordic_SD118.repository.ChiTietSPRepository;
import com.example.Nordic_SD118.repository.LoaiGiayRepository;
import com.example.Nordic_SD118.repository.SanPhamRepository;
//import com.example.Nordic_SD118.sevice.ChiTietSanPhamService;
//import com.example.Nordic_SD118.sevice.GioHangService;
import com.example.Nordic_SD118.sevice.SanPhamSevice;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.net.ssl.HandshakeCompletedEvent;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class WebHomeController {
    @Autowired
    private SanPhamSevice sanPhamSevice;
    @Autowired
    private SanPhamRepository sanPhamRepository;
//    @Autowired
//    private ChiTietSanPhamService chiTietSanPhamService;
    @Autowired
    private ChiTietSPRepository repository;
//    @Autowired
//    private GioHangService gioHangService;

    @RequestMapping(value = {"/", "/home", "/index"})
    public String Homepage(Model model) {
        List<SanPham> sanPham = sanPhamRepository.findAll();
        model.addAttribute("sp", sanPham);
        return "index";
    }

    @RequestMapping("/shop")
    public String ShopHome(@RequestParam(defaultValue = "0", name = "page") Integer number, Model model) {
        Pageable pageable = PageRequest.of(number, 9);
        Page<SanPham> list = sanPhamRepository.findAll(pageable);
        model.addAttribute("listSp", list);
        return "shop";
    }

    @RequestMapping("/detail/{id}")
    public String detail(Model model, @PathVariable("id") String id) {
        try {
            int idValue = Integer.parseInt(id);
            ChiTietSanPham chiTietSanPham = repository.findById(idValue).orElse(null);
//            SanPham sanPham = sanPhamRepository.findById(idValue).orElse(null);
            if (chiTietSanPham != null ) {
                model.addAttribute("spt", chiTietSanPham);
                return "detail";
            } else {
                return "not-found-page";
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return "error-page";
        }
    }
//    @PostMapping("/addToCart/{id}")
//    public String addToCart(@PathVariable Integer id){
//        ChiTietSanPham chiTietSanPham = chiTietSanPhamService.getSanPhamById(id);
//        //lấy giỏ hàng hiện tại
//        GioHang gioHang = gioHangService.getCurrentTrue();
//        //thêm sp
//        gioHang.getChiTietSanPhams().add(chiTietSanPham);
//        //lưu giỏ
//        gioHangService.saveGioHang(gioHang);
//        return "redirect:/cart";
//    }
//    @PostMapping("add")
//    public String addCart(@RequestParam("hinhAnh")String hinhAnh,
//                          @RequestParam("donGia")String donGia,
//                          @RequestParam("soLuong")String soLuong,
//                          @RequestParam("sanPham")String sanPhamId,
//                          @RequestParam("sanPham") String tenSanPham){
//        SanPham sanPham = sanPhamRepository.findById(Integer.valueOf(sanPhamId)).orElse(null);
//        ChiTietSanPham chiTietSanPham = ChiTietSanPham.builder()
//                .hinhAnh(hinhAnh)
//                .donGia(BigDecimal.valueOf(Long.parseLong(donGia)))
//                .soLuong(Integer.valueOf(soLuong))
//                .build();
//        chiTietSPRepository.save(chiTietSanPham);
//        return "redirect:/home";
//    }



    @RequestMapping("/about")
    public String about() {
        return "about";
    }

    @RequestMapping("/blog")
    public String blog() {
        return "blog";
    }

    @RequestMapping("/contact")
    public String contact() {
        return "contact";
    }

}
