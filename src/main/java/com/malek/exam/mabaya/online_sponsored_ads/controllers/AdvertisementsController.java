package com.malek.exam.mabaya.online_sponsored_ads.controllers;

import com.malek.exam.mabaya.online_sponsored_ads.dtos.ProductDto;
import com.malek.exam.mabaya.online_sponsored_ads.models.ApiResponse;
import com.malek.exam.mabaya.online_sponsored_ads.services.AdvertisementsService;


import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/advertisements")
@Api(tags = "Advertisements", description = "Please Disable ADBlocker")
public class AdvertisementsController {

    @Autowired
    private AdvertisementsService advertisementsService;

    @GetMapping("/serveAd/{categoryName}")
    public ResponseEntity<ApiResponse<ProductDto>> getProduct(@PathVariable String categoryName) {
        ApiResponse<ProductDto> response = advertisementsService.retrieveAds(categoryName);
        return ResponseEntity.status(response.statusCode.value()).body(response);
    }
}
