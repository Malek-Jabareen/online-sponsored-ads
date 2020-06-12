package com.malek.exam.mabaya.online_sponsored_ads.controllers;

import com.malek.exam.mabaya.online_sponsored_ads.dtos.requests.CreateCampaignRequest;
import com.malek.exam.mabaya.online_sponsored_ads.models.ApiResponse;
import com.malek.exam.mabaya.online_sponsored_ads.services.CampaignService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/campaigns")
@Api(tags = "Campaigns")
public class CampaignController {

    @Autowired
    private CampaignService campaignService;

    @PostMapping("/")
    public ResponseEntity<ApiResponse> createCampaign(@Valid @RequestBody(required = true) CreateCampaignRequest createCampaignRequest) {
        ApiResponse response = campaignService.createCampaign(createCampaignRequest);
        return ResponseEntity.status(200).body(response);

    }
}
