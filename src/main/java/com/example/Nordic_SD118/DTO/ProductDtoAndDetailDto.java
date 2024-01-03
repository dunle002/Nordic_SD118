package com.example.Nordic_SD118.DTO;

import com.example.Nordic_SD118.entity.ChatLieu;
import com.example.Nordic_SD118.entity.DeGiay;
import com.example.Nordic_SD118.entity.KichCo;
import com.example.Nordic_SD118.entity.LoaiGiay;
import com.example.Nordic_SD118.entity.MauSac;
import com.example.Nordic_SD118.entity.SanPham;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductDtoAndDetailDto {

    private String ma;

    private String tenSanPham;

    private LoaiGiay loaiGiay;

    private String moTa;

    private Integer trangThai;

    private List<BigDecimal> donGia;

    private List<Integer> soLuong;

    private  List<Integer> mauSac;

    private  List<Integer> kichCo;

    private List<Integer> chatLieu;

    private List<Integer> deGiay;

    private Date ngayTao;

    private Date ngaySua;
}
