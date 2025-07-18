package com.it.p5_template_class;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import com.it.p5_template_class.UseTemplate;
import com.it.p5_template_class.MyComparable;

/**
 * 泛型实际：
 *  - 编译器把类型<T>视为Object
 *  - 编译器根据<T>实现安全的强制转型。
 * 局限：
 *  - <T>不能是基本类型，例如int，因为实际类型是Object，Object类型无法持有基本类型
 *  - 无法取得带泛型的Class
 *      Pain<String> 和 Pain<Integer> 获取到的Class都是同一个 Pain<Object>
 *  - 无法判断带泛型的类型
 *  - 不能实例化T类型
 *      new T(); 编译器无法通过，实际为：new Object();
 *      要实例化T类型，需要借助Class
 *      Class<T> cls;
 *      cls.newInstance();
 *
 * extends: （用于读取）
 *  <? extends Person>: 表示方法参数接受所有泛型类型为Person或Person子类的类型
 *  当你希望一个泛型参数只能接受某个特定类或其子类时，可以使用 extends。这意味着你可以访问该类及其所有子类中的方法，但不能保证能够调用任何更具体的子类独有的方法。
 *
 * super: （用于写入）
 *  <? super Integer>: 表示方法参数接受所有泛型类型为Integer或Integer父类的类型
 *  如果你想让泛型参数接受某个特定类或其超类，则可以使用 super。这通常用于需要写入操作的情况，因为它允许你向集合中插入对象，只要这些对象是给定类型的实例或是其超类的实例。
 *
 * 总结： 如果一个结构体生产数据（返回值），则使用 extends；如果消费数据（作为参数），则使用 super
 */

public class Main {
    public static void main(String[] args) {
        Pair<Integer> ipr = new Pair<>(100, 200);
        get(ipr);

        Pair<Number> ip = new Pair<>(0, -1);
        set(ip);
    }

    public static void get(Pair<? extends Number> pair) {
        Number first = pair.getFirst();
        Number last = pair.getLast();
        System.out.println("first: " + first + ", last: " + last);
    }

    public static void set(Pair<? super Integer> pair) {
        Integer first = Integer.valueOf(1);
        Integer last = Integer.valueOf(2);
        pair.setFirst(first);
        pair.setLast(last);
        System.out.println(pair.toString());
    }
}

class Pair<T> {
    T first;
    T last;

    public Pair(T first, T last) {
        this.first = first;
        this.last = last;
    }

    public T getFirst() {
        return first;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public T getLast() {
        return last;
    }

    public void setLast(T last) {
        this.last = last;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "first=" + first +
                ", last=" + last +
                '}';
    }
}


