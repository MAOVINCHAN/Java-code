public class Main {
    public static void main(String[] args) {
        // basic type
        int n1 = 123;
        System.out.println(int.class); // success
        // System.out.println(n1.getClass()); // failed
        Class intCls = int.class;
        System.out.println(intCls.getSimpleName());
        System.out.println(intCls.isEnum());
        System.out.println(intCls.isAnnotation());
        System.out.println(intCls.isInterface());
        System.out.println(intCls.getPackage()); // null

        // array
        String[] arr = {"1", "2", "3"};
        Class arrCls = arr.getClass(); // class [Ljava.lang.String;
        System.out.println(arrCls);

        // 自定义类通过反射获取的Class创建实例
        Person p1 = new Person("p1", 19);
        // 1. 通过实例获取Class后创建再创建实例 -> failed
        // Class p1Cls = p1.getClass();
        // Person p2 = (Person) p1Cls.newInstance();
        // System.out.println("p2's name is:" + p2.name + ",p2's age is:" + p2.age);
        // 2. 通过父类获取Class后创建再创建实例 -> failed
        // Class pCls = Person.class;
        // Person p2 = (Person) pCls.newInstance();
        // System.out.println("p2's name is:" + p2.name + ",p2's age is:" + p2.age);

        // 内置类通过反射获取的Class创建实例
        Class sCls = String.class;
        // String s1 = (String) sCls.newInstance();
    }
}

class Person {
    String name = "";
    int age = 18;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}