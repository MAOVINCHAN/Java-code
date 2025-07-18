
/**
 * 包装类型:
 * 1. 基本类型变为包装类型的赋值写法，称为自动装箱(auto boxing),反过来包装类型变为基本类型的赋值写法，称为自动拆箱(auto unboxing);
 * 2. 对两个Integer实例进行比较要特别注意：绝对不能用==比较，因为Integer是引用类型，必须使用equals()比较;int与Integer的比较可以使用==;
 */
public class Main {
    public static void main(String[] args) {
        int n1 = 1000;
        Integer n2 = 1000; // auto boxing
        int n3 = n2; // auto unboxing
        System.out.println("n2.equals(n1):" + n2.equals(n1));
        System.out.println("==:" + (n1 == n2));

        System.out.println("--------compare-----------");
        Integer a1 = 999999;
        Integer a2 = 999999;
        int a3 = 999999;
        System.out.println(a1 == a2); // false
        System.out.println(a1 == a3); // true
        System.out.println("use equals: " + (a1.equals(a2))); // true

        System.out.println("---------method----------");
        // 字符串转整数
        int a4 = Integer.parseInt("1000");
        System.out.println("a4 is: " + a4);
        String s1 = Integer.toHexString(10); //转16进制： "a"
        System.out.println("s1: " + s1);
        String s2 = Integer.toBinaryString(10); //转2进制： "1010"
        System.out.println("s2: " + s2);
        String s3 = Integer.toOctalString(10); //转8进制： "12"
        System.out.println("s3: " + s3);
        String s4 = Integer.toString(10); // 转10进制： “10”
        System.out.println("s4: " + s4);
        String s5 = Integer.toString(10, 36);// 转36进制："a"
        System.out.println("s5: " + s5);
        int s6 = Integer.MAX_VALUE; // 2147483647
        System.out.println("s6: " + s6);
        int s7 = Integer.MIN_VALUE; // -2147483648
        System.out.println("s7: " + s7);
    }
}