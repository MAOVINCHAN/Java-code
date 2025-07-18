import java.util.*;

/**
 * Map<K, V>为接口，是一种键值（key-value）映射表的数据结构;
 * key不能重复，后面通过put添加的重复的key的值会覆盖旧key的值;
 * value可以重复;
 * 通过Map.get未找到对应实例时，返回null;
 *
 * 正确使用Map必须保证：
 * -作为key的对象必须正确覆写equals()方法，相等的两个key实例调用equals()必须返回true；
 * -作为key的对象还必须正确覆写hashCode()方法，且hashCode()方法要严格遵循以下规范：
 *  - 如果两个对象相等，则两个对象的hashCode()必须相等；
 *      - 对应两个实例a和b：如果a和b相等，那么a.equals(b)一定为true，则a.hashCode()必须等于b.hashCode()；
 *  - 如果两个对象不相等，则两个对象的hashCode()尽量不要相等。
 *      - 对应两个实例a和b：如果a和b不相等，那么a.equals(b)一定为false，则a.hashCode()和b.hashCode()尽量不要相等。
 *
 * 正确使用TreeMap必须保证：
 * 放入的Key必须实现Comparable接口。String、Integer这些类已经实现了Comparable接口，因此可以直接作为Key使用。作为Value的对象则没有任何要求。
 */

public class Main {
    public static void main(String[] args) {
        HashMap<String, Student> map = new HashMap<>();
        Student stu1 = new Student("XMing", 85);
        map.put("stu1", stu1);
        Student stu2 = new Student("xiaochen", 85);
        map.put("stu2", stu2);
        Student stu3 = new Student("xiaohong", 80);
        map.put("stu3", stu3);
        map.put("stu4", stu1);


        Student stu1InMap = map.get("stu1");
        System.out.println("compare instance: " + (stu1 == stu1InMap)); // true;

        // 通过Map.get未找到对应实例时，返回null
        Student stu2InMap = map.get("any");
        System.out.println("when instance is inexist: " + stu2InMap);

        // 遍历Map
        Set<String> keys = map.keySet();
        for (String key :
                keys) {
            Student item = map.get(key);
            System.out.println("key is: " + key + ",value is: " + item.toString());
        }

        // 自定义对象作为key
        Student defineKey = new Student("defineKey", 11);
        Student defineValue = new Student("defineValue", 11);
        HashMap<Student, Student> map2 = new HashMap<>();
        map2.put(defineKey, defineValue);
        Student findDefine = map2.get(defineKey);
        System.out.println("findDefine: " + findDefine.toString()); // success


        // 如果作为Key的class没有实现Comparable接口，那么，必须在创建TreeMap时同时指定一个自定义排序算法：
        TreeMap<Student,Student> treeMap = new TreeMap<>(new Comparator<Student>() {
            public int compare(Student s1, Student s2) {
                return s1.name.compareTo(s2.name);
            }
        });
        treeMap.put(defineKey, defineValue);
        treeMap.put(new Student("test1", 1), new Student("value1", 1));
        treeMap.put(new Student("test2", 2), new Student("value2", 2));
        System.out.println("treeMap: " + treeMap.get(defineKey));
        System.out.println("treeMap: " + treeMap.get(new Student("test2", 2)));
    }
}

class Student {
    String name = "";
    int score = 100;

    public Student(String n, int s) {
        name = n;
        score = s;
    }

    // 作为key的对象必须正确覆写equals()方法，相等的两个key实例调用equals()必须返回true；
    @Override
    public boolean equals(Object obj) {
        if(getClass() != obj.getClass()) {
            return  false;
        }
        if(obj instanceof Student s) {
            return Objects.equals(name, s.name) && score == s.score;
        }
        return  false;
    }

    //编写equals()和hashCode()遵循的原则是：
    // equals()用到的用于比较的每一个字段，都必须在hashCode()中用于计算；equals()中没有使用到的字段，绝不可放在hashCode()中计算。

    @Override
    public int hashCode() {
        int h = 0;
        h = 31 * h + name.hashCode();
        h = 31 * h + score;
        return h;
    }

    @Override
    public String toString() {
        return getClass().getName() + ": {name=" + name + ", socre=" + score + "}";
    }
}