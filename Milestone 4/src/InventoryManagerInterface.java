import java.util.ArrayList;

public interface InventoryManagerInterface {
	
	public static final ArrayList<SalableProduct> inventory = new ArrayList<SalableProduct>();
	
	public SalableProduct getSalableProductByName(String name);
	
	public void addSalableProduct(SalableProduct salableProduc);
	
	public void removeSalableProduct(SalableProduct salableProduc);
	
	public void listInventory();

}
