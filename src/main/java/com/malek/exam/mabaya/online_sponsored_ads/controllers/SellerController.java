package com.malek.exam.mabaya.online_sponsored_ads.controllers;

import com.malek.exam.mabaya.online_sponsored_ads.dtos.SellerDto;
import com.malek.exam.mabaya.online_sponsored_ads.dtos.requests.CreateSellerRequest;
import com.malek.exam.mabaya.online_sponsored_ads.dtos.requests.UpdateSellerRequest;
import com.malek.exam.mabaya.online_sponsored_ads.models.ApiResponse;
import com.malek.exam.mabaya.online_sponsored_ads.services.SellerService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/sellers")
@Api(tags = "Sellers")
public class SellerController {

    @Autowired
    private SellerService sellerService;

    @GetMapping("")
    public ResponseEntity<ApiResponse<List<SellerDto>>> getSellers() {
        ApiResponse<List<SellerDto>> response = sellerService.getSellers();
        return ResponseEntity.status(response.statusCode.value()).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<SellerDto>> getSeller(@PathVariable String id) {
        ApiResponse<SellerDto> response = sellerService.getSeller(id);
        return ResponseEntity.status(response.statusCode.value()).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<SellerDto>> getSeller(@PathVariable String id, @Valid @RequestBody UpdateSellerRequest updateSellerRequest) {
        ApiResponse<SellerDto> response = sellerService.updateSeller(id, updateSellerRequest);
        return ResponseEntity.status(response.statusCode.value()).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteSeller(@PathVariable String id) {
        ApiResponse<Void> response = sellerService.deleteSeller(id);
        return ResponseEntity.status(response.statusCode.value()).body(response);
    }

    @PostMapping("")
    public ResponseEntity<ApiResponse<SellerDto>> createSeller(@Valid @RequestBody CreateSellerRequest createSellerRequest) {
        ApiResponse<SellerDto> response = sellerService.createSeller(createSellerRequest);
        return ResponseEntity.status(response.statusCode.value()).body(response);
    }
}