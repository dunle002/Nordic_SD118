package com.example.Nordic_SD118.dto;

import com.example.Nordic_SD118.entity.ChatLieu;
import com.example.Nordic_SD118.entity.ChiTietSanPham;
import com.example.Nordic_SD118.entity.DeGiay;
import com.example.Nordic_SD118.entity.KichCo;
import com.example.Nordic_SD118.entity.LoaiGiay;

import com.example.Nordic_SD118.entity.MauSac;
import com.example.Nordic_SD118.entity.SanPham;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductDto {

    private Integer idProduct;

    private Integer idProductDetail;

    private String ma;

    private String tenSanPham;

    private String photo;

    private LoaiGiay loaiGiay;

    private BigDecimal donGia;

    private Integer soLuong;

    private String photoOne;

    private String photoTwo;

    private String moTa;

    private Integer trangThai;

    private MauSac mauSac;

    private KichCo kichCo;

    private ChatLieu chatLieu;

    private DeGiay deGiay;


}
