package myservlet;

import java.beans.Statement;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mybean.Login;
import mybean.Register;

/**
 * Servlet implementation class HandelLogin
 */
@WebServlet("/HandelLogin")
public class HandelLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HandelLogin() {
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
		Login loginBean=null;
		String backNews="";
		HttpSession session =request.getSession();
		try {
			loginBean=(Login)session.getAttribute("login");
			if(loginBean==null) {
				loginBean=new Login();
				session.setAttribute("login", loginBean);
				}
			}
			catch(Exception ee){
				loginBean=new Login();
				session.setAttribute("login", loginBean);
			}
		String StuNumber=request.getParameter("usernumber").trim(),
				StuName=request.getParameter("username").trim(),
				password=request.getParameter("password").trim();
		boolean ok=loginBean.isSuccess();
		if(ok==true&&StuNumber.equals(loginBean.getStuNumber())) {
			backNews=StuName+"已经登陆";
			loginBean.setBackNews(backNews);
		}
		else
		{
			String url="jdbc:mysql://localhost:3306/student_manger?serverTimezone=UTC";
			boolean boo=StuNumber.length()>0&&StuName.length()>0&&password.length()>0;
			try {
				conn=DriverManager.getConnection(url, "root", "y5g6k9bruce");
				String condition="select * from register where 学号 = '"+StuNumber+"'"+"and 密码= '"+password+"'";
				sql= conn.prepareStatement( condition);
				
				if(boo) {
					rs=sql.executeQuery(condition);
					boolean m=rs.next();
					if(m==true) {
						backNews="登陆成功";
						loginBean.setBackNews(backNews);
						loginBean.setSuccess(true);
						loginBean.setStuName(StuName);
						loginBean.setStuNumber(StuNumber);
						rs.close();	
					}
					else {
						backNews="您输入的用户名不存在或者密码不匹配";
						loginBean.setBackNews(backNews);
						loginBean.setSuccess(false);
						loginBean.setPassword(password);
						loginBean.setStuName(StuName);
						RequestDispatcher dispatcher=
								request.getRequestDispatcher("LoginWrong.jsp");
								dispatcher.forward(request, response);
								return ;
					}
				}
				else {
					backNews="您输入的用户名不存在或者密码不匹配";
					loginBean.setBackNews(backNews);
					loginBean.setSuccess(false);
					loginBean.setPassword(password);
					loginBean.setStuName(StuName);
					RequestDispatcher dispatcher=
							request.getRequestDispatcher("LoginWrong.jsp");
							dispatcher.forward(request, response);
							return ;
				}
					
				sql.close();
				conn.close();
			}
			catch(SQLException e) {
				backNews=""+e;
				loginBean.setBackNews(backNews);
				loginBean.setSuccess(false);
			}
			RequestDispatcher dispatcher=
			request.getRequestDispatcher("show.jsp");
			dispatcher.forward(request, response);
		}	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
