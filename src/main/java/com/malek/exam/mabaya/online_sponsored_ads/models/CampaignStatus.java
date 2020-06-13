package com.malek.exam.mabaya.online_sponsored_ads.models;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum CampaignStatus {

    ACTIVE("ACTIVE"),
    DELETED("DELETED");

    private String status;

    CampaignStatus(String status) {
        if (status.equals("ACTIVE") || status.equals("DELETED")) {
            this.status = status;
        } else {
            this.status = "ACTIVE";
        }
    }

    public static Boolean isValid(String campaignStatus) {
        List<String> acceptedValues = Stream.of(CampaignStatus.values())
                .map(Enum::name)
                .collect(Collectors.toList());
        return acceptedValues.contains(campaignStatus);
    }
}