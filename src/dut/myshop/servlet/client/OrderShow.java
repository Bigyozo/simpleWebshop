package dut.myshop.servlet.client;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dut.myshop.domain.Order;
import dut.myshop.domain.User;
import dut.myshop.exception.OrderNotFoundException;
import dut.myshop.service.OrderService;

/**
 * Servlet implementation class OrderShow
 */
@WebServlet("/orderShow")
public class OrderShow extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderShow() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		User user=(User) request.getSession().getAttribute("user");
		OrderService service=new OrderService();
		try {
			List<Order> orders=service.showOrderByUserID(user.getId());
			request.setAttribute("orders", orders);
		} catch (OrderNotFoundException e) {		
			e.printStackTrace();
			return;
		}
		request.getRequestDispatcher("/client/myAccount.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
