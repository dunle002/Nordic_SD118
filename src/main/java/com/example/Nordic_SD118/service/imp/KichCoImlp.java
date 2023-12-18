package com.example.Nordic_SD118.service.imp;

import com.example.Nordic_SD118.entity.KichCo;
import com.example.Nordic_SD118.repository.KichCoRepository;
import com.example.Nordic_SD118.service.KichCoSevice;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KichCoImlp implements KichCoSevice {

    @Autowired
    KichCoRepository repository;
    @Override
    public List<KichCo> getAll() {
        return repository.findAll();
    }

    @Override
    public Optional<KichCo> getOne(Integer id) {
        return repository.findById(id);
    }
}
