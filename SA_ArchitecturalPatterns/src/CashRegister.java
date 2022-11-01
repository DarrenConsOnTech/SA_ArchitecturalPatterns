import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class CashRegister {
	
	public ArrayList<Product> products = new ArrayList<Product>();
	public double total = 0;
	
	public CashRegister() {
        double total = 0;
	}
	
	public boolean addItem(String barcode) {
		
		boolean found = false;
		
		Scanner search = null;
		try {
			search = new Scanner(new File("src/database.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		while (search.hasNext()) {
			String DatabaseLine = search.nextLine();
			if (DatabaseLine.contains(barcode)) {
				String[] line = DatabaseLine.split(" ", 3);
				String id = line[0];
				String name = line[1];
				Double price = Double.valueOf(line[2]);
				products.add(new Product(name, id, price));
				found = true;
				addToTotal(price);
				
			}
			
		}
		return found;
	}
	
	public boolean removeItem(String barcode) {
		boolean found = false;
		
		for(int i = 0; i < products.size(); i++) {
			if(products.get(i).getId().equals(barcode)) {
				found = true;
				removeFromTotal(products.get(i).getPrice());
				products.remove(i);
				return found;
			}
		}
		return found;
	}
	
	public void addToTotal(double price) {
		this.total += price;
	}
	
	public void removeFromTotal(double price) {
		this.total -= price;
	}
	
	public double getTotal() {
		return this.total;
	}
	
	public Object getProducts() {
		return products;
	}
	
}
