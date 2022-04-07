package database;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @program: exercise2_lets_go_out
 * @author: qin haojun
 * @create: 2022-04-01 00:03
 */
public class ConnectionFactory {

    public static Connection getConnection()  {
        Connection connection=null;
        try {
            String url = "jdbc:sqlserver://127.0.0.1:1433;DatabaseName=KONGMING234";
            String username = "sa";
            String password = "892599";
            //加载驱动
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            //连接数据库
            connection = DriverManager.getConnection(url, username, password);
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

}
