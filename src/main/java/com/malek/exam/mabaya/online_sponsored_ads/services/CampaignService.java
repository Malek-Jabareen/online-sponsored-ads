package com.malek.exam.mabaya.online_sponsored_ads.services;

import com.malek.exam.mabaya.online_sponsored_ads.dtos.requests.CreateCampaignRequest;
import com.malek.exam.mabaya.online_sponsored_ads.exceptions.NotFoundException;
import com.malek.exam.mabaya.online_sponsored_ads.exceptions.ConnectToDatabaseException;
import com.malek.exam.mabaya.online_sponsored_ads.models.ApiResponse;
import com.malek.exam.mabaya.online_sponsored_ads.models.Campaign;
import com.malek.exam.mabaya.online_sponsored_ads.models.Product;

import com.malek.exam.mabaya.online_sponsored_ads.repositories.CampaignRepository;
import com.malek.exam.mabaya.online_sponsored_ads.repositories.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CampaignService {

    @Autowired
    private CampaignRepository campaignRepository;
    @Autowired
    private SellerRepository sellerRepository;
    @Autowired
    private TranslationService translationService;

    public ApiResponse<Campaign> createCampaign(CreateCampaignRequest createCampaignRequest) {
        ApiResponse<Campaign> response = new ApiResponse<Campaign>();
        Campaign campaign = new Campaign();
        if (sellerRepository.findById(createCampaignRequest.getSellerId()).isEmpty()) {
            throw new NotFoundException(translationService.translate("SellerNotFound"));
        }
        try {
            List<Product> productList = sellerRepository.findById(createCampaignRequest.getSellerId()).get().getProducts();
            campaign.setSellerId(createCampaignRequest.getSellerId());
            campaign.setProducts(productList);
            response.data = campaignRepository.save(campaign);
        } catch (Exception e) {
            throw new ConnectToDatabaseException(translationService.translate("SaveToDatabaseError"));
        }
        return response;
    }

    public ApiResponse<List<Campaign>> getCampaigns() {
        ApiResponse<List<Campaign>> response = new ApiResponse<List<Campaign>>();
        try {
            response.data = campaignRepository.findAll();
        } catch (Exception e) {
            throw new ConnectToDatabaseException(translationService.translate("ReadFromDatabaseError"));
        }
        return response;
    }
}
