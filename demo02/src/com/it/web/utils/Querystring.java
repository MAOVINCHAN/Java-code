package com.it.web.utils;

import java.util.HashMap;
import java.util.Map;
public class Querystring{
    public static Map<String, String> parse(String queryString) {
        Map<String, String> params = new HashMap<>();
        if (queryString != null && !queryString.isEmpty()) {
            String[] pairs = queryString.split("&");
            for (String pair : pairs) {
                int idx = pair.indexOf("=");
                if (idx > 0 && idx < pair.length() - 1) {
                    String key = pair.substring(0, idx);
                    String value = pair.substring(idx + 1);
                    params.put(key, decodeValue(value));
                }
            }
        }
        return params;
    }

    private static String decodeValue(String value) {
        try {
            return java.net.URLDecoder.decode(value, "UTF-8");
        } catch (Exception e) {
            throw new RuntimeException("Failed to decode value: " + value, e);
        }
    }
}