package app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Server {
	
	
	private ServerSocket serverSocket;
	private Socket clientSocket;
	private PrintWriter out;
	private BufferedReader in;
	
	
	/**
	 * Start the Server and listen for commands and send responses back.
	 * 
	 *  @param port to listen on.
	 *  @throws IOException Thrown in the networking classes if something bad happened.
	 */
	public void start(int port) throws IOException{
		
		
		// Create a ServerSocket instance
		try {
			serverSocket = new ServerSocket(port);
			
		}catch (IOException e) {
			e.printStackTrace();
			return;
		}
		
		
		// Continually listen for new connections
		while (true) {
			
			try {
				
				//Wait for a new connection
				clientSocket = serverSocket.accept();
				
				out = new PrintWriter(clientSocket.getOutputStream(), true);
				in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
				
				// Wait for Command string that is terminated by a line feed character
				String inputLine = "";
				
				
				while ((inputLine = in.readLine()) != null) {

					
					// If U command then update the inventory
					if (inputLine.startsWith("U|")) {
						
						
						processUpdateCommand(inputLine);
						break;
				
					// if R command then return inventory from store front	
					}else if (inputLine.startsWith("R|")) {
					
						
						processReturnCommand(inputLine);
						break;
						
					}
					else {
						
						// Echo an acknowledgement back to the Client that Command was not Recognizable 
						out.println("Command Not Recognized");
						
					} 
					
				
				}
				
				
				clientSocket.close();

				
			}catch (IOException e) {
			
				
				e.printStackTrace();
			}
			
		}
	
	
		
	}
	
	
	
	// process the return input line by reading a list of the product type from the file and returning it.
	private void processReturnCommand(String inputLine) {
		

		JsonHelper jh = new JsonHelper();		
		ObjectMapper mapper = new ObjectMapper();


		try {
			
			//Get all weapon products from json inventory file.
			if (inputLine.startsWith("R|W")) {
				
				ArrayList<Weapon> weaponList = jh.readWeaponInventory("inventory_weapon.json");
				for (Weapon weapon : weaponList ){
					
					
					//Send json response back.
					out.println(mapper.writeValueAsString(weapon));
					
				}
			}
			
		
			//Get all armor products from json inventory file.
			if (inputLine.startsWith("R|A")) {
				
				ArrayList<Armor> armorList = jh.readArmorInventory("inventory_armor.json");
				for (Armor armor : armorList ){
					
					//Send json response back.
					out.println(mapper.writeValueAsString(armor));
					
				}
			}
			
		
			//Get all health products from json inventory file.
			if (inputLine.startsWith("R|H")) {
				
			
				ArrayList<Health> healthList = jh.readHealthInventory("inventory_health.json");	
				for (Health health : healthList ){
					
					//Send json response back.
					out.println(mapper.writeValueAsString(health));
					
				}
				
			}
			

		
		
			
		
			 
		} catch (JsonProcessingException e) {
			
			e.printStackTrace();
		}
		
			

		
		
	}
	
	
	
	
	
	//Process the return input line by writing to file.
	private void processUpdateCommand(String inputLine) {
		
		// Create an instance of the ObjectMapper class
        ObjectMapper mapper = new ObjectMapper();
		

	
		
		if (inputLine.startsWith("U|W")) {

			//Remove the command determiner & object type denoter from the inputLine string so all that is left is the json data.
			inputLine = inputLine.replace("U|W", "");
			
			
			try {
				
			
				
				//Create a weapon object 
				Weapon weapon = mapper.readValue(inputLine, Weapon.class);
	
				//Write weapon to file using JsonHelper class.
				JsonHelper.writeWeaponToInventory("inventory_weapon.json", weapon);
				
				out.println("Weapon Product Added to Store Front Inventory.");
				
			} catch (JsonProcessingException e) {
				
				e.printStackTrace();
			}

		}else if (inputLine.startsWith("U|A")) {
			
			//Remove the command determiner & object type denoter from the inputLine string so all that is left is the json data.
			inputLine = inputLine.replace("U|A", "");
			
			
			try {
				
			
				
				//Create an armor object 
				Armor armor = mapper.readValue(inputLine, Armor.class);
	
				//Write weapon to file using JsonHelper class.
				JsonHelper.writeArmorToInventory("inventory_armor.json", armor);
				
				out.println("Armor Product Added to Store Front Inventory.");
				
			} catch (JsonProcessingException e) {
				
				e.printStackTrace();
			}
			
			
		}else if (inputLine.startsWith("U|H")) {
			
			//Remove the command determiner & object type denoter from the inputLine string so all that is left is the json data.
			inputLine = inputLine.replace("U|H", "");
			
			
			try {
				
				
				//Create an armor object 
				Health health = mapper.readValue(inputLine, Health.class);
	
				//Write weapon to file using JsonHelper class.
				JsonHelper.writeHealthToInventory("inventory_health.json", health);
				
				out.println("Armor Product Added to Store Front Inventory.");
				
			} catch (JsonProcessingException e) {
				
				e.printStackTrace();
			}
			
		}
		
		
		
	}
	
	
	

	
	
	

}
