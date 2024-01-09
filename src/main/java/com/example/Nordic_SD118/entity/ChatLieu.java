package com.example.Nordic_SD118.entity;

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
@Table(name = "chat_lieu")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ChatLieu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "ma")
    private String ma;
    @Column(name = "ten_chat_lieu")
    private String tenChatLieu;
    @Column(name = "trang_thai")
    private Integer trangThai;

    @OneToMany(mappedBy = "chatLieu")
    private List<ChiTietSanPham> children;
}
