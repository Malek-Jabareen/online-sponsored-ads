package com.malek.exam.mabaya.online_sponsored_ads.repositories;

import com.malek.exam.mabaya.online_sponsored_ads.models.Product;
import com.malek.exam.mabaya.online_sponsored_ads.models.Seller;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SellerRepository extends MongoRepository<Seller, String> {
    Seller findSellerByProductsContains(Product product);
}
