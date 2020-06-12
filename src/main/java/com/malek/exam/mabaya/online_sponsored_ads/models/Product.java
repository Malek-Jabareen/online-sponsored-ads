package com.malek.exam.mabaya.online_sponsored_ads.models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Product {
    @Id
    private ObjectId id;

    private String title;

    private float price;

    @DBRef
    private Category category;

    private long timestamp;

    private int serialNumber;

    private ObjectId sellerId;

    public Product() {
    }

    public Product(ObjectId id, String title, float price, Category category, int serialNumber, ObjectId sellerId) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.category = category;
        this.timestamp = System.currentTimeMillis();
        this.serialNumber = serialNumber;
        this.sellerId = sellerId;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
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

    public ObjectId getSellerId() {
        return sellerId;
    }

    public void setSellerId(ObjectId sellerId) {
        this.sellerId = sellerId;
    }
}
