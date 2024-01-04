package com.example.Nordic_SD118.controller;

import com.example.Nordic_SD118.DTO.ProductDto;
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
import com.example.Nordic_SD118.repository.ImageRepositoriy;
import com.example.Nordic_SD118.repository.KichCoRepository;
import com.example.Nordic_SD118.repository.LoaiGiayRepository;
import com.example.Nordic_SD118.repository.MauSacRepository;
import com.example.Nordic_SD118.sevice.ProductDetailSevice;
import com.example.Nordic_SD118.sevice.SanPhamSevice;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


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
    @Autowired
    private ImageRepositoriy imageRepositoriy;
    private final ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();

    @RequestMapping("/view")
    public String shopHome(Model model

    ) {

        List<SanPham> list = service.getAll();
        model.addAttribute("product", list);
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
        List<SanPham> listSP = service.getAll();

        model.addAttribute("tenSanPham", listSP);
        model.addAttribute("loaiDay", listLoai);
        model.addAttribute("chatLieuList", chatLieuList);
        model.addAttribute("mauSacList", mauSacList);
        model.addAttribute("coList", coList);
        model.addAttribute("deGiayList", deGiayList);
        return "add-product";
    }

    private void scheduleRedirect(String url, RedirectAttributes redirectAttributes, int delaySeconds) {
        executorService.schedule(() -> {
            redirectAttributes.addFlashAttribute("redirectDelay", true);
            redirectAttributes.addFlashAttribute("redirectUrl", url);
        }, delaySeconds, TimeUnit.SECONDS);
    }

    //
    @PostMapping(value = "/add", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String saveSanPham(@ModelAttribute(name = "product") ProductDto product,
                              @RequestParam("fileImages") List<MultipartFile> fileImages,
                              @RequestParam("image31") MultipartFile fileImagesOne,
                              @RequestParam("chatLieu") Integer chatLieuGet,
                              @RequestParam("deGiay") Integer deGiayGet,
                              @RequestParam("mauSac") List<Integer> mauSacGet,
                              @RequestParam("kichCo") List<Integer> kichCoGet,
                              @RequestParam("donGia") List<BigDecimal> giaGet,
                              @RequestParam("soLuong") List<Integer> soLuongGet,
                              Model model,
                              RedirectAttributes redirectAttributes
    ) throws IOException {

        String check = service.checkNameProduct(product.getTenSanPham());
        if (check == "Sản phẩm đã có sẵn") {
            redirectAttributes.addFlashAttribute("alertType", "error");
            redirectAttributes.addFlashAttribute("alertMessage", "Sản phẩm đã tồn tại.");
            return "redirect:/product/view-add";
        } else {
            String fileName = "../../images/" + fileImagesOne.getOriginalFilename();
            product.setImgMain(fileName);
            SanPham sanPham = mapper.convertToProduct(product);
            service.Save(sanPham);
            service.addAllDetail(fileImages, chatLieuGet, deGiayGet, mauSacGet, kichCoGet, giaGet, soLuongGet, sanPham);
            redirectAttributes.addFlashAttribute("alertType", "success");
            redirectAttributes.addFlashAttribute("alertMessage", "Xử lý thành công.");
            return "redirect:/product/view";
        }


    }

//    @PostMapping(value = "/update", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
//    public String updateSanPham(@ModelAttribute(name = "product") ProductDto product, @RequestParam("image1") MultipartFile anh1,
//                                @RequestParam("image2") MultipartFile anh2,
//                                @RequestParam("image3") MultipartFile anh3,
//                                @RequestParam("photo0") String anh4,
//                                @RequestParam("photoOne1") String anh5,
//                                @RequestParam("photoTwo2") String anh6
//
//    ) throws IOException {
//        if (anh1.isEmpty() && anh2.isEmpty() && anh3.isEmpty()) {
//            product.setPhoto(anh4);
//            product.setPhotoOne(anh5);
//            product.setPhotoTwo(anh6);
//        } else {
//            if (!anh1.isEmpty()) {
//                product.setPhotoOne(anh5);
//                product.setPhotoTwo(anh6);
//                String fileName1 = "../../images/" + anh1.getOriginalFilename();
//                product.setPhoto(fileName1);
//            }
//            if (!anh2.isEmpty()) {
//                product.setPhotoTwo(anh6);
//                product.setPhoto(anh4);
//                String fileName2 = "../../images/" + anh2.getOriginalFilename();
//                product.setPhotoOne(fileName2);
//            }
//            if (!anh3.isEmpty()) {
//                product.setPhoto(anh4);
//                product.setPhotoOne(anh5);
//                String fileName3 = "../../images/" + anh3.getOriginalFilename();
//                product.setPhotoTwo(fileName3);
//            }
//        }
//
//        SanPham sanPham = mapper.convertToProduct(product);
//        service.Save(sanPham);
//        ChiTietSanPham chiTietSanPham = mapper.convertToProductDetail(product);
//        chiTietSanPham.setSanPham(sanPham);
//        serviceDetail.Save(chiTietSanPham);
//        return "redirect:/product/view";
//    }


    @PostMapping("/update")
    public String updateProduct(@ModelAttribute("product") ProductDto sanPham,
                                @RequestParam("image3") MultipartFile file,
                                @RequestParam("fileData") String fileData
    ) {
        if (!file.isEmpty()) {
            String fileName = "../../images/" + file.getOriginalFilename();
            sanPham.setImgMain(fileName);
            SanPham sanPham1 = mapper.convertToProduct(sanPham);
            service.update(sanPham1);
        } else if (file.isEmpty()) {
            sanPham.setImgMain(fileData);
            SanPham sanPham2 = mapper.convertToProduct(sanPham);
            service.update(sanPham2);
        }

        return "redirect:/product/view";
    }

    //    @GetMapping("/get/{id}")
//    public String getOneProductDetail(Model model, @PathVariable("id") Integer id
//    ) {
//        ChiTietSanPham sanPham = serviceDetail.getOne(id);
//        model.addAttribute("productUpdate", sanPham);
//        return shopHome(model);
//    }
    @GetMapping("/productDetail")
    public String getProduct(@RequestParam("id") Integer id, Model model) {
        // Gọi phương thức trong ProductService để lấy thông tin chi tiết sản phẩm dựa trên id
        List<LoaiGiay> listLoai = loaiGiayRepository.findAll();
        SanPham product = service.getOne(id);
        model.addAttribute("listLoai", listLoai);
        model.addAttribute("productct", product);
        return "detail-update";
    }

    @GetMapping("/getDetail")
    public String getProductDetail(@RequestParam("id") Integer id, Model model) {
        // Gọi phương thức trong ProductService để lấy thông tin chi tiết sản phẩm dựa trên id
        SanPham product = service.getOne(id);
        model.addAttribute("productct", product);
        return "list-detail-product";
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

