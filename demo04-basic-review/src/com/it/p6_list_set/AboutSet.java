package com.it.p6_list_set;

import java.util.*;

/**
 * HashSet 和 TreeSet 都实现了 Set 接口，用于存储不重复的元素集合，区别：
 * 实现原理
 *  HashSet:
 *      内部使用哈希表（实际上是一个 HashMap）来存储元素。
 *      元素通过其 hashCode() 方法生成哈希值，并根据该哈希值决定元素在哈希表中的位置。
 *      不保证元素的顺序，即插入顺序和自然顺序都不被维护。
 *  TreeSet:
 *      内部使用红黑树（一种自平衡二叉查找树）来存储元素。
 *      所有元素按照某种排序规则进行排序，默认情况下是按照元素的自然顺序（如果元素实现了 Comparable 接口），也可以通过提供自定义的 Comparator 来指定排序规则。
 *      维护了元素的排序顺序。
 *  性能特性
 *      插入、删除和查询操作:
 *          在 HashSet 中，这些操作的时间复杂度平均为 O(1)，但在最坏的情况下（如发生大量哈希冲突时）可能会退化到 O(n)。
 *          在 TreeSet 中，由于需要维持树的平衡性，插入、删除和查询操作的时间复杂度均为 O(log n)。
 *      遍历顺序:
 *          HashSet 不保证任何特定的顺序。
 *          TreeSet 按照元素的排序顺序遍历，这使得它非常适合需要有序输出的场景。
 *  使用场景
 *      选择 HashSet 的情况:
 *          主要关注于快速的插入、删除和查找操作。
 *          不关心元素的顺序或不需要对集合中的元素进行排序。
 *      选择 TreeSet 的情况:
 *          需要保持元素的自然顺序或根据某个特定规则排序。
 *          对集合的操作性能要求不是特别高，可以接受 O(log n) 的时间复杂度。
 *  其他注意事项
 *      线程安全性：HashSet 和 TreeSet 都不是线程安全的。如果需要在多线程环境中使用，可以考虑使用 Collections.synchronizedSet方法包装这些集合，
 *      或者使用 ConcurrentSkipListSet 作为 TreeSet 的线程安全替代品。
 *      内存占用：TreeSet 因为其内部结构较为复杂（需要维护树形结构），通常会比 HashSet 占用更多的内存。
 *      初始化成本：TreeSet 在初始化时可能需要更多的时间来构建树结构，特别是当集合较大时。而 HashSet 则相对简单，初始化速度更快。
 */

public class AboutSet {
    public static void main(String[] args) {
        // 无序不可重复的集合
        Set<String> set = new HashSet<>();
        set.add("11");
        set.add("22");
        set.add("99");
        set.add("55");
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            System.out.println("it: " + it.next());
        }

        System.out.println("---------------------------");

        // 有序不可重复的集合
        TreeSet<String> set2 = new TreeSet<>();
        set2.add("1");
        set2.add("2");
        set2.add("9");
        set2.add("5");
        Iterator<String> it2 = set2.iterator();
        while (it2.hasNext()) {
            System.out.println("it: " + it2.next());
        }

        System.out.println("---------------------------");

        // 存储自定义数据类型需要重写equals和hashCode方法
        Student tom1 = new Student("Tom", 18);
        Student tom2 = new Student("Tom", 18);
        Student jerry = new Student("Jerry", 19);
        Student tony = new Student("Tony", 20);
        HashSet<Student> stus = new HashSet<>();
        stus.add(tom1);
        stus.add(tom2);
        stus.add(jerry);
        stus.add(tony);
        Iterator<Student> stu_it = stus.iterator();
        while (stu_it.hasNext()) {
            System.out.println("cur: " + (stu_it.next()).toString());
        }
    }
}

class Student {
    String name;
    int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object obj) {
       if(obj instanceof Student stu) {
           return stu.getName().equals(this.name) && stu.getAge() == this.age;
       }
       return false;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

