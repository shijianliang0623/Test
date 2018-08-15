package edu.lanqiao.student;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DBUtil {
    private static String driver;
    private static String url;
    private static String userName;
    private static String pwd;

    static {
        try {
            InputStream in = new BufferedInputStream(
                    new FileInputStream("src/edu/lanqiao/student/dbinfo.properties"));
            Properties p = new Properties();
            p.load(in);
            driver = p.getProperty("DBdriver");
            url = p.getProperty("DBurl");
            userName = p.getProperty("username");
            pwd = p.getProperty("password");
            // 加载驱动
            Class.forName(driver);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // 获取连接
    public static Connection getConnection() {
        Connection conn = null;
        try {
            // 获取连接
            conn = DriverManager.getConnection(url, userName, pwd);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return conn;
    }

    // 关闭资源
    public static void closeResource(Connection conn, Statement stm, ResultSet rs) {
        if (null != rs) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (null != stm) {
            try {
                stm.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (null != conn) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
