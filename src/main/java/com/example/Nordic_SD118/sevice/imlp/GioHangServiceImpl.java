//package com.example.Nordic_SD118.sevice.imlp;
//
//import com.example.Nordic_SD118.entity.GioHang;
//import com.example.Nordic_SD118.repository.GioHangRepository;
//import com.example.Nordic_SD118.sevice.GioHangService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class GioHangServiceImpl implements GioHangService {
//    @Autowired
//    private GioHangRepository gioHangRepository;
////    @Override
////    public GioHang getCurrentGioHang() {
////        GioHang gioHang = gioHangRepository.findCurrentTrue();
////        if (gioHang == null) {
////            gioHang = new GioHang();
////        }
////        return gioHang;
////    }
//
//    @Override
//    public GioHang getCurrentTrue() {
//        GioHang gioHang = gioHangRepository.findCurrentTrue();
//        if (gioHang == null) {
//            gioHang = new GioHang();
//        }
//        return gioHang;
//    }
//
//    @Override
//    public void saveGioHang(GioHang gioHang) {
//        gioHangRepository.save(gioHang);
//    }
//}
