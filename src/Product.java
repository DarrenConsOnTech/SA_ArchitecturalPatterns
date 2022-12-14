public class Product {
	
	private String name;
	private String id;
	private double price;

	public Product(String name, String id, double price) {
		this.setName(name);
		this.setId(id);
		this.setPrice(price);
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
