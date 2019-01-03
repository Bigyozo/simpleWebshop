package dut.myshop.servlet.client;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dut.myshop.dao.UserDao;
import dut.myshop.dao.UserDaoImpl;

/**
 * Servlet implementation class ActiveUser
 */
@WebServlet("/activeUser")
public class ActiveUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		UserDao dao=new UserDaoImpl();
		String activeCode=request.getParameter("activeCode");
		try {
			dao.activeUser(activeCode);
			request.setAttribute("error_message", "激活成功");
			request.getRequestDispatcher("/client/login.jsp").forward(request, response);
		} catch (SQLException e) {
			request.setAttribute("error_message", "激活失败");
			request.getRequestDispatcher("/client/login.jsp").forward(request, response);
			e.printStackTrace();
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
