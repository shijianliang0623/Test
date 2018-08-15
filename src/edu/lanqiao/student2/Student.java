package edu.lanqiao.student2;

public class Student {

		private int stuNo; // ѧ��
		private String pwd; // ����
		private String name; // ����
		private String sex; // �Ա�
		private int age; // ����
		private String phone; // �绰
		private String addr; // ��ַ

		public Student() {
		}

		public Student(int stuNo, String pwd, String name, String sex, int age, String phone, String addr) {
			this.stuNo = stuNo;
			this.pwd = pwd;
			this.name = name;
			this.sex = sex;
			this.age = age;
			this.phone = phone;
			this.addr = addr;
		}

		public int getStuNo() {
			return stuNo;
		}

		public void setStuNo(int stuNo) {
			this.stuNo = stuNo;
		}

		public String getPwd() {
			return pwd;
		}

		public void setPwd(String pwd) {
			this.pwd = pwd;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getSex() {
			return sex;
		}

		public void setSex(String sex) {
			this.sex = sex;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

		public String getPhone() {
			return phone;
		}

		public void setPhone(String phone) {
			this.phone = phone;
		}

		public String getAddr() {
			return addr;
		}

		public void setAddr(String addr) {
			this.addr = addr;
		}

		@Override
		public String toString() {
			return "Student [stuNo=" + stuNo + ", pwd=" + pwd + ", name=" + name + ", sex=" + sex + ", age=" + age
					+ ", phone=" + phone + ", addr=" + addr + "]";
		}

	}


