package test;

import static org.junit.Assert.*;

import org.junit.Test;

import app.Armor;
import app.Health;
import app.InventoryList;
import app.SalableProduct;
import app.Weapon;


public class InventoryListTest {

	@Test
	public void testAdd() {
		
		InventoryList obj = new InventoryList();
		obj.add(new Weapon());
		assertEquals(1, obj.size());
	}

	@Test
	public void testGet() {
		
		InventoryList list = new InventoryList();
		
		Weapon obj = new Weapon();
		list.add(obj);
		
		assertEquals(obj, list.get(0));
	}

	@Test
	public void testRemoveT() {
		
		InventoryList list = new InventoryList();
		
		Weapon obj = new Weapon();
		list.add(obj);
		
		//Remove by object.
		list.remove(obj);
		
		assertEquals(0, list.size());
	}

	@Test
	public void testRemoveInt() {
		
		InventoryList obj = new InventoryList();
		obj.add(new Weapon());
		
		//Remove by int.
		obj.remove(0);
		
		assertEquals(0, obj.size());
	}

	@Test
	public void testSize() {
		InventoryList obj = new InventoryList();
		
		obj.add(new Weapon());
		obj.add(new Armor());
		obj.add(new Health());
		
		assertEquals(3, obj.size());
	}

	@Test
	public void testSort() {
		InventoryList obj = new InventoryList();
		
		Weapon a = new Weapon();
		a.setName("a");
		Weapon b = new Weapon();
		b.setName("b");
		Weapon c = new Weapon();
		c.setName("c");
		
		obj.add(a);
		obj.add(b);
		obj.add(c);
		
		//Test sort in ascending order
		obj.sort(false);
		
		assertEquals("a", ((Weapon) obj.get(0)).getName());
		assertEquals("b", ((Weapon) obj.get(1)).getName());
		assertEquals("c", ((Weapon) obj.get(2)).getName());
		

		//Test sort in descending order
		obj.sort(true);
		
		assertEquals("c", ((Weapon) obj.get(0)).getName());
		assertEquals("b", ((Weapon) obj.get(1)).getName());
		assertEquals("a", ((Weapon) obj.get(2)).getName());
		
	}

}
