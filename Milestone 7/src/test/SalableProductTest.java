package test;

import static org.junit.Assert.*;

import org.junit.Test;

import app.Armor;
import app.Health;
import app.SalableProduct;
import app.Weapon;

public class SalableProductTest {

	@Test
	public void testGetName() {
		SalableProduct obj = new SalableProduct(null, null, 0f, 0, 0f);
		obj.setName("GoldPlated");
		assertEquals("GoldPlated", obj.getName());
	}

	@Test
	public void testSetName() {
		SalableProduct obj = new SalableProduct(null, null, 0f, 0, 0f);
		obj.setName("RustedArmor");
		assertEquals("RustedArmor", obj.getName());
	}

	@Test
	public void testGetDescription() {
		SalableProduct obj = new SalableProduct(null, null, 0f, 0, 0f);
		obj.setDescription("Test Product Description - Get");
		assertEquals("Test Product Description - Get", obj.getDescription());
	}

	@Test
	public void testSetDescription() {
		SalableProduct obj = new SalableProduct(null, null, 0f, 0, 0f);
		obj.setDescription("Test Product Description - Set");
		assertEquals("Test Product Description - Set", obj.getDescription());
		
	}


	@Test
	public void testGetPrice() {
		SalableProduct obj = new SalableProduct(null, null, 0f, 0, 0f);
		obj.setPrice(99.99f);
		assertEquals("99.99", String.valueOf(obj.getPrice()));
	}

	@Test
	public void testSetPrice() {
		SalableProduct obj = new SalableProduct(null, null, 0f, 0, 0f);
		obj.setPrice(55.55f);
		assertEquals("55.55", String.valueOf(obj.getPrice()));
	}

	@Test
	public void testGetQuantity() {
		SalableProduct obj = new SalableProduct(null, null, 0f, 0, 0f);
		obj.setQuantity(10);
		assertEquals(10, obj.getQuantity());
	}

	@Test
	public void testSetQuantity() {
		SalableProduct obj = new SalableProduct(null, null, 0f, 0, 0f);
		obj.setQuantity(100);
		assertEquals(100, obj.getQuantity());
	}

	@Test
	public void testGetWeight() {
		SalableProduct obj = new SalableProduct(null, null, 0f, 0, 0f);
		obj.setWeight(99.99f);
		assertEquals("99.99", String.valueOf(obj.getWeight()));
	}

	@Test
	public void testSetWeight() {
		SalableProduct obj = new SalableProduct(null, null, 0f, 0, 0f);
		obj.setWeight(55.55f);
		assertEquals("55.55", String.valueOf(obj.getWeight()));
	}

	
	@Test
	public void testToString() {
		
		SalableProduct obj = new SalableProduct(null, null, 0f, 0, 0f);
		obj.setName("Test");
		obj.setDescription("Test Description");
		obj.setPrice(99.99f);
		obj.setQuantity(10);
		obj.setWeight(100f);
		
		
		String expectedResult = "Name: Test, Description: Test Description, Price: 99.99, Quantity: 10, Weight: 100.0";
		
		assertEquals(expectedResult, obj.toString());
	}

}
