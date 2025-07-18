public class Main {
    public static void main(String[] args) {
        Person s1 = new Student();
        Person t1 = new Teacher();
        s1.run();
        t1.run();
    }
}

// 抽象方法必须放在抽象类中，抽象类无法被实例化，抽象方法无法被执行，更像是一种规范。
// 子类继承父类，必须重写父类的抽象方法。
// 这种尽量引用高层类型，避免引用实际子类型的形式，称为面向抽象编程。
abstract class Person {
    public abstract void run();
}

class Student extends  Person {
    @Override
    public void run() {
        System.out.println("Student's run");
    }
}

class Teacher extends  Person {
    @Override
    public void run() {
        System.out.println("Teacher's run");
    }
}