import java.sql.*;

public class BaseDao {
    private static final String url = "jdbc:mysql://localhost:3306/learn?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
    private static final String driver = "com.mysql.cj.jdbc.Driver";
    private static final String user = "root";
    private static final String pwd = "112233";

    public static Connection getCon() {
        Connection connection = null;
        try {
            Class.forName(driver);

            connection = DriverManager.getConnection(url, user, pwd);
            return connection;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static int update(String sql, Object[] objects) throws SQLException {
        Connection con = getCon();
        PreparedStatement preparedStatement = null;
        int num = 0;
        try {
            preparedStatement = con.prepareStatement(sql);
            for (int i = 0; i < objects.length; i++) {
                preparedStatement.setObject(i + 1, objects[i]);
            }
            num = preparedStatement.executeUpdate();
            con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            close(con, preparedStatement, null);
        }

        return num;
    }

    public static ResultSet query(String sql, Object[] objects) throws SQLException {
        Connection con = getCon();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = con.prepareStatement(sql);
            for (int i = 0; i < objects.length; i++) {
                preparedStatement.setObject(i + 1, objects[i]);
            }
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            // close(con, preparedStatement, resultSet);
        }
        return resultSet;
    }

    public static void close(Connection con, PreparedStatement ste, ResultSet res) {
        try {
            if(con != null) con.close();
            if(ste != null) ste.close();
            if(res != null) res.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
