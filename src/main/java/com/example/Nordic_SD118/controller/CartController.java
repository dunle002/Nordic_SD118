package com.example.Nordic_SD118.controller;

import com.example.Nordic_SD118.entity.GioHangChiTiet;
import com.example.Nordic_SD118.repository.GioHangCTRepository;
import com.example.Nordic_SD118.repository.GioHangRepository;
import com.example.Nordic_SD118.repository.SanPhamRepository;
import com.example.Nordic_SD118.sevice.GioHangCtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigDecimal;
import java.util.List;

@Controller
@RequestMapping("/giohang")
public class CartController {
    @Autowired
    private SanPhamRepository sanPhamRepository;
    @Autowired
    private GioHangRepository gioHangRepository;
    @Autowired
    private GioHangCtService gioHangCtService;
    @Autowired
    private GioHangCTRepository gioHangCTRepository;
//    @RequestMapping("/cart")
//    private String chuyenTrang(Model model){
//        List<GioHangChiTiet> listGioHangChiTiet = gioHangCtService.listGioHangChiTiets();
//        BigDecimal tongTien = BigDecimal.valueOf(0);
//        List<GioHangChiTiet> list = gioHangCTRepository.findAll();
//        for (int i = 0; i < list.size(); i++) {
//            tongTien = tongTien.add(list.get(i).getDonGia());
//        }
//        model.addAttribute("listGioHangChiTiet",listGioHangChiTiet);
//        model.addAttribute("tongTien",tongTien);
//        return "cart";
//    }
//    @GetMapping()
//    public String viewGioHang(Model model){
//        return chuyenTrang(model);
//    }
//    @GetMapping("/add/{id}")
//    public String addGioHang(Model  model, @PathVariable(name = "id") Integer id,String hoTen){
//        gioHangCtService.addSanPhamVaoGio(id,hoTen);
//        return chuyenTrang(model);
//    }

}
