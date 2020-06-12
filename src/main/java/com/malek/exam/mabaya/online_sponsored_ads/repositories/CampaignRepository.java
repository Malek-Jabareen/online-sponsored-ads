package com.malek.exam.mabaya.online_sponsored_ads.repositories;

import org.bson.types.ObjectId;
import com.malek.exam.mabaya.online_sponsored_ads.models.Campaign;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CampaignRepository extends MongoRepository<Campaign, ObjectId> {
}
