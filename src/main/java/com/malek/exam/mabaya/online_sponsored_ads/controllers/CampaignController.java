package com.malek.exam.mabaya.online_sponsored_ads.controllers;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/campaign")
@Api(tags = "Campaign")
public class CampaignController {

    @GetMapping("/")
    public int getIntTest(@RequestBody(required = true) String justAString) {
        return 1;
    }
}
