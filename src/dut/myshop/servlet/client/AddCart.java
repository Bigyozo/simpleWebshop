package dut.myshop.servlet.client;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dut.myshop.domain.Product;
import dut.myshop.exception.ProductFindExceptiong;
import dut.myshop.exception.ProductNotFoundException;
import dut.myshop.service.ProductService;

/**
 * Servlet implementation class AddCart
 */
@WebServlet("/AddCart")
public class AddCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id =request.getParameter("id");
		String category=request.getParameter("category");
		String searchName=request.getParameter("search");
		ProductService service=new ProductService();
		try {
			Product p=service.findProductById(id);
			HttpSession session=request.getSession();
			@SuppressWarnings("unchecked")
			Map<Product,Integer>cart=(Map<Product, Integer>) session.getAttribute("cart");
			if(cart==null) {
			cart=new HashMap<Product,Integer>();						
			}
			Integer count=cart.put(p, 1);
			if(count!=null) {
				cart.put(p, count+1);
			}
			if(category!=null) {
			session.setAttribute("category", category);
			session.removeAttribute("search");
			}
			else if(searchName!=null) {
			session.setAttribute("search", searchName);
			session.removeAttribute("category");
			}
			session.setAttribute("cart", cart);			
			request.getRequestDispatcher("/client/cart.jsp").forward(request, response);
		} catch (ProductNotFoundException | ProductFindExceptiong e) {
			
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
