public class Main {
    public static void main(String[] args) {
        // 匿名类
        Test n = new Test() {
            @Override
            public void run() {
                System.out.println("n is run");
            }
        };

        n.run();
    }
}

interface Test{
    void run();
}