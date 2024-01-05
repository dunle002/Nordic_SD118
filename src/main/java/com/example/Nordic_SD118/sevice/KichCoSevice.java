package com.example.Nordic_SD118.sevice;

import com.example.Nordic_SD118.entity.DeGiay;
import com.example.Nordic_SD118.entity.KichCo;
import com.example.Nordic_SD118.entity.MauSac;
import java.util.List;
import java.util.Optional;

public interface KichCoSevice {
    public List<KichCo> getAll();
    public Optional<KichCo> getOne(Integer id);
    public boolean add(KichCo id);
    public void remove(KichCo id);
}
