package com.malek.exam.mabaya.online_sponsored_ads.repositories;

import com.malek.exam.mabaya.online_sponsored_ads.models.Campaign;
import com.malek.exam.mabaya.online_sponsored_ads.models.CampaignStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface CampaignRepository extends MongoRepository<Campaign, String> {
    @Query(value = "{ status : 'ACTIVE', products: { $exists: true, $not: {$size: 0} }}",
            sort = "{bid: -1}")
    List<Campaign> findCampaignsWhereAndStatusIsActiveAndHaveProductsOrderedByBid();
}
