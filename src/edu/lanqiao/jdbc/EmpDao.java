package edu.lanqiao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmpDao {
	 public boolean addOne(Emp emp){  
         boolean f = false;  
          
         //2.定义sql语句  
         String sql = "insert into emp values(?,?,?,?,?,?,?,?)";  
         //1.获取数据库连接对象  
         //3.获取preparedStatement对象，以发送sql语句到数据库  
         try (Connection conn = DBConnection.getConn();PreparedStatement ps = conn.prepareStatement(sql)){  
                  //通过ps对象给sql语句设置参数？  
                  ps.setInt(1, emp.getEmpno());  
                  ps.setString(2, emp.getEname());  
                  ps.setString(3, emp.getJob());  
                  ps.setInt(4, emp.getMgr());  
                  ps.setDate(5, emp.getHiredate());  
                  ps.setDouble(6, emp.getSal());  
                  ps.setDouble(7, emp.getComm());  
                  ps.setInt(8, emp.getDeptno());  
                  //4.执行sql语句  
                  int row = ps.executeUpdate();  
                  if(row != 0){  
                           f = true;  
                  }  
         } catch (SQLException e) {  
                  e.printStackTrace();  
         }  
         return f;  
   }  
}
