public class Main {
    public static void main(String[] args) {
        // Integer
        Integer n1 = 1000;
        Integer n2 = 1000;
        int i = n1.compareTo(n2); // 大于返回1， 相等返回0，小于返回-1
        System.out.println("i: " + i);
        Class<Integer> type1 = Integer.TYPE;
        System.out.println("type1: " + type1); // int
        Class<Integer> type2 = n2.TYPE;
        System.out.println("type3: " + type2); // int
        int n3 = n1.intValue();
        System.out.println("n3: " + n3);
        double n4 = n1.doubleValue();
        System.out.println("n4: " + n4);
        float n5 = n1.floatValue();
        System.out.println("n5: " + n5);

        // Byte
        Byte b1 = Byte.valueOf("111");
        System.out.println("b1: " + b1);
        Class<Byte> type3 = Byte.TYPE;
        System.out.println("type3: " + type3); // byte
        int i1 = b1.intValue();
        System.out.println("i1: " + i1); // 111;
        byte i2 = n1.byteValue();
        System.out.println("i2: " + i2); // -24
        float i3 = n1.floatValue();
        System.out.println("i3: " + i3); // 1000.0
        double i4 = n1.doubleValue();
        System.out.println("i4: " + i4); // 1000.0

        // Short
        Short s1 = Short.valueOf("2025");
        System.out.println("s1: " + s1);
    }
}