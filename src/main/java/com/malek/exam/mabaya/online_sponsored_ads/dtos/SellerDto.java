package com.malek.exam.mabaya.online_sponsored_ads.dtos;

import java.util.List;

public class SellerDto {
    private String id;

    private String userName;

    private long timestamp;

    private List<ProductDto> products;

    public SellerDto(String id, String userName, long timestamp, List<ProductDto> products) {
        this.id = id;
        this.userName = userName;
        this.timestamp = timestamp;
        this.products = products;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public List<ProductDto> getProducts() {
        return products;
    }

    public void setProducts(List<ProductDto> products) {
        this.products = products;
    }
}
