
/*A derived class that inherits from a Salable Product. */ 
public class Health extends SalableProduct implements Comparable<Health> {

	private int health = 0;
	
	public Health() {
	    super("", "", 0, 0, 0);
	}
	
	public Health(String name, String description, float price, int quantity, float weight, int health) {
		super(name, description, price, quantity, weight);
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
