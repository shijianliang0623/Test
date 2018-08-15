package edu.lanqiao.student;

public class Student1 {
	private int stuNo;
	private String stuPass;
    private String stuName;
    private String stuSex;
    private String stuAge;
    private String stuTel;
	private String stuAddr;
	
  
    public Student1(int stuNo,String stuPass,String stuName, String stuSex, String stuAge,String stuTel,String stuAddr) {
        this.stuNo = stuNo; 
        this.stuPass = stuPass;
        this.stuName = stuName;
        this.stuSex = stuSex;
        this.stuAge = stuAge;
        this.stuTel = stuTel;
        this.stuAddr = stuAddr;
    }

    public int getStuNo() {
        return stuNo;
    }

    public void setStuNo(int stuNo) {
        this.stuNo = stuNo;
    }

    public String getStuPass() {
		return stuPass;
	}

	public void setStuPass(String stuPass) {
		this.stuPass = stuPass;
	}
	
    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getStuSex() {
        return stuSex;
    }

    public void setStuSex(String stuSex) {
        this.stuSex = stuSex;
    }

    public String getStuAge() {
        return stuAge;
    }

    public void setStuAge(String stuAge) {
        this.stuAge = stuAge;
    }

    public String getStuTel() {
		return stuTel;
	}

	public void setStuTel(String stuTel) {
		this.stuTel = stuTel;
	}

	public String getStuAddr() {
		return stuAddr;
	}

	public void setStuAddr(String stuAddr) {
		this.stuAddr = stuAddr;
	}
	
	
	public String toString() {
		return  "Student [ID=" + getStuNo() + ", 密码=" + getStuPass() +", 姓名=" + getStuName() + ", 性别=" + getStuSex() + ", 年龄=" + getStuAge()+", 年龄=" 
	    + getStuTel()+", 地址=" + getStuAddr()+ " ]";
	}

	public Object getPwd() {
		// TODO Auto-generated method stub
		return null;
	}
}
