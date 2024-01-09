package com.example.Nordic_SD118.controller;

import com.example.Nordic_SD118.entity.ChatLieu;
import com.example.Nordic_SD118.entity.ChiTietSanPham;
import com.example.Nordic_SD118.entity.DeGiay;
import com.example.Nordic_SD118.entity.KichCo;
import com.example.Nordic_SD118.entity.MauSac;
import com.example.Nordic_SD118.repository.ChatLieuRepository;
import com.example.Nordic_SD118.repository.DeGiayRepository;
import com.example.Nordic_SD118.repository.KichCoRepository;
import com.example.Nordic_SD118.repository.MauSacRepository;
import com.example.Nordic_SD118.sevice.ProductDetailSevice;
import com.example.Nordic_SD118.sevice.SanPhamSevice;
import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/detail")
public class ProductDeTailController {
    @Autowired
    private SanPhamSevice service;
    @Autowired
    private ProductDetailSevice serviceDetail;
    @Autowired
    private ChatLieuRepository chatLieuRepository;
    @Autowired
    private MauSacRepository mauSacRepository;
    @Autowired
    private KichCoRepository kichCoRepository;
    @Autowired
    private DeGiayRepository deGiayRepository;

    @RequestMapping("/detai-update/view")
    public String test(Model model, @RequestParam("id") Integer integer) {
        ChiTietSanPham chiTietSanPhams = serviceDetail.getOne(integer);

        List<ChatLieu> chatLieuList = chatLieuRepository.findAll();
        List<MauSac> mauSacList = mauSacRepository.findAll();
        List<KichCo> coList = kichCoRepository.findAll();
        List<DeGiay> deGiayList = deGiayRepository.findAll();
        Collections.sort(coList, (obj1, obj2) -> Integer.compare(Integer.parseInt(obj2.getSize()), Integer.parseInt(obj1.getSize())));
        model.addAttribute("listCt", chiTietSanPhams);
        model.addAttribute("chatLieuList", chatLieuList);
        model.addAttribute("mauSacList", mauSacList);
        model.addAttribute("coList", coList);
        model.addAttribute("deGiayList", deGiayList);


        return "chi-tiet-update";
    }

    @PostMapping("/chi-tiet/update")
    public String updateDetail(
            @RequestParam("") List<MultipartFile> multipartFiles,
            @RequestParam("imageURL")MultipartFile imageURL,
                               @ModelAttribute("chiTietUpdate") ChiTietSanPham chiTietSanPham,
                               RedirectAttributes redirectAttributes
    ) {
        if (serviceDetail.update(chiTietSanPham)) {
            serviceDetail.update(chiTietSanPham);
            redirectAttributes.addFlashAttribute("alertType", "error");
            redirectAttributes.addFlashAttribute("alertMessage", "Cập nhật thành công.");

        } else {
            redirectAttributes.addFlashAttribute("alertType", "error");
            redirectAttributes.addFlashAttribute("alertMessage", "Đã có chi tiết sản phẩm tương tự.");
        }
        return "redirect:/product/view";
    }

    @PostMapping("/chi-tiet/update-gia")
    public String updateDetail(@RequestParam("id-check") List<Integer> checkList,
                               @RequestParam("editPrice") Integer integerDg,
                               @RequestParam("editQuantity") Integer integerSl,
                               RedirectAttributes redirectAttributes
    ) {
        if (checkList != null) {
            for (Integer x : checkList
            ) {
                ChiTietSanPham chiTietSanPhams = serviceDetail.getOne(x);
                chiTietSanPhams.setSoLuong(integerSl);
                chiTietSanPhams.setDonGia(integerDg);
                serviceDetail.Save(chiTietSanPhams);
            }
            redirectAttributes.addFlashAttribute("alertType", "error");
            redirectAttributes.addFlashAttribute("alertMessage", "Cập nhật thành công.");
        }

        return "redirect:/product/view";
    }
}
