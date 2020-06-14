package com.malek.exam.mabaya.online_sponsored_ads.dtos.requests;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UpdateSellerRequest {
    @NotEmpty(message = "userName must not be empty")
    @NotNull(message = "userName must not be empty")
    @Size(min = 2, message = "userName must be at least 2 characters length")
    private String userName;

    public UpdateSellerRequest(String id, String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
