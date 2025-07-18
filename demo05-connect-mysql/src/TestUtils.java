import Utils.DBPropertiesUtils;

import java.sql.*;

public class TestUtils {
    public static void main(String[] args) {
        try {
            DBPropertiesUtils utils = DBPropertiesUtils.getDbPropertiesUtils();
            String driver = utils.getValue("jdbc.driver");
            System.out.println("driver: " + driver);
            Class.forName(driver);
            Connection con = DriverManager.getConnection(
            utils.getValue("jdbc.url"),
            utils.getValue("jdbc.user"),
            utils.getValue("jdbc.password")
            );
            PreparedStatement pre = con.prepareStatement("select * from user_sheet where username = ? and password = ?");
            pre.setString(1, "tom");
            pre.setString(2, "123456");
            ResultSet res = pre.executeQuery();
            while (res.next()) {
                int id = res.getInt("id");
                String username = res.getString("username");
                System.out.println("id: " + id + ",username: " + username);
                System.out.println();
            }

            // 使用java代码操作事务
            // con.setAutoCommit(false);
            // boolean autoCommit = con.getAutoCommit();
            // con.commit();
            // con.rollback();


            res.close();
            pre.close();
            con.close();
        } catch (ClassNotFoundException e) {
            System.out.println("驱动加载失败");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("数据库连接失败");
            throw new RuntimeException(e);
        }
    }
}
