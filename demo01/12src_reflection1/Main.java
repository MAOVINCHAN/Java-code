public class Main {
    /**
     * 1. 获取了某个Class实例，我们就可以通过这个Class实例获取到该实例对应的class的所有信息
     * 2. 通过Class实例获取class信息的方法称为反射（Reflection）
     */
    public static void main(String[] args) throws ClassNotFoundException {
        // 获取一个类的Class
        // 1. 类.class;
        Class s1 = String.class; // java.lang.String;
        System.out.println("s1 is:" + s1);
        // 2. 实例对象.getClass();
        String s = new String("1111");
        Class s2 = s.getClass(); // java.lang.String;
        System.out.println("s2 is:" + s2);
        // 3. Class.forName(“完整类名”)
        Class s3 = Class.forName("java.lang.String");
        System.out.println("s3 is:" + s3);

        // Class实例在JVM中是唯一的，所以，上述方法获取的Class实例是同一个实例。可以用==比较两个Class实例
        System.out.println(s1 == s2);
        System.out.println(s1 == s3);

        System.out.println("------------------------ split ------------------------");

        printClassInfo(s1);
    }

    static void printClassInfo(Class cls) {
        System.out.println("Class name: " + cls.getName());
        System.out.println("Simple name: " + cls.getSimpleName());
        if (cls.getPackage() != null) {
            System.out.println("Package name: " + cls.getPackage().getName());
        }
        System.out.println("is interface: " + cls.isInterface());
        System.out.println("is enum: " + cls.isEnum());
        System.out.println("is array: " + cls.isArray());
        System.out.println("is primitive: " + cls.isPrimitive());
    }
}