package com.example.Nordic_SD118.sevice;


import com.example.Nordic_SD118.entity.ChiTietSanPham;
import com.example.Nordic_SD118.entity.SanPham;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

public interface SanPhamSevice {
    public Page<SanPham> getAll(Pageable pageable);

    public List<SanPham> getAll();

    public SanPham getOne(Integer id);

    public void delete(SanPham id);

    public SanPham Save(SanPham sanPham);

    public SanPham update(SanPham sanPham);
    public SanPham findSanPhamByTen(String sanPham);

    String generateUniqueProductCode();

    List<ChiTietSanPham> addAllDetail(List<MultipartFile> fileImages,
                                      Integer chatLieuGet,
                                      Integer deGiayGet,
                                      List<Integer> mauSacGet,
                                      List<Integer> kichCoGet,
                                      List<Integer> giaGet,
                                      List<Integer> soLuongGet,
                                      SanPham sanPham
                        );
    String checkNameProduct(String s);

}
