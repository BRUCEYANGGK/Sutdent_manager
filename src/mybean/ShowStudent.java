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
			System.out.println("���سɹ���");
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
					String StudentNumber=rs.getString("ѧ��");
					String StudentName=rs.getString("����");
					String StudentSex=rs.getString("�Ա�");
					String StudentID=rs.getString("���֤��");
					String StudentAddress=rs.getString("��ͥסַ");
					String StudentApartment=rs.getString("�����");
					String StudentAcademy=rs.getString("ѧԺ");
					String StudentMajor=rs.getString("רҵ");
					String StudentClass=rs.getString("�༶");
					StudentMessage txl = new StudentMessage(StudentNumber,StudentName,StudentSex,StudentID,
							StudentAddress,StudentApartment,StudentAcademy,StudentMajor,StudentClass);
					list.add(txl);
					System.out.println("�ɲ鿴");
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

