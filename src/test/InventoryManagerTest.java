package test;

import static org.junit.Assert.*;

import org.junit.Test;

import app.InventoryList;
import app.InventoryManager;
import app.Weapon;


public class InventoryManagerTest {

	@Test
	public void testGetSalableProductByName() {
		InventoryManager im = new InventoryManager();
		
		Weapon obj = new Weapon();
		obj.setName("Dagger");
		
		//Add object to inventory manager
		im.addSalableProduct(obj);
		
		assertEquals("Dagger", im.getSalableProductByName("Dagger").getName());
	}

	@Test
	public void testAddSalableProduct() {
		
		InventoryManager im = new InventoryManager();
		
		Weapon obj = new Weapon();
		obj.setName("Bow");
		
		//Add object to inventory manager
		im.addSalableProduct(obj);
		
		assertEquals("Bow", im.getSalableProductByName("Bow").getName());
		
	}

	@Test
	public void testRemoveSalableProduct() {
		
		InventoryManager im = new InventoryManager();
		
		Weapon obj = new Weapon();
		
		//Add object to inventory manager
		im.addSalableProduct(obj);
		
		//Now test removing
		im.removeSalableProduct(obj);
		
		assertEquals(null, im.getSalableProductByName("Bow"));
	}

	

	
}
