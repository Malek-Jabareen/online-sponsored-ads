package com.malek.exam.mabaya.online_sponsored_ads.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Campaign {

    @Id
    private String id;
}
