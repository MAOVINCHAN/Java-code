package com.instance.stusys.utils;

import org.mindrot.bcrypt.BCrypt;

public class PwdUtils {
    public static String hashPassword(String pwd) {
        return BCrypt.hashpw(pwd, BCrypt.gensalt());
    }

    public static Boolean checkPassword(String pwd, String hashed) {
        return BCrypt.checkpw(pwd, hashed);
    }
}
