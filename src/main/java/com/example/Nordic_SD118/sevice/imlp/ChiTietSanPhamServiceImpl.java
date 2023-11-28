//package com.example.Nordic_SD118.sevice.imlp;
//
//import com.example.Nordic_SD118.entity.ChiTietSanPham;
//import com.example.Nordic_SD118.repository.ChiTietSPRepository;
//import com.example.Nordic_SD118.sevice.ChiTietSanPhamService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.crossstore.ChangeSetPersister;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.NoSuchElementException;
//
//@Service
//public class ChiTietSanPhamServiceImpl implements ChiTietSanPhamService {
//    @Autowired
//    ChiTietSPRepository chiTietSPRepository;
//    @Override
//    public ChiTietSanPham findById(Integer id) {
//        return chiTietSPRepository.findById(id).orElse(null);
//    }
//
//    @Override
//    public List<ChiTietSanPham> findAll() {
//        return chiTietSPRepository.findAll();
//
//    }
//
//    @Override
//    public void save(ChiTietSanPham chiTietSanPham) {
//        chiTietSPRepository.save(chiTietSanPham);
//    }
//
//    @Override
//    public void delete(ChiTietSanPham id) {
//        chiTietSPRepository.delete(id);
//    }
//
//    @Override
//    public ChiTietSanPham getSanPhamById(Integer id) {
//        return chiTietSPRepository.findById(id)
//                .orElseThrow(() -> new NoSuchElementException("Product not found with id: " + id));
//    }
//
//}
