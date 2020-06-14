package com.malek.exam.mabaya.online_sponsored_ads.dtos.requests;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CreateProductRequest {
    @NotEmpty(message = "title must not be empty")
    @NotNull(message = "title must not be empty")
    @Size(min = 2, message = "title must be at least 2 characters length")
    private String title;

    @NotNull(message = "price must not be empty")
    private float price;

    @NotEmpty(message = "categoryName must not be empty")
    @NotNull(message = "categoryName must not be empty")
    @Size(min = 2, message = "categoryName must be at least 2 characters length")
    private String categoryName;

    @NotNull(message = "Title must not be empty")
    private int serialNumber;

    @NotEmpty(message = "sellerId must not be empty")
    @NotNull(message = "sellerId must not be empty")
    private String sellerId;

    public CreateProductRequest(String title, float price, String categoryName, int serialNumber, String sellerId) {
        this.title = title;
        this.price = price;
        this.categoryName = categoryName;
        this.serialNumber = serialNumber;
        this.sellerId = sellerId;
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
