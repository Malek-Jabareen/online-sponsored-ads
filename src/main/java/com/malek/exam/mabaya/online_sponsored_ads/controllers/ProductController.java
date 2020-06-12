package com.malek.exam.mabaya.online_sponsored_ads.controllers;

import com.malek.exam.mabaya.online_sponsored_ads.dtos.ProductDto;
import com.malek.exam.mabaya.online_sponsored_ads.services.ProductService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
@Api(tags = "Products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/")
    public ResponseEntity<List<ProductDto>> getProducts() {
        return new ResponseEntity<List<ProductDto>>(productService.getProducts(), HttpStatus.OK);
    }

//    @PostMapping("/generate")
//    public ResponseEntity<boolean> generateProducts() {
//        return new ResponseEntity<boolean>(true, HttpStatus.OK);
//    }
}
