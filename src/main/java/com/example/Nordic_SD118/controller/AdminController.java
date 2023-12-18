package com.example.Nordic_SD118.controller;

import java.util.Optional;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/admin")
public class AdminController {


    @RequestMapping("/view")
    public String shopHome(Model model,
                           @RequestParam(defaultValue = "0", name = "page") Integer num,
                           @RequestParam("field") Optional<String> field) {
//        Sort sort = Sort.by(Direction.DESC, field.orElse("id"));
//        model.addAttribute("field", field.orElse("id"));
//        Pageable pageable = PageRequest.of(num, 5, sort);
//        Page<SanPham> list = sevice.getAll(pageable);
//
//        List<LoaiGiay> listLoai = repository.findAll();
//        model.addAttribute("product", list);
//        model.addAttribute("loaiDay", listLoai);
        return "admin-home";
    }
}
