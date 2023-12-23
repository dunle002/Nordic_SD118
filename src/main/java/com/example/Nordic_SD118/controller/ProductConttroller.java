package com.example.Nordic_SD118.controller;

import com.example.Nordic_SD118.dto.ProductDto;
import com.example.Nordic_SD118.entity.ChatLieu;
import com.example.Nordic_SD118.entity.ChiTietSanPham;
import com.example.Nordic_SD118.entity.DeGiay;
import com.example.Nordic_SD118.entity.KichCo;
import com.example.Nordic_SD118.entity.LoaiGiay;
import com.example.Nordic_SD118.entity.MauSac;
import com.example.Nordic_SD118.entity.SanPham;
import com.example.Nordic_SD118.mapper.ProductMapper;
import com.example.Nordic_SD118.repository.ChatLieuRepository;
import com.example.Nordic_SD118.repository.DeGiayRepository;
import com.example.Nordic_SD118.repository.KichCoRepository;
import com.example.Nordic_SD118.repository.LoaiGiayRepository;
import com.example.Nordic_SD118.repository.MauSacRepository;
import com.example.Nordic_SD118.service.ProductDetailSevice;
import com.example.Nordic_SD118.service.SanPhamSevice;
import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


@Controller
@RequestMapping("/product")
public class ProductConttroller {

    @Autowired
    private SanPhamSevice service;
    @Autowired
    private ProductDetailSevice serviceDetail;
    @Autowired
    private LoaiGiayRepository loaiGiayRepository;
    @Autowired
    private ChatLieuRepository chatLieuRepository;
    @Autowired
    private MauSacRepository mauSacRepository;
    @Autowired
    private KichCoRepository kichCoRepository;
    @Autowired
    private DeGiayRepository deGiayRepository;
    @Autowired
    private ProductMapper mapper;


    @RequestMapping("/view")
    public String shopHome(Model model

    ) {
        List<LoaiGiay> listLoai = loaiGiayRepository.findAll();
        List<ChatLieu> chatLieuList = chatLieuRepository.findAll();
        List<MauSac> mauSacList = mauSacRepository.findAll();
        List<KichCo> coList = kichCoRepository.findAll();
        List<DeGiay> deGiayList = deGiayRepository.findAll();
        List<ChiTietSanPham> list = serviceDetail.getAll();
        model.addAttribute("maZen", service.generateUniqueProductCode());
        model.addAttribute("product", list);
        model.addAttribute("loaiDay", listLoai);
        model.addAttribute("chatLieuList", chatLieuList);
        model.addAttribute("mauSacList", mauSacList);
        model.addAttribute("coList", coList);
        model.addAttribute("deGiayList", deGiayList);
        return "san-pham";
    }

    @RequestMapping("/view-add")
    public String viewAdd(Model model

    ) {
        model.addAttribute("maZen", service.generateUniqueProductCode());
        List<LoaiGiay> listLoai = loaiGiayRepository.findAll();
        List<ChatLieu> chatLieuList = chatLieuRepository.findAll();
        List<MauSac> mauSacList = mauSacRepository.findAll();
        List<KichCo> coList = kichCoRepository.findAll();
        List<DeGiay> deGiayList = deGiayRepository.findAll();
        List<ChiTietSanPham> list = serviceDetail.getAll();

        model.addAttribute("loaiDay", listLoai);
        model.addAttribute("chatLieuList", chatLieuList);
        model.addAttribute("mauSacList", mauSacList);
        model.addAttribute("coList", coList);
        model.addAttribute("deGiayList", deGiayList);
        return "add-product";
    }

    //
    @PostMapping(value = "/add", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String saveSanPham(@ModelAttribute(name = "product") ProductDto product, @RequestParam("image1") MultipartFile anh1,
                              @RequestParam("image2") MultipartFile anh2,
                              @RequestParam("image3") MultipartFile anh3
    ) throws IOException {

        String fileName1 = "../../images/" + anh1.getOriginalFilename();
        String fileName2 = "../../images/" + anh2.getOriginalFilename();
        String fileName3 = "../../images/" + anh3.getOriginalFilename();
        product.setPhoto(fileName1);
        product.setPhotoOne(fileName2);
        product.setPhotoTwo(fileName3);
        SanPham sanPham = mapper.convertToProduct(product);
        service.Save(sanPham);
        ChiTietSanPham chiTietSanPham = mapper.convertToProductDetail(product);
        chiTietSanPham.setSanPham(sanPham);
        serviceDetail.Save(chiTietSanPham);
        return "redirect:/product/view";
    }
//    @RequestParam("photoTwo2") Integer idProductDto,
//    @RequestParam("photoTwo2") Integer idProductDetailDto

    @PostMapping(value = "/update", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String updateSanPham(@ModelAttribute(name = "product") ProductDto product, @RequestParam("image1") MultipartFile anh1,
                                @RequestParam("image2") MultipartFile anh2,
                                @RequestParam("image3") MultipartFile anh3,
                                @RequestParam("photo0") String anh4,
                                @RequestParam("photoOne1") String anh5,
                                @RequestParam("photoTwo2") String anh6

    ) throws IOException {
        if (anh1.isEmpty() && anh2.isEmpty() && anh3.isEmpty()) {
            product.setPhoto(anh4);
            product.setPhotoOne(anh5);
            product.setPhotoTwo(anh6);
        } else {
            if (!anh1.isEmpty()) {
                product.setPhotoOne(anh5);
                product.setPhotoTwo(anh6);
                String fileName1 = "../../images/" + anh1.getOriginalFilename();
                product.setPhoto(fileName1);
            }
            if (!anh2.isEmpty()) {
                product.setPhotoTwo(anh6);
                product.setPhoto(anh4);
                String fileName2 = "../../images/" + anh2.getOriginalFilename();
                product.setPhotoOne(fileName2);
            }
            if (!anh3.isEmpty()) {
                product.setPhoto(anh4);
                product.setPhotoOne(anh5);
                String fileName3 = "../../images/" + anh3.getOriginalFilename();
                product.setPhotoTwo(fileName3);
            }
        }

        SanPham sanPham = mapper.convertToProduct(product);
        service.Save(sanPham);
        ChiTietSanPham chiTietSanPham = mapper.convertToProductDetail(product);
        chiTietSanPham.setSanPham(sanPham);
        serviceDetail.Save(chiTietSanPham);
        return "redirect:/product/view";
    }


//    @PostMapping("/update/{id}")
//    public String updateProduct(@ModelAttribute("product") SanPham sanPham,
//                                @PathVariable("id") Integer id,
//                                @RequestParam("file") MultipartFile file,
//                                @RequestParam("fileData") String fileData
//    ) {
//        if (!file.isEmpty()) {
//            sanPham.setIdProduct(id);
//            String fileName = "../../images/" + file.getOriginalFilename();
//            sanPham.setPhoto(fileName);
//            service.update(sanPham);
//        } else if (file.isEmpty()) {
//            sanPham.setIdProduct(id);
//            sanPham.setPhoto(fileData);
//            service.update(sanPham);
//        }
//
//        return "redirect:/product/view";
//    }

    //    @GetMapping("/get/{id}")
//    public String getOneProductDetail(Model model, @PathVariable("id") Integer id
//    ) {
//        ChiTietSanPham sanPham = serviceDetail.getOne(id);
//        model.addAttribute("productUpdate", sanPham);
//        return shopHome(model);
//    }
    @GetMapping("/productDetail")
    public String getProductDetail(@RequestParam("id") Integer id, Model model) {
        // Gọi phương thức trong ProductService để lấy thông tin chi tiết sản phẩm dựa trên id

        ChiTietSanPham product = serviceDetail.getOne(id);
        model.addAttribute("productct", product);
        viewAdd(model);
        return "detail-update";
    }


//    @GetMapping("/delete/{id}")
//    public String deleteProduct(Model model, @PathVariable("id") Integer id
//    ) {
//        SanPham sanPham = service.getOne(id);
//        service.delete(sanPham);
//        shopHome(model);
//        return "redirect:/product/view";
//    }
}

