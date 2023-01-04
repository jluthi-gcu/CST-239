package test;

import static org.junit.Assert.*;

import org.junit.Test;

import app.Armor;

public class ArmorTest {

	@Test
	public void testGetArmor() {
		
		Armor obj = new Armor();
		obj.setName("Gold");
		assertEquals("Gold", obj.getName());
		
	}

	@Test
	public void testSetArmor() {
		Armor obj = new Armor();
		obj.setName("Dimond");
		assertEquals("Dimond", obj.getName());
	}

	@Test
	public void testCompareTo() {
		
		Armor obj1 = new Armor();
		Armor obj2 = new Armor();
		
		obj1.setName("Gold");
		obj2.setName("Purple");
		assertTrue(obj1.compareTo(obj2) < 0);
		
		
		obj1 = new Armor();
		obj2 = new Armor();
		
		obj1.setName("Purple");
		obj2.setName("Gold");
		assertTrue(obj1.compareTo(obj2) > 0);
		
		
		obj1 = new Armor();
		obj2 = new Armor();
		
		obj1.setName("Gold");
		obj2.setName("Gold");
		assertEquals(0, obj1.compareTo(obj2));
		
	}

}
