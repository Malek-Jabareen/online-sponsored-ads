package com.malek.exam.mabaya.online_sponsored_ads.dtos.mappers;

import com.malek.exam.mabaya.online_sponsored_ads.dtos.SellerDto;
import com.malek.exam.mabaya.online_sponsored_ads.models.Seller;

public class SellerMapper {
    public static SellerDto toSellerDto(Seller seller) {
        return new SellerDto();
    }
}
