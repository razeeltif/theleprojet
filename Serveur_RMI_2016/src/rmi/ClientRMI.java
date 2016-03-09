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
			for (Animation animation : res) {
				System.out.println("res = "+animation.getNom_animation());
			}
		}catch(Exception e){
			System.out.println("Erreur CLient RMI "+e.getMessage());
		}
	}

		
}
	
