package dut.myshop.service;

import java.sql.SQLException;
import java.util.Map;
import dut.myshop.dao.ProductDao;
import dut.myshop.dao.ProductDaoImpl;
import dut.myshop.domain.PageBean;
import dut.myshop.domain.Product;
import dut.myshop.exception.ProductFindExceptiong;
import dut.myshop.exception.ProductNotFoundException;

public class ProductService {
	private ProductDao dao = new ProductDaoImpl();

	public Product findProductById(String id) throws ProductNotFoundException, ProductFindExceptiong {
		Product product;
		try {
			product = dao.findProductById(id);
			if (product == null)
				throw new ProductNotFoundException("找不到该商品");
			else
				return product;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ProductFindExceptiong("商品查找出错");
		}

	}



	public PageBean findProductByPage(int currentPage, String category) throws ProductFindExceptiong {
		int currentCount =5;
		int from = (currentPage - 1) * currentCount;
		int to = currentCount;
		Map<String, Product> map;
		int count =0;
		try {
			if ("全部商品".equals(category)) {
				map = dao.listAllProduct(from,to);
				count=dao.countAllProduct();
			}
			else {
				map = dao.listProductByPage(category, from, to);
				count=dao.countProductByCategory(category);
			}
			
			count=(count%currentCount==0)?count/currentCount:count/currentCount+1;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ProductFindExceptiong("商品查找出错");
		}
		PageBean bean = new PageBean(map, currentPage, category, count,null);
		return bean;
	}

	public PageBean findProductByName(int currentPage, String name) throws ProductFindExceptiong {
		int currentCount =5;
		int from = (currentPage - 1) * currentCount;
		int to = currentCount;
		Map<String, Product> map;
		int count =0;
		try {
			map=dao.listProductByName(name,from,to);
			count=dao.countProductByName(name);
		} catch (SQLException e) {			
			e.printStackTrace();
			throw new ProductFindExceptiong("商品查找出错");
		}		
		count=(count%currentCount==0)?count/currentCount:count/currentCount+1;
		PageBean bean=new PageBean(map,currentPage,null,count,name);
		return bean;
	}
}
