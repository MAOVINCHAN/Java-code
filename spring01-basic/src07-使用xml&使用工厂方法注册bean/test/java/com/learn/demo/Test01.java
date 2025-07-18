package com.learn.demo;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class Test01 {
    ClassPathXmlApplicationContext ctx;
    @Before
    public void before() {
        ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
    }

    @Test
    public void test01() throws IOException {
        // 获取用来发送请求的对象
        OkHttpClient client = ctx.getBean(OkHttpClient.class);

        Request request = new Request.Builder()
                .url("http://www.baidu.com")
                .get()
                .build();

        Call newCall = client.newCall(request);

        Response response = newCall.execute();

        System.out.println("response.body().string() = " + response.body().string());
    }

    @After
    public void after() {
        ctx.close();
    }
}
