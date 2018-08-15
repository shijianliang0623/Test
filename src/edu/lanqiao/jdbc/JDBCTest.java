package edu.lanqiao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class JDBCTest {
	public void addOneEmp(int empno, String name, String job, int mgr, String hireDate, float sal, float comm, int deptno) {
		// 9527 TBH bookkids 7902 1488-07-18 1.00 null 10
		Connection conn = null;
		Statement stm = null;
		PreparedStatement pstm = null;
		try {
			// 1.加载驱动
			Class.forName("oracle.jdbc.OracleDriver");
			// 2.获取连接
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL11", "scott", "scott");
			// 3.创建语句
			//stm = conn.createStatement();
			pstm = conn.prepareStatement("Insert into emp(empno,ename,job,mgr,hiredate,sal,comm,deptno) \r\n" + 
					"values (?, ?, ?, ?, ?, ?, ?, ?)");
			pstm.setInt(1, empno);
			pstm.setString(2, name);
			pstm.setString(3, job);
			pstm.setInt(4, mgr);
			//java.sql.Date/java.util.Date
			java.util.Date udate = new SimpleDateFormat("yyyy-mm-dd").parse(hireDate);
			pstm.setDate(5, new java.sql.Date(udate.getTime())); //String->Date
			pstm.setFloat(6, sal);
			if (comm<=0) {
				pstm.setNull(7, Types.FLOAT);
			} else {
				pstm.setFloat(7, comm);
			}
			pstm.setInt(8, deptno);
			
			// 4.编写SQL语句
			/*String sqlStr = "Insert into emp(empno,ename,job,mgr,hiredate,sal,comm,deptno) \r\n"
					+ "values ("+empno+",'"+name+"','"+job+"',"+mgr+",to_date('"+hireDate+"','yyyy-mm-dd'),"+sal+",null,"+deptno+")";*/
			// 5.执行SQL
			pstm.executeUpdate();
			//boolean rst = stm.execute(sqlStr);
			// stm.executeUpdate(sqlStr);
			// 6.处理结果
			//System.out.println("result=" + rst);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 7.关闭资源
			try {
				pstm.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public void getAllEmp() {
		// 需求：拿到emp的表数据
		// 准备工作：添加jar文件到buildPath
		Connection conn = null;
		Statement stm = null;
		ResultSet rs = null;
		try {
			// 1.加载驱动
			Class.forName("oracle.jdbc.OracleDriver");
			// 2.获取连接 127.0.0.1:1521/orcl
			// http://www.baidu.com/index.html
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", "scott", "tiger");
			// 3.创建语句
			stm = conn.createStatement();
			// 4.编写SQL语句
			String sqlStr = "SELECT * FROM EMP";
			// 5.执行SQL
			rs = stm.executeQuery(sqlStr);
			// 6.处理结果
			while (rs.next()) {
				System.out.print(rs.getInt("EMPNO") + "@");
				System.out.println(rs.getString("ENAME"));
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 7.关闭资源
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				stm.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		JDBCTest jt = new JDBCTest();
		//jt.getAllEmp();
		//9527 TBH bookkids 7902 1488-07-18 1.00 null 10
		jt.addOneEmp(9529,"tbh","st",7902,"1490-07-18",1.00f,0f,10);

	}

}
