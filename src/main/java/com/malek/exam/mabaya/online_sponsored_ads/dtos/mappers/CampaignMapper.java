package com.malek.exam.mabaya.online_sponsored_ads.dtos.mappers;

import com.malek.exam.mabaya.online_sponsored_ads.dtos.CampaignDto;
import com.malek.exam.mabaya.online_sponsored_ads.models.Campaign;

public class CampaignMapper {
    public static CampaignDto toCampaignDto(Campaign campaign) {
        return new CampaignDto();
    }
}
