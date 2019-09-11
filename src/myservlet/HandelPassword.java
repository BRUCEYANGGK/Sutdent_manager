package myservlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mybean.Login;
import mybean.PasswordUp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
/**
 * Servlet implementation class HandelPassword
 */
@WebServlet("/HandelPassword")
public class HandelPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HandelPassword() {
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
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		HttpSession session=request.getSession(true);
		Login login=(Login)session.getAttribute("login");
		boolean ok=true;
		if(login==null) {
			ok=false;
			response.sendRedirect("index.jsp");
			return ;
		}
		if(ok=true) {
			System.out.println("修改也！");
			continueWork(request,response);
		}
	}

	public void continueWork(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		HttpSession session=request.getSession(true);
		Login login=(Login)session.getAttribute("login");
		Connection conn=null;
		PreparedStatement sql;
		ResultSet rs;
		String Stunumber=login.getStuNumber();
		PasswordUp passwordBean=new PasswordUp();
		request.setAttribute("password", passwordBean);
		String oldpassword=request.getParameter("oldpassword").trim();
		String newpassword=request.getParameter("newpassword").trim();
		String url="jdbc:mysql://localhost:3306/student_manger?serverTimezone=UTC";
		System.out.println(Stunumber);
		try {
			conn=DriverManager.getConnection(url, "root", "y5g6k9bruce");
			String condition="select * from register where 学号 = '"+Stunumber+"'"+"and 密码= '"+oldpassword+"'";
			sql= conn.prepareStatement( condition);
			rs=sql.executeQuery();
			if(rs.next()) {
				String updataString="update register set 密码='"+newpassword+"' where 密码='"+oldpassword+"' and 学号='"+Stunumber+"'";
				int m=sql.executeUpdate(updataString);
				if(m==1) {
					passwordBean.setBackNews("密码更新成功！");
					passwordBean.setNewpassword(newpassword);
					passwordBean.setOldpassword(oldpassword);
					System.out.println("成功！");
				}
				else {
					passwordBean.setBackNews("密码更新失败！");
					System.out.println("不止一个失败！");
					RequestDispatcher dispatcher=
							request.getRequestDispatcher("UpdataPassword.jsp");
							dispatcher.forward(request, response);
							return ;
				}
				rs.close();
			}
			else {
				passwordBean.setBackNews("密码更新失败！");
				System.out.println("查不到失败！");
				RequestDispatcher dispatcher=
						request.getRequestDispatcher("UpdataPassword.jsp");
						dispatcher.forward(request, response);
						return ;
			}
			sql.close();
			conn.close();
		}
		catch(Exception e){
			passwordBean.setBackNews("密码更新失败！"+e);
			e.printStackTrace();
			RequestDispatcher dispatcher=
					request.getRequestDispatcher("UpdataPassword.jsp");
					dispatcher.forward(request, response);
					return ;
		}
		
	}

}
