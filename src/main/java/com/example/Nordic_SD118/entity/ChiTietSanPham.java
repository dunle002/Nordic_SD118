package com.example.Nordic_SD118.entity;


import jakarta.persistence.*;
import java.util.List;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "chi_tiet_san_pham")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ChiTietSanPham {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer idProductDetail;

    @Column(name = "don_gia")
    private BigDecimal donGia;

    @Column(name = "so_luong_ton")
    private Integer soLuong;

    @Column(name = "main_photo")
    private String photo;

    @Column(name = "main_photo1")
    private String photoOne;

    @Column(name = "main_photo2")
    private String photoTwo;

//    @Column(name = "mo_ta_ct")
//    private String moTa;

    @Column(name = "trang_thai")
    private Integer trangThai;

    @ManyToOne
    @JoinColumn(name = "id_san_pham")
    private SanPham sanPham;

    @ManyToOne
    @JoinColumn(name = "id_mau_sac")
    private MauSac mauSac;

    @ManyToOne
    @JoinColumn(name = "id_kich_co")
    private KichCo kichCo;

    @ManyToOne
    @JoinColumn(name = "id_chat_lieu")
    private ChatLieu chatLieu;

    @ManyToOne
    @JoinColumn(name = "id_de_giay")
    private DeGiay deGiay;

    @OneToMany(mappedBy = "detail", cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Images> image;

    public void addChildEntity(Images childEntity) {
        image.add(childEntity);
        childEntity.setParentEntity(this);
    }

    public void removeChildEntity(Images childEntity) {
        image.remove(childEntity);
        childEntity.setParentEntity(null);
    }

    public void setParentEntity(SanPham parentEntity) {
        this.sanPham = parentEntity;
    }
}

