package com.malek.exam.mabaya.online_sponsored_ads.services;

import com.malek.exam.mabaya.online_sponsored_ads.dtos.ProductDto;
import com.malek.exam.mabaya.online_sponsored_ads.dtos.mappers.ProductMapper;
import com.malek.exam.mabaya.online_sponsored_ads.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<ProductDto> getProducts() {
        List<ProductDto> products = new ArrayList<ProductDto>();
        productRepository.findAll()
                .forEach(product -> products.add(ProductMapper.toProductDto(product)));
        return products;
    }
}
