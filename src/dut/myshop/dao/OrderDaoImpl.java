package dut.myshop.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import dut.myshop.domain.Order;
import dut.myshop.domain.OrderItem;
import dut.myshop.utils.DataSourceUtils;

public class OrderDaoImpl implements OrderDao {
	@Override
	public void addOrder(Order ord) throws SQLException {
		String sql="insert into orders(id,money,receiverAddress,receiverName,receiverPhone,user_id) values(?,?,?,?,?,?)";
		QueryRunner runner=new QueryRunner();
		Connection conn=DataSourceUtils.getConnection();
		int row=runner.execute(conn, sql, ord.getId(),ord.getMoney(),ord.getReceiverAddress(),ord.getReceiverName()
				,ord.getReceiverPhone(),ord.getUser_id());
		if(row==0) {
			throw new RuntimeException();
		}
	}
	@Override
	public void addOrderItem(OrderItem orderItem) throws SQLException {
		String sql="insert into orderitem(order_id,product_id,buynum) values(?,?,?)";
		QueryRunner runner=new QueryRunner();
		Connection conn=DataSourceUtils.getConnection();
		int row=runner.execute(conn, sql, orderItem.getOrder_id(),orderItem.getProduct_id(),orderItem.getBuynum());
		if(row==0) {
			throw new RuntimeException();
		}
	}
	@Override
	public List<Order> getOrdersByUserID(int id) throws SQLException {
		String sql="select * from orders where user_id = ?";
		QueryRunner runner=new QueryRunner();
		Connection conn=DataSourceUtils.getConnection();
		List<Order> list=runner.query(conn, sql, new BeanListHandler<Order>(Order.class), id);
		return list;
	}
	
}
