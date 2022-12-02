
/*A derived class that inherits from a Salable Product. */ 
public class Health extends SalableProduct implements Comparable<Health> {

	private int health = 0;
	
	public Health(String name, String description, int health) {
		super(name, description);
		this.health = health;
	}

	/*Getter method for health.*/
	public int getHealth() {
		return health;
	}

	/*Setter method for health.*/
	public void setHealth(int health) {
		this.health = health;
	}

	
	@Override
	public int compareTo(Health health) {
		
		int	value = this.getName().toLowerCase().compareTo(health.getName().toLowerCase());
		
		return value;
	}
	
	
}
