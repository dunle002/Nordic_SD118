package com.example.Nordic_SD118.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "gio_hang_chi_tiet")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class GioHangChiTiet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "so_luong")
    private Integer soLuong;
    @Column(name = "don_gia")
    private Integer donGia;
    @Column(name = "don_gia_khi_giam")
    private Integer donGiaKhiGiam;
    @ManyToOne
    @JoinColumn(name = "id_gio_hang")
    private GioHang gioHang;
    @ManyToOne
    @JoinColumn(name = "id_san_pham")
    private ChiTietSanPham chiTietSanPham;


}
