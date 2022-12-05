import java.util.ArrayList;

public interface ShoppingCartInterface {

	public SalableProduct getSalableProductByName(String name);
	
	public float getTotalAmountDue();
	
	public void addToCart(SalableProduct salableProduct);
	
	public void removeFromCart(SalableProduct salableProduct);
	
	public void listCart();
	
	public boolean checkout();
	
	public void emptyCart();
	
}
