package dut.myshop.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanMapHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import dut.myshop.domain.Product;
import dut.myshop.utils.DataSourceUtils;


public class ProductDaoImpl implements ProductDao {
	@Override
	public void addProduct(Product pro) throws SQLException {
		String sql="insert into products(id,name,price,category,pnum,imgurl,description) values(?,?,?,?,?,?,?)";
		QueryRunner runner=new QueryRunner();
		Connection conn=DataSourceUtils.getConnection();
		int row=runner.update(conn, sql,pro.getId(),pro.getName(),pro.getPrice(),pro.getCategory(),pro.getPnum(),pro.getImgurl(),pro.getDescription());
		if(row==0) {
			throw new RuntimeException();
		}
	}
	@Override
	public Product findProductById(String id) throws SQLException {
		String sql="select * from products where id=?";
		QueryRunner runner=new QueryRunner();
		Connection conn=DataSourceUtils.getConnection();
		return runner.query(conn, sql, new BeanHandler<Product>(Product.class), id);
	}
	@Override
	public Map<String, Product> listAllProduct(int from, int to) throws SQLException {
		String sql="select * from products limit ?,?";
		QueryRunner runner=new QueryRunner();
		Connection conn=DataSourceUtils.getConnection();
		Map<String, Product>map=runner.query(conn, sql, new BeanMapHandler<String, Product> (Product.class,"id"),from,to);		
		 return map;
	}
	@Override
	public Map<String, Product> listProductByPage(String category, int from, int to) throws SQLException {
		String sql="select * from products where category=? limit ?,?";
		QueryRunner runner=new QueryRunner();
		Connection conn=DataSourceUtils.getConnection();
		Map<String, Product>map=runner.query(conn, sql, new BeanMapHandler<String, Product> (Product.class,"id"),category,from,to);	
		return map;
	}
	@Override
	public int countProductByCategory(String category) throws SQLException {
		String sql="select count(*) as count from products where category=?";
		Connection conn=DataSourceUtils.getConnection();
		QueryRunner runner=new QueryRunner();		
		long count=runner.query(conn, sql, new ScalarHandler<Long>(), category);
		int i=(int)count;
		return i;
	}
	@Override
	public int countAllProduct() throws SQLException {
		String sql="select count(*) as count from products";
		Connection conn=DataSourceUtils.getConnection();
		QueryRunner runner=new QueryRunner();		
		long count=runner.query(conn, sql, new ScalarHandler<Long>());
		int i=(int)count;
		return i;
	}
	@Override
	public Map<String, Product> listProductByName(String name, int from, int to) throws SQLException {
		String sql="select * from products where name like ? limit ?,?";
		QueryRunner runner=new QueryRunner();
		Connection conn=DataSourceUtils.getConnection();
		Map<String, Product>map=runner.query(conn, sql, new BeanMapHandler<String, Product> (Product.class,"id"),"%"+name+"%",from,to);	
		return map;		
	}
	@Override
	public int countProductByName(String name) throws SQLException {
		String sql="select count(*) as count from products where name like ?";
		Connection conn=DataSourceUtils.getConnection();
		QueryRunner runner=new QueryRunner();		
		long count=runner.query(conn, sql, new ScalarHandler<Long>(), "%"+name+"%");
		int i=(int)count;
		return i;
	}
	
	
	
}
