package com.example.Nordic_SD118.mapper;



import com.example.Nordic_SD118.DTO.ProductDetailDTO;
import com.example.Nordic_SD118.DTO.ProductDto;
import com.example.Nordic_SD118.DTO.ProductDtoAndDetailDto;
import com.example.Nordic_SD118.entity.ChiTietSanPham;
import com.example.Nordic_SD118.entity.SanPham;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductMapper {
    @Autowired
    private  ModelMapper modelMapper;

    public ProductDtoAndDetailDto convertToDtoAllProduct(SanPham sanPham,ChiTietSanPham chiTietSanPham) {
        ProductDtoAndDetailDto productDto = new ProductDtoAndDetailDto();
        modelMapper.map(sanPham,ProductDtoAndDetailDto.class);
        modelMapper.map(chiTietSanPham,ProductDtoAndDetailDto.class);
        return productDto;
    }

    public ProductDto convertToDtoProduct(SanPham sanPham) {
        ProductDto productDto = new ProductDto();
        modelMapper.map(sanPham,ProductDto.class);
        return productDto;
    }
    public ProductDetailDTO convertToDtoProductDetail(ChiTietSanPham ctsanPham) {
        ProductDetailDTO productDto = new ProductDetailDTO();
        modelMapper.map(ctsanPham,ProductDetailDTO.class);
        return productDto;
    }

    public ChiTietSanPham convertToProductDetail(ProductDetailDTO productDto) {
        ChiTietSanPham entity = modelMapper.map(productDto, ChiTietSanPham.class);
        return entity;
    }

    public ChiTietSanPham convertToProductDetail(ProductDtoAndDetailDto productDto) {
        ChiTietSanPham entity = modelMapper.map(productDto, ChiTietSanPham.class);
        return entity;
    }

    public SanPham convertToProduct(ProductDto productDto) {
        SanPham entity = modelMapper.map(productDto, SanPham.class);
        return entity;

    }

    public SanPham convertToProduct(ProductDtoAndDetailDto productDto) {
        SanPham entity = modelMapper.map(productDto, SanPham.class);
        return entity;
    }

}
