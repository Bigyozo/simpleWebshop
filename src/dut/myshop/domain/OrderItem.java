package dut.myshop.domain;

public class OrderItem {
	String order_id;
	String product_id;
	int buynum;
	
	public OrderItem() {
		super();
	}
	public OrderItem(String order_id, String product_id, int buynum) {
		super();
		this.order_id = order_id;
		this.product_id = product_id;
		this.buynum = buynum;
	}
	public String getOrder_id() {
		return order_id;
	}
	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}
	public String getProduct_id() {
		return product_id;
	}
	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}
	public int getBuynum() {
		return buynum;
	}
	public void setBuynum(int buynum) {
		this.buynum = buynum;
	}
	
}
