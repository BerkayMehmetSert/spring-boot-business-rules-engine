package com.bms.businessrulesengine.request;

import lombok.Data;

@Data
public abstract class BaseRequest {
    private String username;
    private String email;
    private String password;
}
