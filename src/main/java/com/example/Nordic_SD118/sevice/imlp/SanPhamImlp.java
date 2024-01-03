package com.example.Nordic_SD118.sevice.imlp;

import com.example.Nordic_SD118.entity.ChatLieu;
import com.example.Nordic_SD118.entity.ChiTietSanPham;
import com.example.Nordic_SD118.entity.DeGiay;
import com.example.Nordic_SD118.entity.Images;
import com.example.Nordic_SD118.entity.KichCo;
import com.example.Nordic_SD118.entity.MauSac;
import com.example.Nordic_SD118.entity.SanPham;
import com.example.Nordic_SD118.mapper.ProductMapper;
import com.example.Nordic_SD118.repository.ChatLieuRepository;
import com.example.Nordic_SD118.repository.DeGiayRepository;
import com.example.Nordic_SD118.repository.ImageRepositoriy;
import com.example.Nordic_SD118.repository.KichCoRepository;
import com.example.Nordic_SD118.repository.LoaiGiayRepository;
import com.example.Nordic_SD118.repository.MauSacRepository;
import com.example.Nordic_SD118.repository.ProductDetailRepositori;
import com.example.Nordic_SD118.repository.SanPhamRepository;
import com.example.Nordic_SD118.sevice.SanPhamSevice;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
public class SanPhamImlp implements SanPhamSevice {


    @Autowired
    SanPhamRepository repository;
    @Autowired
    ProductDetailRepositori detailRepo;
    @Autowired
    private LoaiGiayRepository loaiGiayRepository;
    @Autowired
    private ChatLieuRepository chatLieuRepository;
    @Autowired
    private MauSacRepository mauSacRepository;
    @Autowired
    private KichCoRepository kichCoRepository;
    @Autowired
    private DeGiayRepository deGiayRepository;
    @Autowired
    private ProductMapper mapper;
    @Autowired
    private ImageRepositoriy imageRepositoriy;
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Page<SanPham> getAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public List<SanPham> getAll() {
        return repository.findAll();
    }

    @Override
    public SanPham getOne(Integer id) {
        Optional<SanPham> otp = repository.findById(id);
        if (otp.isPresent()) {
            return otp.get();
        } else {
            return null;
        }
    }

    @Override
    public void delete(SanPham sanPham) {
        Integer idSanPham = sanPham.getIdProduct();
        resetParentIdInChildren(findChildrenByParentId(idSanPham));
        Boolean idSpNoExis = repository.existsById(idSanPham);
        if (idSpNoExis) {
            repository.delete(sanPham);
        }
    }

    @Override
    public SanPham Save(SanPham sanPham) {
        return repository.save(sanPham);
    }

    @Override
    public SanPham update(SanPham sanPham) {
        Integer idSanPham = sanPham.getIdProduct();
        Boolean idSpNoExis = repository.existsById(idSanPham);
        if (idSpNoExis) {
            return repository.save(sanPham);
        }
        return null;
    }


    @Transactional
    public List<ChiTietSanPham> findChildrenByParentId(Integer parentId) {
        SanPham parent = entityManager.find(SanPham.class, parentId);
        List<ChiTietSanPham> children = parent.getChildren();

        List<ChiTietSanPham> childrenWithParentId = new ArrayList<>();

        for (ChiTietSanPham child : children) {
            if (child.getSanPham().getIdProduct().equals(parentId)) {
                childrenWithParentId.add(child);
            }
        }

        return childrenWithParentId;
    }

    @Transactional
    public void resetParentIdInChildren(List<ChiTietSanPham> children) {
        for (ChiTietSanPham child : children) {
            child.setSanPham(null);
            entityManager.persist(child);
        }
    }

    @Override
    public String generateUniqueProductCode() {
        String prefix = "SP";
        String productCode;
        do {
            String randomCode = generateRandomCode();
            productCode = prefix + randomCode;
        } while (repository.existsByMa(productCode));

        return productCode;
    }

    @Override
    public String addAllDetail(List<MultipartFile> fileImages, Integer chatLieuGet, Integer deGiayGet, List<Integer> mauSacGet, List<Integer> kichCoGet, List<BigDecimal> giaGet, List<Integer> soLuongGet, SanPham sanPham) {
        List<ChiTietSanPham> chiTietSanPhams = new ArrayList<>();
        int additionalListIndex = 0;


        //List
        List<String> fileImageName = new ArrayList<>();
        List<Integer> mauSac1 = new ArrayList<>();
        mauSac1.addAll(mauSacGet);
        List<Integer> kichCo2 = new ArrayList<>();
        kichCo2.addAll(kichCoGet);
        List<BigDecimal> donGia3 = new ArrayList<>();
        donGia3.addAll(giaGet);
        List<Integer> soLuong4 = new ArrayList<>();
        soLuong4.addAll(soLuongGet);
        //list multipartFile
        List<List<String>> fileImageSets = new ArrayList<>();
        int batchSize = 3;
        int count = 0;
        List<String> currentSet = new ArrayList<>();

        for (MultipartFile abc : fileImages) {
            fileImageName.add(abc.getOriginalFilename());
            currentSet.add("../../images/" + abc.getOriginalFilename());
            count++;

            if (count == batchSize) {
                fileImageSets.add(currentSet);
                currentSet = new ArrayList<>();
                count = 0;
            }
        }
        List<Images> imagesList = new ArrayList<>();

// Kiểm tra xem nếu còn phần tử trong currentSet, thì thêm nó vào fileImageSets
        for (int i = 0; i < kichCo2.size(); i++) {
            ChiTietSanPham detail = new ChiTietSanPham();
            MauSac mauSac = mauSacRepository.getReferenceById(mauSac1.get(i));
            detail.setMauSac(mauSac);
            KichCo kichCo = kichCoRepository.getReferenceById(kichCo2.get(i));
            detail.setKichCo(kichCo);
            ChatLieu chatLieu = chatLieuRepository.getReferenceById(chatLieuGet);
            detail.setChatLieu(chatLieu);
            DeGiay deGiay = deGiayRepository.getReferenceById(deGiayGet);
            detail.setDeGiay(deGiay);
            detail.setDonGia(donGia3.get(i));
            detail.setSoLuong(soLuong4.get(i));
            detail.setSanPham(sanPham);
            detailRepo.save(detail);
            if (additionalListIndex < fileImageSets.size()) {
                List<String> additionalList = fileImageSets.get(additionalListIndex);
                System.out.println(additionalList);
                for (int abc = 0; abc < additionalList.size(); abc++) {
                    Images images = new Images();
                    images.setUrl(additionalList.get(abc));
                    images.setDetail(detail);
                    imagesList.add(images);
                }

                additionalListIndex++;
            }

        }
        for (Images ac : imagesList
        ) {
            System.out.println("url: " + ac.getUrl() + ", ctsp:" + ac.getDetail().getIdProductDetail());
        }
        imageRepositoriy.saveAll(imagesList);

        return "Thành công";
    }

    private String generateRandomCode() {
        String numbers = "0123456789";
        String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        StringBuilder randomCode = new StringBuilder();

        // Sinh ra 2 số ngẫu nhiên
        for (int i = 0; i < 2; i++) {
            int randomIndex = (int) (Math.random() * numbers.length());
            randomCode.append(numbers.charAt(randomIndex));
        }

        // Sinh ra 2 chữ ngẫu nhiên
        for (int i = 0; i < 2; i++) {
            int randomIndex = (int) (Math.random() * letters.length());
            randomCode.append(letters.charAt(randomIndex));
        }

        return randomCode.toString();

    }
}
