package com.example.Nordic_SD118.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "thuong_hieu")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ThuongHieu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_nsx")
    private Integer id;
    @Column(name = "ten_nsx")
    private String tenThuongHieu;
    @Column(name = "trang_thai")
    private Integer trangThai;
    @OneToMany(mappedBy = "thuongHieu", cascade = CascadeType.ALL)
    private List<SanPham> childrenSp;
}
