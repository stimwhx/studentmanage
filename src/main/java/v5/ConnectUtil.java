package v5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectUtil {
    private Connection connection;
    public Connection getConnection(){
        PropertiesUtil.loadFile("db");
        String driver = PropertiesUtil.getPropertiesValue("driver");
        String url = PropertiesUtil.getPropertiesValue("url");
        String username = PropertiesUtil.getPropertiesValue("username");
        String password = PropertiesUtil.getPropertiesValue("password");
        try {
            Class.forName(driver);
            connection= DriverManager.getConnection(url,username,password);
            System.out.println("MySQL联接成功");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
            close();
        }
        return connection;
    }

    private void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
