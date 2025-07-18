import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// List
public class Main {
    public static void main(String[] args) {
        // create
        // List ls = List.of("e1", "e2", "e5", "e6");

        // List是接口, List转Array1
        // ArrayList als1 = new ArrayList(ls);
        // als1.add(null); // allow
        // als1.add("12");

        // 遍历
        // Iterator lsi = ls.iterator();
        // while (lsi.hasNext()) {
        //     System.out.println(lsi.next());
        // }

        // for (String it: ls) {
        //     System.out.println(it);
        // }

        // for (Iterator it = als1.iterator(); it.hasNext();) {
        //     System.out.println(it.next());
        // }

        // List转Array 2, 丢失了item的数据类型，使用较少
        // Object[] als2 = ls.toArray();
        // for (Object it :
        //         als2) {
        //     System.out.println("als2 it is:" + it);
        // }

        // List转Array 3
        // List<Integer> list = List.of(12, 34, 56);
        // Integer[] array = list.toArray(new Integer[3]);
        // for (Integer it :
        //         array) {
        //     System.out.println("als3 it is:" + it);
        // }

        // Array to List;
        // String[] a1 = new String[] {"ab", "bc", "cd"};
        // List<String> a1l = List.of(a1);
        // for (String it :
        //         a1l) {
        //     System.out.println(it);
        // }


        // 判断元素是否存在
        // List<String> list = List.of("a", "b", "c");
        // System.out.println(list.contains("a")); // true
        // System.out.println(list.indexOf("b")); // 1
        // System.out.println(list.indexOf("F")); // -1

        // 传入不同的实例，得到预期的结果是因为内部并非使用 == 进行比较，而是使用equals.
        // System.out.println(list.contains(new String("c"))); // true
        // System.out.println(list.indexOf(new String("b"))); // 1

        // 要正确使用List的contains()、indexOf()这些方法，放入的实例必须正确覆写equals()方法，否则，放进去的实例，查找不到
        List<Person> ps = List.of(
                new Person("jerry", 20),
                new Person("bob", 20),
                new Person("tom", 20)
        );
        System.out.println("contains: " + ps.contains(new Person("jerry", 20))); // 如果不重新equals则结果恒为false
        System.out.println("indexof: " + (ps.indexOf(new Person("tom", 18)) != -1));

        /**
         * 引用类型的比较中 == 和 equals 的区别
         * == :对于非null的对象引用，只有当两个引用指向完全相同的对象时，== 比较才会返回true
         *     new String("123") == new String("123")结果为 false
         * equals: equals() 方法用于比较两个对象的内容是否相等。每个类都有一个默认的equals() 实现，
         * 位于Object基类中。默认实现仅比较对象的引用是否相同，即默认的equals() 方法的行为和== 是一样的。
         * 但是，许多内置类（如String, Integer等）以及我们自定义的类都可以重写equals() 方法，使其比较对象的内容而非引用。
         *     new String("123").equals(new String("123"))结果为 true
         * 如果你有一个自定义的类，并且你想根据类的某些字段来判断两个对象是否相等，你需要重写equals()方法。
         * 同时，为了遵循equals()方法的一些约定，通常也需要重写hashCode()方法，以保证equals()和hashCode()的行为一致性。
         */
        System.out.println("equals: " + new String("123").equals(new String("123")));
    }
}

class Person {
    String name = "";
    int age = 18;
    public Person(String n, int a) {
        name = n;
        age = a;
    }

    @Override
    public boolean equals(Object o) {
        if(getClass() != o.getClass()) {
            return  false;
        }

        if(o instanceof Person p) {
            return name.equals(p.name) && this.age == p.age;
        }

        return  false;
    }
}