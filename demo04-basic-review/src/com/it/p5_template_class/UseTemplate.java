package com.it.p5_template_class;

import java.util.ArrayList;


// 泛型类
public class UseTemplate<T> {
    ArrayList<T> als = new ArrayList<>();

    void add(T it) {
        als.add(it);
    }

    void remove(T it) {
        als.remove(it);
    }

    ArrayList<T> get() {
        return als;
    }
}
