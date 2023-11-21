package com.example.Nordic_SD118.controller;

import com.example.Nordic_SD118.entity.ChiTietSanPham;
import com.example.Nordic_SD118.entity.SanPham;


import com.example.Nordic_SD118.repository.ChiTietSPRepository;
import com.example.Nordic_SD118.repository.LoaiGiayRepository;
import com.example.Nordic_SD118.repository.SanPhamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class WebHomeController {
    @Autowired
    private LoaiGiayRepository loaiGiayRepository;
    @Autowired
    private SanPhamRepository sanPhamRepository;
    @Autowired
    private ChiTietSPRepository chiTietSPRepository;
    @RequestMapping(value = {"/","/home","/index"})
    public String Homepage(Model model){
        List<SanPham> sanPham =sanPhamRepository.findAll();
        model.addAttribute("sp",sanPham);
        return "index";
    }
    @RequestMapping("/shop")
    public String ShopHome(@RequestParam(defaultValue = "0",name = "page") Integer number, Model model){
        Pageable pageable = PageRequest.of(number,8);
        Page<SanPham> list = sanPhamRepository.findAll(pageable);
        model.addAttribute("listSp",list);
        return "shop";
    }
    @RequestMapping("/detail/{id}")
    public String detail(Model model, @PathVariable("id") String id) {
        try {
            int idValue = Integer.parseInt(id);
            ChiTietSanPham chiTietSanPham = chiTietSPRepository.findById(idValue).orElse(null);

            if (chiTietSanPham != null) {
                model.addAttribute("spt", chiTietSanPham);
                return "detail";
            } else {
                return "not-found-page";
            }
        } catch (NumberFormatException e) {
            // Xử lý khi không thể chuyển đổi thành số
            e.printStackTrace();
            // Chuyển hướng đến trang lỗi
            return "error-page";
        }
    }
    @RequestMapping("/about")
    public String about(){
        return "about";
    }
    @RequestMapping("/blog")
    public String blog(){
        return "blog";
    }
    @RequestMapping("/contact")
    public String contact(){
        return "contact";
    }
}
