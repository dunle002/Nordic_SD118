package com.example.Nordic_SD118.controller;

import com.example.Nordic_SD118.entity.LoaiGiay;
import com.example.Nordic_SD118.entity.SanPham;
import com.example.Nordic_SD118.repository.LoaiGiayRepository;
import com.example.Nordic_SD118.sevice.SanPhamSevice;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
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
    public String shopHome(Model model,
                           @RequestParam(defaultValue = "0", name = "page") Integer num,
                           @RequestParam("field") Optional<String> field) {
        Sort sort = Sort.by(Direction.DESC, field.orElse("id"));
        model.addAttribute("field", field.orElse("id"));
        Pageable pageable = PageRequest.of(num, 5, sort);
        Page<SanPham> list = sevice.getAll(pageable);

        List<LoaiGiay> listLoai = repository.findAll();
        model.addAttribute("product", list);

        model.addAttribute("loaiDay", listLoai);
        return "crud";
    }

    @PostMapping("/add")
    public String newProduct(Model model, @ModelAttribute("product") SanPham sanPham) {
        sevice.Save(sanPham);
        return "redirect:crud";
    }

    @PostMapping("/update/{id}")
    public String updateProduct(Model model, @ModelAttribute("product") SanPham sanPham,
                                @PathVariable("id") Integer id,
                                @RequestParam(defaultValue = "0", name = "page") Integer num,
                                @RequestParam("field") Optional<String> field
    ) {
        sanPham.setId(id);
        sevice.update(sanPham);
        shopHome(model, num, field);
        return "update";
    }

    @GetMapping("/get/{id}")
    public String getOneProduct(Model model, @PathVariable("id") Integer id,
                                @RequestParam(defaultValue = "0", name = "page") Integer num,
                                @RequestParam("field") Optional<String> field
    ) {
        SanPham sanPham = sevice.getOne(id);
        model.addAttribute("productUpdate", sanPham);
        shopHome(model, num, field);
        return "update";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(Model model, @PathVariable("id") Integer id,
                                @RequestParam(defaultValue = "0", name = "page") Integer num,
                                @RequestParam("field") Optional<String> field
    ) {
        SanPham sanPham = sevice.getOne(id);
        sevice.delete(sanPham);
        shopHome(model, num, field);
        return "redirect:/product/crud";
    }
}
