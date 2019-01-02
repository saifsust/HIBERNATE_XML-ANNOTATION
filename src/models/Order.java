package models;

public class Order {

	private int order_id;
	private int customer_id;
	private int product_id;
	public Order() {
		super();
	}
	public Order(int customer_id, int product_id) {
		super();
		this.customer_id = customer_id;
		this.product_id = product_id;
	}
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public int getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	@Override
	public String toString() {
		return "Order [order_id=" + order_id + ", customer_id=" + customer_id + ", product_id=" + product_id + "]";
	}
	
	
}
