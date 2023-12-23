package com.example.Nordic_SD118.controller;

import jakarta.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/image")
public class ImageController {

    private static final String UPLOAD_DIRECTORY = "/Nordic_SD118_/upload/";

    @GetMapping("/create")
    public String showCreateImageForm() {
        return "add-product";
    }

    @PostMapping("/add")
    public String addImage(@RequestParam("file") MultipartFile file, Model model) {
        if (!file.isEmpty()) {
            try {
                String fileName = file.getOriginalFilename();
                Path filePath = Path.of(UPLOAD_DIRECTORY + fileName);
                Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
                System.out.println(filePath);
                String imageUrl = "image"+fileName;
                model.addAttribute("imageUrl", imageUrl);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return "redirect:/image/create";
    }

    private String getBaseUrl() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String baseUrl = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
        return baseUrl;
    }
}
