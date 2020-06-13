package com.malek.exam.mabaya.online_sponsored_ads.services;

import com.malek.exam.mabaya.online_sponsored_ads.dtos.ProductDto;
import com.malek.exam.mabaya.online_sponsored_ads.dtos.mappers.ProductMapper;
import com.malek.exam.mabaya.online_sponsored_ads.dtos.requests.CreateProductRequest;
import com.malek.exam.mabaya.online_sponsored_ads.dtos.requests.UpdateProductRequest;
import com.malek.exam.mabaya.online_sponsored_ads.exceptions.ConnectToDatabaseException;
import com.malek.exam.mabaya.online_sponsored_ads.exceptions.NotFoundException;
import com.malek.exam.mabaya.online_sponsored_ads.models.ApiResponse;
import com.malek.exam.mabaya.online_sponsored_ads.models.Category;
import com.malek.exam.mabaya.online_sponsored_ads.models.Product;
import com.malek.exam.mabaya.online_sponsored_ads.models.Seller;
import com.malek.exam.mabaya.online_sponsored_ads.repositories.CategoryRepository;
import com.malek.exam.mabaya.online_sponsored_ads.repositories.ProductRepository;
import com.malek.exam.mabaya.online_sponsored_ads.repositories.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private SellerRepository sellerRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private TranslationService translationService;

    public ApiResponse<List<ProductDto>> getProducts() {
        ApiResponse<List<ProductDto>> response = new ApiResponse<List<ProductDto>>();
        List<ProductDto> products = new ArrayList<ProductDto>();
        productRepository.findAll()
                .forEach(product -> products.add(ProductMapper.toProductDto(product)));
        response.data = products;
        return response;
    }

    public ApiResponse<ProductDto> getProduct(String id) {
        ApiResponse<ProductDto> response = new ApiResponse<ProductDto>();
        if (productRepository.findById(id).isEmpty()) {
            throw new NotFoundException(translationService.translate("ProductNotFound"));
        }
        response.data = ProductMapper.toProductDto(productRepository.findById(id).get());
        return response;
    }

    public ApiResponse<Void> deleteProduct(String id) {
        ApiResponse<Void> response = new ApiResponse<Void>();
        try {
            if (productRepository.findById(id).isEmpty()) {
                throw new NotFoundException(translationService.translate("ProductNotFound"));
            }
            Product product = productRepository.findById(id).get();
            // Find product seller and delete the product from its products list ( Could do that with a normal query )
            String sellerId = product.getSellerId();
            productRepository.delete(product);
            Seller seller = sellerRepository.findById(sellerId).get();
            List<Product> sellerNewProducts = seller.getProducts().stream().filter(product1 -> !product1.getId().equals(id)).collect(Collectors.toList());
            seller.setProducts(sellerNewProducts);
            sellerRepository.save(seller);
        } catch (Exception e) {
            if (e instanceof NotFoundException) {
                throw new NotFoundException(translationService.translate("ProductNotFound"));
            } else {
                throw e;
            }
        }
        return response;
    }

    public ApiResponse<ProductDto> addProduct(CreateProductRequest createProductRequest) {
        ApiResponse<ProductDto> response = new ApiResponse<ProductDto>();
        if (sellerRepository.findById(createProductRequest.getSellerId()).isEmpty()) {
            throw new NotFoundException(translationService.translate("SellerNotFound"));
        }
        if (categoryRepository.findByName(createProductRequest.getCategoryName()) == null) {
            Category category = new Category(createProductRequest.getCategoryName());
            categoryRepository.save(category);
        }
        Product product = new Product(
                createProductRequest.getTitle(),
                createProductRequest.getPrice(),
                createProductRequest.getCategoryName(),
                createProductRequest.getSerialNumber(),
                createProductRequest.getSellerId()
        );
        Seller seller = sellerRepository.findById(createProductRequest.getSellerId()).get();
        response.data = ProductMapper.toProductDto(productRepository.insert(product));
        List<Product> productList = seller.getProducts();
        productList.add(product);
        seller.setProducts(productList);
        sellerRepository.save(seller);
        return response;
    }

    public ApiResponse<ProductDto> updateProduct(String id, UpdateProductRequest updateProductRequest) {
        ApiResponse<ProductDto> response = new ApiResponse<ProductDto>();
        if (productRepository.findById(id).isEmpty()) {
            throw new NotFoundException(translationService.translate("ProductNotFound"));
        }
        Product product = productRepository.findById(id).get();
        // Handle missed category
        if (categoryRepository.findByName(updateProductRequest.getCategoryName()) == null) {
            Category category = new Category(updateProductRequest.getCategoryName());
            categoryRepository.save(category);
        }
        product.setCategoryName(updateProductRequest.getCategoryName());
        product.setPrice(updateProductRequest.getPrice());
        product.setTitle(updateProductRequest.getTitle());
        product.setSerialNumber(updateProductRequest.getSerialNumber());
        response.data = ProductMapper.toProductDto(productRepository.save(product));
        return response;
    }
}
