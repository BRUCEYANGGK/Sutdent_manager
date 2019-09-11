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
			System.out.println("加载成功！");
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
				String condition="select * from student where 学号 = '"+StuNumber+"'"+"and 姓名= '"+StuName+"'";
				sql= conn.prepareStatement(condition);
				if(boo) {
					rs=sql.executeQuery(condition);
					if(rs.next()) {
						backNews="查询成功";
						String studentNumber=rs.getString("学号");
						String studentName=rs.getString("姓名");
						String studentSex=rs.getString("性别");
						String studentID=rs.getString("身份证号");
						String studentAddress=rs.getString("家庭住址");
						String studentApartment=rs.getString("宿舍号");
						String studentAcademy=rs.getString("学院");
						String studentMajor=rs.getString("专业");
						String studentClass=rs.getString("班级");
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
