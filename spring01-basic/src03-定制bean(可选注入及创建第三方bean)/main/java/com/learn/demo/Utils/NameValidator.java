package com.learn.demo.Utils;

import org.springframework.stereotype.Component;

@Component
public class NameValidator implements Validator {
    @Override
    public boolean validate(String email, String password, String name) {
        if (name == null || name.isBlank() || name.length() > 20) {
            throw new IllegalArgumentException("invalid name: " + name);
        }
        return true;
    }
}
