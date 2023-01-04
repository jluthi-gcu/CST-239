package test;

import static org.junit.Assert.*;

import org.junit.Test;

import app.InventoryManager;
import app.ShoppingCart;
import app.Weapon;

public class ShoppingCartTest {

	@Test
	public void testGetSalableProductByName() {
		ShoppingCart sc = new ShoppingCart();
		//Requires inventory manager.
		sc.Initialize(new InventoryManager());
		
		Weapon obj = new Weapon();
		obj.setName("New Sword");
		
		//Add object to shopping cart
		sc.addToCart(obj);
		
		assertEquals("New Sword", sc.getSalableProductByName("New Sword").getName());
	}

	@Test
	public void testGetTotalAmountDue() {
		ShoppingCart sc = new ShoppingCart();
		//Requires inventory manager.
		sc.Initialize(new InventoryManager());
	
		
		Weapon obj = new Weapon();
		obj.setPrice(50.0f);
		Weapon obj2 = new Weapon();
		obj2.setPrice(50.0f);
		
		//Add object to shopping cart
		sc.addToCart(obj);
		sc.addToCart(obj2);
		
		assertEquals("100.0", String.valueOf(sc.getTotalAmountDue()));
	}

	@Test
	public void testAddToCart() {
		ShoppingCart sc = new ShoppingCart();
		//Requires inventory manager.
		sc.Initialize(new InventoryManager());
		
		Weapon obj = new Weapon();
		obj.setName("Added Weapon");
		
		//Add object to shopping cart
		sc.addToCart(obj);
		
		assertEquals("Added Weapon", sc.getSalableProductByName("Added Weapon").getName());
	}

	@Test
	public void testRemoveFromCart() {
		
		ShoppingCart sc = new ShoppingCart();
		//Requires inventory manager.
		sc.Initialize(new InventoryManager());
		
		Weapon obj = new Weapon();
		obj.setName("Removing Weapon");
		
		//Add object to shopping cart
		sc.addToCart(obj);
		
		//Now test removing
		sc.removeFromCart(obj);
		
		assertEquals(null, sc.getSalableProductByName("Removing Weapon"));
	}



	@Test
	public void testEmptyCart() {
		ShoppingCart sc = new ShoppingCart();
		//Requires inventory manager.
		sc.Initialize(new InventoryManager());
		
		Weapon obj = new Weapon();
		obj.setName("Weapon 1");
		
		Weapon obj2 = new Weapon();
		obj2.setName("Weapon 2");
		
		//Add object to shopping cart
		sc.addToCart(obj);
		sc.addToCart(obj2);
		
		//Test emptying cart.
		sc.emptyCart();
		
		assertEquals(null, sc.getSalableProductByName("Weapon 1"));
		assertEquals(null, sc.getSalableProductByName("Weapon 2"));
		
	}

	

}
