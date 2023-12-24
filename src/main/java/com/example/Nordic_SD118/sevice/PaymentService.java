package com.example.Nordic_SD118.sevice;

import com.example.Nordic_SD118.entity.ChiTietSanPham;
import com.example.Nordic_SD118.entity.GioHangChiTiet;
import com.paypal.api.payments.*;

import java.util.List;

public class PaymentService {
    private static final String CLIENT_ID = "AalZPlOqcMPluLI-IueQj1Z6WutAvOPTysMtMcy7QeNOCAEHnv4wNPnX4PoNffIwwu3NygbLLUq8hf91";
    private static final String CLIENT_SECRET = "EAPekwW8AtuRfuGw4iQ3ELMV3fJ8jioVNWuGAunkaN9_LT2Vr9-ZMp3hbpDR5Ul40HRCnl1QXUQT7sj7";
    private static final String MODE = "sandbox";

    public String authorrizePayment(GioHangChiTiet gioHangChiTiet) {
        Payer payer = getPayerInformation();
        RedirectUrls redirectUrls = getRedirectURLs();
        return null;
    }

    private RedirectUrls getRedirectURLs() {
        RedirectUrls redirectUrls = new RedirectUrls();
        redirectUrls.setCancelUrl("http://localhost:8080/cancel.jsp");
        redirectUrls.setReturnUrl("http://localhost:8080/review_payment");
        return redirectUrls;
    }

    private List<Transaction> getTransactionInformation(GioHangChiTiet gioHangChiTiet) {
        Details details = new Details();
        //details.setShipping(gioHangChiTiet.getDonGia())
        return null;
    }
    private Payer getPayerInformation() {
        Payer payer = new Payer();
        payer.setPaymentMethod("paypal");
        PayerInfo payerInfo = new PayerInfo();
        payerInfo.setFirstName("Duong")
                .setLastName("Le")
                .setEmail("17102002cc@gmail.com");
        payer.setPayerInfo(payerInfo);
        return payer;
    }

}
