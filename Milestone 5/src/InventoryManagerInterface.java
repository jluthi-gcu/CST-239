import java.util.ArrayList;

public interface InventoryManagerInterface {
	
	public static final InventoryList<SalableProduct> inventory = new InventoryList<SalableProduct>();
	
	public SalableProduct getSalableProductByName(String name);
	
	public void addSalableProduct(SalableProduct salableProduc);
	
	public void removeSalableProduct(SalableProduct salableProduc);
	
	public void listInventory();

}
