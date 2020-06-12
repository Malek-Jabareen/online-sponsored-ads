package com.malek.exam.mabaya.online_sponsored_ads.controllers;

import com.malek.exam.mabaya.online_sponsored_ads.helpers.JsonHelper;
import com.malek.exam.mabaya.online_sponsored_ads.models.ApiResponse;
import com.malek.exam.mabaya.online_sponsored_ads.services.TranslationService;
import io.swagger.annotations.Api;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/initData")
@Api(tags = "Init Data", description = "This Api will insert Categories, Products and Sellers to the MongoDB ")
public class InitDataController {

    @Autowired
    private TranslationService translator;

    @GetMapping("/")
    public ResponseEntity<ApiResponse<Object>> initData() throws IOException, ParseException {
        ApiResponse<Object> response = new ApiResponse<Object>();
        response.data = JsonHelper.readJson("src/main/resources/mocks/Categories.json");
        response.message = translator.translate("AppInitiatedSuccessfully");
        return ResponseEntity.status(200).body(response);
    }
}
