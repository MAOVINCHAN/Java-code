import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * 测试工具类BaseDao
 */
public class TestDao {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("用户名：");
        String username = scanner.next();
        System.out.print("密码：");
        String password = scanner.next();
        String[] params = { username, password };
        ResultSet resultSet = BaseDao.query("select * from user_sheet where username = ? and password = ?", params);
        System.out.println(resultSet.next() ? "登录成功" : "登录失败");
    }
}
