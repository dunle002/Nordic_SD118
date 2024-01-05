package com.example.Nordic_SD118.DTO;

import com.example.Nordic_SD118.entity.ChiTietSanPham;
import com.example.Nordic_SD118.entity.LoaiGiay;
import com.example.Nordic_SD118.entity.ThuongHieu;
import java.util.List;
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

    private String ma;

    private String tenSanPham;

    private LoaiGiay loaiGiay;
    private ThuongHieu thuongHieu;

    private String moTa;

    private String imgMain;

    private Integer trangThai;




}
