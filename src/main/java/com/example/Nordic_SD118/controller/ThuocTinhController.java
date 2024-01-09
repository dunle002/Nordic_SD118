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
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
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


    @RequestMapping("/{class}/thuoc-tinh/delete/{id}")
    public String xoaThuocTinh(@PathVariable("class") String className,
                               @PathVariable("id") Integer id,
                               RedirectAttributes redirectAttributes) {
        try {
            if (className.equals("MauSac")) {
                MauSac mauSac = mauSacSevice.getOne(id);
                mauSacSevice.remove(mauSac);
                redirectAttributes.addFlashAttribute("alertType", "error");
                redirectAttributes.addFlashAttribute("alertMessage", "Xóa thành công.");
            } else if (className.equals("ChatLieu")) {
                ChatLieu mauSac = chatLieuSevice.getOne(id);
                chatLieuSevice.remove(mauSac);
                redirectAttributes.addFlashAttribute("alertType", "error");
                redirectAttributes.addFlashAttribute("alertMessage", "Xóa thành công.");
            } else if (className.equals("KichCo")) {
                KichCo mauSac = kichCoSevice.getOne(id);
                kichCoSevice.remove(mauSac);
                redirectAttributes.addFlashAttribute("alertType", "error");
                redirectAttributes.addFlashAttribute("alertMessage", "Xóa thành công.");
            } else if (className.equals("LoaiGiay")) {
                LoaiGiay mauSac = loaiGiaySevice.getOne(id);
                loaiGiaySevice.remove(mauSac);
                redirectAttributes.addFlashAttribute("alertType", "error");
                redirectAttributes.addFlashAttribute("alertMessage", "Xóa thành công.");
            } else if (className.equals("DeGiay")) {
                DeGiay mauSac = deGiaySevice.getOne(id);
                deGiaySevice.remove(mauSac);
                redirectAttributes.addFlashAttribute("alertType", "error");
                redirectAttributes.addFlashAttribute("alertMessage", "Xóa thành công.");
            } else if (className.equals("ThuongHieu")) {
                ThuongHieu mauSac = thuongHieuSevice.getOne(id);
                thuongHieuSevice.remove(mauSac);
                redirectAttributes.addFlashAttribute("alertType", "error");
                redirectAttributes.addFlashAttribute("alertMessage", "Xóa thành công.");
            } else {
                redirectAttributes.addFlashAttribute("alertType", "error");
                redirectAttributes.addFlashAttribute("alertMessage", "Lớp không hợp lệ.");
            }


        } catch (Exception e) {
            e.printStackTrace();
            redirectAttributes.addFlashAttribute("alertType", "error");
            redirectAttributes.addFlashAttribute("alertMessage", "Đã xảy ra lỗi khi xóa thuộc tính.");

        }
        return "redirect:/thuoc-tinh/view";
    }

    //update
    @RequestMapping("/{class}/update")
    public String xoaThuocTinh(@PathVariable("class") String className,
                               @ModelAttribute("thuongHieuAdd") ThuongHieu thuongHieu,
                               @ModelAttribute("mauSacAdd") MauSac mauSac,
                               @ModelAttribute("chatLieuAdd") ChatLieu chatLieu,
                               @ModelAttribute("kichCoAdd") KichCo kichCo,
                               @ModelAttribute("loaiGiayAdd") LoaiGiay loaiGiay,
                               @ModelAttribute("deGiayAdd") DeGiay deGiay,
                               RedirectAttributes redirectAttributes) {
        try {
            if (className.equals("mau-sac")) {
                mauSacSevice.add(mauSac);
                redirectAttributes.addFlashAttribute("alertType", "error");
                redirectAttributes.addFlashAttribute("alertMessage", "Cập nhật thành công.");
            } else if (className.equals("chat-lieu")) {
                chatLieuSevice.add(chatLieu);
                redirectAttributes.addFlashAttribute("alertType", "error");
                redirectAttributes.addFlashAttribute("alertMessage", "nhậtCapaj nhật thành công.");
            } else if (className.equals("kich-co")) {

                kichCoSevice.add(kichCo);
                redirectAttributes.addFlashAttribute("alertType", "error");
                redirectAttributes.addFlashAttribute("alertMessage", "Cập  thành công.");
            } else if (className.equals("loai-giay")) {
                loaiGiaySevice.add(loaiGiay);
                redirectAttributes.addFlashAttribute("alertType", "error");
                redirectAttributes.addFlashAttribute("alertMessage", "Cập nhật thành công.");
            } else if (className.equals("de-giay")) {
                deGiaySevice.add(deGiay);
                redirectAttributes.addFlashAttribute("alertType", "error");
                redirectAttributes.addFlashAttribute("alertMessage", "Cập nhật thành công.");
            } else if (className.equals("thuong-hieu")) {

                thuongHieuSevice.add(thuongHieu);
                redirectAttributes.addFlashAttribute("alertType", "error");
                redirectAttributes.addFlashAttribute("alertMessage", "Cập nhật thành công.");
            } else {
                redirectAttributes.addFlashAttribute("alertType", "error");
                redirectAttributes.addFlashAttribute("alertMessage", "Lớp không hợp lệ.");
            }


        } catch (Exception e) {
            e.printStackTrace();
            redirectAttributes.addFlashAttribute("alertType", "error");
            redirectAttributes.addFlashAttribute("alertMessage", "Đã xảy ra lỗi khi cập nhật thuộc tính.");

        }
        return "redirect:/thuoc-tinh/view";
    }

    @RequestMapping("/thuoc-tinh/view")
    public String viewThuocTinh(Model model
    ) {
        List<KichCo> coList = kichCoSevice.getAll();
        List<LoaiGiay> loaiGiays = loaiGiaySevice.getAll();
        List<ThuongHieu> thuongHieuList = thuongHieuSevice.getAll();
        List<MauSac> mauSacList = mauSacSevice.getAll();
        List<DeGiay> deGiayList = deGiaySevice.getAll();
        List<ChatLieu> chatLieuList = chatLieuSevice.getAll();
        model.addAttribute("coList", coList);
        model.addAttribute("loaiGiays", loaiGiays);
        model.addAttribute("thuongHieuList", thuongHieuList);
        model.addAttribute("mauSacList", mauSacList);
        model.addAttribute("deGiayList", deGiayList);
        model.addAttribute("chatLieuList", chatLieuList);
        return "thuoc-tinh-view";
    }

    @RequestMapping("/kich-co/view")
    public String viewKichCo(Model model
    ) {
        return "add-kich-co";
    }

    @RequestMapping("/kich-co/view-update")
    public String viewKichCoUpdate(Model model,
                                   @RequestParam("id") Integer integer
    ) {
        KichCo thuongHieu = kichCoSevice.getOne(integer);
        model.addAttribute("kichCo", thuongHieu);
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

    @RequestMapping("/mau-sac/view-update")
    public String viewMauSacUpdate(Model model,
                                   @RequestParam("id") Integer integer
    ) {
        MauSac thuongHieu = mauSacSevice.getOne(integer);
        model.addAttribute("mauSac", thuongHieu);
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

    @RequestMapping("/chat-lieu/view-update")
    public String viewChatLieuUpdate(Model model, @RequestParam("id") Integer integer
    ) {
        ChatLieu thuongHieu = chatLieuSevice.getOne(integer);
        model.addAttribute("chatLieu", thuongHieu);
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

    @RequestMapping("/loai-giay/view-update")
    public String viewLoaiGiay(Model model, @RequestParam("id") Integer integer
    ) {
        LoaiGiay thuongHieu = loaiGiaySevice.getOne(integer);
        model.addAttribute("loaiGiay", thuongHieu);
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

    @RequestMapping("/de-giay/view-update")
    public String viewDeGiay(Model model, @RequestParam("id") Integer integer
    ) {
        DeGiay thuongHieu = deGiaySevice.getOne(integer);
        model.addAttribute("deGiay", thuongHieu);
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

    @RequestMapping("/thuong-hieu/view-update")
    public String viewNsx(Model model, @RequestParam("id") Integer integer
    ) {
        ThuongHieu thuongHieu = thuongHieuSevice.getOne(integer);
        model.addAttribute("thuongHieu", thuongHieu);
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
