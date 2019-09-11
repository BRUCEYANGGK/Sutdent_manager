package myservlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mybean.ClassMates;

/**
 * Servlet implementation class HandelClassMates
 */
@WebServlet("/HandelClassMates")
public class HandelClassMates extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HandelClassMates() {
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
		String classNumber=request.getParameter("classNumber").trim();
		String backNews="";
		List<ClassMates> list = new ArrayList<ClassMates>();
		ClassMates mat=new ClassMates();
		request.setAttribute("classmates", mat);
		mat.setClassNumber(classNumber);
		boolean boo=classNumber.length()>0;
		String condition="select 学号,姓名 from class x join student y on x.classcode=y.班级 where x.classcode = '"+classNumber+"'";
		try {
			String url="jdbc:mysql://localhost:3306/student_manger?serverTimezone=UTC";
			conn=DriverManager.getConnection(url, "root", "y5g6k9bruce");
			sql=conn.prepareStatement(condition);
			rs=sql.executeQuery();
			if(boo) {
				if(rs.first()) {
					backNews="查到数据！";
					mat.setBackNews(backNews);
					rs.close();
					rs=sql.executeQuery();
					System.out.println(backNews);
					while(rs.next()) {
						String studentNumber=rs.getString("学号");
						String studentName=rs.getString("姓名");
						ClassMates mt = new ClassMates();
						mt.setStudentNumber(studentNumber);
						mt.setStudentName(studentName);
						list.add(mt);
					}
					rs.close();
					mat.setList(list);
				}
				else {
					backNews="该班级目前还没有学生报道!";
					mat.setBackNews(backNews);
					System.out.println(backNews);
				}
			}
			else {
				backNews="数据不能为空！";
				mat.setBackNews(backNews);
			}
			sql.close();
			conn.close();
			
		}
		catch(SQLException ee) {
			backNews="数据查询失败"+ee;
			mat.setBackNews(backNews);
			System.out.println(backNews);
		}
		RequestDispatcher dispatcher=
				request.getRequestDispatcher("ShowMates.jsp");
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
