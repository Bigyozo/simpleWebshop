package dut.myshop.servlet.client;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dut.myshop.domain.PageBean;
import dut.myshop.exception.ProductFindExceptiong;
import dut.myshop.service.ProductService;

/**
 * Servlet implementation class MenuSearch
 */
@WebServlet("/menuSearch")
public class MenuSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String searchName=request.getParameter("search");
		if("请输入商品名".equals(searchName)) {
			request.getRequestDispatcher("/showProductByPage").forward(request, response);
			return;
		}
		int currentPage=1;
		String _currentPage=request.getParameter("currentPage");
		if(_currentPage!=null) {
			currentPage=Integer.parseInt(_currentPage);
		}
		ProductService service=new ProductService();
		PageBean bean;
		try {
			bean = service.findProductByName(currentPage, searchName);
		} catch (ProductFindExceptiong e) {			
			e.printStackTrace();
			return;
		}
		request.setAttribute("bean", bean);
		request.getRequestDispatcher("/client/productListBySearch.jsp").forward(request, response);;		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
