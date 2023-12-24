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
    private Integer idProduct;
    @Column(name = "ma")

    private String ma;

    @Column(name = "ten_san_pham")
    private String tenSanPham;

    @ManyToOne
    @JoinColumn(name = "id_loai_giay")
    private LoaiGiay loaiGiay;

    @OneToMany(mappedBy = "sanPham", cascade = CascadeType.ALL)
    private List<ChiTietSanPham> children;

}
