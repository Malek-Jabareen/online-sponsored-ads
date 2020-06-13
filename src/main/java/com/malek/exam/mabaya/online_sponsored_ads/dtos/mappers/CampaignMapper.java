package com.malek.exam.mabaya.online_sponsored_ads.dtos.mappers;

import com.malek.exam.mabaya.online_sponsored_ads.dtos.CampaignDto;
import com.malek.exam.mabaya.online_sponsored_ads.models.Campaign;
import com.malek.exam.mabaya.online_sponsored_ads.models.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CampaignMapper {
    public static CampaignDto toCampaignDto(Campaign campaign) {
        List<Product> products = campaign.getProducts();
        if (products == null) {
            products = new ArrayList<Product>();
        }
        return new CampaignDto(
                campaign.getId(),
                campaign.getStatus(),
                products.stream().map(ProductMapper::toProductDto).collect(Collectors.toList()),
                campaign.getTimestamp(),
                campaign.getSellerId()

        );
    }
}
