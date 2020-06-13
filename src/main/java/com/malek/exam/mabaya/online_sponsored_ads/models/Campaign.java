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

    private String sellerId;

    private String name;

    private float bid;


    public Campaign() {
        this.timestamp = System.currentTimeMillis();
    }

    public Campaign(String id, String name, float bid, CampaignStatus status, String sellerId, List<Product> products) {
        this.id = id;
        this.name = name;
        this.bid = bid;
        this.status = status;
        this.sellerId = sellerId;
        this.products = products;
        this.timestamp = System.currentTimeMillis();
    }

    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
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

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getBid() {
        return bid;
    }

    public void setBid(float bid) {
        this.bid = bid;
    }
}