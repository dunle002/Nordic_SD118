package com.example.Nordic_SD118.sevice.imlp;

import com.example.Nordic_SD118.entity.SanPham;
import com.example.Nordic_SD118.repository.SanPhamRepository;
import com.example.Nordic_SD118.sevice.SanPhamSevice;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class SanPhamImlp implements SanPhamSevice {

    @Autowired
    SanPhamRepository repository;
    public static List<SanPham> list = new ArrayList<>();
    @Override
    public Page<SanPham> getAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public SanPham getOne(Integer id) {
        Optional<SanPham> otp = repository.findById(id);
        if (otp.isPresent()) {
            return otp.get();
        } else {
            return null;
        }
    }

    @Override
    public void delete(SanPham id) {
        repository.delete(id);
    }

    @Override
    public SanPham SaveOrUpdate(SanPham sanPham) {
        return repository.save(sanPham);
    }

    @Override
    public SanPham findById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<SanPham> findAll() {
        return repository.findAll();
    }

    @Override
    public void save(SanPham sanPham) {
            repository.save(sanPham);
    }

    @Override
    public List<SanPham> getAll() {
        return null;
    }

    @Override
    public SanPham findSanPhamById(int id) {
        for (SanPham sanPham : list){
            if (sanPham.getId() == id){
                return sanPham;
            }
        }
        return null;
    }
}
