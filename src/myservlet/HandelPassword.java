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
			System.out.println("�޸�Ҳ��");
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
			String condition="select * from register where ѧ�� = '"+Stunumber+"'"+"and ����= '"+oldpassword+"'";
			sql= conn.prepareStatement( condition);
			rs=sql.executeQuery();
			if(rs.next()) {
				String updataString="update register set ����='"+newpassword+"' where ����='"+oldpassword+"' and ѧ��='"+Stunumber+"'";
				int m=sql.executeUpdate(updataString);
				if(m==1) {
					passwordBean.setBackNews("������³ɹ���");
					passwordBean.setNewpassword(newpassword);
					passwordBean.setOldpassword(oldpassword);
					System.out.println("�ɹ���");
				}
				else {
					passwordBean.setBackNews("�������ʧ�ܣ�");
					System.out.println("��ֹһ��ʧ�ܣ�");
					RequestDispatcher dispatcher=
							request.getRequestDispatcher("UpdataPassword.jsp");
							dispatcher.forward(request, response);
							return ;
				}
				rs.close();
			}
			else {
				passwordBean.setBackNews("�������ʧ�ܣ�");
				System.out.println("�鲻��ʧ�ܣ�");
				RequestDispatcher dispatcher=
						request.getRequestDispatcher("UpdataPassword.jsp");
						dispatcher.forward(request, response);
						return ;
			}
			sql.close();
			conn.close();
		}
		catch(Exception e){
			passwordBean.setBackNews("�������ʧ�ܣ�"+e);
			e.printStackTrace();
			RequestDispatcher dispatcher=
					request.getRequestDispatcher("UpdataPassword.jsp");
					dispatcher.forward(request, response);
					return ;
		}
		
	}

}
