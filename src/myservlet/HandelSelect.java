package myservlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mybean.Login;
import mybean.StudentSelect;

/**
 * Servlet implementation class HandelSelect
 */
@WebServlet("/HandelSelect")
public class HandelSelect extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HandelSelect() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("���سɹ���");
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
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
				String condition="select * from student where ѧ�� = '"+StuNumber+"'"+"and ����= '"+StuName+"'";
				sql= conn.prepareStatement(condition);
				if(boo) {
					rs=sql.executeQuery(condition);
					if(rs.next()) {
						backNews="��ѯ�ɹ�";
						String studentNumber=rs.getString("ѧ��");
						String studentName=rs.getString("����");
						String studentSex=rs.getString("�Ա�");
						String studentID=rs.getString("���֤��");
						String studentAddress=rs.getString("��ͥסַ");
						String studentApartment=rs.getString("�����");
						String studentAcademy=rs.getString("ѧԺ");
						String studentMajor=rs.getString("רҵ");
						String studentClass=rs.getString("�༶");
						sel.setBackNews(backNews);
						sel.setStudentAcademy(studentAcademy);
						sel.setStudentAddress(studentAddress);
						sel.setStudentApartment(studentApartment);
						sel.setStudentClass(studentClass);
						sel.setStudentID(studentID);
						sel.setStudentMajor(studentMajor);
						sel.setStudentName(studentName);
						sel.setStudentNumber(studentNumber);
						sel.setStudentSex(studentSex);
						rs.close();	
						System.out.println(sel.getStudentID());
						System.out.println(sel.getBackNews());
					}
					else {
						backNews="��������û��������ڻ���ѧ�Ų�ƥ��";
						System.out.println(backNews);
						sel.setBackNews(backNews);
					}
				}
				else {
					backNews="��δ�����û�����ѧ�ţ�";
					System.out.println(backNews);
					sel.setBackNews(backNews);
				}
				//sel.setBackNews(backNews);
					
				sql.close();
				conn.close();
			}
			catch(SQLException e) {
				backNews=""+e;
				sel.setBackNews(backNews);
			}
			System.out.println(sel.getStudentAddress());
			RequestDispatcher dispatcher=
					request.getRequestDispatcher("ShowStuSelect.jsp");
					dispatcher.forward(request, response);
		}	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
