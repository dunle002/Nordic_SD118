package com.example.Nordic_SD118.sevice;

import com.example.Nordic_SD118.entity.ChatLieu;
import com.example.Nordic_SD118.entity.MauSac;
import java.util.List;
import java.util.Optional;

public interface ChatLieuSevice {
    public List<ChatLieu> getAll();
    public Optional<ChatLieu> getOne(Integer id);
}
