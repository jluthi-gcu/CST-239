package app;
import java.util.ArrayList;
import java.util.Scanner;

/*Class that contains an array or list of Salable Products.*/
public class ShoppingCart implements ShoppingCartInterface {

	
	

	private InventoryManagerInterface inventoryManager = null;
	
	
	public void Initialize(InventoryManagerInterface inventoryManager ) {
		
		this.inventoryManager = inventoryManager;
		
	}
	

	/*Gets a salable product from the inventory that matches the passed in name. Returns null if no match found.*/
	public SalableProduct getSalableProductByName(String name) {
		
	
		for (int i = 0; i < cart.size(); i++  ){
			
			if (cart.get(i).getName().toLowerCase().equals(name.toLowerCase())) {
				
				return cart.get(i);
			}
				
			
		}
		
		return null;
		
		
	}
	
	/*Get total amount due of all items in the cart.*/
	public float getTotalAmountDue() {
		
		float totalDue = 0;
		
		for (int i = 0; i < cart.size(); i++){
			
			//Add's current salableprodut's amount to the total 
			totalDue += (cart.get(i).getPrice());		
			
		}
		
		return totalDue;
	}
	
	
	/*Adds a salable product to the cart list.*/
	public void addToCart(SalableProduct salableProduct) {
	
		cart.add(salableProduct);
		inventoryManager.removeSalableProduct(salableProduct);
		
	}
	
	/*Removes a salable product from the cart list.*/
	public void removeFromCart(SalableProduct salableProduct) {
		
		cart.remove(salableProduct);
		inventoryManager.addSalableProduct(salableProduct);
		
	}
	
	/*Lists all salable products currently in the chart list to the console.*/
	public void listCart() {
		
		for (int i = 0; i < cart.size(); i++  ){
			
			System.out.println(cart.get(i).toString());
			
		}
		
	}
	
	/*Allows the user to checkout.*/
	public boolean checkout() {
		
		// Create a Scanner object
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("The total amount due from the products in cart is: $" + getTotalAmountDue());
		
		
		String userInput = "";
		
		do{
			System.out.println("Would you like to pay? y/n: ");
			userInput = scanner.nextLine();
		}while(userInput.toLowerCase().equals("n") == false && userInput.toLowerCase().equals("y") == false);
			
		
		
		
		if (userInput.equals("y")) {
			
			System.out.println("Checkout complete!");
			return true;
			
		}else{
			System.out.println("Checkout cancelled.");
			return false;
		}

	}
	
	
	/*Empty the contents of the Shopping Cart.*/
	public void emptyCart() {
		
		int size = cart.size();
		
		for (int i = 0; i < size; i++) {
			
			this.removeFromCart(cart.get(i));
		}
		
	}
	
	
	/*Sort cart*/
	public void sort(boolean descending) {
		cart.sort(descending);
	}
	
	
	
	
	
}
