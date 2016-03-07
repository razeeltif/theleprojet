package rmi;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ClientRMI {

	public static void main(String [] args){
		
		int port = 10000;
		
		Registry registry;
		try {
			registry = LocateRegistry.getRegistry(port);
			billetRMI srmi = (billetRMI) registry.lookup("billetRMI");
			int res = srmi.getCode();
			
			System.out.println(res);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		
	}
	
	
	
}
