package com.malek.exam.mabaya.online_sponsored_ads.repositories;

import com.malek.exam.mabaya.online_sponsored_ads.models.Category;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface CategoryRepository extends MongoRepository<Category, String> {

    @Query(value = "{'name': {$regex : ?0, $options: 'i'}}")
    Category findByNameRegexIgnoreCase(String name);
}
