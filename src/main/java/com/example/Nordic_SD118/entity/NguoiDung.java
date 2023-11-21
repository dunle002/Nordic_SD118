package com.example.Nordic_SD118.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Entity
@Table(name = "nguoi_dung")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NguoiDung {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "ho_ten")
    private String hoTen;
    @Column(name = "pass_word")
    private String passWord;
    @Column(name = "gioi_tinh")
    private Boolean gioiTinh;
    @Column(name = "ngay_sinh")
    private Date ngaySinh;
    @Column(name = "dia_chi")
    private String diaChi;
    @Column(name = "so_dien_thoai")
    private String soDienThoai;
    @Column(name = "email")
    private String email;
    @Column(name = "role")
    private Boolean role;
    @Column(name = "trang_thai")
    private Integer trangThai;

}
