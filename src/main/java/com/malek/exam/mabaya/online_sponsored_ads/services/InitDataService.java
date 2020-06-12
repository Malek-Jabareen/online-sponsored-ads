package com.malek.exam.mabaya.online_sponsored_ads.services;

import com.malek.exam.mabaya.online_sponsored_ads.helpers.JsonHelper;
import com.malek.exam.mabaya.online_sponsored_ads.models.ApiResponse;
import com.malek.exam.mabaya.online_sponsored_ads.models.Category;
import com.malek.exam.mabaya.online_sponsored_ads.models.Product;
import com.malek.exam.mabaya.online_sponsored_ads.models.Seller;
import com.malek.exam.mabaya.online_sponsored_ads.repositories.CategoryRepository;
import com.malek.exam.mabaya.online_sponsored_ads.repositories.ProductRepository;
import com.malek.exam.mabaya.online_sponsored_ads.repositories.SellerRepository;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.*;

@Service
public class InitDataService {

    @Autowired
    private TranslationService translator;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private SellerRepository sellerRepository;

    public ApiResponse initData() throws IOException, ParseException {
        ApiResponse response = new ApiResponse();
        try {
            List<Category> categories = Arrays.asList((Category[]) JsonHelper.getJsonArray("src/main/resources/mocks/Categories.json", Category[].class));
            List<Seller> sellers = Arrays.asList((Seller[]) JsonHelper.getJsonArray("src/main/resources/mocks/Sellers.json", Seller[].class));
            Map<String, Object> jsonMap = new HashMap<>();
            categories = categoryRepository.insert(categories);
            jsonMap.put("categories", categories);

            sellers.forEach(seller -> {
                List<Product> sellerProducts = new ArrayList<Product>();
                seller.getProducts().forEach(product -> {
                    sellerProducts.add(productRepository.insert(product));
                });
                seller.setProducts(sellerProducts);
            });

            sellers = sellerRepository.insert(sellers);
            jsonMap.put("sellers", sellers);

            response.data = jsonMap;
            response.message = translator.translate("AppInitiatedSuccessfully");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return response;
    }
}
