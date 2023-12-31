package com.example.Nordic_SD118.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Formula;

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
    @Column(name = "total")
   // @Formula("(SELECT SUM(g1_0.so_luong * g1_0.don_gia) FROM gio_hang_chi_tiet g1_0)")
    private Integer total;
    @ManyToOne
    @JoinColumn(name = "id_gio_hang")
    private GioHang gioHang;

    @ManyToOne
    @JoinColumn(name = "id_san_pham")
    private ChiTietSanPham chiTietSanPham;
    @Column(name = "total")
    public Integer getTotal() {
        if (soLuong != null && donGia != null) {
            return soLuong * donGia;
        } else {
            return total; // Hoặc giá trị mặc định khác nếu cần
        }
    }
}
