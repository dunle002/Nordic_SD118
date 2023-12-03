package com.example.Nordic_SD118.sevice.imlp;

import com.example.Nordic_SD118.entity.ChiTietSanPham;
import com.example.Nordic_SD118.repository.ChiTietSPRepository;
import com.example.Nordic_SD118.sevice.ChiTietSanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ChiTietSanPhamServiceImpl implements ChiTietSanPhamService {


    public static  List<ChiTietSanPham> list = new ArrayList<>();
    @Override
    public int add(ChiTietSanPham chiTietSanPham) {
        return 0;
    }

    @Override
    public int remove(int id) {
        return 0;
    }

    @Override
    public List<ChiTietSanPham> getAll() {
        return null;
    }

    @Override
    public ChiTietSanPham findChiTietSanPhamById(int id) {
        for (ChiTietSanPham chiTietSanPham : list){
            if (chiTietSanPham.getId() == id){
                return chiTietSanPham;
            }
        }
        return null;
    }
}
