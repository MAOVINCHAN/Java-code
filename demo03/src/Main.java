public class Main {
    public static void main(String[] args) {
        System.out.println("MON is: " + Weekday2.MON);
        // 获取枚举case的name
        System.out.println("MON is: " + Weekday2.MON.name());
        // 获取值
        System.out.println("MON is: " + Weekday2.MON.ordinal());

        // 获取类
        System.out.println("class is: " + Weekday2.class); // class Weekday
    }
}

// 此类枚举写法，容易造成顺序改变的问题。
enum Weekday1 {
    MON, TUH, WED, THU, FRI, SAT, SUN
}

// 改良后
enum Weekday2 {
    MON(1),
    TUH(2),
    WED(3),
    THU(4),
    FRI(5),
    SAT(6),
    SUN(0);

    public final int val;

    private Weekday2(int val) {
        this.val = val;
    }
}