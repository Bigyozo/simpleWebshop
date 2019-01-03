package dut.myshop.dao;

import java.sql.SQLException;
import java.util.Map;

import dut.myshop.domain.Product;

public interface ProductDao {

	void addProduct(Product pro) throws SQLException;

	Product findProductById(String id) throws SQLException;
	
	Map<String,Product> listAllProduct(int from, int to) throws SQLException;
	
	Map<String,Product> listProductByPage(String category,int from,int to) throws SQLException;
	
	public int countProductByCategory(String category) throws SQLException;
	
	public int countAllProduct() throws SQLException;

	Map<String, Product> listProductByName(String name, int from, int to) throws SQLException;

	int countProductByName(String name) throws SQLException;
}