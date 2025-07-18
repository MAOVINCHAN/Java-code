// import java.io.UnsupportedEncodingException;
// import java.util.Arrays;
//
// public class Main {
//     public static void main(String[] args) {
//         byte[] bs = toGBK("中文");
//         System.out.println(Arrays.toString(bs));
//     }
//
//     private static byte[] toGBK(String s) {
//         try {
//             return  s.getBytes("GBK");
//         } catch (UnsupportedEncodingException e) {
//             e.printStackTrace(); // 所有异常都可使用printStackTrace打印出方法的调用栈。
//             return s.getBytes();
//         }
//     }
// }


// 不常用 assert
// public class Main {
//     public static void main(String[] args) {
//         int x = -1;
//         assert x > 1;
//         System.out.println("x is:" + x);
//     }
// }