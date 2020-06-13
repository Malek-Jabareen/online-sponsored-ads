package com.malek.exam.mabaya.online_sponsored_ads.controllers;

import com.malek.exam.mabaya.online_sponsored_ads.dtos.ProductDto;
import com.malek.exam.mabaya.online_sponsored_ads.dtos.requests.CreateProductRequest;
import com.malek.exam.mabaya.online_sponsored_ads.dtos.requests.UpdateProductRequest;
import com.malek.exam.mabaya.online_sponsored_ads.models.ApiResponse;
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

    @GetMapping("")
    public ResponseEntity<ApiResponse<List<ProductDto>>> getProducts() {
        ApiResponse<List<ProductDto>> response = new ApiResponse<List<ProductDto>>();
        response = productService.getProducts();
        return new ResponseEntity<ApiResponse<List<ProductDto>>>(response, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<ApiResponse<ProductDto>> addProduct(@Valid @RequestBody CreateProductRequest createProductRequest) {
        ApiResponse<ProductDto> response = new ApiResponse<ProductDto>();
        response = productService.addProduct(createProductRequest);
        return new ResponseEntity<ApiResponse<ProductDto>>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<ProductDto>> getProduct(@PathVariable String id) {
        ApiResponse<ProductDto> response = new ApiResponse<ProductDto>();
        response = productService.getProduct(id);
        return new ResponseEntity<ApiResponse<ProductDto>>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteProduct(@PathVariable String id) {
        ApiResponse<Void> response = new ApiResponse<Void>();
        response = productService.deleteProduct(id);
        return new ResponseEntity<ApiResponse<Void>>(response, HttpStatus.OK);
    }

    @PutMapping("")
    public ResponseEntity<ApiResponse<ProductDto>> updateProduct(@Valid @RequestBody UpdateProductRequest updateProductRequest) {
        ApiResponse<ProductDto> response = new ApiResponse<ProductDto>();
        response = productService.updateProduct(updateProductRequest);
        return new ResponseEntity<ApiResponse<ProductDto>>(response, HttpStatus.OK);
    }
}
