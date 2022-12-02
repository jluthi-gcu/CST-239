
/*A derived class that inherits from a Salable Product. */ 
public class Weapon extends SalableProduct implements Comparable<Weapon> {

	private int weaponDamage = 0;
	

	public Weapon(String name, String description, int weaponDamage) {
		super(name, description);
		
		this.weaponDamage = weaponDamage;
	}

	/*Getter method for weaponDamage.*/
	public int getWeaponDamage() {
		return weaponDamage;
	}

	/*Setter method for weaponDamage.*/
	public void setWeaponDamage(int weaponDamage) {
		this.weaponDamage = weaponDamage;
	}

	@Override
	public int compareTo(Weapon weapon) {
		
		int	value = this.getName().toLowerCase().compareTo(weapon.getName().toLowerCase());
		
		return value;
	}
	

}
