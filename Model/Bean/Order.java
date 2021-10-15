package Bean;


import java.util.List;

public class Order {
	private int id;
	private Customerbean customer;
	private List<Item> items;
	private int status;
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Order(int id, Customerbean customer, List<Item> items, int status) {
		super();
		this.id = id;
		this.customer = customer;
		this.items = items;
		this.status = status;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Customerbean getCustomer() {
		return customer;
	}
	public void setCustomer(Customerbean customer) {
		this.customer = customer;
	}
	public List<Item> getItems() {
		return items;
	}
	public void setItems(List<Item> items) {
		this.items = items;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
}
