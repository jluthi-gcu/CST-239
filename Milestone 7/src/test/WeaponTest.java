package test;

import static org.junit.Assert.*;

import org.junit.Test;


import app.Weapon;



public class WeaponTest {

	@Test
	public void testGetWeaponDamage() {
		Weapon obj = new Weapon();
		obj.setName("BronzeSword");
		assertEquals("BronzeSword", obj.getName());
	}

	@Test
	public void testSetWeaponDamage() {
		Weapon obj = new Weapon();
		obj.setName("DeathBlade");
		assertEquals("DeathBlade", obj.getName());
	}

	@Test
	public void testCompareTo() {

		Weapon obj1 = new Weapon();
		Weapon obj2 = new Weapon();
		
		obj1.setName("Lightsword");
		obj2.setName("Zweihander");
		assertTrue(obj1.compareTo(obj2) < 0);
		
		
		obj1 = new Weapon();
		obj2 = new Weapon();
		
		obj1.setName("Zweihander");
		obj2.setName("Lightsword");
		assertTrue(obj1.compareTo(obj2) > 0);
		
		
		obj1 = new Weapon();
		obj2 = new Weapon();
		
		obj1.setName("Lightsword");
		obj2.setName("Lightsword");
		assertEquals(0, obj1.compareTo(obj2));
	}

}
