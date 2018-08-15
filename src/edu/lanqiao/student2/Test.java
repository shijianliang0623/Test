package edu.lanqiao.student2;


import java.util.Scanner;



	public class Test {
		public static void main(String[] args) {
			 teacherFunction();
		}
		
	public static  void teacherFunction() {
			
			System.out.println("***************************************");
			System.out.println("*        欢迎来到本教务系统 ！                      *");
			System.out.println("*         1:        添加学生                             *");
			System.out.println("*         2:        删除学生                             *");
			System.out.println("*         3:        修改学生                             *");
			System.out.println("*         4:        查询学生                             *");
			System.out.println("请输入所要操作所对应的号码：");
			Scanner sn = new Scanner(System.in);
			int choice = sn.nextInt();
			Teacher te = new Teacher();
				switch(choice){
					case 1:
						 System.out.print("请输入学生的学号：");
				    	 Scanner StuNo = new Scanner(System.in);
				    	 int  stuno = StuNo.nextInt();
				    	 System.out.print("请输入学生的密码：");
				    	 Scanner Spass = new Scanner(System.in);
				         String  stupass = Spass.next();
						 System.out.print("请输入学生的姓名：");
				    	 Scanner Sname = new Scanner(System.in);
				         String  stuname = Sname.next();
				         System.out.print("请输入学生的性别：");
				         Scanner Ssex = new Scanner(System.in);
				         String  stusex  = Ssex.next();
				         System.out.print("请输入学生的年龄：");
				         Scanner Sage = new Scanner(System.in);
				         int  stuage = Sage.nextInt();
				         System.out.print("请输入学生的电话：");
				         Scanner Stel = new Scanner(System.in);
				         String  stutel = Stel.next();
				         System.out.print("请输入学生的地址：");
				         Scanner Saddr = new Scanner(System.in);
				         String  stuaddr = Saddr.next();
				         te.add(new Student(stuno,stupass,stuname,stusex,stuage,stutel,stuaddr));
				         System.out.print("添加成功");
				         teacherFunction();
				         break;
					 case 2:
						 System.out.print("请输入要删除的学生学生的学号：");
					     Scanner StuNo1 = new Scanner(System.in);
					     int  stuno1 = StuNo1.nextInt();
						 te.deleteByNo(stuno1);
						 System.out.print("删除成功");
						 teacherFunction();
						 break;
					 case 3:
						 System.out.print("输入要修改的学生的学号：");
				    	 Scanner StuNo11 = new Scanner(System.in);
				    	 int  stuno11 = StuNo11.nextInt();
						 System.out.print("请修改");
				    	 System.out.print("请输入密码：");
				    	 Scanner Stupass = new Scanner(System.in);
				         String  stupass11 = Stupass.next();
				         System.out.print("请输入姓名：");
				    	 Scanner Stuname11 = new Scanner(System.in);
				         String  stuname11 = Stuname11.next();
				         System.out.print("请输入性别：");
				         Scanner Stusex11 = new Scanner(System.in);
				         String  stusex11  = Stusex11.next();
				         System.out.print("请输入年龄：");
				         Scanner Stuage11 = new Scanner(System.in);
				         int stuage11 = Stuage11.nextInt();
				         System.out.print("请输入电话：");
				         Scanner Stel11 = new Scanner(System.in);
				         String  stutel11 = Stel11.next();
				         System.out.print("请输入地址：");
				         Scanner Saddr11 = new Scanner(System.in);
				         String  stuaddr11 = Saddr11.next();
				         te.updateInfo(new Student(stuno11,stupass11,stuname11,stusex11,stuage11,stutel11,stuaddr11));
				         System.out.print("修改成功");
				         teacherFunction();
						 break;	
					 case 4:  	
						 System.out.print("请输入要查询的学生的姓名：");
				    	 Scanner Sname2 = new Scanner(System.in);
				         String  name2 = Sname2.next();
				         te.queryByName(name2);
				         teacherFunction();
				         break;	
				     default:
					     break;
		  }
				sn.close();
		}
	}


