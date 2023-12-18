package com.example.Nordic_SD118.service.imp;

import com.example.Nordic_SD118.entity.ChiTietSanPham;
import com.example.Nordic_SD118.entity.SanPham;
import com.example.Nordic_SD118.repository.ProductDetailRepositori;
import com.example.Nordic_SD118.repository.SanPhamRepository;
import com.example.Nordic_SD118.service.SanPhamSevice;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SanPhamImlp implements SanPhamSevice {


    @Autowired
    SanPhamRepository repository;
    @Autowired
    ProductDetailRepositori detailRepo;

    @PersistenceContext
    private EntityManager entityManager;

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
        Integer idSanPham = sanPham.getIdProduct();
        resetParentIdInChildren(findChildrenByParentId(idSanPham));
        Boolean idSpNoExis = repository.existsById(idSanPham);
        if (idSpNoExis) {
            repository.delete(sanPham);
        }
    }

    @Override
    public SanPham Save(SanPham sanPham) {
        return repository.save(sanPham);
    }

    @Override
    public SanPham update(SanPham sanPham) {
        Integer idSanPham = sanPham.getIdProduct();
        Boolean idSpNoExis = repository.existsById(idSanPham);
        if (idSpNoExis) {
            return repository.save(sanPham);
        }
        return null;
    }


    @Transactional
    public List<ChiTietSanPham> findChildrenByParentId(Integer parentId) {
        SanPham parent = entityManager.find(SanPham.class, parentId);
        List<ChiTietSanPham> children = parent.getChildren();

        List<ChiTietSanPham> childrenWithParentId = new ArrayList<>();

        for (ChiTietSanPham child : children) {
            if (child.getSanPham().getIdProduct().equals(parentId)) {
                childrenWithParentId.add(child);
            }
        }

        return childrenWithParentId;
    }

    @Transactional
    public void resetParentIdInChildren(List<ChiTietSanPham> children) {
        for (ChiTietSanPham child : children) {
            child.setSanPham(null);
            entityManager.persist(child);
        }
    }

    @Override
    public String generateUniqueProductCode() {
        String prefix = "SP";
        String productCode;
        do {
            String randomCode = generateRandomCode();
            productCode = prefix + randomCode;
        } while (repository.existsByMa(productCode));

        return productCode;
    }

    private String generateRandomCode() {
        String numbers = "0123456789";
        String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        StringBuilder randomCode = new StringBuilder();

        // Sinh ra 2 số ngẫu nhiên
        for (int i = 0; i < 2; i++) {
            int randomIndex = (int) (Math.random() * numbers.length());
            randomCode.append(numbers.charAt(randomIndex));
        }

        // Sinh ra 2 chữ ngẫu nhiên
        for (int i = 0; i < 2; i++) {
            int randomIndex = (int) (Math.random() * letters.length());
            randomCode.append(letters.charAt(randomIndex));
        }

        return randomCode.toString();

    }
}

