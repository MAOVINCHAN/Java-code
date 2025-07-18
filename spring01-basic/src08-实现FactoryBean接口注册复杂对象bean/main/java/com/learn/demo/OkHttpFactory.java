package com.learn.demo;

import okhttp3.OkHttpClient;
import org.springframework.beans.factory.FactoryBean;
import java.net.http.HttpClient;
import java.util.concurrent.TimeUnit;

public class OkHttpFactory implements FactoryBean<OkHttpClient> {
    @Override
    public OkHttpClient getObject() throws Exception {
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(5, TimeUnit.SECONDS)
                .readTimeout(5, TimeUnit.SECONDS)
                .build();
        return client;
    }

    @Override
    public Class<?> getObjectType() {
        return HttpClient.class;
    }

    @Override
    public boolean isSingleton() {
        return false; // true or false
    }
}
