package prob8;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
public class Main {
	List<OrderItem> orderItems = new ArrayList<>();
	public static void main(String[] args) {
		Main m = new Main();
		m.loadOrderItemData();
		System.out.println("Do any of these Order Items have an order of flowers? " + 
		   m.findProduct("Flowers"));
	}
	
	private boolean findProduct(String prodName) {
		for(OrderItem i : orderItems) {
			if(Optional.ofNullable(i).map((OrderItem x) -> x.getProduct())
				   .map((Product x) -> x.getProductName())
				   .orElse("").equals(prodName))  {					
				return true;
			}
		}
		return false;
}
	
	private void loadOrderItemData() {
		orderItems.add(new OrderItem(new Product("1016", "Tools", 131.00), 3));
		orderItems.add(new OrderItem(new Product("1017", "Fishing Rod", 111.00), 1));
		orderItems.add(new OrderItem(new Product("1018", "Game of Go",66.00), 2));
		orderItems.add(new OrderItem(new Product("1019", "Flowers", 221.00), 5));
	}
}
