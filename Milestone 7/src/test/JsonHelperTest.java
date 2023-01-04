package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Random;

import org.junit.Test;

import app.Armor;
import app.Health;
import app.JsonHelper;
import app.Weapon;

public class JsonHelperTest {

	@Test
	public void testReadWeaponInventory() {
		
		JsonHelper jh = new JsonHelper();		
		ArrayList<Weapon> list = jh.readWeaponInventory("inventory_weapon.json");
		
		assertNotNull(list);
		assertFalse(list.isEmpty());
		
	}

	@Test
	public void testWriteWeaponToInventory() {

		Random random = new Random();
	    int min = 1;
	    int max = 1000;
	    int randomName = random.nextInt((max - min) + 1) + min;
	   
		
		Weapon weapon = new Weapon();
		weapon.setName(String.valueOf(randomName));
		
		
		JsonHelper jh = new JsonHelper();		
		jh.writeWeaponToInventory("inventory_weapon.json", weapon);
		
		
		ArrayList<Weapon> list = jh.readWeaponInventory("inventory_weapon.json");
		
		
		Boolean matchFound = false;
		for (int i = 0; i < list.size(); i++) {
			
		      Weapon w = list.get(i);
		      
		      if (w.getName().equals(String.valueOf(randomName))) {
		    	  
		    	  matchFound = true;
		    	  break;
		      }
	
		 }
		
		
		assertTrue(matchFound);
	
	}

	@Test
	public void testReadArmorInventory() {
		JsonHelper jh = new JsonHelper();		
		ArrayList<Armor> list = jh.readArmorInventory("inventory_armor.json");
		
		assertNotNull(list);
		assertFalse(list.isEmpty());
	}

	@Test
	public void testWriteArmorToInventory() {

		Random random = new Random();
	    int min = 1;
	    int max = 1000;
	    int randomName = random.nextInt((max - min) + 1) + min;
	   
		
		Armor armor = new Armor();
		armor.setName(String.valueOf(randomName));
		
		
		JsonHelper jh = new JsonHelper();		
		jh.writeArmorToInventory("inventory_armor.json", armor);
		
		
		ArrayList<Armor> list = jh.readArmorInventory("inventory_armor.json");
		
		
		Boolean matchFound = false;
		for (int i = 0; i < list.size(); i++) {
			
			 Armor w = list.get(i);
		      
		      if (w.getName().equals(String.valueOf(randomName))) {
		    	  
		    	  matchFound = true;
		    	  break;
		      }
	
		 }
		
		
		assertTrue(matchFound);
	}

	@Test
	public void testReadHealthInventory() {
		JsonHelper jh = new JsonHelper();		
		ArrayList<Health> list = jh.readHealthInventory("inventory_health.json");
		
		assertNotNull(list);
		assertFalse(list.isEmpty());
	}

	@Test
	public void testWriteHealthToInventory() {
		Random random = new Random();
	    int min = 1;
	    int max = 1000;
	    int randomName = random.nextInt((max - min) + 1) + min;
	   
		
		Health health = new Health();
		health.setName(String.valueOf(randomName));
		
		
		JsonHelper jh = new JsonHelper();		
		jh.writeHealthToInventory("inventory_health.json", health);
		
		
		ArrayList<Health> list = jh.readHealthInventory("inventory_health.json");
		
		
		Boolean matchFound = false;
		for (int i = 0; i < list.size(); i++) {
			
			 Health w = list.get(i);
		      
		      if (w.getName().equals(String.valueOf(randomName))) {
		    	  
		    	  matchFound = true;
		    	  break;
		      }
	
		 }
		
		
		assertTrue(matchFound);
	}

}
