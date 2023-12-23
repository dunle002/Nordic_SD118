package com.example.Nordic_SD118.sevice.imlp;

import com.example.Nordic_SD118.entity.ChatLieu;
import com.example.Nordic_SD118.entity.MauSac;
import com.example.Nordic_SD118.repository.ChatLieuRepository;
import com.example.Nordic_SD118.repository.MauSacRepository;
import com.example.Nordic_SD118.sevice.ChatLieuSevice;
import com.example.Nordic_SD118.sevice.MauSacSevice;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChatLieuImlp implements ChatLieuSevice {

    @Autowired
    ChatLieuRepository repository;
    @Override
    public List<ChatLieu> getAll() {
        return repository.findAll();
    }

    @Override
    public Optional<ChatLieu> getOne(Integer id) {
        return repository.findById(id);
    }
}
