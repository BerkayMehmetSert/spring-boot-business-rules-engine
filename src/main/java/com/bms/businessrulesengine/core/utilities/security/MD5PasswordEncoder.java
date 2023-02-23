package com.bms.businessrulesengine.core.utilities.security;

import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;

import java.util.Random;

@Component
public class MD5PasswordEncoder implements PasswordEncoder {
    final static Random random = new Random();

    @Override
    public String encode(String password) {
        var value = random.nextInt(1000) + password;
        return DigestUtils.md5DigestAsHex(value.getBytes());
    }
}
