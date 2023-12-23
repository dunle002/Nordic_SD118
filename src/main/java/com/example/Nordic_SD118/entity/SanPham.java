package com.example.Nordic_SD118.entity;

import jakarta.persistence.*;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import lombok.ToString;

@Entity
@Table(name = "san_pham")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SanPham {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer idProduct;
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

    @OneToMany(mappedBy = "sanPham", cascade = CascadeType.ALL)
    private List<ChiTietSanPham> children;
}
