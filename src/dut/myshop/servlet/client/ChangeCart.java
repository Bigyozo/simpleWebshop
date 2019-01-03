package dut.myshop.servlet.client;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dut.myshop.domain.Product;

/**
 * Servlet implementation class ChangeCart
 */
@WebServlet("/changecart")
public class ChangeCart extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id=request.getParameter("id");
		String count=request.getParameter("count");
		int countnum=Integer.parseInt(count);
		HttpSession session=request.getSession();
		Map<Product,Integer>cart=(Map<Product, Integer>) session.getAttribute("cart");
		Set<Entry<Product, Integer>> entry=cart.entrySet();
		Iterator<Entry<Product, Integer>> it=entry.iterator();
		Product p;
		while(it.hasNext()) {
			p=it.next().getKey();
			if(id.equalsIgnoreCase(p.getId())) {
				if(countnum==0) {
					cart.remove(p);
				}
				else {
				cart.put(p, countnum);
				}
				break;
			}
		}
		request.getRequestDispatcher("/client/cart.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
