package dut.myshop.servlet.client;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import dut.myshop.domain.User;
import dut.myshop.exception.RegisterException;
import dut.myshop.exception.UserExistException;
import dut.myshop.service.UserService;
import dut.myshop.utils.ActiveCodeUtils;
import dut.myshop.web.formbean.RegisterForm;

/**
 * Servlet implementation class Register
 */
@WebServlet("/register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Register() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		RegisterForm form = new RegisterForm();
		User user = new User();
		try {
			BeanUtils.populate(form, request.getParameterMap());
			String imageCode=(String)request.getSession().getAttribute("imageCode");
			if (!form.validate(imageCode)) {
				request.getSession().setAttribute("form", form);
				request.getRequestDispatcher("/client/register.jsp").forward(request, response);
				return;
			}
			BeanUtils.populate(user, request.getParameterMap());
			user.setActiveCode(ActiveCodeUtils.createActiveCode());
		} catch (IllegalAccessException e) {

			e.printStackTrace();
		} catch (InvocationTargetException e) {

			e.printStackTrace();
		}
		UserService service = new UserService();
		try {
			service.register(user);
		} catch (RegisterException e) {
			e.printStackTrace();
			request.setAttribute("error_message", "服务器出错");
			request.getRequestDispatcher("client/register.jsp").forward(request, response);
			return;
		} catch (UserExistException e) {
			e.printStackTrace();
			form.getErrors().put("username", "注册的用户名已存在");
			request.getRequestDispatcher("client/register.jsp").forward(request, response);
			return;
		}
		response.sendRedirect(request.getContextPath() + "/client/registersuccess.jsp");
	}

}
