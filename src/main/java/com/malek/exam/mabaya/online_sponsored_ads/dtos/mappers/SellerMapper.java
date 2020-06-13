package com.malek.exam.mabaya.online_sponsored_ads.dtos.mappers;

import com.malek.exam.mabaya.online_sponsored_ads.dtos.ProductDto;
import com.malek.exam.mabaya.online_sponsored_ads.dtos.SellerDto;
import com.malek.exam.mabaya.online_sponsored_ads.models.Product;
import com.malek.exam.mabaya.online_sponsored_ads.models.Seller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SellerMapper {
    public static SellerDto toSellerDto(Seller seller) {
        List<Product> products = seller.getProducts();
        if (products == null) {
            products = new ArrayList<Product>();
        }
        return new SellerDto(
                seller.getId(),
                seller.getUserName(),
                seller.getTimestamp(),
                products.stream().map(ProductMapper::toProductDto).collect(Collectors.toList())
        );
    }
}
