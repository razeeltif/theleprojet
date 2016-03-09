package rmi;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;

import Bean.Animation;
  
public class ClientRMI {

	public static void main(String [] args){
		int port = 10000;
		try{
			Registry registry = LocateRegistry.getRegistry(port);
			
			ServeurRMI srmi = (ServeurRMI) registry.lookup("serveurRMI");
			
			ArrayList<Animation> res = srmi.getAllAnim();
			for (int i = 0; i < res.size(); i++) {
				System.out.println("res "+i+"= "+res.get(i).getNom_animation());
				System.out.println("	 "+res.get(i).getDescription());
				System.out.println("	 "+res.get(i).getGroupe_name());
			}
		}catch(Exception e){
			System.out.println("Erreur CLient RMI "+e.getMessage());
		}
	}

		
}
	
