package blog.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/**
 * @author 斯洪霄
 * @version 1.0
 * 连接数据库
 * @date 2021/10/12 - 16:30
 */
public class dbConnection {
    private static String driver;
    private static String url;
    private static String username;
    private static String password;

    static {

        Properties properties = new Properties();
        try {
//            FileInputStream in = new FileInputStream("dbConnection.properties");
            InputStream in =dbConnection.class.getResourceAsStream("/dbConnection.properties");
            properties.load(in);
            driver = properties.getProperty("DRIVER");
            url = properties.getProperty("URL");
            username = properties.getProperty("USERNAME");
            password =properties.getProperty("PASSWORD");
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static Connection getConnection(){
        Connection conn = null;
        try {
            Class.forName(driver);
            conn= DriverManager.getConnection(url,username,password);
        }catch (Exception e){
            e.printStackTrace();
        }
        return conn;
    }
}
