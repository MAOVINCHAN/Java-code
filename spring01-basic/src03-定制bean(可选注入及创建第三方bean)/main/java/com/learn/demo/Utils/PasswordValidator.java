package com.learn.demo.Utils;

import org.springframework.stereotype.Component;

@Component
public class PasswordValidator implements Validator {
    @Override
    public boolean validate(String email, String password, String name) {
        if (!password.matches("^.{6,20}$")) {
            throw new IllegalArgumentException("invalid password");
        }
        return true;
    }
}
