package edu.lanqiao.student2;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import edu.lanqiao.student.DBUtil;
import edu.lanqiao.student2.Student;




	public class Teacher {
		
	
		
		
		// 根据姓名模糊查询
			public List<Student> queryByName(String stuName) {
				ResultSetHandler<List<Student>> h = new BeanListHandler<Student>(Student.class);
				QueryRunner run = new QueryRunner();
				Connection conn = DBUtil.getConnection();
				String sql = "SELECT * FROM T_STUINFO WHERE NAME LIKE ?";
				List<Student> list = new ArrayList<Student>();
				try {
					list = run.query(conn, sql, h, "%"+stuName+"%");
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					try {
						DbUtils.close(conn);
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				return list;
			}
		
		public Student queryByNo(int stuNo) {
			QueryRunner run = new QueryRunner();
			ResultSetHandler<Student> h = new BeanHandler<Student>(Student.class);
			Student stu = null;
			Connection conn = DBUtil.getConnection();
			try {
				stu = run.query(conn, "SELECT * FROM T_STUINFO WHERE STUNO = ?", h, stuNo);
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					DbUtils.close(conn);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			return stu;
		}
		
		// 添加对象
		public Student add(Student stu) {
			QueryRunner run = new QueryRunner();
            String sql = "insert into t_stuinfo (StuId,StuPassword,StuName,StuSex,StuAge,StuTelephone,StuAddress) values(?,?,?,?,?,?,?)";
			Connection conn = DBUtil.getConnection();
			try {
				int i = run.update(conn,sql,stu.getStuNo(),stu.getPwd(), stu.getName(),stu.getSex(),stu.getAge(),stu.getPhone(),stu.getAddr());
				if(i==1) {
					System.out.println("数据添加成功！");
				}else {
					System.out.println("数据添加失败！");
				}

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					DbUtils.close(conn);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			return stu;
		}
		
		
		// 添加对象
				public void deleteByNo(int stuNo) {
					QueryRunner run = new QueryRunner();
		            String sql = "delete from t_stuinfo where stuid = ?";
					Connection conn = DBUtil.getConnection();
					try {
						int i = run.update(conn,sql,stuNo);
						if(i==1) {
							System.out.println("数据删除成功！");
						}else {
							System.out.println("数据删除失败！");
						}

					} catch (SQLException e) {
						e.printStackTrace();
					} finally {
						try {
							DbUtils.close(conn);
						} catch (SQLException e) {
							e.printStackTrace();
						}
					}
				}
				
				
				// 修改对象
				public void updateInfo(Student newStu) {
					QueryRunner run = new QueryRunner();
		            String sql = "update student set stupassword= ?,stuname=?,stusex=?,stuage=?,stutelephone=?,stuaddress=? where stuid = ?";
					Connection conn = DBUtil.getConnection();
					try {
						int i = run.update(conn,sql,newStu.getPwd(),newStu.getName(),newStu.getSex(),newStu.getAge(),newStu.getPhone(),newStu.getAddr());
						if(i==1) {
							System.out.println("数据删除成功！");
						}else {
							System.out.println("数据删除失败！");
						}

					} catch (SQLException e) {
						e.printStackTrace();
					} finally {
						try {
							DbUtils.close(conn);
						} catch (SQLException e) {
							e.printStackTrace();
						}
					}
				}
		
		public static void main(String[] args) {
			
	        
		}
	}


