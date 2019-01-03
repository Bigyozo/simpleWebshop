package dut.myshop.servlet.client;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import dut.myshop.domain.Order;
import dut.myshop.domain.OrderItem;
import dut.myshop.domain.Product;
import dut.myshop.domain.User;
import dut.myshop.exception.OrderNotCreateException;
import dut.myshop.service.OrderService;

/**
 * Servlet implementation class CreateOrder
 */
@WebServlet("/createOrder")
public class CreateOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;

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
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		Map<Product, Integer> cart = (Map<Product, Integer>) session.getAttribute("cart");
		Order order = new Order();
		try {
			BeanUtils.populate(order, request.getParameterMap());
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
		order.setId(UUID.randomUUID().toString());
		order.setUser_id(user.getId());		
		List<OrderItem> orderItems = new ArrayList<OrderItem>();
		Set<Entry<Product, Integer>> entrySet = cart.entrySet();
		for (Entry<Product, Integer> e : entrySet) {
			OrderItem item = new OrderItem(order.getId(), e.getKey().getId(), e.getValue());
			orderItems.add(item);
		}
		order.setOrderItems(orderItems);
		OrderService service = new OrderService();
		try {
			service.addOrder(order);
		} catch (OrderNotCreateException e1) {
			e1.printStackTrace();
			request.setAttribute("message", "¶©µ¥´´½¨Ê§°Ü");
			request.getRequestDispatcher("/client/message.jsp").forward(request, response);
			return;
		}

		response.sendRedirect(request.getContextPath() + "/client/createOrderSuccess.jsp");
	}

}
