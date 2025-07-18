package com.it.p6_list_set;

import java.util.*;

/**
 * ArrayList 和 LinkedList 都是实现了 List 接口的集合类，区别：
 * 实现原理
 *  ArrayList:
 *      内部使用动态数组来存储元素。
 *      当数组容量不足时，会自动扩容（通常是当前容量的1.5倍）。
 *      支持快速随机访问，因为可以直接通过索引计算出元素的位置。
 *  LinkedList:
 *      内部使用双向链表来存储元素。
 *      每个元素（节点）包含三个部分：前驱节点引用、数据域和后继节点引用。
 *      不支持直接通过索引访问元素，必须从头或尾开始遍历链表直到找到目标位置。
 * 性能特性
 *  插入与删除操作:
 *      在ArrayList中，除非是在末尾添加元素，否则插入和删除操作可能需要移动后续的所有元素，这会导致O(n)的时间复杂度。
 *      在LinkedList中，在任何位置插入或删除元素只需调整相邻节点的指针即可完成，理论上为O(1)，但实际上由于需要先定位到插入点，所以平均情况下的时间复杂度仍然是O(n)。
 *  访问元素:
 *      ArrayList支持随机访问，即通过索引获取元素的操作效率很高，时间为O(1)。
 *      LinkedList不支持高效的随机访问，必须从头部或尾部开始遍历链表，时间复杂度为O(n)。
 *  内存占用:
 *      ArrayList的内存消耗相对较低，因为它只需要存储元素本身的数据。
 *      LinkedList除了存储元素的数据外，还需要额外的空间来保存前后节点的引用，因此内存开销较大。
 * 使用场景
 *  选择ArrayList的情况:
 *      主要进行元素的遍历和随机访问。
 *      插入和删除操作大多发生在列表的末尾。
 *  选择LinkedList的情况:
 *      需要频繁地在列表中间进行插入和删除操作。
 *      应用程序更关注于队列或栈的行为（如addFirst, addLast, removeFirst, removeLast等方法），虽然这些操作也可以通过Deque接口更好地实现。
 * 其他注意事项
 *      对于大多数应用来说，ArrayList因其较好的缓存局部性和较低的内存开销而成为首选。
 *      如果确实需要频繁的中间插入和删除，并且能够接受较高的内存开销，则可以考虑使用LinkedList。
 *      注意，对于队列操作，Java提供了专门的Queue接口及其多种实现（如PriorityQueue, ArrayDeque），其中ArrayDeque通常比LinkedList更适合用作队列，因为它提供了更好的性能。
 */

public class AboutList {
    public static void main(String[] args) {
        // 创建List方式一
        List<Integer> ls1 = new ArrayList<>();
        ls1.add(null);
        ls1.add(1);
        ls1.add(2);
        ls1.add(null); // size == 4;

        /**
        // 遍历List
        // for：只有针对ArrayList使用get方法获取元素速度较快外，其他容器使用get方法较慢
        for (int i = 0; i < ls1.size(); i++) {
            System.out.println("i: " + ls1.get(i));
        }

        // 使用迭代器
        Iterator<Integer> it1 = ls1.iterator();
        while (it1.hasNext()) {
            System.out.println(it1.next());
        }

        // 创建List方式二
        List<String> ls2 = List.of("A", "B", "C", "D"); // 不可含null

        // toArray
        Object[] arr2 = ls2.toArray();
        Iterator<Object> it2 = Arrays.stream(arr2).iterator();
        while (it2.hasNext()) {
            System.out.println(it2.next());
         }
         **/

        // 方法
        ls1.add(5);
        int i = ls1.indexOf(5);
        System.out.println("indexOf: " + i);
        Integer tar = ls1.get(1);
        int len = ls1.size();
        boolean has2 = ls1.contains(2);
        // ...

        // 存储自定义数据类型
        Person tom = new Person("Tom", 18);
        Person jerry = new Person("Jerry", 19);
        Person tony = new Person("tony", 20);
        List<Person> ls = List.of(tom, jerry, tony);
        System.out.println("tom是否存在：" + ls.contains(tom));

        LinkedList<Person> link = new LinkedList<>();
        link.add(tom);
        link.add(jerry);
        link.add(tony);
        Person first = link.get(0);
        System.out.println("first is: " + first.toString());
        System.out.println("contains tom: " + link.contains(tom));

        LinkedList<Person> clone = (LinkedList<Person>) link.clone();
        Person clone_first = clone.get(0);
        System.out.println("clone_first: " + clone_first.toString());
    }
}

class Person {
    String name;
    int age;
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // 需要重写equals方法
    @Override
    public boolean equals(Object p) {
        if(p instanceof Person o) {
            return o.name.equals(this.name);
        }
        return false;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
