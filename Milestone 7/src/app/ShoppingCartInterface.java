package app;
import java.util.ArrayList;

public interface ShoppingCartInterface {

	public static final InventoryList<SalableProduct> cart = new InventoryList<SalableProduct>();
	
	public SalableProduct getSalableProductByName(String name);
	
	public float getTotalAmountDue();
	
	public void addToCart(SalableProduct salableProduct);
	
	public void removeFromCart(SalableProduct salableProduct);
	
	public void listCart();
	
	public boolean checkout();
	
	public void emptyCart();
	
}
