package com.example.Nordic_SD118.sevice.imlp;

import com.example.Nordic_SD118.entity.SanPham;
import com.example.Nordic_SD118.repository.SanPhamRepository;
import com.example.Nordic_SD118.sevice.SanPhamSevice;
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

    @Override
    public Page<SanPham> getAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public List<SanPham> getAll() {
        return repository.findAll();
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
    public void delete(SanPham sanPham) {
        Integer idSanPham = sanPham.getId();
        Boolean idSpNoExis= repository.existsById(idSanPham);
        if (idSpNoExis){
            repository.delete(sanPham);
        }
    }

    @Override
    public SanPham Save(SanPham sanPham) {
        return repository.save(sanPham);
    }

    @Override
    public SanPham update(SanPham sanPham) {
        Integer idSanPham = sanPham.getId();
        Boolean idSpNoExis= repository.existsById(idSanPham);
        if (idSpNoExis){
            return repository.save(sanPham);
        }
        return null;
    }
}
