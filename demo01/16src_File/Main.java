import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        // File file = new File("C:\\Users\\admin\\Desktop\\test");
        // System.out.println("isFile: " + file.isFile());
        // System.out.println("isDirectory: " + file.isDirectory());
        // System.out.println("path: " + file.getAbsolutePath());
        //
        // File[] fs = file.listFiles(new FilenameFilter() {
        //     @Override
        //     public boolean accept(File dir, String name) {
        //         return name.endsWith(".txt");
        //     }
        // });
        // printFile(fs);

        // 递归打印所有文件
        deepPrint("C:\\Users\\admin\\Desktop\\test");
    }

    public static void deepPrint(String path) {
        File file = new File(path);

        if(file == null) return;

        File[] files = file.listFiles();

        for (File item :
                    files) {
            if (item.isDirectory()) {
                String newPath = item.getAbsolutePath();
                System.out.println("directroy: " + item.getName());
                deepPrint(newPath);
            }else {
                System.out.println("file: " + item.getName());
            }
        }
    }

    // public static void printFile(File[] file) {
    //     if(file != null) {
    //         for (File it :
    //                 file) {
    //             System.out.println("--- file ---: " + it.getAbsolutePath());
    //         }
    //     }
    // }
}