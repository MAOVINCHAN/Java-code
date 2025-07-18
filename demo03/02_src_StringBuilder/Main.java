/**
 * StringBuilder:
 * 1. 为了能高效拼接字符串，Java标准库提供了StringBuilder，它是一个可变对象，可以预分配缓冲区，这样，往StringBuilder中新增字符时，不会创建新的临时对象;
 */
public class Main {
    public static void main(String[] args) {
        String[] fields = { "name", "position", "salary" };
        String table = "employee";
        String insert1 = buildInsertSql(table, fields);
        System.out.println(insert1);
        String s = "INSERT INTO employee (name, position, salary) VALUES (?, ?, ?)";
        System.out.println(s.equals(insert1) ? "测试1成功" : "测试1失败");
        System.out.println(s.equals(buildInsertSql2(table, fields)) ? "测试2成功" : "测试2失败");

        // 数组转为字符串
        String[] names = {"name", "position", "salary"};
        String namesToString = String.join(",", names);

        String insert3 = buildInsertSql3(table, fields);
        System.out.println("insert3:" + insert3);
        System.out.println(s.equals(insert3) ? "测试3成功" : "测试3失败");
    }

    static String buildInsertSql(String table, String[] fields) {
        StringBuilder sb = new StringBuilder("INSERT INTO");
        for (int i = 0; i < fields.length; i++) {
            sb
            .append(i == 0 ? " " + table + " (" : "")
            .append(fields[i])
            .append(i == fields.length - 1 ? ") VALUES (?, ?, ?)" : ", ");
        }
        return sb.toString();
    }

    static String buildInsertSql2(String table, String[] fields) {
        return "INSERT INTO " + table +
                " (" + (ArrayToString(fields)) + ") " +
                "VALUES (?, ?, ?)"
                ;
    }

    static String buildInsertSql3(String table, String[] fields) {
        return "INSERT INTO " + table +
                " (" + (String.join(", ", fields)) + ") " +
                "VALUES (?, ?, ?)"
                ;
    }

    static String ArrayToString(String[] arr) {
        String s = "";
        for (int i = 0; i < arr.length; i++) {
            if(i != 0) s += ", ";
            s += arr[i];
        }
        return  s;
    }
}