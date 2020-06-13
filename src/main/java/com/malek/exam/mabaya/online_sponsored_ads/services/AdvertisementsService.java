package com.malek.exam.mabaya.online_sponsored_ads.services;

import com.malek.exam.mabaya.online_sponsored_ads.dtos.ProductDto;
import com.malek.exam.mabaya.online_sponsored_ads.dtos.mappers.ProductMapper;
import com.malek.exam.mabaya.online_sponsored_ads.models.*;
import com.malek.exam.mabaya.online_sponsored_ads.repositories.CampaignRepository;
import com.malek.exam.mabaya.online_sponsored_ads.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AdvertisementsService {
    @Autowired
    private TranslationService translationService;
    @Autowired
    private CampaignRepository campaignRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    public ApiResponse<ProductDto> retrieveAds(String categoryName) {
        ApiResponse<ProductDto> response = new ApiResponse<ProductDto>();

        // Retrieve the category from the DB and throw
        Category category = categoryRepository.findByName(categoryName);
        List<Campaign> campaigns = campaignRepository.findCampaignsWhereAndStatusIsActiveAndHaveProductsOrderedByBid();

        // Option 1 - Product that belongs to an active campaign with highest bid in the category
        if (category != null) {
            // Here i understand that i was should use SQL instead,
            // OR to stop working with DBRef,
            // OR to find alternative for relationships
            // but tried to make the life easier.
            for (Campaign campaign : campaigns) {
                for (Product product : campaign.getProducts()) {
                    if (product.getCategoryName().toLowerCase().trim().equals(categoryName.toLowerCase().trim())) {
                        response.data = ProductMapper.toProductDto(product);
                        return response;
                    }
                }
            }
        }
        // Option 2 - Product that belongs to an active campaign with highest bid but not in the category
        response.data = ProductMapper.toProductDto(campaigns.get(0).getProducts().get(0));
        return response;

    }
}
