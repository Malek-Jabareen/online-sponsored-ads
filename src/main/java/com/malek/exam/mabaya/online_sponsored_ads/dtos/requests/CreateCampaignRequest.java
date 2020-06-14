package com.malek.exam.mabaya.online_sponsored_ads.dtos.requests;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CreateCampaignRequest {
    @NotNull(message = "Name is required")
    @NotEmpty(message = "Name is required")
    @Size(min = 3, message = "Name must be at least 2 characters length")
    private String name;

    @NotNull(message = "bid is required")
    private float bid;

    @NotNull(message = "sellerId is required")
    @NotEmpty(message = "sellerId is required")
    private String sellerId;

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

    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }
}
