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
			String condition="select Χ�Ϻ�,Χ�Ϲ���Ա from apartment where Χ�Ϻ�= '"+apartment+"'";
			conn=DriverManager.getConnection(url, "root", "y5g6k9bruce");
			sql=conn.prepareStatement(condition);
			rs=sql.executeQuery();
			if(boo) {
				if(rs.first()) {
					backNews="��ѯ�ɹ���";
					ap.setBackNews(backNews);
					ap.setApartment(apartment);
					String manger=rs.getString("Χ�Ϲ���Ա");
					ap.setManger(manger);
					rs.close();
					System.out.println(backNews);
				}
				else {
					backNews="û�����ݣ�";
					ap.setBackNews(backNews);
					System.out.println(backNews);
				}
			}
			else {
				backNews="����дΧ�Ϻţ����ݲ���Ϊ�գ�";
				ap.setBackNews(backNews);
				System.out.println(backNews);
			}
			sql.close();
			conn.close();
			}
		catch(Exception ee) {
			backNews="��ѯʧ�ܣ�"+ee;
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
