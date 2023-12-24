package com.example.Nordic_SD118.sevice.imlp;

import com.example.Nordic_SD118.entity.ChiTietSanPham;
import com.example.Nordic_SD118.repository.ProductDetailRepositori;

import com.example.Nordic_SD118.sevice.ProductDetailSevice;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class DetailProductImlp implements ProductDetailSevice {

    @Autowired
    ProductDetailRepositori repository;

    @Override
    public List<ChiTietSanPham> getAll() {
        return repository.findAll();
    }

    @Override
    public Page<ChiTietSanPham> getAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public ChiTietSanPham getOne(Integer id) {
        Optional<ChiTietSanPham> otp = repository.findById(id);
        if (otp.isPresent()) {
            return otp.get();
        } else {
            return null;
        }
    }

    @Override
    public void delete(ChiTietSanPham sanPham) {
        Integer idSanPham = sanPham.getIdProductDetail();
        Boolean idSpNoExis = repository.existsById(idSanPham);
        if (idSpNoExis) {
            repository.delete(sanPham);
        }
    }

    @Override
    public ChiTietSanPham Save(ChiTietSanPham sanPham) {
        return repository.save(sanPham);
    }

    @Override
    public ChiTietSanPham update(ChiTietSanPham chiTietSanPham) {
        Integer idSanPham = chiTietSanPham.getIdProductDetail();
        Boolean idSpNoExis = repository.existsById(idSanPham);
        if (idSpNoExis) {
            return repository.save(chiTietSanPham);
        }
        return null;
    }
}
