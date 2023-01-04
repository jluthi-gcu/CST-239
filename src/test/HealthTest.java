package test;

import static org.junit.Assert.*;

import org.junit.Test;

import app.Health;



public class HealthTest {

	@Test
	public void testGetHealth() {
		Health obj = new Health();
		obj.setName("Greenwild");
		assertEquals("Greenwild", obj.getName());
	}

	@Test
	public void testSetHealth() {
		Health obj = new Health();
		obj.setName("FreshBlood");
		assertEquals("FreshBlood", obj.getName());
	}

	@Test
	public void testCompareTo() {

		Health obj1 = new Health();
		Health obj2 = new Health();
		
		obj1.setName("FreshBlood");
		obj2.setName("Greenwild");
		assertTrue(obj1.compareTo(obj2) < 0);
		
		
		obj1 = new Health();
		obj2 = new Health();
		
		obj1.setName("Greenwild");
		obj2.setName("FreshBlood");
		assertTrue(obj1.compareTo(obj2) > 0);
		
		
		obj1 = new Health();
		obj2 = new Health();
		
		obj1.setName("Greenwild");
		obj2.setName("Greenwild");
		assertEquals(0, obj1.compareTo(obj2));
		
	}

}
