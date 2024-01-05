package com.example.Nordic_SD118.controller;

import com.example.Nordic_SD118.config.VNPayService;
import com.example.Nordic_SD118.entity.ChiTietSanPham;
import com.example.Nordic_SD118.entity.GioHangChiTiet;
import com.example.Nordic_SD118.entity.SanPham;
import com.example.Nordic_SD118.repository.GioHangCTRepository;
import com.example.Nordic_SD118.repository.GioHangRepository;
import com.example.Nordic_SD118.repository.ProductDetailRepositori;
import com.example.Nordic_SD118.repository.SanPhamRepository;
import com.example.Nordic_SD118.sevice.GioHangCtService;
import com.example.Nordic_SD118.sevice.ProductDetailSevice;
import com.example.Nordic_SD118.sevice.SanPhamSevice;
import com.example.Nordic_SD118.sevice.imlp.DetailProductImlp;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.util.List;

@Controller
public class WebHomeController {
    @Autowired
    private ProductDetailSevice productDetailSevice;
    @Autowired
    private SanPhamRepository sanPhamRepository;
    @Autowired
    private ProductDetailRepositori repository;
    @Autowired
    private GioHangRepository gioHangRepository;
    @Autowired
    private GioHangCtService gioHangCtService;
    @Autowired
    private GioHangCTRepository gioHangCTRepository;
    @Autowired
    private VNPayService vnPayService;

    @RequestMapping("/home")
    public String Homepage(Model model) {
        List<ChiTietSanPham> sanPham = repository.findAll();
        model.addAttribute("sp", sanPham);
        return "index";
    }

    @RequestMapping("/detail/{id}")
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

    @RequestMapping("/shop")
    public String ShopHome(@RequestParam(defaultValue = "0", name = "page") Integer number, Model model) {
        Pageable pageable = PageRequest.of(number, 9);
        Page<ChiTietSanPham> list = productDetailSevice.getAll(pageable);
        model.addAttribute("listSp", list);
        return "shop";
    }

    @RequestMapping("/cart")
    private String chuyenTrang(Model model) {
        List<GioHangChiTiet> listGioHangChiTiet = gioHangCtService.listGioHangChiTiets();
        BigDecimal tongTien = BigDecimal.valueOf(0);
        List<GioHangChiTiet> list = gioHangCTRepository.findAll();
        for (int i = 0; i < list.size(); i++) {
//            tongTien = tongTien.add(list.get(i).getDonGia());
        }
        if (list.isEmpty()) {
            model.addAttribute("cartEmptyMessage", "Giỏ hàng của bạn trống");
        } else {
            model.addAttribute("listGioHangChiTiet", listGioHangChiTiet);
            model.addAttribute("tongTien", tongTien);
        }

        return "cart";
    }

    @GetMapping()
    public String viewGioHang(Model model) {
        return chuyenTrang(model);
    }

    @GetMapping("/add/{id}")
    public String addGioHang(Model model, @PathVariable(name = "id") Integer id, String hoTen) {
        gioHangCtService.addSanPhamVaoGio(id, hoTen);
        return chuyenTrang(model);
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id){
        gioHangCTRepository.deleteById(id);
        return "redirect:/cart";
    }

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
    @RequestMapping("/checkout")
    public String checkout() {
        return "checkout";
    }

}
