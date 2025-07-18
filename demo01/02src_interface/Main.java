public class Main {
    public static void main(String[] args) {

    }
}

// 接口定义的所有方法默认都是 public abstract修饰的，可以省略不写
// 接口定义的所有字段默认都是 public static final修饰的，可以省略不写
// 一个类不能继承接口，只能实现接口 implements
// 一个类可以实现多个接口: class Name implements I1,I2,I3... {}
interface Person {
    String name = "name";
    void run();
    String getName();
}

class Stu implements Person {
    @Override
    public void run() {
        System.out.println("Stu's run");
    }

    @Override
    public String getName() {
        return "anything";
    }
}