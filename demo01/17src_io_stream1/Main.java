import org.junit.Test;

import java.io.*;

public class Main {
    // public static void main(String[] args) throws IOException {
    //     InputStream input = null;
    //     try {
    //         input = new FileInputStream("C:\\Users\\admin\\Desktop\\test\\1.txt");
    //         int n;
    //         while ((n = input.read()) != -1) {
    //             System.out.println("n is: " + n);
    //         }
    //     }catch (FileNotFoundException e) {
    //     }finally {
    //         if(input != null) input.close();
    //     }
    // }


    // FileInputStream
    @Test
    public void FileInputStream() throws Exception {
        // File file = new File("src\\test.txt");
        // System.out.println("getAbsolutePath: " + file.getAbsolutePath());
        // FileInputStream fis = new FileInputStream(file);

        // read()每次读取一个字节。
        // int b1 = fis.read();
        // System.out.println("b1: " + b1); // 97
        // int b2 = fis.read();
        // System.out.println("b2: " + b2); // 98
        // int b3 = fis.read();
        // System.out.println("b3: " + b3); // -1
        // int b4 = fis.read();
        // System.out.println("b4: " + b4); // -1

        // 循环读取
        // int b;
        // while ((b = fis.read()) != -1) {
        //     System.out.println((char) b);
        // }

        /**
         * read()产生的问题：
         * 性能很差！
         * 读取汉字会出现乱码，且无法避免！
         */


        // 每次读取多个字节。
        // public int read(byte b[]) throws IOException:
        // 每次读取多个字节到字节数组中去，返回读取的字节数量，读取完毕返回-1;
        // byte[] buffer = new byte[3]; // 每次读取3个字节。
        // int len = fis.read(buffer);
        // String str = new String(buffer);
        // System.out.println("str: " + str + ", len: " + len); // abc
        //
        // int len2 = fis.read(buffer);
        // str = new String(buffer, 0, len2);
        // System.out.println("str: " + str + ", len: " + len2); // de
        //
        // int len3 = fis.read(buffer);
        // System.out.println("len3: " + len3); // -1

        // 循环读取
        // byte[] buffer = new byte[3];
        // int len;
        // while ((len = fis.read(buffer)) != -1) {
        //     String str = new String(buffer, 0, len);
        //     System.out.print(str); // abcde
        // }

        /**
         * read(byte[] b);
         * 性能得到大幅提升；
         * 读取汉字会出现乱码，且无法避免！
         */

        // 碰到中文文件，可以定义一个长度与文件一致的数组，一次性读取所有数据
        // File file = new File("src\\test2.txt");
        // System.out.println("getAbsolutePath: " + file.getAbsolutePath());
        // FileInputStream fis = new FileInputStream(file);

        // long totalLen = file.length();
        // System.out.println("totalLen: " + totalLen);
        // byte[] buffer = new byte[(int) totalLen];
        //
        // int len = fis.read(buffer);
        // String str = new String(buffer, 0, len);
        // System.out.println("str: " + str);

        // readAllBytes():
        // byte[] buffer = fis.readAllBytes();
        // System.out.println(new String(buffer));

        // 存在的问题：如果文件过大超过内存大小，会导致内存溢出。


        // fis.close();
    }

    @Test
    public void FileOutputStream() throws Exception {
        // 覆盖流，每次会从头开始写数据
        //FileOutputStream fos = new FileOutputStream("src\\test3out.txt");
        //追加流
        // FileOutputStream fos = new FileOutputStream("src\\test3out.txt", true);

        // 每次输出一个字节
        // fos.write(97);
        // fos.write('b');

        // 换行
        // fos.write("\r\n".getBytes());

        // 每次输出多个字节
        // byte[] bs = "这是需要输出的数据".getBytes();
        // fos.write(bs);

        // 指定数据的中间部分输出
        // fos.write(bs, 3, 6); // 注意是字节长度，非字符长度,截取错误会导致乱码;
        //
        // fos.close();
    }

    @Test
    public void CaseCopy() throws Exception {
        // InputStream fis = new FileInputStream("C:\\Users\\admin\\Desktop\\test\\1.txt");
        //
        // File fileToSave = new File("C:\\Users\\admin\\Desktop\\test_copy\\1.txt");
        //
        // File parentFile = fileToSave.getParentFile();
        //
        // if(!parentFile.exists()) {
        //     parentFile.mkdirs();
        // }
        //
        // FileOutputStream fos = new FileOutputStream("C:\\Users\\admin\\Desktop\\test_copy\\1.txt");
        //
        // byte[] buffer = new byte[1024]; // 1kb;
        //
        // int len;
        //
        // while ((len = fis.read(buffer)) != -1) {
        //     fos.write(buffer, 0, len);
        // }
        //
        // System.out.println("copy successed!");
        //
        // // 关闭：先进后出
        // fos.close();
        // fis.close();
    }

    @Test
    public void FileReader() throws IOException {
        // FileReader fr = null;
        // try {
        //     fr = new FileReader("src\\test3out.txt");

            // 一次读取一个字符。性能较差
            // int c;
            // while ((c = fr.read()) != -1) {
            //     System.out.print((char) c);
            // }

            // 一次读取多个字符
            // char[] buffer = new char[5];
            // int len;
            // while ((len = fr.read(buffer)) != -1) {
            //     System.out.print(new String(buffer, 0, len));
            // }
        // }catch (Exception e) {
        //     e.printStackTrace();
        // }finally {
        //     if(fr != null) fr.close();
        // }
    }

    @Test
    public void FileWriter() {
        try(
                //覆盖流
                //FileWriter fw = new FileWriter("src\\test4out.txt");
                //追加流
                FileWriter fw = new FileWriter("src\\test4out.txt", true)
        ) {
            // 输出一个字符
            // fw.write('a');
            // fw.write(98);

            // 输出多个字符
            // char[] cs = new char[]{'c', 'd', 'e', 'f'};
            // fw.write(cs);
            // fw.write(cs, 0, 1);

            // 输出字符串
            // String str = "ghijklmn";
            // fw.write(str);
            // fw.write(str, 0, 5);

            // 注意事项：
            // 字符输出流写出数据后，必须刷新流或者关闭流，输出才能生效。
            // 刷新流： fw.flush(),关闭流: fw.close(); 关闭流包含刷新流
            // 区别： 刷新流调用后仍然可以输出数据，关闭流关闭后无法再输出数据。

        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void BufferedStream() {
        try{
            // 字节缓冲输入流
            // FileInputStream fis = new FileInputStream("src\\test4out.txt");
            //BufferedInputStream bis = new BufferedInputStream(fis, 8092 * 2);
            // BufferedInputStream bis = new BufferedInputStream(fis);

            // 一次一个字节
            // System.out.print("1: ");
            // int n;
            // while ((n = bis.read()) != -1) {
            //     System.out.print((char)n);
            // }
            // 一次多个字节
            // System.out.print("2: ");
            // byte[] bs = new byte[5];
            // int len;
            // while ((len = bis.read(bs)) != -1) {
            //     System.out.print(new String(bs, 0, len));
            // }

            // 字节缓冲输出流
            // FileOutputStream fos = new FileOutputStream("src\\test5out.txt");
            // BufferedOutputStream bos = new BufferedOutputStream(fos, 8092 * 2);
            // BufferedOutputStream bos = new BufferedOutputStream(fos);

            //输出
            // bos.write("flasdflajsdf".getBytes());
            // bos.close();

            // 字符缓冲输入流
            // FileReader fr = new FileReader("src\\test5out.txt");
            // BufferedReader bfr = new BufferedReader(fr, 8092 * 2);
            // BufferedReader bfr = new BufferedReader(fr);
            // System.out.print("3 ");
            // System.out.println(bfr.readLine());

            // 字符缓冲输出流
            // FileWriter fw = new FileWriter("src\\test6out.txt");
            // BufferedWriter bfw = new BufferedWriter(fw, 8092 * 2);
            // BufferedWriter bfw = new BufferedWriter(fw);
            // bfw.write("FileWriter fw = new FileWriter(\"src\\\\test6out.txt\");");
            // bfw.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}