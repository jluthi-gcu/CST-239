package app;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.fasterxml.jackson.databind.ObjectMapper;


/*Class used to help read json objects from various files*/
public class JsonHelper {

	
	
	// Helper method for reading weapon objects from a given json file.
	public static ArrayList<Weapon> readWeaponInventory(String filename)
	{
		
		ArrayList<Weapon> returnList = new ArrayList<Weapon>();
		
		try {

			
			ObjectMapper objectMapper = new ObjectMapper();
			List<Weapon> list1 = Arrays.asList(objectMapper.readValue(Paths.get(filename).toFile(), Weapon[].class));
			
			//Convert to ArrayList
			for (Weapon weapon : list1) {
				
				returnList.add(weapon);
			}
			
		}catch(IOException e) {
			
			// Print exception
			e.printStackTrace();
			
		}catch(Exception ex) {
			
			// Print exception
			ex.printStackTrace();
		}
		
		// Return the list of weapons
		return returnList;
		
	}
	
	

	// Helper method for writing a weapon object to a given json file.
	public static boolean writeWeaponToInventory(String filename, Weapon weapon)
	{
		
		try {

			
			ObjectMapper objectMapper = new ObjectMapper();
			
			//Convert object to json
			String json = objectMapper.writeValueAsString(weapon);


			//Remove ']' from end of file first.
			RandomAccessFile file = new RandomAccessFile(filename, "rw");
			file.seek(file.length() - 1);
			file.write(' ');
			file.setLength(file.length() - 1);
			file.close();
			
			
			//Append json to file.
			FileWriter fileWriter = new FileWriter(filename, true);
			fileWriter.write("," + json + ']');
			fileWriter.close();
			
			
			return true;
			
		}catch(IOException e) {
			
			// Print exception
			e.printStackTrace();
			
		}catch(Exception ex) {
			
			// Print exception
			ex.printStackTrace();
		}
		
	
		return false;
		
	}
	
	
	
	// Helper method for reading armor objects from a given json file.
	public static ArrayList<Armor> readArmorInventory(String filename)
	{
		
		ArrayList<Armor> returnList = new ArrayList<Armor>();
		
		try {

			
			ObjectMapper objectMapper = new ObjectMapper();
			List<Armor> list1 = Arrays.asList(objectMapper.readValue(Paths.get(filename).toFile(), Armor[].class));
			
			//Convert to ArrayList
			for (Armor weapon : list1) {
				
				returnList.add(weapon);
			}
			
		}catch(IOException e) {
			
			// Print exception
			e.printStackTrace();
			
		}catch(Exception ex) {
			
			// Print exception
			ex.printStackTrace();
		}
		
		// Return the list of weapons
		return returnList;
		
	}
	
	
	

	// Helper method for writing a armor object to a given json file.
	public static boolean writeArmorToInventory(String filename, Armor armor)
	{
		
		try {

			
			ObjectMapper objectMapper = new ObjectMapper();
			
			//Convert object to json
			String json = objectMapper.writeValueAsString(armor);


			//Remove ']' from end of file first.
			RandomAccessFile file = new RandomAccessFile(filename, "rw");
			file.seek(file.length() - 1);
			file.write(' ');
			file.setLength(file.length() - 1);
			file.close();
			
			
			//Append json to file.
			FileWriter fileWriter = new FileWriter(filename, true);
			fileWriter.write("," + json + ']');
			fileWriter.close();
			
			
			return true;
			
		}catch(IOException e) {
			
			// Print exception
			e.printStackTrace();
			
		}catch(Exception ex) {
			
			// Print exception
			ex.printStackTrace();
		}
		
	
		return false;
		
	}
	
	
	
	// Helper method for reading health objects from a given json file.
	public static ArrayList<Health> readHealthInventory(String filename)
	{
		
		ArrayList<Health> returnList = new ArrayList<Health>();
		
		try {

			
			ObjectMapper objectMapper = new ObjectMapper();
			List<Health> list1 = Arrays.asList(objectMapper.readValue(Paths.get(filename).toFile(), Health[].class));
			
			//Convert to ArrayList
			for (Health weapon : list1) {
				
				returnList.add(weapon);
			}
			
		}catch(IOException e) {
			
			// Print exception
			e.printStackTrace();
			
		}catch(Exception ex) {
			
			// Print exception
			ex.printStackTrace();
		}
		
		// Return the list of weapons
		
		return returnList;
		
	}
	

	// Helper method for writing a heatlh object to a given json file.
	public static boolean writeHealthToInventory(String filename, Health health)
	{
		
		try {

			
			ObjectMapper objectMapper = new ObjectMapper();
			
			//Convert object to json
			String json = objectMapper.writeValueAsString(health);


			//Remove ']' from end of file first.
			RandomAccessFile file = new RandomAccessFile(filename, "rw");
			file.seek(file.length() - 1);
			file.write(' ');
			file.setLength(file.length() - 1);
			file.close();
			
			
			//Append json to file.
			FileWriter fileWriter = new FileWriter(filename, true);
			fileWriter.write("," + json + ']');
			fileWriter.close();
			
			
			return true;
			
		}catch(IOException e) {
			
			// Print exception
			e.printStackTrace();
			
		}catch(Exception ex) {
			
			// Print exception
			ex.printStackTrace();
		}
		
	
		return false;
		
	}
	
	
}
