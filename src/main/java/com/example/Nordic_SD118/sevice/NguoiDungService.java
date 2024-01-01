package com.example.Nordic_SD118.sevice;

import com.example.Nordic_SD118.entity.NguoiDung;
import org.springframework.stereotype.Service;

@Service
public interface NguoiDungService {
    public NguoiDung saveNguoiDung(NguoiDung nguoiDung);
    public void removeSessionMessage();
}
