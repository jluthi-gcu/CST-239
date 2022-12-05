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
	
		JsonHelper jh = new JsonHelper();
		
		
		
		//Get all weapon products from json inventory file.
		ArrayList<Weapon> weaponList = jh.readWeaponInventory("inventory_weapon.json");
		for (Weapon weapon : weaponList ){
			
			this.addSalableProduct(weapon);
			
		}
	
		

		//Get all armor products from json inventory file.
		ArrayList<Armor> armorList = jh.readArmorInventory("inventory_armor.json");
		for (Armor armor : armorList ){
			
			this.addSalableProduct(armor);
			
		}
		
	
		//Get all health products from json inventory file.
		ArrayList<Health> healthList = jh.readHealthInventory("inventory_health.json");	
		for (Health health : healthList ){
			
			this.addSalableProduct(health);
			
		}
		
		
		
	
	}

	
	

	

}
