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

import mybean.Register;

/**
 * Servlet implementation class UserHandel
 */
@WebServlet("/UserHandel")
public class UserHandel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserHandel() {
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
		Register reg= new Register();
		request.setAttribute("register", reg);
		String StuNumber=request.getParameter("usernumber").trim(),
				StuName=request.getParameter("username").trim(),
				password=request.getParameter("password").trim();
		if(StuNumber==null)
			StuNumber="";
		if(StuName==null)
			StuName="";
		boolean boo=StuNumber.length()>0&&StuName.length()>0&&password.length()>0;
		String backNews="";
		try {
			String url="jdbc:mysql://localhost:3306/student_manger?serverTimezone=UTC";
			conn=DriverManager.getConnection(url, "root", "y5g6k9bruce");
			String insertCondition="INSERT INTO register VALUES (?,?,?)";
			sql=conn.prepareStatement(insertCondition);
			if(boo) {
				sql.setString(1,StuNumber );
				sql.setString(2, StuName);
				sql.setString(3, password);
				int m=sql.executeUpdate();
				if(m!=0)
				{
					backNews="注册成功！";
					System.out.println("注册成功！");
					reg.setBackNews(backNews);
					reg.setStuNumber(StuNumber);
					reg.setStuName(StuName);
					reg.setPassword(password);;
				}
			}
			else {
				backNews="信息填写不完整或者名字中有非法字符！";
				System.out.println("信息填写不完整或者名字中有非法字符！");
				reg.setBackNews(backNews);
				RequestDispatcher dispatcher=
						request.getRequestDispatcher("Wrong.jsp");
						dispatcher.forward(request, response);
				return ;
			}
			sql.close();
			conn.close();
		}
		catch(SQLException e) {
			backNews="名字已被使用请更换名字"+e;
			System.out.println("名字已被使用请更换名字");
			reg.setBackNews(backNews);
			RequestDispatcher dispatcher=
					request.getRequestDispatcher("Wrong.jsp");
					dispatcher.forward(request, response);
			return ;
		}
		RequestDispatcher dispatcher=
		request.getRequestDispatcher("showUser.jsp");
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
