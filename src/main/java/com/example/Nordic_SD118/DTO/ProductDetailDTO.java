package com.example.Nordic_SD118.DTO;

import com.example.Nordic_SD118.entity.ChatLieu;
import com.example.Nordic_SD118.entity.DeGiay;
import com.example.Nordic_SD118.entity.KichCo;
import com.example.Nordic_SD118.entity.MauSac;
import com.example.Nordic_SD118.entity.SanPham;
import java.math.BigDecimal;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductDetailDTO {
    private Integer idProductDetail;

    private BigDecimal donGia;

    private Integer soLuong;

    private Integer trangThai;

    private MauSac mauSac;

    private KichCo kichCo;

    private ChatLieu chatLieu;

    private DeGiay deGiay;

    private SanPham sanPham;

    private Date ngayTao;

    private Date ngaySua;
}
