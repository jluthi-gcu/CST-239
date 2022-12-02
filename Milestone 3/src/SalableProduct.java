/*A base class to inherit from that represents a salable product with common properties and methods.*/
public class SalableProduct  {
	
	
	private String name = "";
	
	private String description = "";
	
	private float price = 0;
	
	private int quantity = 0;

	private float weight = 0;

	
	public SalableProduct(String name, String description) {
		
		this.name = name;
		this.description = description;
	}
	
	/*Getter method for name.*/
	public String getName() {
		return name;
	}

	/*Setter method for name.*/
	public void setName(String name) {
		this.name = name;
	}

	/*Getter method for description.*/
	public String getDescription() {
		return description;
	}


	/*Setter method for description.*/
	public void setDescription(String description) {
		this.description = description;
	}


	/*Getter method for price.*/
	public float getPrice() {
		return price;
	}

	/*Setter method for price.*/
	public void setPrice(float price) {
		this.price = price;
	}

	/*Getter method for quantity.*/
	public int getQuantity() {
		return quantity;
	}

	/*Setter method for quantity.*/
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/*Getter method for weight.*/
	public float getWeight() {
		return weight;
	}

	/*Setter method for weight.*/
	public void setWeight(float weight) {
		this.weight = weight;
	}

	/*Override the toString() method to display all object properties.*/
	@Override
	public String toString() {
		return "Name: " + name + ", Description: " + description + ", Price: " + price + ", Quantity: "
				+ quantity + ", Weight: " + weight;
	}

	
	
}
