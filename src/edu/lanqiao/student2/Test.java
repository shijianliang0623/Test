package edu.lanqiao.student2;


import java.util.Scanner;



	public class Test {
		public static void main(String[] args) {
			 teacherFunction();
		}
		
	public static  void teacherFunction() {
			
			System.out.println("***************************************");
			System.out.println("*        ��ӭ����������ϵͳ ��                      *");
			System.out.println("*         1:        ���ѧ��                             *");
			System.out.println("*         2:        ɾ��ѧ��                             *");
			System.out.println("*         3:        �޸�ѧ��                             *");
			System.out.println("*         4:        ��ѯѧ��                             *");
			System.out.println("��������Ҫ��������Ӧ�ĺ��룺");
			Scanner sn = new Scanner(System.in);
			int choice = sn.nextInt();
			Teacher te = new Teacher();
				switch(choice){
					case 1:
						 System.out.print("������ѧ����ѧ�ţ�");
				    	 Scanner StuNo = new Scanner(System.in);
				    	 int  stuno = StuNo.nextInt();
				    	 System.out.print("������ѧ�������룺");
				    	 Scanner Spass = new Scanner(System.in);
				         String  stupass = Spass.next();
						 System.out.print("������ѧ����������");
				    	 Scanner Sname = new Scanner(System.in);
				         String  stuname = Sname.next();
				         System.out.print("������ѧ�����Ա�");
				         Scanner Ssex = new Scanner(System.in);
				         String  stusex  = Ssex.next();
				         System.out.print("������ѧ�������䣺");
				         Scanner Sage = new Scanner(System.in);
				         int  stuage = Sage.nextInt();
				         System.out.print("������ѧ���ĵ绰��");
				         Scanner Stel = new Scanner(System.in);
				         String  stutel = Stel.next();
				         System.out.print("������ѧ���ĵ�ַ��");
				         Scanner Saddr = new Scanner(System.in);
				         String  stuaddr = Saddr.next();
				         te.add(new Student(stuno,stupass,stuname,stusex,stuage,stutel,stuaddr));
				         System.out.print("��ӳɹ�");
				         teacherFunction();
				         break;
					 case 2:
						 System.out.print("������Ҫɾ����ѧ��ѧ����ѧ�ţ�");
					     Scanner StuNo1 = new Scanner(System.in);
					     int  stuno1 = StuNo1.nextInt();
						 te.deleteByNo(stuno1);
						 System.out.print("ɾ���ɹ�");
						 teacherFunction();
						 break;
					 case 3:
						 System.out.print("����Ҫ�޸ĵ�ѧ����ѧ�ţ�");
				    	 Scanner StuNo11 = new Scanner(System.in);
				    	 int  stuno11 = StuNo11.nextInt();
						 System.out.print("���޸�");
				    	 System.out.print("���������룺");
				    	 Scanner Stupass = new Scanner(System.in);
				         String  stupass11 = Stupass.next();
				         System.out.print("������������");
				    	 Scanner Stuname11 = new Scanner(System.in);
				         String  stuname11 = Stuname11.next();
				         System.out.print("�������Ա�");
				         Scanner Stusex11 = new Scanner(System.in);
				         String  stusex11  = Stusex11.next();
				         System.out.print("���������䣺");
				         Scanner Stuage11 = new Scanner(System.in);
				         int stuage11 = Stuage11.nextInt();
				         System.out.print("������绰��");
				         Scanner Stel11 = new Scanner(System.in);
				         String  stutel11 = Stel11.next();
				         System.out.print("�������ַ��");
				         Scanner Saddr11 = new Scanner(System.in);
				         String  stuaddr11 = Saddr11.next();
				         te.updateInfo(new Student(stuno11,stupass11,stuname11,stusex11,stuage11,stutel11,stuaddr11));
				         System.out.print("�޸ĳɹ�");
				         teacherFunction();
						 break;	
					 case 4:  	
						 System.out.print("������Ҫ��ѯ��ѧ����������");
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


