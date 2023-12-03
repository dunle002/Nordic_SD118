package com.example.Nordic_SD118.sevice;

import com.example.Nordic_SD118.entity.GioHangChiTiet;
import com.example.Nordic_SD118.sevice.imlp.GioHangCtServiceImpl;

import java.util.Collection;
import java.util.List;

public interface GioHangCtService  {
    List<GioHangChiTiet> listGioHangChiTiets();
    GioHangChiTiet findOneGioHangChiTiet(Integer id);
    Boolean addSanPhamVaoGio(Integer id,String hoTen);
    Boolean botSanPhamTrongGio(Integer id);
    Boolean removeSanPhamTrongGio(Integer id);
}
