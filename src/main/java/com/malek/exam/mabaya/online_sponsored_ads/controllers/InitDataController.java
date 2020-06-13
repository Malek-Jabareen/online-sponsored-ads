package com.malek.exam.mabaya.online_sponsored_ads.controllers;

import com.malek.exam.mabaya.online_sponsored_ads.models.ApiResponse;
import com.malek.exam.mabaya.online_sponsored_ads.services.InitDataService;
import io.swagger.annotations.Api;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/data")
@Api(tags = "Data", description = "This Api will insert Categories, Products and Sellers to the MongoDB or delete them")
public class InitDataController {

    @Autowired
    private InitDataService initDataService;

    @GetMapping("/initData")
    public ResponseEntity<ApiResponse<Object>> initData() throws IOException, ParseException {
        ApiResponse<Object> response = initDataService.initData();
        return ResponseEntity.status(200).body(response);
    }

    @GetMapping("/deleteData")
    public ResponseEntity<ApiResponse<Object>> deleteData() throws IOException, ParseException {
        ApiResponse<Object> response = initDataService.deleteData();
        return ResponseEntity.status(200).body(response);
    }
}
