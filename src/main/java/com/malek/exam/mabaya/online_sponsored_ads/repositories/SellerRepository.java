package com.malek.exam.mabaya.online_sponsored_ads.repositories;

import org.bson.types.ObjectId;
import com.malek.exam.mabaya.online_sponsored_ads.models.Seller;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SellerRepository extends MongoRepository<Seller, ObjectId> {
}
