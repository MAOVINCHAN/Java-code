import java.sql.*;
import java.util.Scanner;

/**
 * 登录功能实现
 */
public class Login {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入用户名：");
        String username = scanner.next();
        System.out.print("请输入密码：");
        String password = scanner.next();
        System.out.println(checkUser(username, password) ? "登录成功" : "登录失败");
    }

    private static boolean checkUser(String username, String password) throws SQLException {
        Connection con = null;
        PreparedStatement preparedStatement = null;
        ResultSet res = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/learn?serverTimezone=UTC", "root", "******");
            // 改造前，容易发生sql注入
            // Statement ste = con.createStatement();
            // ResultSet res = ste.executeQuery("select * from user_sheet where username = '" + username + "' and password = '" + password + "';");
            // 改造后
            preparedStatement = con.prepareStatement("select * from user_sheet where username = ? and password = ?");
            preparedStatement.setString(1, username); // 从1开始
            preparedStatement.setString(2, password);
            res = preparedStatement.executeQuery();
            if(res.next()) {
                return true;
            }
            return false;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if(con != null) con.close();
            if(preparedStatement != null) preparedStatement.close();
            if(res != null) res.close();
            return false;
        }
    }
}
