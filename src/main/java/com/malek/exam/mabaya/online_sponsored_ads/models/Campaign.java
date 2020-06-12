package com.malek.exam.mabaya.online_sponsored_ads.models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
public class Campaign {

    @Id
    private ObjectId id;

    private CampaignStatus status = CampaignStatus.ACTIVE;

    @DBRef
    private List<Product> products;

    private long timestamp;

    public Campaign() {
    }

    public Campaign(ObjectId id, CampaignStatus status, List<Product> products) {
        this.id = id;
        this.status = status;
        this.products = products;
        this.timestamp = System.currentTimeMillis();
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public CampaignStatus getStatus() {
        return status;
    }

    public void setStatus(CampaignStatus status) {
        this.status = status;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}