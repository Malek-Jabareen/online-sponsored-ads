package com.malek.exam.mabaya.online_sponsored_ads.models;

public enum CampaignStatus {

    ACTIVE("ACTIVE"),
    DELETED("DELETED");

    private String status;

    CampaignStatus(String status) {
        this.status = status;
    }
}