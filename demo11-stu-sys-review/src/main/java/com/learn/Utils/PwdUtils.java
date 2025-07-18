package com.learn.Utils;

import at.favre.lib.crypto.bcrypt.BCrypt;


public class PwdUtils {
    public static String hashPassword(String password) {
        BCrypt.Hasher hasher = BCrypt.withDefaults();
        String hash = hasher.hashToString(5, password.toCharArray());
        return hash;
    }

    public static boolean checkPassword(String password, String hashPassword) {
        BCrypt.Verifyer verifyer = BCrypt.verifyer();
        BCrypt.Result result = verifyer.verify(password.toCharArray(), hashPassword.toCharArray());
        return result.verified;
    }
}
