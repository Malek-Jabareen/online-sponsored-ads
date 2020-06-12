package com.malek.exam.mabaya.online_sponsored_ads.models;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "campaign")
public class Campaign {

    @Id
    private String id;

    private CampaignStatus status = CampaignStatus.ACTIVE;

    @DBRef
    private List<Product> products;

    @CreatedDate
    private long timestamp;

    public Campaign() {
        this.timestamp = System.currentTimeMillis();
    }

    public Campaign(String id, CampaignStatus status, List<Product> products) {
        this.id = id;
        this.status = status;
        this.products = products;
        this.timestamp = System.currentTimeMillis();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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