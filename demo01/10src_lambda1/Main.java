import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        // lambda表达式
        // 只有一个方法的函数式接口才能使用lambda表达式

        Swimming s = () -> System.out.println("S's run function is running");

        s.run();
    }
}

@FunctionalInterface
interface Swimming{
    void run();
}