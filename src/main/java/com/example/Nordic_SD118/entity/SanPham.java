package com.example.Nordic_SD118.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "san_pham")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SanPham {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "ma")
    @NotNull
    @NotBlank
    private String ma;
    @NotNull
    @NotBlank
    @Column(name = "ten_san_pham")
    private String tenSanPham;
<<<<<<< HEAD

<<<<<<< HEAD
=======
    @NotNull
    @NotBlank
    @Column(name = "thumbnail_photo")
    private String photo;
    @NotNull
    @Column(name = "price")
    private BigDecimal price;
    @NotNull
    @Column(name = "trang_thai")
    private Integer trangThai;
>>>>>>> parent of 96c4105 (gui code)
=======
    @Column(name = "thumbnail_photo")
    private String photo;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "trang_thai")
    private Integer trangThai;
>>>>>>> parent of b7388ac (gui code)
    @ManyToOne
    @JoinColumn(name = "id_loai_giay")
    private LoaiGiay loaiGiay;

}
