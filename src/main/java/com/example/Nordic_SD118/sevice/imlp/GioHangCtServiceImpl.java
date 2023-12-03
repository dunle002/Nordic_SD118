package com.example.Nordic_SD118.sevice.imlp;

import com.example.Nordic_SD118.entity.ChiTietSanPham;
import com.example.Nordic_SD118.entity.GioHang;
import com.example.Nordic_SD118.entity.GioHangChiTiet;
import com.example.Nordic_SD118.entity.NguoiDung;
import com.example.Nordic_SD118.repository.ChiTietSPRepository;
import com.example.Nordic_SD118.repository.GioHangCTRepository;
import com.example.Nordic_SD118.repository.GioHangRepository;
import com.example.Nordic_SD118.repository.NguoiDungRepository;
import com.example.Nordic_SD118.sevice.GioHangCtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service
public class GioHangCtServiceImpl implements GioHangCtService {
    @Autowired
    private GioHangCTRepository gioHangCTRepository;
    @Autowired
    private ChiTietSPRepository chiTietSPRepository;
    @Autowired
    private GioHangRepository gioHangRepository;
    @Autowired
    private NguoiDungRepository nguoiDungRepository;

    @Override
    public List<GioHangChiTiet> listGioHangChiTiets() {
        List<GioHangChiTiet> listGioHangChiTiet = gioHangCTRepository.findAll();
        return listGioHangChiTiet;
    }

    @Override
    public GioHangChiTiet findOneGioHangChiTiet(Integer id) {
        return gioHangCTRepository.findById(id).get();
    }

    @Override
    public Boolean addSanPhamVaoGio(Integer id,String hoTen) {
        List<GioHangChiTiet> listGioHangChiTiets = gioHangCTRepository.findAll();
        NguoiDung nguoiDung = nguoiDungRepository.findByHoTen("Lê Xuân Dương");
        GioHangChiTiet gioHangChiTiet = new GioHangChiTiet();
        Date date = new Date();
        GioHang gioHang = new GioHang(id,date,date,nguoiDung.getHoTen(),nguoiDung.getSoDienThoai(), nguoiDung.getTrangThai(),nguoiDung);
        ChiTietSanPham chiTietSanPham = chiTietSPRepository.findById(id).orElse(null);

        if (chiTietSanPham != null) {
            if (checkTrung(listGioHangChiTiets, id)) {
                for (GioHangChiTiet gioHangChiTietExisting : listGioHangChiTiets) {
                    if (gioHangChiTietExisting.getChiTietSanPham().getId().equals(id)) {
                        Integer soLuong = gioHangChiTietExisting.getSoLuong() + 1;
                        BigDecimal giaTong = gioHangChiTietExisting.getDonGia().add(chiTietSanPham.getDonGia());
                        gioHangChiTiet = new GioHangChiTiet(
                                gioHangChiTietExisting.getId(),
                                soLuong,
                                giaTong,
                                gioHangChiTietExisting.getDonGiaKhiGiam(),
                                gioHangChiTietExisting.getGioHang(),
                                chiTietSanPham
                        );
                    }
                }
            } else {
                gioHangChiTiet = new GioHangChiTiet(
                        null,
                        1,
                        chiTietSanPham.getDonGia(),
                        BigDecimal.valueOf(0),
                        gioHang,
                        chiTietSanPham
                );
            }
            gioHangRepository.save(gioHang);
            gioHangCTRepository.save(gioHangChiTiet);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Boolean botSanPhamTrongGio(Integer id) {
        return null;
    }

    @Override
    public Boolean removeSanPhamTrongGio(Integer id) {
        return null;
    }

    private Boolean checkTrung(List<GioHangChiTiet> listGioHangChiTiets, Integer id) {
        for (int i = 0; i < listGioHangChiTiets.size(); i++) {
            if (listGioHangChiTiets.get(i).getChiTietSanPham().getId().equals(id)) {
                return true;
            }
        }
        return false;
    }
}
