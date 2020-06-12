package com.malek.exam.mabaya.online_sponsored_ads.repositories;

import org.bson.types.ObjectId;
import com.malek.exam.mabaya.online_sponsored_ads.models.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, ObjectId> {
}
