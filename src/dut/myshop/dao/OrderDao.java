package dut.myshop.dao;

import java.sql.SQLException;
import java.util.List;

import dut.myshop.domain.Order;
import dut.myshop.domain.OrderItem;

public interface OrderDao {

	void addOrder(Order ord) throws SQLException;

	void addOrderItem(OrderItem orderItem) throws SQLException;

	List<Order> getOrdersByUserID(int id) throws SQLException;

}