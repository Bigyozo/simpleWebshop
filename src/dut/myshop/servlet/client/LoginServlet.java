package dut.myshop.servlet.client;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dut.myshop.domain.User;
import dut.myshop.exception.LoginException;
import dut.myshop.service.UserService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
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
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		UserService service=new UserService();
		try {
			User user=service.login(username,password);
			request.getSession().setAttribute("user", user);
			String role=user.getRole();
			if("super".equals(role)) {
				response.sendRedirect(request.getContextPath()+"/admin/login/home.jsp");
				return;
			}
			else {
				response.sendRedirect(request.getContextPath()+"/client/myAccount.jsp");
				return;
			}
		} catch (LoginException e) {
			e.printStackTrace();
			request.setAttribute("error_message", e.getMessage());
			request.getRequestDispatcher("/client/login.jsp").forward(request, response);
			return;
		}
		
		
		
	}

}
