package com.malek.exam.mabaya.online_sponsored_ads.dtos.mappers;

import com.malek.exam.mabaya.online_sponsored_ads.dtos.CategoryDto;
import com.malek.exam.mabaya.online_sponsored_ads.models.Category;

public class CategoryMapper {
    public static CategoryDto toCategoryDto(Category category) {
        return new CategoryDto();
    }
}
