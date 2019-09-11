package myservlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mybean.Teacher;

/**
 * Servlet implementation class TeacherMasg
 */
@WebServlet("/TeacherMasg")
public class TeacherMasg extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeacherMasg() {
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
		String academyNumber=request.getParameter("academyNumber");
		Teacher te=new Teacher();
		List<Teacher> list =new ArrayList<Teacher>();
		request.setAttribute("academy", te);
		String backNews="";
		String url="jdbc:mysql://localhost:3306/student_manger?serverTimezone=UTC";
		String condition="select TeacherCode,TeacherName,Academyname from academy x join teacher "
				+ "y on x.AacademyCode=y.AcademyCode where x.AacademyCode='"
				+academyNumber+"'";
		try {
			conn=DriverManager.getConnection(url, "root", "y5g6k9bruce");
			sql=conn.prepareStatement(condition);
			rs=sql.executeQuery();
			if(rs.first()) {
				backNews="查询成功！";
				te.setBackNews(backNews);
				System.out.println(backNews);
				rs.close();
				rs=sql.executeQuery();
				while(rs.next()) {
					String teacherNumber=rs.getString("TeacherCode");
					String teacherName=rs.getString("TeacherName");
					String academyName=rs.getString("AcademyName");
					Teacher tt=new Teacher();
					tt.setAcademyName(academyName);
					tt.setTeacherName(teacherName);
					tt.setTeacherNumber(teacherNumber);
					list.add(tt);
				}
				rs.close();
				te.setList(list);
			}
			else {
				backNews="暂时查不到该院系的相关信息！";
				te.setBackNews(backNews);
				System.out.println(backNews);
			}
			sql.close();
			conn.close();
		}
		catch(Exception ee) {
			backNews="查询失败！"+ee;
			te.setBackNews(backNews);
			System.out.println(backNews);
		}
		RequestDispatcher dispatcher=
				request.getRequestDispatcher("Teacher.jsp");
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
