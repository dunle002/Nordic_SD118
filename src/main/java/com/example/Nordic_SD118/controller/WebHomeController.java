package com.example.Nordic_SD118.controller;

import com.example.Nordic_SD118.entity.SanPham;


import com.example.Nordic_SD118.repository.LoaiGiayRepository;
import com.example.Nordic_SD118.repository.SanPhamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class WebHomeController {
    @Autowired
    private LoaiGiayRepository loaiGiayRepository;
    @Autowired
    private SanPhamRepository sanPhamRepository;
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

}
