package edu.lanqiao.student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class Teacher {

	
	//���ѧ����Ϣ
	public void add(Student1 stu) {
		ResultSet rs=null;
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
		
			conn = DBUtil.getConnection();
			pstm = conn.prepareStatement("insert into t_stuinfo (STUNO,PWD,STUNAME,SEX,AGE,PHONE,ADDR) values(?,?,?,?,?,?,?)");
			pstm.setInt(1, stu.getStuNo());
			pstm.setString(2, stu.getStuPass());
			pstm.setString(3, stu.getStuName());
			pstm.setString(4, stu.getStuSex());
			pstm.setString(5, stu.getStuAge());
			pstm.setString(6, stu.getStuTel());
			pstm.setString(7, stu.getStuAddr());
			pstm.executeUpdate();
			
        } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
			// 7.�ر���Դ
			DBUtil.closeResource(conn, pstm, rs);
		}

	}
	
	//���ݱ��ɾ��ѧ����Ϣ
	public void deleteByNo(int stuNo) {
		ResultSet rs = null;
		Connection conn = null;
	    PreparedStatement pstm = null;
		try {
			
			conn = DBUtil.getConnection();
			pstm = conn.prepareStatement("delete from t_stuinfo where stuid='" + stuNo + "'");
//			stm = conn.prepareStatement("delete from t_student where id=?");
//			stm.setString(1, stuNo);
			pstm.executeUpdate();
			
        } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
			// 7.�ر���Դ
			DBUtil.closeResource(conn, pstm, rs);
		}
	}
	
	//�޸�ѧ����Ϣ
	public void updateInfo(Student1 newStu) {
		ResultSet rs = null;
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
		
			conn=DBUtil.getConnection();
			pstm = conn.prepareStatement("update t_stuinfo set stuage='" + newStu.getStuAge() + "',stusex='" + newStu.getStuSex() + "',stuid='" + newStu.getStuNo() + "'"
					+ ",stupassword='" + newStu.getStuPass() + "', stutelephone='" + newStu.getStuTel() + "',stuaddress='" + newStu.getStuAddr()+ "' where StuName='" + newStu.getStuName() + "'");
			pstm.executeUpdate();
			
        }  catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
		
			// 7.�ر���Դ
			DBUtil.closeResource(conn, pstm, rs);
		}
	}
	
	//��������ģ����ѯ
	public List<Student1> queryByName(){
		List<Student1> list = new ArrayList<>();  
		Connection conn = null;
		ResultSet rs = null;
	    PreparedStatement pstm = null;
		try {
			conn = DBUtil.getConnection();
			// 3.�������
			pstm = conn.prepareStatement("select * from t_stuinfo ");
//			where stuname like '%"+Name+"%'		
			rs = pstm.executeQuery();
	         //ȡ����ǰ�����ݣ���װ��һ��Student���󣬷���list����
			while(rs.next()){ 
            int id = rs.getInt(1);  
            String password = rs.getString(2);  
            String name = rs.getString(3); 
            String sex = rs.getString(4);  
            String age = rs.getString(5); 
            String telephone = rs.getString(6);
            String address = rs.getString(7);
            list.add(new Student1(id,password,name,sex,age,telephone,address));  
            }  
			  for(Student1 s:list) {
					System.out.println(s.toString());
				}
			
        
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 7.�ر���Դ
			DBUtil.closeResource(conn, pstm, rs);
		}
		return list;
	
		
	}
	
	
	
}