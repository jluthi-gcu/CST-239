import java.util.ArrayList;


/*Class that contains an array or list of Salable Products. */
public class InventoryManager implements InventoryManagerInterface{
	


	
	
	/*Gets a salable product from the inventory that matches the passed in name. Returns null if no match found.*/
	public SalableProduct getSalableProductByName(String name) {
		
	
		for (int i = 0; i < inventory.size(); i++  ){
			
			if (inventory.get(i).getName().toLowerCase().equals(name.toLowerCase())) {
				
				return inventory.get(i);
			}
				
			
		}
		
		return null;
		
		
	}
	
	/*Adds a salable product to inventory list.*/
	public void addSalableProduct(SalableProduct salableProduct) {
		
		inventory.add(salableProduct);
		
	}
	
	/*Removes a salable product from inventory list.*/
	public void removeSalableProduct(SalableProduct salableProduct) {
		
		inventory.remove(salableProduct);
		
	}
	
	/*Lists all salable products currently in the inventory list to the console.*/
	public void listInventory() {
		
		for (int i = 0; i < inventory.size(); i++  ){
			
			System.out.println(inventory.get(i).toString());
			
		}
		
	}


	public void Initialize() {
		

		//Create weapon products.
		
		Weapon lightSword = new Weapon("Light Sword", "A light weight sharp welee weapon.", 10);
		lightSword.setPrice((float) 100.74);
		lightSword.setQuantity(10);
		lightSword.setWeight(6);
		
		//Add new weapon product to inventory
		this.addSalableProduct(lightSword);
		
		
		Weapon bowWeapon = new Weapon("Elven Bow", "A fast shooting bow made by the best elvish craftsmanship.", 7);
		bowWeapon.setPrice((float) 232.21);
		bowWeapon.setQuantity(1);
		bowWeapon.setWeight(9);
		
		//Add new weapon product to inventory.
		this.addSalableProduct(bowWeapon);
		
		
		Weapon daggerWeapon = new Weapon("Twisted Dagger", "A rusty ugly dagger when brandished makes enemies think twice.", 7);
		daggerWeapon.setPrice((float) 13.49);
		daggerWeapon.setQuantity(8);
		daggerWeapon.setWeight((float)2.4);
		
		//Add new weapon product to inventory.
		this.addSalableProduct(daggerWeapon);
	
		
		
		//Add armor products 
		
		Armor lightChainmail = new Armor("Light Chainmail", "A light weight chainmail.", 10);
		lightChainmail.setPrice((float) 15.32);
		lightChainmail.setQuantity(2);
		lightChainmail.setWeight(3);
		
		//Add new armor product to inventory
		this.addSalableProduct(lightChainmail);
		
		
		Armor mythrilArmor  = new Armor("Mythril Armor", "A rare light weight armor item capable of sustaining many heavy blows.", 250);
		mythrilArmor.setPrice((float) 3442.89);
		mythrilArmor.setQuantity(1);
		mythrilArmor.setWeight(10);
		
		//Add new armor product to inventory.
		this.addSalableProduct(mythrilArmor);
		

		
		
		//Create health products
		
		Health wolfsbanePotion = new Health("Wolfsbane Potion", "A well made potion capable of bringing any fallen soldier back to 100% health.", 500);
		wolfsbanePotion.setPrice((float) 320.17);
		wolfsbanePotion.setQuantity(5);
		wolfsbanePotion.setWeight((float)1);
		
		//Add new health product to inventory.
		this.addSalableProduct(wolfsbanePotion);
		
		
		Health draughtOfPeacePotion = new Health("Draught of Peace", "Made with herbs not native to this world.", 9000);
		draughtOfPeacePotion.setPrice((float) 1100.71);
		draughtOfPeacePotion.setQuantity(3);
		draughtOfPeacePotion.setWeight((float)2);
		
		//Add new health product to inventory.
		this.addSalableProduct(draughtOfPeacePotion);
	}

	
	

	

}
