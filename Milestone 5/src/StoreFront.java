import java.util.Scanner;

/*Class with a main() method, containing an instance of the Inventory Manager class and the Shopping Cart class*/
public class StoreFront {
	
	private static Scanner scanner = null;
	
	private static InventoryManager inventoryManager = null;
	private static ShoppingCart shoppingCart = null;

	/*Driver method*/
	public static void main(String[] args) {
		
		//Set this flag to unit test.
		boolean unitTest = false;
		
		if (unitTest) {
			
			//Run unit test and check if passed.
			boolean passed = unitTest();
			
			if (passed) {
				System.out.println("All unit tests passed successfully.");
			}else {
				System.out.println("A unit test failed. Aborted further unit testing. Please review log above.");
			}
			
		//If not unit testing then run main code.
		}else {
			
			//Initialize state of store with products in inventory manager.
			initializeStore();
			
			String userInputString = "";
			int userInputInt = 0;
			
			//Display welcome message.
			System.out.println("Welcome to Lucky's Goods!");
			

			
			int choice = 0;
			

			do{
				
				choice = MainMenu();
				
				if (choice == 1) {
					
					boolean sortDescending = false;
					do {
						
						//List inventory to user.
						System.out.println("\nThe following products are in inventory: ");
						inventoryManager.sort(sortDescending);
						inventoryManager.listInventory();
						System.out.println("\nType r + enter to sort inventory by reverse name & price OR press enter to continue: ");
						userInputString = scanner.nextLine();
						
						if (userInputString.toLowerCase().equals("r") == false) {
							break;
						}else {
							sortDescending = !sortDescending;
						}
						
					}while(true);
			
				
						
					
					
				}else if (choice == 2) {
					
					System.out.println("\nEnter the name of the product you would like to add to the cart: ");
					
					userInputString = scanner.nextLine();
					
					  
					SalableProduct salableProduct = inventoryManager.getSalableProductByName(userInputString);
					
					
					
					//If product found, add to cart.
					if (salableProduct != null) {
						
						//Add salable product with updated quantity to cart.
						shoppingCart.addToCart(salableProduct);
						System.out.println("Product Added to Cart");
					
						
					}else {
						
						System.out.println("Product Not Found");
					}
					
					
				}else if (choice == 3) {
					
					System.out.println("\nEnter the name of the product you would like to remove from the cart: ");
					
					userInputString = scanner.nextLine();
					
					
					  
					SalableProduct salableProduct = shoppingCart.getSalableProductByName(userInputString);
					
					
					
					//If product found, add to cart.
					if (salableProduct != null) {
						
						//Add salable product with updated quantity to cart.
						shoppingCart.removeFromCart(salableProduct);
						System.out.println("Product Removed from Cart");
					
						
					}else {
						
						System.out.println("Product Not Found");
					}
					
				}else if (choice == 4) {
					
				
					
			
					
					
					boolean sortDescending = false;
					do {
						
						//List cart contents to user.
						System.out.println("\nThe following products are in your shopping cart: ");
						shoppingCart.sort(sortDescending);
						shoppingCart.listCart();
						System.out.println("\nType r + enter to sort cart by reverse name & price OR press enter to continue: ");
						userInputString = scanner.nextLine();
						
						if (userInputString.toLowerCase().equals("r") == false) {
							break;
						}else {
							sortDescending = !sortDescending;
						}
						
					}while(true);
			
					
					
					
				}else if (choice == 5) {
				
					shoppingCart.emptyCart();
					
					
				}else if (choice == 6) {
					shoppingCart.checkout();
				}
				else {
					System.out.println("Not a valid Option");
					
				}

					
			//Loop until user enters product name that matches product in inventory.
			}while(true);
				
			
		}
			
			
		
		

	}
	
	public static int MainMenu() {
		
		System.out.println("\nMAIN MENU");
		System.out.println("1. List Available Inventory");
		System.out.println("2. Add Product from Inventory To Cart");
		System.out.println("3. Remove Product from Cart");
		System.out.println("4. List Cart");
		System.out.println("5. Clear Cart");
		System.out.println("6. Checkout");

		
		System.out.println("\nPlease enter a numeric choice: ");
		
		String value = scanner.nextLine();
		
		try {
			
			return  Integer.parseInt(value);
			
		}catch (Exception ex) {
			
		}
		
		
		return  0;
		
	}
	
	
	
	
	/*Initializes the scanner, inventoryManager, and shoppingCart.*/
	public static void initializeStore () {
		
		scanner = new Scanner(System.in);
		
		inventoryManager = new InventoryManager();			
		inventoryManager.Initialize();
		
		
		shoppingCart = new ShoppingCart();
		shoppingCart.Initialize(inventoryManager);
		
		
		
	}
	
	/*A method with the unit tests*/
	public static boolean unitTest() {
		
	    //Unit Tests for Weapon object:
		
		//Test constructor
		Weapon weapon1 = new Weapon("Weapon", "This is a description for a weapon product", 1, 0, 0, 0);
		if (weapon1.getName().equals("Weapon") && weapon1.getDescription().equals("This is a description for a weapon product") && weapon1.getWeaponDamage() == 1) {
			System.out.println("Unit Test Passed: Weapon constructor passed.");
		}else {
			System.out.println("Unit Test Failed!: Weapon constructor failed.");
			return false;
		}
		
		//Test name getter/setter methods.
		weapon1.setName("Weapon 1");
		if (weapon1.getName().equals("Weapon 1")) {
			System.out.println("Unit Test Passed: Weapon name getter/setter test passed.");
		}else {
			System.out.println("Unit Test Failed!: Weapon name getter/setter test failed.");
			return false;
		}
		
		//Test description getter/setter methods.
		weapon1.setDescription("This is a description for weapon 1");
		if (weapon1.getDescription().equals("This is a description for weapon 1")) {
			System.out.println("Unit Test Passed: Weapon description getter/setter test passed.");
		}else {
			System.out.println("Unit Test Failed!: Weapon description getter/setter test failed.");
			return false;
		}
		
		
		//Test price getter/setter methods.
		weapon1.setPrice((float) 1234.12);
		if (weapon1.getPrice() == ((float) 1234.12)) {
			System.out.println("Unit Test Passed: Weapon price getter/setter test passed.");
		}else {
			System.out.println("Unit Test Failed!: Weapon price getter/setter test failed.");
			return false;
		}
		
		
		//Test quantity getter/setter methods.
		weapon1.setQuantity(17);
		if (weapon1.getQuantity() == 17) {
			System.out.println("Unit Test Passed: Weapon price getter/setter test passed.");
		}else {
			System.out.println("Unit Test Failed!: Weapon price getter/setter test failed.");
			return false;
		}
		
		
		//Test weight getter/setter methods.
		weapon1.setWeight(100);
		if (weapon1.getWeight() == 100) {
			System.out.println("Unit Test Passed: Weapon weight getter/setter test passed.");
		}else {
			System.out.println("Unit Test Failed!: Weapon weight getter/setter test failed.");
			return false;
		}
		
		
		//Test weaponDamage getter/setter methods.
		weapon1.setWeaponDamage(9);
		if (weapon1.getWeaponDamage() == 9) {
			System.out.println("Unit Test Passed: Weapon weaponDamage getter/setter test passed.");
		}else {
			System.out.println("Unit Test Failed!: Weapon weaponDamage getter/setter test failed.");
			return false;
		}
		
		
		
		//Unit test for Armor object:
		
		//Test constructor
		Armor armor1 = new Armor("Armor", "This is a description for an armor product", 12, 0, 0, 0);
		if (armor1.getName().equals("Armor") && armor1.getDescription().equals("This is a description for an armor product") && armor1.getArmor() == 12) {
			System.out.println("Unit Test Passed: Armor constructor passed.");
		}else {
			System.out.println("Unit Test Failed!: Armor constructor failed.");
			return false;
		}
		
		//Test name getter/setter methods.
		armor1.setName("Armor 1");
		if (armor1.getName().equals("Armor 1")) {
			System.out.println("Unit Test Passed: Armor name getter/setter test passed.");
		}else {
			System.out.println("Unit Test Failed!: Armor name getter/setter test failed.");
			return false;
		}
		
		//Test description getter/setter methods.
		armor1.setDescription("This is a description for armor 1");
		if (armor1.getDescription().equals("This is a description for armor 1")) {
			System.out.println("Unit Test Passed: Armor description getter/setter test passed.");
		}else {
			System.out.println("Unit Test Failed!: Armor description getter/setter test failed.");
			return false;
		}
		
		
		//Test price getter/setter methods.
		armor1.setPrice((float) 1234.12);
		if (armor1.getPrice() == ((float) 1234.12)) {
			System.out.println("Unit Test Passed: Armor price getter/setter test passed.");
		}else {
			System.out.println("Unit Test Failed!: Armor price getter/setter test failed.");
			return false;
		}
		
		
		//Test quantity getter/setter methods.
		armor1.setQuantity(17);
		if (armor1.getQuantity() == 17) {
			System.out.println("Unit Test Passed: Armor price getter/setter test passed.");
		}else {
			System.out.println("Unit Test Failed!: Armor price getter/setter test failed.");
			return false;
		}
		
		
		//Test weight getter/setter methods.
		armor1.setWeight(100);
		if (armor1.getWeight() == 100) {
			System.out.println("Unit Test Passed: Armor weight getter/setter test passed.");
		}else {
			System.out.println("Unit Test Failed!: Armor weight getter/setter test failed.");
			return false;
		}
		
		
		//Test weaponDamage getter/setter methods.
		armor1.setArmor(9);
		if (armor1.getArmor() == 9) {
			System.out.println("Unit Test Passed: Armor armor getter/setter test passed.");
		}else {
			System.out.println("Unit Test Failed!: Armor armo getter/setter test failed.");
			return false;
		}
		
		
		
		
	    //Unit Tests for Health object:
		
		//Test constructor
		Health health1 = new Health("Health", "This is a description for a health product", 12, 0, 0 , 0);
		if (health1.getName().equals("Health") && health1.getDescription().equals("This is a description for a health product") && health1.getHealth() == 12) {
			System.out.println("Unit Test Passed: Health constructor passed.");
		}else {
			System.out.println("Unit Test Failed!: Health constructor failed.");
			return false;
		}
		
		//Test name getter/setter methods.
		health1.setName("Health 1");
		if (health1.getName().equals("Health 1")) {
			System.out.println("Unit Test Passed: Health name getter/setter test passed.");
		}else {
			System.out.println("Unit Test Failed!: Health name getter/setter test failed.");
			return false;
		}
		
		//Test description getter/setter methods.
		health1.setDescription("This is a description for health 1");
		if (health1.getDescription().equals("This is a description for health 1")) {
			System.out.println("Unit Test Passed: Health description getter/setter test passed.");
		}else {
			System.out.println("Unit Test Failed!: Health description getter/setter test failed.");
			return false;
		}
		
		
		//Test price getter/setter methods.
		health1.setPrice((float) 1234.12);
		if (health1.getPrice() == ((float) 1234.12)) {
			System.out.println("Unit Test Passed: Health price getter/setter test passed.");
		}else {
			System.out.println("Unit Test Failed!: Health price getter/setter test failed.");
			return false;
		}
		
		
		//Test quantity getter/setter methods.
		health1.setQuantity(17);
		if (health1.getQuantity() == 17) {
			System.out.println("Unit Test Passed: Health price getter/setter test passed.");
		}else {
			System.out.println("Unit Test Failed!: Health price getter/setter test failed.");
			return false;
		}
		
		
		//Test weight getter/setter methods.
		health1.setWeight(100);
		if (health1.getWeight() == 100) {
			System.out.println("Unit Test Passed: Health weight getter/setter test passed.");
		}else {
			System.out.println("Unit Test Failed!: Health weight getter/setter test failed.");
			return false;
		}
		
		
		//Test weaponDamage getter/setter methods.
		health1.setHealth(9);
		if (health1.getHealth() == 9) {
			System.out.println("Unit Test Passed: Health health getter/setter test passed.");
		}else {
			System.out.println("Unit Test Failed!: Health health getter/setter test failed.");
			return false;
		}
		
	
		
		
		
		
		return true;
		
		
	}
	
	
	

}
