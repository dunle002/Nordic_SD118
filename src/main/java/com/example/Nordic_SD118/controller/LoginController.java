package com.example.Nordic_SD118.controller;

import com.example.Nordic_SD118.entity.NguoiDung;
import com.example.Nordic_SD118.repository.NguoiDungRepository;
import com.example.Nordic_SD118.sevice.NguoiDungService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
    @Autowired
    private NguoiDungRepository nguoiDungRepository;

    @GetMapping("")
    public String viewHomePage() {
        return "homepage";
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("user", new NguoiDung());
        return "register";
    }

    @PostMapping("/saveUser")
    public String saveUser(NguoiDung nguoiDung, HttpSession session, Model model) {
        nguoiDungRepository.save(nguoiDung);
        return "redirect:/register";
    }

}
