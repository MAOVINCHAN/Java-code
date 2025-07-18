public class Main {
    public static void main(String[] args) {
        Person ming = new Person("xiao ming", 18);
        Person hong = new Person("xiao hong", 19);
        ming.number = 88;
        System.out.println("hong number is:" + hong.number);
        hong.number = 50;
        System.out.println("ming number is:" + ming.number);
        System.out.println("app instance count:" + Person.instanceCount);
    }
}

// 非静态字段（实例字段）在每个实例中都有自己的独立空间，静态字段只有一个共享空间，所有实例共享。
// 非静态方法（实例方法）只能通过实例调用，静态方法可以通过类.直接调用。
// 静态方法内部，无法访问实例字段，无法访问this。
class Person {
    public static int instanceCount = 0;

    public String name;
    public int age;

    public static int number;

    public Person(String name, int age) {
        instanceCount++;
        this.name = name;
        this.age = age;
    }

    public static int getCount() {
        return instanceCount;
    }
}