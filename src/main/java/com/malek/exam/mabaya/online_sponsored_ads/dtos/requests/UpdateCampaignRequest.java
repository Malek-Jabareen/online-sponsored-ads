package com.malek.exam.mabaya.online_sponsored_ads.dtos.requests;

import com.malek.exam.mabaya.online_sponsored_ads.models.CampaignStatus;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UpdateCampaignRequest {

    @NotNull(message = "Name is required")
    @NotEmpty(message = "Name is required")
    @Size(min = 3, message = "Name must be at least 2 characters length")
    private String name;

    @NotNull(message = "bid is required")
    private float bid;

    @NotNull(message = "status is required")
    private CampaignStatus status;

    public UpdateCampaignRequest(String name, float bid, CampaignStatus status) {
        this.name = name;
        this.bid = bid;
        this.status = status;
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

    public CampaignStatus getStatus() {
        return status;
    }

    public void setStatus(CampaignStatus status) {
        this.status = status;
    }
}
