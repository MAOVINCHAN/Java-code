package com.learn.demo.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

@Component
public class AppService {
    /**
     * 所有资源文件放入src/main/resources即可通过classpath:/xxx.xxx读取文件
     * 也可以通过文件路径读取，例如：@Value("file:/path/to/logo.txt")
     */
    @Value("classpath:/resource.properties")
    private Resource resource;
    private String logo;
    public void init() {
        try (var reader = new BufferedReader(
                new InputStreamReader(resource.getInputStream(), StandardCharsets.UTF_8))) {
            logo = reader.lines().collect(Collectors.joining("\n"));
            System.out.println("logo = " + logo);
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
