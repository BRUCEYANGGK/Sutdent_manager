package mybean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ShowStudent {
	private String url;
	private ResultSet rs;
	private PreparedStatement sql;
	private Connection conn;
	private List<StudentMessage> list =new ArrayList<StudentMessage>();
	
	public void ShowStudent() {
		this.rs=null;
		this.sql=null;
		this.conn=null;
		this.url=null;
	}
	public List read() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("加载成功！");
		}
		catch(Exception e){
			e.printStackTrace();
		}
		url="jdbc:mysql://localhost:3306/student_manger?serverTimezone=UTC";
		try {
			conn=DriverManager.getConnection(url, "root", "y5g6k9bruce");
			String condition="select * from student_check";
			sql= conn.prepareStatement(condition);
			rs=sql.executeQuery();
			if(rs!=null) {
				while(rs.next()) {
					String StudentNumber=rs.getString("学号");
					String StudentName=rs.getString("姓名");
					String StudentSex=rs.getString("性别");
					String StudentID=rs.getString("身份证号");
					String StudentAddress=rs.getString("家庭住址");
					String StudentApartment=rs.getString("宿舍号");
					String StudentAcademy=rs.getString("学院");
					String StudentMajor=rs.getString("专业");
					String StudentClass=rs.getString("班级");
					StudentMessage txl = new StudentMessage(StudentNumber,StudentName,StudentSex,StudentID,
							StudentAddress,StudentApartment,StudentAcademy,StudentMajor,StudentClass);
					list.add(txl);
					System.out.println("可查看");
				}
			}
			sql.close();
			conn.close();
		}
		catch(Exception ee) {
			ee.printStackTrace();
		}
		return list;
	}
}

