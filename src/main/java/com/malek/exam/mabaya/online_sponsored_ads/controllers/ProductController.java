package com.malek.exam.mabaya.online_sponsored_ads.controllers;

import com.malek.exam.mabaya.online_sponsored_ads.dtos.ProductDto;
import com.malek.exam.mabaya.online_sponsored_ads.dtos.requests.CreateProductRequest;
import com.malek.exam.mabaya.online_sponsored_ads.dtos.requests.UpdateProductRequest;
import com.malek.exam.mabaya.online_sponsored_ads.models.ApiResponse;
import com.malek.exam.mabaya.online_sponsored_ads.services.AdvertisementsService;
import com.malek.exam.mabaya.online_sponsored_ads.services.ProductService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/products")
@Api(tags = "Products")
public class ProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private AdvertisementsService advertisementsService;

    @GetMapping("/ad/{categoryName}")
    public ResponseEntity<ApiResponse<ProductDto>> getAd(@PathVariable String categoryName) {
        ApiResponse<ProductDto> response = advertisementsService.retrieveAds(categoryName);
        return ResponseEntity.status(200).body(response);
    }

    @GetMapping("")
    public ResponseEntity<ApiResponse<List<ProductDto>>> getProducts() {
        ApiResponse<List<ProductDto>> response = productService.getProducts();
        return new ResponseEntity<ApiResponse<List<ProductDto>>>(response, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<ApiResponse<ProductDto>> addProduct(@Valid @RequestBody CreateProductRequest createProductRequest) {
        ApiResponse<ProductDto> response = productService.addProduct(createProductRequest);
        return ResponseEntity.status(200).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<ProductDto>> getProduct(@PathVariable String id) {
        ApiResponse<ProductDto> response = productService.getProduct(id);
        return ResponseEntity.status(200).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteProduct(@PathVariable String id) {
        ApiResponse<Void> response = productService.deleteProduct(id);
        return ResponseEntity.status(200).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<ProductDto>> updateProduct(@PathVariable String id, @Valid @RequestBody UpdateProductRequest updateProductRequest) {
        ApiResponse<ProductDto> response = productService.updateProduct(id, updateProductRequest);
        return ResponseEntity.status(200).body(response);
    }
}
