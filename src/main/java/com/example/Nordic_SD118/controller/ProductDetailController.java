package com.example.Nordic_SD118.controller;


import com.example.Nordic_SD118.service.ChatLieuSevice;
import com.example.Nordic_SD118.service.DeGiaySevice;
import com.example.Nordic_SD118.service.KichCoSevice;
import com.example.Nordic_SD118.service.MauSacSevice;
import com.example.Nordic_SD118.service.ProductDetailSevice;
import com.example.Nordic_SD118.service.SanPhamSevice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/product-detail")
public class ProductDetailController {
    @Autowired
    ProductDetailSevice sevice;
    @Autowired
    KichCoSevice kichCoRepository;
    @Autowired
    SanPhamSevice sanPhamSevice;
    @Autowired
    MauSacSevice mauSacRepository;
    @Autowired
    DeGiaySevice deGiaySevice;
    @Autowired
    ChatLieuSevice chatLieuSevice;

//    @RequestMapping("/view")
//    public String getAll(Model model,
//                         @RequestParam(defaultValue = "0", name = "page") Integer num,
//                         @RequestParam("field") Optional<String> field) {
//        Sort sort = Sort.by(Direction.DESC, field.orElse("id"));
//        model.addAttribute("field", field.orElse("id"));
//        Pageable pageable = PageRequest.of(num, 5, sort);
//        Page<ChiTietSanPham> list = sevice.getAll(pageable);
//        model.addAttribute("product", list);
//
//        List<MauSac> listLoai = mauSacRepository.getAll();
//        List<SanPham> listLoai1 = sanPhamSevice.getAll();
//        List<KichCo> listLoai2 = kichCoRepository.getAll();
//        List<DeGiay> listLoai3 = deGiaySevice.getAll();
//        List<ChatLieu> listLoai4 = chatLieuSevice.getAll();
//
//        Map<String, List<?>> danhSachMap = new HashMap<>();
//
//        // Thêm các danh sách vào đối tượng Map
//        danhSachMap.put("sanPham", listLoai1);
//        danhSachMap.put("mauSac", listLoai);
//        danhSachMap.put("kichCo", listLoai2);
//        danhSachMap.put("deGiay", listLoai3);
//        danhSachMap.put("chatLieu", listLoai4);
//
//        // Thêm đối tượng Map vào model
//        model.addAttribute("danhSach", danhSachMap);
//
//        return "product_detail";
//    }
//
//    @PostMapping("/add")
//    public String newProduct(Model model, @Valid @ModelAttribute("productDetail") ChiTietSanPham sanPham, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
//        if (bindingResult.hasErrors()) {
//           Map<String,String> errorMap =new HashMap<>();
//            for (FieldError fieldError : bindingResult.getFieldErrors()) {
//                errorMap.put(fieldError.getField(), fieldError.getDefaultMessage());
//            }
//            redirectAttributes.addFlashAttribute("errors", errorMap);
//            System.out.println("lỗi");
//            return "redirect:view";
//        }else{
//            sevice.Save(sanPham);
//        }
//
//        return "redirect:view";
//    }
//
//    @PostMapping("/update/{id}")
//    public String updateProduct(Model model, @ModelAttribute("product") ChiTietSanPham sanPham,
//                                @PathVariable("id") Integer id,
//                                @RequestParam(defaultValue = "0", name = "page") Integer num,
//                                @RequestParam("field") Optional<String> field
//    ) {
//        sanPham.setId(id);
//        sevice.update(sanPham);
//        getAll(model, num, field);
//        return "update";
//    }
//
//
//
//    @GetMapping("/get/{id}")
//    public String getOneProductDetail(Model model, @PathVariable("id") Integer id,
//                                      @RequestParam(defaultValue = "0", name = "page") Integer num,
//                                      @RequestParam("field") Optional<String> field
//    ) {
//        ChiTietSanPham sanPham = sevice.getOne(id);
//        model.addAttribute("detailUpdate", sanPham);
//        getAll(model, num, field);
//        return "update-product-detail";
//    }
//
//    @GetMapping("/delete/{id}")
//    public String deleteProduct(Model model, @PathVariable("id") Integer id,
//                                @RequestParam(defaultValue = "0", name = "page") Integer num,
//                                @RequestParam("field") Optional<String> field
//    ) {
//        ChiTietSanPham detail = sevice.getOne(id);
//        sevice.delete(detail);
//        getAll(model, num, field);
//        return "redirect:/product-detail/view";
//    }

}
