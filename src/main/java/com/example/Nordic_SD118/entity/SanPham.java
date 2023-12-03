package com.example.Nordic_SD118.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "san_pham")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SanPham {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "ma")
    private String ma;
    @Column(name = "ten_san_pham")
    private String tenSanPham;
    @Column(name = "thumbnail_photo")
    private String photo;
    @Column(name = "price")
    private BigDecimal price;
    @Column(name = "trang_thai")
    private Integer trangThai;
    @ManyToOne
    @JoinColumn(name = "id_loai_giay")
    private LoaiGiay loaiGiay;

//    @ManyToOne
//    private GioHang gioHang;

}
