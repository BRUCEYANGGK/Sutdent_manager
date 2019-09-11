package mybean;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShowStuSelect {
	private String studentNumber;
	private String studentName;
	private String studentSex;
	private String studentID;
	private String studentAddress;
	private String studentApartment;
	private String studentAcademy;
	private String studentMajor;
	private String studentClass;
	private String backNews;
	public void ShowStuSelect() {
		
	}
	public void Read(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		Connection conn;
		PreparedStatement sql;
		ResultSet rs;
		String backNews="";
		StudentSelect sel=new StudentSelect();
		request.setAttribute("selectstu", sel);
		String StuNumber=request.getParameter("StuNumber").trim(),
				StuName=request.getParameter("StuName").trim();
			String url="jdbc:mysql://localhost:3306/student_manger?serverTimezone=UTC";
			boolean boo=StuNumber.length()>0&&StuName.length()>0;
			try {
				conn=DriverManager.getConnection(url, "root", "y5g6k9bruce");
				String condition="select * from student where 学号 = '"+StuNumber+"'"+"and 姓名= '"+StuName+"'";
				sql= conn.prepareStatement(condition);
				if(boo) {
					rs=sql.executeQuery(condition);
					if(rs.next()) {
						backNews="登陆成功";
						studentNumber=rs.getString("学号");
						studentName=rs.getString("姓名");
						studentSex=rs.getString("性别");
						studentID=rs.getString("身份证号");
						studentAddress=rs.getString("家庭住址");
						studentApartment=rs.getString("宿舍号");
						studentAcademy=rs.getString("学院");
						studentMajor=rs.getString("专业");
						studentClass=rs.getString("班级");
						rs.close();	
						System.out.println(studentName);
					}
					else {
						backNews="您输入的用户名不存在或者学号不匹配";
						System.out.println(backNews);
						sel.setBackNews(backNews);
					}
				}
				else {
					backNews="您未输入用户名或学号！";
					System.out.println(backNews);
					sel.setBackNews(backNews);
				}
					
				sql.close();
				conn.close();
			}
			catch(SQLException e) {
				backNews=""+e;
				sel.setBackNews(backNews);
			}
	}
	public String getStudentNumber() {
		return studentNumber;
	}
	public void setStudentNumber(String studentNumber) {
		this.studentNumber = studentNumber;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getStudentSex() {
		return studentSex;
	}
	public void setStudentSex(String studentSex) {
		this.studentSex = studentSex;
	}
	public String getStudentID() {
		return studentID;
	}
	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}
	public String getStudentAddress() {
		return studentAddress;
	}
	public void setStudentAddress(String studentAddress) {
		this.studentAddress = studentAddress;
	}
	public String getStudentApartment() {
		return studentApartment;
	}
	public void setStudentApartment(String studentApartment) {
		this.studentApartment = studentApartment;
	}
	public String getStudentAcademy() {
		return studentAcademy;
	}
	public void setStudentAcademy(String studentAcademy) {
		this.studentAcademy = studentAcademy;
	}
	public String getStudentMajor() {
		return studentMajor;
	}
	public void setStudentMajor(String studentMajor) {
		this.studentMajor = studentMajor;
	}
	public String getStudentClass() {
		return studentClass;
	}
	public void setStudentClass(String studentClass) {
		this.studentClass = studentClass;
	}
	public String getBackNews() {
		return backNews;
	}
	public void setBackNews(String backNews) {
		this.backNews = backNews;
	}
	
}
