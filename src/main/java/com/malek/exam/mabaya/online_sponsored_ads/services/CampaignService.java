package com.malek.exam.mabaya.online_sponsored_ads.services;

import com.malek.exam.mabaya.online_sponsored_ads.dtos.CampaignDto;
import com.malek.exam.mabaya.online_sponsored_ads.dtos.mappers.CampaignMapper;
import com.malek.exam.mabaya.online_sponsored_ads.dtos.requests.CreateCampaignRequest;
import com.malek.exam.mabaya.online_sponsored_ads.dtos.requests.UpdateCampaignRequest;
import com.malek.exam.mabaya.online_sponsored_ads.exceptions.InvalidRequestBodyException;
import com.malek.exam.mabaya.online_sponsored_ads.exceptions.NotFoundException;
import com.malek.exam.mabaya.online_sponsored_ads.exceptions.ConnectToDatabaseException;
import com.malek.exam.mabaya.online_sponsored_ads.models.*;

import com.malek.exam.mabaya.online_sponsored_ads.repositories.CampaignRepository;
import com.malek.exam.mabaya.online_sponsored_ads.repositories.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.validation.ValidationException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CampaignService {

    @Autowired
    private CampaignRepository campaignRepository;
    @Autowired
    private SellerRepository sellerRepository;
    @Autowired
    private TranslationService translationService;

    public ApiResponse<CampaignDto> createCampaign(CreateCampaignRequest createCampaignRequest) {
        ApiResponse<CampaignDto> response = new ApiResponse<CampaignDto>();
        Campaign campaign = new Campaign();
        // Retrieve Seller and check if exists
        Optional<Seller> seller = sellerRepository.findById(createCampaignRequest.getSellerId());
        if (seller.isEmpty()) {
            throw new NotFoundException(translationService.translate("SellerNotFound"));
        }
        try {
            // Save campaign
            List<Product> productList = seller.get().getProducts();
            campaign.setSellerId(createCampaignRequest.getSellerId());
            campaign.setProducts(productList);
            campaign.setName(createCampaignRequest.getName());
            campaign.setBid(createCampaignRequest.getBid());
            response.data = CampaignMapper.toCampaignDto(campaignRepository.save(campaign));
        } catch (Exception e) {
            throw new ConnectToDatabaseException(translationService.translate("SaveToDatabaseError"));
        }
        return response;
    }

    public ApiResponse<List<CampaignDto>> getCampaigns() {
        ApiResponse<List<CampaignDto>> response = new ApiResponse<List<CampaignDto>>();
        try {
            response.data = campaignRepository.findAll().stream().map(CampaignMapper::toCampaignDto).collect(Collectors.toList());
            if (response.data.size() == 0) {
                response.statusCode = HttpStatus.NO_CONTENT;
            }
        } catch (Exception e) {
            throw new ConnectToDatabaseException(translationService.translate("ReadFromDatabaseError"));
        }

        return response;
    }

    public ApiResponse<CampaignDto> getCampaign(String id) {
        ApiResponse<CampaignDto> response = new ApiResponse<CampaignDto>();
        if (campaignRepository.findById(id).isEmpty()) {
            throw new ConnectToDatabaseException(translationService.translate("CampaignNotFound"));
        }
        response.data = CampaignMapper.toCampaignDto(campaignRepository.findById(id).get());
        return response;
    }

    public ApiResponse<CampaignDto> updateCampaign(String id, UpdateCampaignRequest updateCampaignRequest) {
        ApiResponse<CampaignDto> response = new ApiResponse<CampaignDto>();
        if (campaignRepository.findById(id).isEmpty()) {
            throw new ConnectToDatabaseException(translationService.translate("CampaignNotFound"));
        }
        if (!CampaignStatus.isValid(updateCampaignRequest.getStatus().name())) {
            throw new InvalidRequestBodyException(translationService.translate("CampaignStatusIsInvalid"));
        }
        try {
            Campaign campaign = campaignRepository.findById(id).get();
            campaign.setStatus(updateCampaignRequest.getStatus());
            campaign.setName(updateCampaignRequest.getName());
            campaign.setBid(updateCampaignRequest.getBid());
            response.data = CampaignMapper.toCampaignDto(campaignRepository.save(campaign));
        } catch (Exception e) {
            throw new ConnectToDatabaseException(translationService.translate("SaveToDatabaseError"));
        }
        return response;
    }

    public ApiResponse<Void> deleteCampaign(String id) {
        ApiResponse<Void> response = new ApiResponse<Void>();
        if (campaignRepository.findById(id).isEmpty()) {
            throw new ConnectToDatabaseException(translationService.translate("CampaignNotFound"));
        }
        try {
            campaignRepository.deleteById(id);
        } catch (Exception e) {
            throw new ConnectToDatabaseException(translationService.translate("DeleteFromDatabaseError"));
        }
        return response;
    }
}
