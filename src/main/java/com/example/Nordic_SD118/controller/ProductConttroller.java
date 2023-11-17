package com.example.Nordic_SD118.controller;

import com.example.Nordic_SD118.entity.LoaiGiay;
import com.example.Nordic_SD118.entity.SanPham;
import com.example.Nordic_SD118.repository.LoaiGiayRepository;
import com.example.Nordic_SD118.sevice.SanPhamSevice;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/product")
public class ProductConttroller {

    @Autowired
    private SanPhamSevice sevice;
    @Autowired
    private LoaiGiayRepository repository;

    @RequestMapping("/crud")
    public String shopHome(Model model, @RequestParam(defaultValue = "0", name = "page") Integer num) {
        Pageable pageable = PageRequest.of(num, 5);
        Page<SanPham> list = sevice.getAll(pageable);
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

    @GetMapping("/get/{id}")
    public String getOneProduct(Model model, @PathVariable("id") Integer id, @RequestParam(defaultValue = "0", name = "page") Integer num) {
        SanPham sanPham = sevice.getOne(id);
        model.addAttribute("productUpdate", sanPham);
        shopHome(model, num);
        return "crud";
    }
}
