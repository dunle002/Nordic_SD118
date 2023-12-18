package com.example.Nordic_SD118.mapper;


import com.example.Nordic_SD118.dto.ProductDto;
import com.example.Nordic_SD118.entity.ChiTietSanPham;
import com.example.Nordic_SD118.entity.SanPham;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductMapper {
    @Autowired
    private  ModelMapper modelMapper;

    public ProductDto convertToDtoProduct(ChiTietSanPham chiTietSanPham, SanPham sanPham) {
        ProductDto productDto = new ProductDto();
        modelMapper.map(chiTietSanPham,ProductDto.class);
        modelMapper.map(sanPham,ProductDto.class);
        return productDto;
    }

    public ChiTietSanPham convertToProductDetail(ProductDto productDto) {
        ChiTietSanPham entity = modelMapper.map(productDto, ChiTietSanPham.class);
        return entity;
    }

    public SanPham convertToProduct(ProductDto productDto) {
        SanPham entity = modelMapper.map(productDto, SanPham.class);
        return entity;
    }
}
