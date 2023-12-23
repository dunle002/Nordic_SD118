package com.example.Nordic_SD118.controller;

import com.example.Nordic_SD118.entity.LoaiGiay;
import com.example.Nordic_SD118.entity.SanPham;
import com.example.Nordic_SD118.repository.LoaiGiayRepository;
import com.example.Nordic_SD118.sevice.SanPhamSevice;
import jakarta.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/product")
public class ProductConttroller {

    @Autowired
    private SanPhamSevice sevice;
    @Autowired
    private LoaiGiayRepository repository;


    @RequestMapping("/view")
    public String shopHome(Model model,
                           @RequestParam(defaultValue = "0", name = "page") Integer num,
                           @RequestParam("field") Optional<String> field) {
        Sort sort = Sort.by(Direction.DESC, field.orElse("id"));
        model.addAttribute("field", field.orElse("id"));
        Pageable pageable = PageRequest.of(num, 5, sort);
        Page<SanPham> list = sevice.getAll(pageable);

<<<<<<< HEAD
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

=======
        List<LoaiGiay> listLoai = repository.findAll();
        model.addAttribute("product", list);
>>>>>>> parent of 96c4105 (gui code)
        model.addAttribute("loaiDay", listLoai);
        return "crud";
    }

    @PostMapping("/add")
    public String newProduct(Model model, @Valid @ModelAttribute("product") SanPham sanPham, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            Map<String, String> errorMap = new HashMap<>();
            for (FieldError fieldError : bindingResult.getFieldErrors()) {
                errorMap.put(fieldError.getField(), fieldError.getDefaultMessage());
            }
            redirectAttributes.addFlashAttribute("errors", errorMap);
            return "redirect:view";
        } else {
            sevice.Save(sanPham);
        }
        return "redirect:view";
    }
//    @RequestParam("photoTwo2") Integer idProductDto,
//    @RequestParam("photoTwo2") Integer idProductDetailDto

<<<<<<< HEAD
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
=======
    @PostMapping("/update/{id}")
    public String updateProduct(Model model, @ModelAttribute("product") SanPham sanPham,
                                @PathVariable("id") Integer id,
                                @RequestParam(defaultValue = "0", name = "page") Integer num,
                                @RequestParam("field") Optional<String> field,
                                BindingResult bindingResult,
                                RedirectAttributes redirectAttributes
    ) {
        if (bindingResult.hasErrors()) {
            Map<String, String> errorMap = new HashMap<>();
            for (FieldError fieldError : bindingResult.getFieldErrors()) {
                errorMap.put(fieldError.getField(), fieldError.getDefaultMessage());
            }
            redirectAttributes.addFlashAttribute("errors", errorMap);

            System.out.println("lỗi");
            return "redirect:update";
        } else {
            sanPham.setId(id);
            sevice.update(sanPham);
        }
        shopHome(model, num, field);
        return "update";
    }

    @GetMapping("/get/{id}")
    public String getOneProductDetail(Model model, @PathVariable("id") Integer id,
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
        return "redirect:/product/view";
    }
>>>>>>> parent of 96c4105 (gui code)
}
