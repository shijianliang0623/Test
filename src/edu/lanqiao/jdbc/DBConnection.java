package edu.lanqiao.jdbc;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnection {
	 private static String url = "jdbc:oracle:thin:@localhost:1521:ORCL11";    
     private static String user = "scott";    
     private static String password = "scott";    
      static{    
               try{    
                        //加载驱动类    
                        Class.forName("oracle.jdbc.driver.OracleDriver");    
               }catch (ClassNotFoundException e) {    
                        e.printStackTrace();    
               }    
      }    
     public static Connection getConn(){    
               //获取连接对象    
               Connection con = null;    
               try{    
                        con= DriverManager.getConnection(url, user, password);    
               }catch (SQLException e) {    
                        e.printStackTrace();    
               }    
                                 return con;    
      }    
              public static void close(Connection conn,PreparedStatement ps, ResultSet rs){    
               if(rs!= null){    
                        try{    
                                 rs.close();    
                        }catch (SQLException e) {    
                                 e.printStackTrace();    
                        }    
               }    
               if(ps!= null){    
                        try{    
                                 ps.close();    
                        }catch (SQLException e) {    
                                 e.printStackTrace();    
                        }    
               }    
               if(conn!= null){    
                        try{    
                                 conn.close();    
                        }catch (SQLException e) {    
                                 e.printStackTrace();    
                        }    
               }    
      }    
}
