package com.example.Nordic_SD118.service;

import com.example.Nordic_SD118.entity.ChatLieu;
import java.util.List;
import java.util.Optional;

public interface ChatLieuSevice {
    public List<ChatLieu> getAll();
    public Optional<ChatLieu> getOne(Integer id);
}
