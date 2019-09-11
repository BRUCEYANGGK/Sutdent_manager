package myservlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mybean.Apartment;

/**
 * Servlet implementation class HandelManger
 */
@WebServlet("/HandelManger")
public class HandelManger extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HandelManger() {
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
		Apartment ap = new Apartment();
		request.setAttribute("apartment", ap);
		String backNews="";
		String apartment=request.getParameter("apartment").trim();
		String url="jdbc:mysql://localhost:3306/student_manger?serverTimezone=UTC";
		boolean boo=apartment.length()>0;
		try {
			String condition="select 围合号,围合管理员 from apartment where 围合号= '"+apartment+"'";
			conn=DriverManager.getConnection(url, "root", "y5g6k9bruce");
			sql=conn.prepareStatement(condition);
			rs=sql.executeQuery();
			if(boo) {
				if(rs.first()) {
					backNews="查询成功！";
					ap.setBackNews(backNews);
					ap.setApartment(apartment);
					String manger=rs.getString("围合管理员");
					ap.setManger(manger);
					rs.close();
					System.out.println(backNews);
				}
				else {
					backNews="没有数据！";
					ap.setBackNews(backNews);
					System.out.println(backNews);
				}
			}
			else {
				backNews="请填写围合号，数据不能为空！";
				ap.setBackNews(backNews);
				System.out.println(backNews);
			}
			sql.close();
			conn.close();
			}
		catch(Exception ee) {
			backNews="查询失败！"+ee;
			ap.setBackNews(backNews);
			System.out.println(backNews);
		}
		RequestDispatcher dispatcher=
				request.getRequestDispatcher("ShowManger.jsp");
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
