package com.malek.exam.mabaya.online_sponsored_ads.dtos.mappers;

import com.malek.exam.mabaya.online_sponsored_ads.dtos.ProductDto;
import com.malek.exam.mabaya.online_sponsored_ads.models.Product;

public class ProductMapper {
    public static ProductDto toProductDto(Product product) {
        return new ProductDto(
                product.getId(),
                product.getTitle(),
                product.getPrice(),
                product.getCategoryName(),
                product.getSerialNumber(),
                product.getSellerId()
        );
    }
}
