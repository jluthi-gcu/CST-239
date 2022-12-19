package admin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import app.Armor;
import app.Health;
import app.InventoryList;
import app.JsonHelper;
import app.SalableProduct;
import app.Weapon;


public class AdminService {

	private final String _IP = "127.0.0.1";
	private final int _PORT = 4321;
	
	private Socket clientSocket;
	private PrintWriter out;
	private BufferedReader in;
	
	
	//Send a command and get a response string from the server back.
	public String sendCommand(String command) {
		
		
		try {
			//Establish socket connection.
			clientSocket = new Socket(_IP, _PORT);
		} catch (IOException e) {
			
			e.printStackTrace();
			
		}
	
		
		try {
			
			
			out = new PrintWriter(clientSocket.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

			// Send the command to the server.
			out.println(command);
			
			//If command is R, meaning return inventory, then read multiple responses.
			if (command.startsWith("R")) {
				
				String readLine = "";
				String response = "";
				
				while ((readLine = in.readLine()) != null) {
					
					
					if (response != "")
						response+= ",";
					
					response += readLine;
					
				}
				
				//Wrap in array if not empty.
				if (response != "")
					response = "[" + response + "]";
				
				
				return response;
				
			}else {
				// Return single response.
				return in.readLine();
				
			}
			
			
			
		}catch (IOException e) {
			
			e.printStackTrace();
		
				
	    }
		
		
		return "";
	
		
	}
	
	
	public InventoryList<SalableProduct> getInventory() {
			
		    InventoryList<SalableProduct> inventory = new InventoryList<SalableProduct>();
		    
			
		
			
			String response = "";
			
			//Send command to get all weapon inventory
			response = sendCommand("R|W");
			
			//Convert json response of weapon items and put in inventory array
			if (response != "") {
	
		
				try {
					
					ObjectMapper objectMapper = new ObjectMapper();
					
					List<Weapon> weaponList = Arrays.asList(objectMapper.readValue(response, Weapon[].class));
					
					for (Weapon weaponProduct : weaponList ){
						
					
						inventory.add(weaponProduct);
						
					}
					
				} catch (JsonProcessingException e) {
					
					e.printStackTrace();
				}
			
			
				
			}
			
			
			
			
			//Send command to get all armor inventory
			response = sendCommand("R|A");
			
			if (response != "") {
				
				
				try {
					
					ObjectMapper objectMapper = new ObjectMapper();
					
					List<Armor> armorList = Arrays.asList(objectMapper.readValue(response, Armor[].class));
					
					for (Armor armorProduct : armorList ){
						
						inventory.add(armorProduct);
						
					}
					
				} catch (JsonProcessingException e) {
					
					e.printStackTrace();
				}
				
			
			}
			
			
			
			
			//Send command to get all health inventory
			response = sendCommand("R|H");
			
			if (response != "") {
				
				try {
					
					ObjectMapper objectMapper = new ObjectMapper();
					
					List<Health> healthList = Arrays.asList(objectMapper.readValue(response, Health[].class));
					
					for (Health healthProduct : healthList ){
						
						inventory.add(healthProduct);
						
					}
					
				} catch (JsonProcessingException e) {
					
					e.printStackTrace();
				}
			
				
			}
			


			
			// Return the inventory
			return inventory;
			
			
			
	}
	
	
	
	
	public String addWeaponProduct(Weapon weapon) {
		
		//Build out command with determiner & object type denoter in front.
		String command = "U|W";

  	
        try {
        	
          	// Convert the object to a JSON string
            ObjectMapper mapper = new ObjectMapper();
			String json = mapper.writeValueAsString(weapon);
			
			//Append json;
			command += json;
			
			//Send command to the server.
			return sendCommand(command);
			
		} catch (JsonProcessingException e) {

			e.printStackTrace();
		}
		
		return "";
		
	}
	
	
	

	public String addArmorProduct(Armor armor) {
		
		//Build out command with determiner & object type denoter in front.
		String command = "U|A";

  	
        try {
        	
          	// Convert the object to a JSON string
            ObjectMapper mapper = new ObjectMapper();
			String json = mapper.writeValueAsString(armor);
			
			//Append json;
			command += json;
			
			//Send command to the server.
			return sendCommand(command);
			
		} catch (JsonProcessingException e) {

			e.printStackTrace();
		}
		
		return "";
		
	}
	
	

	public String addHealthProduct(Health health) {
		
		//Build out command with determiner & object type denoter in front.
		String command = "U|H";

  	
        try {
        	
          	// Convert the object to a JSON string
            ObjectMapper mapper = new ObjectMapper();
			String json = mapper.writeValueAsString(health);
			
			//Append json;
			command += json;
			
			//Send command to the server.
			return sendCommand(command);
			
		} catch (JsonProcessingException e) {

			e.printStackTrace();
		}
		
		return "";
		
	}
	
	
	
	
	
	
	
	
}
