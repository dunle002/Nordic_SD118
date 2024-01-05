package com.example.Nordic_SD118.controller;

import com.example.Nordic_SD118.entity.ChatLieu;
import com.example.Nordic_SD118.entity.DeGiay;
import com.example.Nordic_SD118.entity.KichCo;
import com.example.Nordic_SD118.entity.LoaiGiay;
import com.example.Nordic_SD118.entity.MauSac;
import com.example.Nordic_SD118.entity.ThuongHieu;
import com.example.Nordic_SD118.sevice.ChatLieuSevice;
import com.example.Nordic_SD118.sevice.DeGiaySevice;
import com.example.Nordic_SD118.sevice.KichCoSevice;
import com.example.Nordic_SD118.sevice.LoaiGiaySevice;
import com.example.Nordic_SD118.sevice.MauSacSevice;
import com.example.Nordic_SD118.sevice.ThuongHieuSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ThuocTinhController {
    @Autowired
    public KichCoSevice kichCoSevice;
    @Autowired
    public DeGiaySevice deGiaySevice;
    @Autowired
    public LoaiGiaySevice loaiGiaySevice;
    @Autowired
    public MauSacSevice mauSacSevice;
    @Autowired
    public ThuongHieuSevice thuongHieuSevice;
    @Autowired
    public ChatLieuSevice chatLieuSevice;


    @RequestMapping("/kich-co/view")
    public String viewKichCo(Model model
    ) {
        return "add-kich-co";
    }

    @PostMapping("/kich-co/add")
    public String KichCo(Model model,
                         @ModelAttribute("kichCoAdd") KichCo kichCo,
                         @RequestParam("trangThai") Integer trangThai,
                         RedirectAttributes redirectAttributes
    ) {
        kichCo.setTrangThai(trangThai);

        if (kichCoSevice.add(kichCo)) {
            redirectAttributes.addFlashAttribute("alertType", "error");
            redirectAttributes.addFlashAttribute("alertMessage", "Thêm thành công.");
        } else {
            redirectAttributes.addFlashAttribute("alertType", "error");
            redirectAttributes.addFlashAttribute("alertMessage", "Thêm thất bại.");
        }

        return "redirect:/product/view-add";
    }

    //Màu sắc
    @RequestMapping("/mau-sac/view")
    public String viewMauSac(Model model
    ) {
        return "add-mau-sac";
    }

    @PostMapping("/mau-sac/add")
    public String MauSac(Model model,
                         @ModelAttribute("mauSacAdd") MauSac kichCo,
                         RedirectAttributes redirectAttributes
    ) {

        if (mauSacSevice.add(kichCo)) {
            redirectAttributes.addFlashAttribute("alertType", "error");
            redirectAttributes.addFlashAttribute("alertMessage", "Thêm thành công.");
        } else {
            redirectAttributes.addFlashAttribute("alertType", "error");
            redirectAttributes.addFlashAttribute("alertMessage", "Thêm thất bại.");
        }

        return "redirect:/product/view-add";
    }

    //Chất liệu
    @RequestMapping("/chat-lieu/view")
    public String viewChatLieu(Model model
    ) {
        return "add-chat-lieu";
    }

    @PostMapping("/chat-lieu/add")
    public String ChatLieu(Model model,
                           @ModelAttribute("chatLieuAdd") ChatLieu kichCo,
                           RedirectAttributes redirectAttributes
    ) {

        if (chatLieuSevice.add(kichCo)) {
            redirectAttributes.addFlashAttribute("alertType", "error");
            redirectAttributes.addFlashAttribute("alertMessage", "Thêm thành công.");
        } else {
            redirectAttributes.addFlashAttribute("alertType", "error");
            redirectAttributes.addFlashAttribute("alertMessage", "Thêm thất bại.");
        }

        return "redirect:/product/view-add";
    }

    //Loaij giày
    @RequestMapping("/loai-giay/view")
    public String viewLoaiGiay(Model model
    ) {
        return "add-loai-giay";
    }

    @PostMapping("/loai-giay/add")
    public String LoaiGiay(Model model,
                           @ModelAttribute("loaiGiayAdd") LoaiGiay kichCo,
                           RedirectAttributes redirectAttributes
    ) {

        if (loaiGiaySevice.add(kichCo)) {
            redirectAttributes.addFlashAttribute("alertType", "error");
            redirectAttributes.addFlashAttribute("alertMessage", "Thêm thành công.");
        } else {
            redirectAttributes.addFlashAttribute("alertType", "error");
            redirectAttributes.addFlashAttribute("alertMessage", "Thêm thất bại.");
        }

        return "redirect:/product/view-add";
    }

    //Đế giày
    @RequestMapping("/de-giay/view")
    public String viewDeGiay(Model model
    ) {
        return "add-de-giay";
    }

    @PostMapping("/de-giay/add")
    public String deGiay(Model model,
                         @ModelAttribute("deGiayAdd") DeGiay kichCo,
                         RedirectAttributes redirectAttributes
    ) {

        if (deGiaySevice.add(kichCo)) {
            redirectAttributes.addFlashAttribute("alertType", "error");
            redirectAttributes.addFlashAttribute("alertMessage", "Thêm thành công.");
        } else {
            redirectAttributes.addFlashAttribute("alertType", "error");
            redirectAttributes.addFlashAttribute("alertMessage", "Thêm thất bại.");
        }

        return "redirect:/product/view-add";
    }

    //Nsx
    @RequestMapping("/thuong-hieu/view")
    public String viewNsx(Model model
    ) {
        return "add-thuong-hieu";
    }

    @PostMapping("/thuong-hieu/add")
    public String Nsx(Model model,
                      @ModelAttribute("thuongHieuAdd") ThuongHieu kichCo,
                      RedirectAttributes redirectAttributes
    ) {
        if (thuongHieuSevice.add(kichCo)) {
            redirectAttributes.addFlashAttribute("alertType", "error");
            redirectAttributes.addFlashAttribute("alertMessage", "Thêm thành công.");
        } else {
            redirectAttributes.addFlashAttribute("alertType", "error");
            redirectAttributes.addFlashAttribute("alertMessage", "Thêm thất bại.");
        }

        return "redirect:/product/view-add";
    }
}
