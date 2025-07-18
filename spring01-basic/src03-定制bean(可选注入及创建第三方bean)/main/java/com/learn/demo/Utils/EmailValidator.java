package com.learn.demo.Utils;

import org.springframework.stereotype.Component;

@Component
public class EmailValidator implements Validator {
    @Override
    public boolean validate(String email, String password, String name) {
        if (!email.matches("^[a-z0-9]+\\@[a-z0-9]+\\.[a-z]{2,10}$")) {
            throw new IllegalArgumentException("invalid email: " + email);
        }
        return true;
    }
}
