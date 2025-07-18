import java.sql.*;

public class Main {
    public static void main(String[] args) {
        try {
            // 加载驱动
            // 8.0以下版本为：com.mysql.jdbc.Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 获取连接
            // 8.0以下版本为：jdbc:mysql://localhost:3306/数据库名
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/learn?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC",
                    "root",
                    "******");
            // 获取执行sql的对象
            Statement statement = con.createStatement();
            // 定义sql
            String sql = "select * from user_sheet";
            // 执行查询sql
            ResultSet res = statement.executeQuery(sql);
            while (res.next()) {
                int id = res.getInt("id");
                String username = res.getString("username");
                int age = res.getInt("age");
                String phoneNumber = res.getString("phone_number");
                String address = res.getString("address");
                double score = res.getDouble("score");

                System.out.print("id: " + id + ", ");
                System.out.print("username: " + username + ", ");
                System.out.print("age: " + age + ", ");
                System.out.print("phoneNumber: " + phoneNumber + ", ");
                System.out.print("address: " + address + ", ");
                System.out.print("score: " + score);
                System.out.println();
            }
            // 执行更新sql
            int num = statement.executeUpdate(
                "insert into user_sheet values " +
                "(4, 'aaa', 21, '15111550000', 'shanghai', 100)," +
                "(5, 'bbb', 22, '15111550000', 'shanghai', 100)," +
                "(6, 'ccc', 23, '15111550000', 'shanghai', 100);" // 以分号结尾
            );
            System.out.println("num: " + num); // 更新的行数

            statement.close();
            con.close();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}