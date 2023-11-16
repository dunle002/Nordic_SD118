package com.example.Nordic_SD118.controller;

import com.example.Nordic_SD118.entity.LoaiGiay;
import com.example.Nordic_SD118.entity.SanPham;
import com.example.Nordic_SD118.repository.LoaiGiayRepository;
import com.example.Nordic_SD118.sevice.SanPhamSevice;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/product")
public class ProductConttroller {

    @Autowired
    private SanPhamSevice sevice;
    @Autowired
    private LoaiGiayRepository repository;

    @RequestMapping("/crud")
    public String shopHome(Model model) {
        List<SanPham> list = sevice.getAll();
        List<LoaiGiay> listLoai = repository.findAll();
        model.addAttribute("product", list);
        model.addAttribute("loaiDay", listLoai);
        return "crud";
    }

    @PostMapping("/add")
    public String newProduct(Model model, @ModelAttribute("product") SanPham sanPham) {
        sevice.SaveOrUpdate(sanPham);
        return "redirect:crud";
    }

}
