package com.malek.exam.mabaya.online_sponsored_ads.services;

import com.malek.exam.mabaya.online_sponsored_ads.dtos.CreateCampaignRequest;
import com.malek.exam.mabaya.online_sponsored_ads.models.ApiResponse;
import com.malek.exam.mabaya.online_sponsored_ads.repositories.CampaignRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class CampaignService {

    @Autowired
    private CampaignRepository campaignRepository;

    public ApiResponse createCampaign(CreateCampaignRequest createCampaignRequest) {
        ApiResponse response = new ApiResponse();
        Map<String, Object> jsonMap = new HashMap<>();
        response.data = createCampaignRequest;
        try {

        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }
}
