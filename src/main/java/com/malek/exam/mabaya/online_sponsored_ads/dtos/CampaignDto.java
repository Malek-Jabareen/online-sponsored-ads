package com.malek.exam.mabaya.online_sponsored_ads.dtos;

import com.malek.exam.mabaya.online_sponsored_ads.models.CampaignStatus;
import com.malek.exam.mabaya.online_sponsored_ads.models.Product;


import java.util.List;

public class CampaignDto {
    private String id;

    private CampaignStatus status;

    private List<ProductDto> products;

    private long timestamp;

    private String sellerId;

    private float bid;

    public CampaignDto(String id, CampaignStatus status, List<ProductDto> products, long timestamp, String sellerId, float bid) {
        this.id = id;
        this.status = status;
        this.products = products;
        this.timestamp = timestamp;
        this.sellerId = sellerId;
        this.bid = bid;
    }

    public float getBid() {
        return bid;
    }

    public void setBid(float bid) {
        this.bid = bid;
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

    public List<ProductDto> getProducts() {
        return products;
    }

    public void setProducts(List<ProductDto> products) {
        this.products = products;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }
}
