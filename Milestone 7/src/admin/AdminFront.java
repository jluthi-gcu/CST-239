package admin;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

import app.Armor;
import app.Health;
import app.InventoryList;
import app.SalableProduct;
import app.Weapon;

public class AdminFront {
	
	private static Scanner scanner = null;

	private static AdminService adminService = null;
	
	
	public static void main(String[] args) {
		
		adminService = new AdminService();
		
		scanner = new Scanner(System.in);
		
	
		
	
		//Display welcome message.
		System.out.println("Welcome to the Admin Front.");
	
		
		int choice = 0;

		do{
			
			choice = mainMenu();
			
			if (choice == 1) {
				
			 
			   System.out.println("\nThe following products are in inventory: ");
			   
			   //Call service to use client to get inventory from server.
			   InventoryList<SalableProduct> inventory = adminService.getInventory();
			   inventory.sort(false);
			   
			   //List inventory to user.
			   for (int i = 0; i < inventory.size(); i++  ){
					
					System.out.println(inventory.get(i).toString());
					
				}
			   
	
			}else if (choice == 2) {
				
				
			
				
				do {
					choice = inventoryTypeMenu();
					
					if (choice == 1)
					{
						
						//Used for randomizing weapon data.
						Random rand = new Random();
						
						Weapon weapon = new Weapon();
					    weapon.setName("Weapon Product " + rand.nextInt(10000) + 1);
					    weapon.setDescription("New weapon product added from Admin Front");
						weapon.setPrice(rand.nextFloat(1000) + 1);
						weapon.setWeight(rand.nextFloat(100) + 1);
						weapon.setQuantity(rand.nextInt(100) + 1);
						weapon.setWeaponDamage(rand.nextInt(20) + 1);
					
						//Add weapon via service call.
						String response = adminService.addWeaponProduct(weapon);
						
						if (response != "")
							System.out.println(response);
						
						break;
						
					}else if (choice == 2) {
						
						//Used for randomizing armor data.
						Random rand = new Random();
						
						Armor armor = new Armor();
						armor.setName("Armor Product " + rand.nextInt(10000) + 1);
						armor.setDescription("New armor product added from Admin Front");
						armor.setPrice(rand.nextFloat(1000) + 1);
						armor.setWeight(rand.nextFloat(100) + 1);
						armor.setQuantity(rand.nextInt(100) + 1);
						armor.setArmor(rand.nextInt(20) + 1);
					
						//Add armor via service call.
						String response = adminService.addArmorProduct(armor);
						
						if (response != "")
							System.out.println(response);
						
						break;
						
					}else if (choice == 3) {
						
						//Used for randomizing health data.
						Random rand = new Random();
						
						Health health = new Health();
						health.setName("Health Product " + rand.nextInt(10000) + 1);
						health.setDescription("New health product added from Admin Front");
						health.setPrice(rand.nextFloat(1000) + 1);
						health.setWeight(rand.nextFloat(100) + 1);
						health.setQuantity(rand.nextInt(100) + 1);
						health.setHealth(rand.nextInt(1000) + 1);
					
						//Add health via service call.
						String response = adminService.addHealthProduct(health);
						
						if (response != "")
							System.out.println(response);
						
						
						break;
						
					}else if (choice == 4) {
						//Go back to main menu
						break;
					}
					else {
						
						System.out.println("Not a valid product type.");
					}
				}while (true);
				
			}else if (choice == 3) {
				
				System.out.println("Program Closed.");
				break;
				
			}
			else {
				System.out.println("Not a valid option.");
				
			}

				
		
		}while(true);
			

	}
	
	
	
	public static int mainMenu() {
		
		System.out.println("\nMAIN MENU");
		System.out.println("1. List Inventory");
		System.out.println("2. Add Product to Inventory");
		System.out.println("3. QUIT");

		
		System.out.println("\nPlease enter a choice: ");
		
		String value = scanner.nextLine();
		
		try {
			
			return  Integer.parseInt(value);
			
		}catch (Exception ex) {
			
		}
		
		
		return  0;
		
	}
	
	

	public static int inventoryTypeMenu() {
		
		System.out.println("\nInventory Types");
		System.out.println("1. Weapon");
		System.out.println("2. Armor");
		System.out.println("3. Healtlh");
		System.out.println("4. Back to Main Menu");
		
		System.out.println("\nPlease enter the type of product you wish to add to the inventory: ");
		
		String value = scanner.nextLine();
		
		try {
			
			return  Integer.parseInt(value);
			
		}catch (Exception ex) {
			
		}
		
		
		return  0;
		
	}
	
	
	

}
