/*A derived class that inherits from a Salable Product. */ 
public class Armor extends SalableProduct implements Comparable<Armor> {

	private int armor = 0;
	
	public Armor(String name, String description, int armor) {
		super(name, description);
		this.armor = armor;
	}

	/*Getter method for weaponDamage.*/
	public int getArmor() {
		return armor;
	}

	/*Setter method for health.*/
	public void setArmor(int armor) {
		this.armor = armor;
	}

	
	
	@Override
	public int compareTo(Armor armor) {
		
		int	value = this.getName().toLowerCase().compareTo(armor.getName().toLowerCase());
		
		return value;
	}
	
}
