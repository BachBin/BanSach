package Bean;



public class Item {
	private int id;
	private Bookbean book;
	private long quantity;
	private long price;
	public Item() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Item(int id, Bookbean book, long quantity, long price) {
		super();
		this.id = id;
		this.book = book;
		this.quantity = quantity;
		this.price = price;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Bookbean getBook() {
		return book;
	}
	public void setBook(Bookbean book) {
		this.book = book;
	}
	public long getQuantity() {
		return quantity;
	}
	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}
	public long getPrice() {
		return price;
	}
	public void setPrice(long price) {
		this.price = price;
	}	
}
