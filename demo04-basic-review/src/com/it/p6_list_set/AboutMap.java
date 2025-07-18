package com.it.p6_list_set;

import org.junit.*;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.*;

/**
 * HashMap 和 TreeMap 都实现了 Map 接口，用于存储键值对（key-value pairs）,区别：
 * 实现原理
 *  HashMap:
 *      内部使用哈希表（实际上是一个数组加链表或红黑树结构）来存储键值对。
 *      元素的键通过其 hashCode() 方法生成哈希值，并根据该哈希值决定元素在哈希表中的位置。
 *      不保证元素的顺序，即插入顺序和自然顺序都不被维护。但从Java 8开始，如果多个键映射到同一个桶（即发生哈希冲突），当链表长度超过一定阈值时，会将链表转换为红黑树以提高查找效率。
 *  TreeMap:
 *      内部使用红黑树（一种自平衡二叉查找树）来存储键值对。
 *      所有键按照某种排序规则进行排序，默认情况下是按照键的自然顺序（如果键实现了 Comparable 接口），也可以通过提供自定义的 Comparator 来指定排序规则。
 *      维护了键的排序顺序。
 * 性能特性
 *  插入、删除和查询操作:
 *      在 HashMap 中，这些操作的时间复杂度平均为 O(1)，但在最坏的情况下（如大量哈希冲突导致链表过长时）可能会退化到 O(n)。不过，由于Java 8引入了红黑树优化，在大多数情况下可以保持接近O(1)的性能。
 *      在 TreeMap 中，由于需要维持树的平衡性，插入、删除和查询操作的时间复杂度均为 O(log n)。
 *  遍历顺序:
 *      HashMap 不保证任何特定的顺序。然而，从Java 8开始，LinkedHashMap 可以保证插入顺序或访问顺序。
 *      TreeMap 按照键的排序顺序遍历，这使得它非常适合需要有序输出的场景。
 * 使用场景
 *  选择 HashMap 的情况:
 *      主要关注于快速的插入、删除和查找操作。
 *      不关心键的顺序或不需要对集合中的键进行排序。
 *      当你希望获得接近常数时间复杂度的操作性能时。
 *  选择 TreeMap 的情况:
 *      需要保持键的自然顺序或根据某个特定规则排序。
 *      对集合的操作性能要求不是特别高，可以接受 O(log n) 的时间复杂度。
 *      适用于需要频繁地获取最大/最小键或者进行范围查询的场景。
 * 其他注意事项
 *  线程安全性：HashMap 和 TreeMap 都不是线程安全的。如果需要在多线程环境中使用，可以考虑使用 Collections.synchronizedMap 方法包装这些集合，
 *  或者使用 ConcurrentHashMap 作为 HashMap 的线程安全替代品。
 *  内存占用：TreeMap 因为其内部结构较为复杂（需要维护树形结构），通常会比 HashMap 占用更多的内存。
 *  初始化成本：TreeMap 在初始化时可能需要更多的时间来构建树结构，特别是当集合较大时。而 HashMap 则相对简单，初始化速度更快。
 */
public class AboutMap {
    public static void main(String[] args) {
        testHashMap();
    }

    @Test
    public static void testHashMap() {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("a", 1);
        map.put("b", 2);
        map.put("c", 3);
        map.put("g", 7);
        map.put("d", 4);
        map.put("f", 6);
        map.put("e", 5);

        // 遍历
        // Set<String> keys = map.keySet();
        // for (String key:
        //      keys) {
        //     System.out.println(key + ": " + map.get(key));
        // }

        // Set<Map.Entry<String, Integer>> entries = map.entrySet();
        // Iterator<Map.Entry<String, Integer>> iterator = entries.iterator();
        // while (iterator.hasNext()) {
        //     Map.Entry<String, Integer> next = iterator.next();
        //     String key = next.getKey();
        //     Integer value = next.getValue();
        //     System.out.println("key: " + key + ", value: " + value);
        // }

        // Set<Map.Entry<String, Integer>> entrys = map.entrySet();
        // for (Map.Entry<String, Integer> entry :
        //         entrys) {
        //     String key = entry.getKey();
        //     Integer value = entry.getValue();
        //     System.out.println("key: " + key + ", value: " + value);
        // }

        // 遍历values
        // Collection<Integer> values = map.values();
        // Iterator<Integer> iterator = values.iterator();
        // while (iterator.hasNext()) {
        //     System.out.println(iterator.next());
        // }
    }
}
