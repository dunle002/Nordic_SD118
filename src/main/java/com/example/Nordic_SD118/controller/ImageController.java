package com.example.Nordic_SD118.controller;

import com.example.Nordic_SD118.repository.DeGiayRepository;
import jakarta.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/image")
public class ImageController {
@Autowired
    DeGiayRepository repository;
    @GetMapping("/product")
    public String ProductDetail() {
        return "test";
    }

    @GetMapping("/productDetail")
    public ModelAndView getProductDetail(@RequestParam("id") int productId) {
        ModelAndView modelAndView = new ModelAndView("productDetail");
        modelAndView.addObject("productId", productId);
        modelAndView.addObject("productName", "Product " + productId);
        modelAndView.addObject("productDescription", "This is the detail of Product " + productId);
        return modelAndView;
    }
}
