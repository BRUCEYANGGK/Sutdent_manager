package myservlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mybean.InsertStudent;

/**
 * Servlet implementation class InsertMessage
 */
@WebServlet("/InsertMessage")
public class InsertMessage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertMessage() {
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
		response.setCharacterEncoding("UTF-8");
		Connection conn;
		PreparedStatement sql;
		InsertStudent su= new InsertStudent();
		request.setAttribute("InsertMess", su);
		String studentNumber=request.getParameter("studentNumber"),
				studentName=request.getParameter("studentName"),
				studentSex=request.getParameter("studentSex"),
				studentID=request.getParameter("studentID"),
				studentAddress=request.getParameter("studentAddress"),
				studentApartment=request.getParameter("studentApartment"),
				studentAcademy=request.getParameter("studentAcademy"),
				studentMajor=request.getParameter("studentMajor"),
				studentClass=request.getParameter("studentClass");
		boolean boo=false;
		String backNews="";
		boo=studentNumber.length()>0&&studentName.length()>0&&studentSex.length()>0&&studentID.length()>0;
		try {
			String url="jdbc:mysql://localhost:3306/student_manger?serverTimezone=UTC";
			conn=DriverManager.getConnection(url, "root", "y5g6k9bruce");
			String insertCondition="INSERT INTO student_check VALUES (?,?,?,?,?,?,?,?,?)";
			sql=conn.prepareStatement(insertCondition);
			if(boo) {
				sql.setString(1, studentNumber);
				sql.setString(2, studentName);
				sql.setString(3, studentSex);
				sql.setString(4, studentID);
				sql.setString(5, studentAddress);
				sql.setString(6, studentApartment);
				sql.setString(7, studentAcademy);
				sql.setString(8, studentMajor);
				sql.setString(9, studentClass);
				int m=sql.executeUpdate();
				if(m!=0) {
					backNews="信息已经存储，等待老师审核！";
					su.setBackNews(backNews);
					su.setStudentAcademy(studentAcademy);
					su.setStudentAddress(studentAddress);
					su.setStudentApartment(studentApartment);
					su.setStudentClass(studentClass);
					su.setStudentID(studentID);
					su.setStudentMajor(studentMajor);
					su.setStudentName(studentName);
					su.setStudentNumber(studentNumber);
					su.setStudentSex(studentSex);
					
				}
				else {
					backNews="信息保存失败！原因可能是之前填写过，请勿重复填写！后台联系管理员";
					su.setBackNews(backNews);
				}
			}
			else {
				backNews="请至少填写带'*'的选项，为了保证审核通过建议全填！";
				su.setBackNews(backNews);
			}
			sql.close();
			conn.close();
			
		}
		catch(SQLException ee) {
			backNews="数据库连接失败！请联系管理员"+ee;
			su.setBackNews(backNews);
			
		}
		RequestDispatcher dispatcher=
				request.getRequestDispatcher("ShowInsert.jsp");
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
