package com.learn.demo;

import okhttp3.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws IOException {
        // 构造用来发生请求的对象
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(5, TimeUnit.SECONDS)
                .readTimeout(5, TimeUnit.SECONDS).build();

        // 构造一个具体的请求
        Request request = new Request.Builder()
                .url("https://www.baidu.com")
                .get()
                .build();

        // 准备发生请求
        Call newCall = client.newCall(request);

        // 发生同步请求，使用enqueue可异步发送请求
        Response response = newCall.execute();
        ResponseBody body = response.body();
        System.out.println("body = " + body.string());
    }
}
