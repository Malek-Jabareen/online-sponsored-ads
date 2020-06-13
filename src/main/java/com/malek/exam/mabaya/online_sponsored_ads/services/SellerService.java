package com.malek.exam.mabaya.online_sponsored_ads.services;

import com.malek.exam.mabaya.online_sponsored_ads.dtos.SellerDto;
import com.malek.exam.mabaya.online_sponsored_ads.dtos.mappers.SellerMapper;
import com.malek.exam.mabaya.online_sponsored_ads.dtos.requests.CreateSellerRequest;
import com.malek.exam.mabaya.online_sponsored_ads.dtos.requests.UpdateSellerRequest;
import com.malek.exam.mabaya.online_sponsored_ads.exceptions.NotFoundException;
import com.malek.exam.mabaya.online_sponsored_ads.models.ApiResponse;
import com.malek.exam.mabaya.online_sponsored_ads.models.Seller;
import com.malek.exam.mabaya.online_sponsored_ads.repositories.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SellerService {
    @Autowired
    private SellerRepository sellerRepository;
    @Autowired
    private TranslationService translationService;

    public ApiResponse<List<SellerDto>> getSellers() {
        ApiResponse<List<SellerDto>> response = new ApiResponse<List<SellerDto>>();
        response.data = sellerRepository.findAll().stream()
                .map(SellerMapper::toSellerDto).collect(Collectors.toList());
        return response;
    }

    public ApiResponse<SellerDto> getSeller(String id) {
        ApiResponse<SellerDto> response = new ApiResponse<SellerDto>();
        if (sellerRepository.findById(id).isEmpty()) {
            throw new NotFoundException(translationService.translate("SellerNotFound"));
        }
        response.data = SellerMapper.toSellerDto(sellerRepository.findById(id).get());
        return response;
    }

    public ApiResponse<SellerDto> updateSeller(String id, UpdateSellerRequest updateSellerRequest) {
        ApiResponse<SellerDto> response = new ApiResponse<SellerDto>();
        if (sellerRepository.findById(id).isEmpty()) {
            throw new NotFoundException(translationService.translate("SellerNotFound"));
        }
        Seller seller = sellerRepository.findById(id).get();
        seller.setUserName(updateSellerRequest.getUserName());
        response.data = SellerMapper.toSellerDto(sellerRepository.save(seller));
        return response;
    }

    public ApiResponse<Void> deleteSeller(String id) {
        ApiResponse<Void> response = new ApiResponse<Void>();
        if (sellerRepository.findById(id).isEmpty()) {
            throw new NotFoundException(translationService.translate("SellerNotFound"));
        }
        sellerRepository.deleteById(id);
        return response;
    }

    public ApiResponse<SellerDto> createSeller(CreateSellerRequest createSellerRequest) {
        ApiResponse<SellerDto> response = new ApiResponse<SellerDto>();
        Seller seller = new Seller();
        seller.setUserName(createSellerRequest.getUserName());
        response.data = SellerMapper.toSellerDto(sellerRepository.save(seller));
        return response;
    }
}
