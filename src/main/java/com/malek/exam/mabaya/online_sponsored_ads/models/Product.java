package com.malek.exam.mabaya.online_sponsored_ads.models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Product {

    @Id
    private ObjectId id;
}
