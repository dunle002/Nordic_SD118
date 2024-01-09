package com.example.Nordic_SD118.sevice.imlp;

import com.example.Nordic_SD118.entity.ThuongHieu;
import com.example.Nordic_SD118.repository.ThuongHieuRepo;
import com.example.Nordic_SD118.sevice.ThuongHieuSevice;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ThuongHieuImlp implements ThuongHieuSevice {
    @Autowired
    public ThuongHieuRepo thuongHieuRepo;

    @Override
    public List<ThuongHieu> getAll() {
        return thuongHieuRepo.findAll();
    }

    @Override
    public ThuongHieu getOne(Integer id) {
        Optional<ThuongHieu> kichCo = thuongHieuRepo.findById(id);
        if (kichCo.isPresent()) {
            return kichCo.get();
        } else {
            return null;
        }
    }

    @Override
    public boolean add(ThuongHieu id) {
        ThuongHieu thuongHieu = new ThuongHieu();
        thuongHieu.setId(id.getId());
        thuongHieu.setTenThuongHieu(id.getTenThuongHieu().trim());
        thuongHieu.setTrangThai(id.getTrangThai());
        if (thuongHieuRepo.existsByTenThuongHieuLike(thuongHieu.getTenThuongHieu().trim())) {
            if (thuongHieu.getId() == null) {
                return false;
            } else {
                thuongHieuRepo.save(thuongHieu);
            }
        } else {
            thuongHieuRepo.save(thuongHieu);

        }
        return true;
    }

    @Override
    public void remove(ThuongHieu id) {
        thuongHieuRepo.delete(id);
    }


}
