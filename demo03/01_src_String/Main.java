/**
 * 结论：
 * 1. 两个字符串比较，必须总是使用equals()方法。
 * 2. 两个字符串==比较为true，纯属巧合,因Java编译器在编译期，会自动把所有相同的字符串当作一个对象放入常量池，自然a和b的引用就是相同的
 * 3. 要忽略大小写比较，使用equalsIgnoreCase()方法。
 */
public class Main {
    public static void main(String[] args) {
        String s = "123";
        s = "abc";
        s = s.toLowerCase(); // 字符串内部不可变
        System.out.println("s is: " + s); // abc

        // 字符串比较
        String a = "abc";
        String b = "abc";
        System.out.println(a == b); // true
        System.out.println(a.equals(b)); // true

        String c = "hello";
        String d = "HELLO".toLowerCase();
        System.out.println(c == d); // false
        System.out.println(c.equals(d)); // true

        // 把任意基本类型或引用类型转换为字符串
        String.valueof(123); // "123"
        String.valueof(true); // "true"
        String.valueof(new Object()); // 类似java.lang.Object@636be97c

        // 字符串转数字
        int n1 = Integer.parseInt("123"); // 123
        int n2 = Integer.parseInt("ff", 16); // 按十六进制转换，255

        // 字符串转布尔
        boolean b1 = Boolean.parseBoolean("true"); // true
        boolean b2 = Boolean.parseBoolean("TRUE"); // true

        // 字符串转char[]
        char[] c1 = "123".toCharArray();

        // char[]转字符串
        String s1 = new String(c1);
    }
}