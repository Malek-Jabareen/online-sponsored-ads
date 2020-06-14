package com.malek.exam.mabaya.online_sponsored_ads.services;

import com.malek.exam.mabaya.online_sponsored_ads.helpers.JsonHelper;
import com.malek.exam.mabaya.online_sponsored_ads.models.ApiResponse;
import com.malek.exam.mabaya.online_sponsored_ads.models.Category;
import com.malek.exam.mabaya.online_sponsored_ads.models.Product;
import com.malek.exam.mabaya.online_sponsored_ads.models.Seller;
import com.malek.exam.mabaya.online_sponsored_ads.repositories.CampaignRepository;
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
    @Autowired
    private CampaignRepository campaignRepository;

    public ApiResponse<Object> initData() throws IOException, ParseException {
        ApiResponse<Object> response = new ApiResponse<Object>();
        try {
            // Get data from json files
            List<Category> categories = Arrays.asList((Category[]) JsonHelper.getJsonArray("/Categories.json", Category[].class));
            List<Seller> sellers = Arrays.asList((Seller[]) JsonHelper.getJsonArray("/Sellers.json", Seller[].class));
            Map<String, Object> jsonMap = new HashMap<>();

            // Insert categories to the database
            categories = categoryRepository.insert(categories);

            // Insert Sellers and their Products to the database
            sellers.forEach(seller -> {
                List<Product> sellerProducts = new ArrayList<Product>();
                seller.getProducts().forEach(product -> {
                    product.setSellerId(seller.getId());
                    sellerProducts.add(productRepository.insert(product));
                });
                seller.setProducts(sellerProducts);
            });
            sellers = sellerRepository.insert(sellers);

            // Foreach product find for which seller it is belongs and update its SellerId
            productRepository.findAll()
                    .forEach(product -> {
                        String sellerId = sellerRepository.findSellerByProductsContains(product).getId();
                        product.setSellerId(sellerId);
                        productRepository.save(product);
                    });

            jsonMap.put("categories", categories);
            jsonMap.put("sellers", sellers);

            response.data = jsonMap;
            response.message = translator.translate("AppInitiatedSuccessfully");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return response;
    }

    public ApiResponse<Object> deleteData() {
        ApiResponse<Object> response = new ApiResponse<Object>();
        productRepository.deleteAll();
        sellerRepository.deleteAll();
        categoryRepository.deleteAll();
        campaignRepository.deleteAll();
        return response;
    }
}
