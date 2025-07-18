package com.learn.about_json;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.learn.about_json.model.Book;

import java.util.*;

public class Test01 {
    public static void main(String[] args) throws JsonProcessingException {
        Book book1 = new Book(1, "水浒传", "施耐庵");
        Book book2 = new Book(2, "三国演义", "罗贯中");
        // 获取对象json转换器
        ObjectMapper om = new ObjectMapper();
        // 将对象转为json
        String objectToJson1 = om.writeValueAsString(book1);
        System.out.println("objectToJson1: " + objectToJson1);
        String objectToJson2 = om.writeValueAsString(book2);
        System.out.println("objectToJson2: " + objectToJson2);

        // 将数组转为json
        List<Book> books = new ArrayList<>();
        books.add(book1);
        books.add(book2);
        String listToJson = om.writeValueAsString(books);
        System.out.println("listToJson = " + listToJson);

        // 将Map转为json
        Map<String, Object> map = new HashMap<>();
        map.put("username", "zhangSan");
        map.put("books", books);
        map.put("age", 18);
        String mapToJson = om.writeValueAsString(map);
        System.out.println("mapToJson = " + mapToJson);

        // 将Set转为json
        Set<String> set = new TreeSet<>();
        set.add(book1.toString());
        set.add(book2.toString());
        String setToJson = om.writeValueAsString(set);
        System.out.println("setToJson = " + setToJson);

        // 将json转为java对象
        //language=JSON
        String json = "{" +
                "\"id\": 111," +
                "\"name\": \"红楼梦\"," +
                "\"author\": \"曹雪芹\"" +
                "}";
        Book book = om.readValue(json, Book.class);
        System.out.println("book = " + book);

        // json转java数组
        //language=JSON
        String json2 = "[{\n" +
                "  \"id\": 1, \"name\": \"老人与海\", \"author\": \"海明威\"\n" +
                "}, {\n" +
                "  \"id\": 2, \"name\": \"红楼梦\", \"author\": \"曹雪芹\"\n" +
                "}]";

        Book[] jsonToArray = om.readValue(json2, Book[].class);
        System.out.println("jsonToArray = " + Arrays.toString(jsonToArray));

        // json转javaList
        List<Book> jsonToList = om.readValue(json2, new TypeReference<>() {
        });
        System.out.println("jsonToList = " + jsonToList);
    }
}
