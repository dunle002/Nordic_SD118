package com.example.Nordic_SD118.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "gio_hang")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GioHang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "ngay_tao")
    private Date ngayTao;
    @Column(name = "ngay_thanh_toan")
    private Date ngayThanhToan;
    @Column(name = "ten_nd")
    private String tenNd;
    @Column(name = "so_dien_thoai")
    private String soDienThoai;
    @Column(name = "trang_thai")
    private Integer trangThai;
    @ManyToOne
    @JoinColumn(name = "id_nguoi_dung")
    private NguoiDung nguoiDung;

}
