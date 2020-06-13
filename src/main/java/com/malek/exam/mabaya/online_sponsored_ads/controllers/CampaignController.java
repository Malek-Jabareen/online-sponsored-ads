package com.malek.exam.mabaya.online_sponsored_ads.controllers;

import com.malek.exam.mabaya.online_sponsored_ads.dtos.CampaignDto;
import com.malek.exam.mabaya.online_sponsored_ads.dtos.requests.CreateCampaignRequest;
import com.malek.exam.mabaya.online_sponsored_ads.dtos.requests.UpdateCampaignRequest;
import com.malek.exam.mabaya.online_sponsored_ads.models.ApiResponse;
import com.malek.exam.mabaya.online_sponsored_ads.models.Campaign;
import com.malek.exam.mabaya.online_sponsored_ads.services.CampaignService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/campaigns")
@Api(tags = "Campaigns")
public class CampaignController {

    @Autowired
    private CampaignService campaignService;

    @PostMapping("")
    public ResponseEntity<ApiResponse<Campaign>> createCampaign(@Valid @RequestBody(required = true) CreateCampaignRequest createCampaignRequest) {
        ApiResponse<Campaign> response = campaignService.createCampaign(createCampaignRequest);
        return ResponseEntity.status(200).body(response);

    }

    @GetMapping("")
    public ResponseEntity<ApiResponse<List<CampaignDto>>> getCampaigns() {
        ApiResponse<List<CampaignDto>> response = campaignService.getCampaigns();
        return ResponseEntity.status(200).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<CampaignDto>> getCampaign(@PathVariable String id) {
        ApiResponse<CampaignDto> response = campaignService.getCampaign(id);
        return ResponseEntity.status(200).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<CampaignDto>> updateCampaign(@PathVariable String id, @Valid @RequestBody UpdateCampaignRequest updateCampaignRequest) {
        ApiResponse<CampaignDto> response = campaignService.updateCampaign(id, updateCampaignRequest);
        return ResponseEntity.status(200).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteCampaign(@PathVariable String id) {
        ApiResponse<Void> response = campaignService.deleteCampaign(id);
        return ResponseEntity.status(200).body(response);
    }
}
