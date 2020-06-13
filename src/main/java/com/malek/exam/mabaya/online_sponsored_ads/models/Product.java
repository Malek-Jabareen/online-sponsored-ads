package com.malek.exam.mabaya.online_sponsored_ads.models;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "products")
public class Product {
    @Id
    private String id;

    private String title;

    private float price;

    private String categoryName;

    @CreatedDate
    private long timestamp;

    private int serialNumber;

    private String sellerId;

    public Product() {
    }

    public Product(String id, String title, float price, String categoryName, int serialNumber, String sellerId) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.categoryName = categoryName;
        this.timestamp = System.currentTimeMillis();
        this.serialNumber = serialNumber;
        this.sellerId = sellerId;
    }

    public Product(String title, float price, String categoryName, int serialNumber, String sellerId) {
        this.title = title;
        this.price = price;
        this.categoryName = categoryName;
        this.serialNumber = serialNumber;
        this.sellerId = sellerId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(int serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }
}
