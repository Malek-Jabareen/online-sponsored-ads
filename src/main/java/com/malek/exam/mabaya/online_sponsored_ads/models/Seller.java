package com.malek.exam.mabaya.online_sponsored_ads.models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
public class Seller {

    @Id
    private ObjectId id;

    private String userName;

    private long timestamp;
    @DBRef
    private List<Product> products;

    public Seller() {
    }

    public Seller(ObjectId id, String userName, List<Product> products) {
        this.id = id;
        this.userName = userName;
        this.timestamp = System.currentTimeMillis();
        this.products = products;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
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

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
