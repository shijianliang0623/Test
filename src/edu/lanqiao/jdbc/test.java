package edu.lanqiao.jdbc;

import java.sql.Date;

public class test {

	public  static void main (String args[]) {
		Emp e1 = new Emp();
		e1.setEmpno(9527);
		e1.setEname("TBH");
		e1.setJob("bookkids");
		e1.setMgr(7902 );
		e1.setHiredate(Date.valueOf("1488-07-18"));
		e1.setSal(1.00);
		e1.setComm(300.0);
		e1.setDeptno(10);

	}
}
