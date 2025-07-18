package com.learn.demo;

import okhttp3.OkHttpClient;

import java.util.concurrent.TimeUnit;

public class OkHttpFactory2 {
    public OkHttpClient getInstance() {
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(5, TimeUnit.SECONDS)
                .readTimeout(5, TimeUnit.SECONDS).build();
        return client;
    }
}
