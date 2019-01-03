package dut.myshop.service;

import java.sql.SQLException;
import java.util.List;

import dut.myshop.dao.OrderDao;
import dut.myshop.dao.OrderDaoImpl;
import dut.myshop.domain.Order;
import dut.myshop.domain.OrderItem;
import dut.myshop.exception.OrderNotCreateException;
import dut.myshop.exception.OrderNotFoundException;

public class OrderService {
	OrderDao dao = new OrderDaoImpl();

	public void addOrder(Order order) throws OrderNotCreateException {
		try {
			dao.addOrder(order);
			List<OrderItem> orderItems = order.getOrderItems();
			for (OrderItem item : orderItems) {
				dao.addOrderItem(item);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new OrderNotCreateException();
		}
	}

	public List<Order> showOrderByUserID(int id) throws OrderNotFoundException {
		try {
			List<Order>orders=dao.getOrdersByUserID(id);
			return orders;
		} catch (SQLException e) {			
			e.printStackTrace();
			throw new OrderNotFoundException();
		}
		
	}
}
