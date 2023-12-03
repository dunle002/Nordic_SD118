package com.example.Nordic_SD118.controller;

import com.example.Nordic_SD118.entity.ChiTietSanPham;
import com.example.Nordic_SD118.entity.GioHang;
import com.example.Nordic_SD118.entity.GioHangChiTiet;
import com.example.Nordic_SD118.entity.SanPham;


import com.example.Nordic_SD118.repository.*;
//import com.example.Nordic_SD118.sevice.ChiTietSanPhamService;
//import com.example.Nordic_SD118.sevice.GioHangService;
import com.example.Nordic_SD118.sevice.GioHangCtService;
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
@RequestMapping("/")
public class WebHomeController {
    @Autowired
    private SanPhamSevice sanPhamSevice;
    @Autowired
    private SanPhamRepository sanPhamRepository;
    @Autowired
    private ChiTietSPRepository repository;
    @Autowired
    private GioHangRepository gioHangRepository;
    @Autowired
    private GioHangCtService gioHangCtService;
    @Autowired
    private GioHangCTRepository gioHangCTRepository;

    @RequestMapping("home")
    public String Homepage(Model model) {
        List<SanPham> sanPham = sanPhamRepository.findAll();
        model.addAttribute("sp", sanPham);
        return "index";
    }

    @RequestMapping("detail/{id}")
    public String detail(Model model, @PathVariable("id") String id) {
        try {
            int idValue = Integer.parseInt(id);
            ChiTietSanPham chiTietSanPham = repository.findById(idValue).orElse(null);
            if (chiTietSanPham != null) {
                model.addAttribute("spt", chiTietSanPham);
                return "product-single";
            } else {
                return "not-found-page";
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return "error-page";
        }
    }

    @RequestMapping("shop")
    public String ShopHome(@RequestParam(defaultValue = "0", name = "page") Integer number, Model model) {
        Pageable pageable = PageRequest.of(number, 9);
        Page<SanPham> list = sanPhamRepository.findAll(pageable);
        model.addAttribute("listSp", list);
        return "shop";
    }

    //    @RequestMapping("/cart")
//    public String addToCart(){
//        return "cart";
//    }
    @RequestMapping("cart")
    private String chuyenTrang(Model model) {
        List<GioHangChiTiet> listGioHangChiTiet = gioHangCtService.listGioHangChiTiets();
        BigDecimal tongTien = BigDecimal.valueOf(0);
        List<GioHangChiTiet> list = gioHangCTRepository.findAll();
        for (int i = 0; i < list.size(); i++) {
            tongTien = tongTien.add(list.get(i).getDonGia());
        }
        model.addAttribute("listGioHangChiTiet", listGioHangChiTiet);
        model.addAttribute("tongTien", tongTien);
        return "cart";
    }

    @GetMapping()
    public String viewGioHang(Model model) {
        return chuyenTrang(model);
    }

    @GetMapping("add/{id}")
    public String addGioHang(Model model, @PathVariable(name = "id") Integer id, String hoTen) {
        gioHangCtService.addSanPhamVaoGio(id, hoTen);
        return chuyenTrang(model);
    }

    @RequestMapping("about")
    public String about() {
        return "about";
    }

    @RequestMapping("blog")
    public String blog() {
        return "blog";
    }

    @RequestMapping("contact")
    public String contact() {
        return "contact";
    }

}
