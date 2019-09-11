package myservlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import mybean.CheckMessage;
import mybean.GetStudent;
import mybean.StudentMessage;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.OutputBuffer;

/**
 * Servlet implementation class StudentCheck
 */
@WebServlet("/StudentCheck")
public class StudentCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentCheck() {
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
		ResultSet rs;
		CheckMessage back=new CheckMessage();
		request.setAttribute("stata", back);
		String falg;
		falg=request.getParameter("stu").trim();
		boolean m=false;
		m=falg.equals("china");
		String backNews="";
		try {
			String url="jdbc:mysql://localhost:3306/student_manger?serverTimezone=UTC";
			conn=DriverManager.getConnection(url, "root", "y5g6k9bruce");
			String insertCondition="INSERT INTO student select * from student_check";
			String search="select * from student_check";
			String delectdb="delete from student_check";
			Statement st =conn.createStatement();
			if(m) {
				rs=st.executeQuery(search);
				if(rs.next()) {
					backNews="审核数据库不为空！";
					back.setBackNews(backNews);
					System.out.println(backNews);
					rs.close();
					int b=st.executeUpdate(insertCondition);
					if(b!=0) {
						backNews="审核成功！";
						back.setBackNews(backNews);
						st.executeUpdate(delectdb);
						System.out.println(backNews);
					}
					else
					{
						backNews="审核失败！";
						back.setBackNews(backNews);
						System.out.println(backNews);
					}
				}
				else {
					backNews="审核表为空！";
					back.setBackNews(backNews);
					System.out.println(backNews);
				}
			}
			else {
				backNews="审核表为空,不需要审核！！！";
				back.setBackNews(backNews);
				System.out.println(backNews);
			}
			st.close();
			conn.close();
		}
		catch(Exception ee) {
			backNews="数据库连接失败！！！"+ee;
			back.setBackNews(backNews);
			System.out.println(backNews);
		}
		RequestDispatcher dispatcher=
				request.getRequestDispatcher("ShowCheck.jsp");
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
	