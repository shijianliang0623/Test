package edu.lanqiao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmpDao {
	 public boolean addOne(Emp emp){  
         boolean f = false;  
          
         //2.����sql���  
         String sql = "insert into emp values(?,?,?,?,?,?,?,?)";  
         //1.��ȡ���ݿ����Ӷ���  
         //3.��ȡpreparedStatement�����Է���sql��䵽���ݿ�  
         try (Connection conn = DBConnection.getConn();PreparedStatement ps = conn.prepareStatement(sql)){  
                  //ͨ��ps�����sql������ò�����  
                  ps.setInt(1, emp.getEmpno());  
                  ps.setString(2, emp.getEname());  
                  ps.setString(3, emp.getJob());  
                  ps.setInt(4, emp.getMgr());  
                  ps.setDate(5, emp.getHiredate());  
                  ps.setDouble(6, emp.getSal());  
                  ps.setDouble(7, emp.getComm());  
                  ps.setInt(8, emp.getDeptno());  
                  //4.ִ��sql���  
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
