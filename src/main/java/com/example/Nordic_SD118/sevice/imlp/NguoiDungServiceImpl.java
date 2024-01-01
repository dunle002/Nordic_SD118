package com.example.Nordic_SD118.sevice.imlp;

import com.example.Nordic_SD118.entity.NguoiDung;
import com.example.Nordic_SD118.repository.NguoiDungRepository;
import com.example.Nordic_SD118.sevice.NguoiDungService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Service
public class NguoiDungServiceImpl implements NguoiDungService {
    @Autowired
    private NguoiDungRepository nguoiDungRepository;
    @Override
    public NguoiDung saveNguoiDung(NguoiDung nguoiDung) {
        NguoiDung newnguoiDung = nguoiDungRepository.save(nguoiDung);
        return nguoiDung;
    }

    @Override
    public void removeSessionMessage() {
       HttpSession session = ((ServletRequestAttributes) (RequestContextHolder.getRequestAttributes())).getRequest().getSession();
        session.removeAttribute("msg");
    }
}
