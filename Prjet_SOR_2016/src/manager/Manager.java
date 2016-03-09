package manager;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import rmi.ServeurRMI;

public class Manager {

	// classe pour la création
	// d'un objet persistant
	
	boolean identifie = true;
	boolean admin = true;
	int num = -1;
	ServeurRMI servRMI;
	
	public Manager(){
		int port = 10000;
		
		Registry registry;
		try {
			registry = LocateRegistry.getRegistry(port);
			servRMI = (ServeurRMI) registry.lookup("serveurRMI");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	
	public boolean isIdentifie() {
		return identifie;
	}

	public void setIdentifie(boolean identifie) {
		this.identifie = identifie;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
	
	public void setAdmin(boolean admin){
		this.admin = admin;
	}
	
	public boolean isAdmin(){
		return admin;
	}
	
	public ServeurRMI getServRMI(){
		return servRMI;
	}
	
	public void setServeurRMI(ServeurRMI s){
		servRMI = s;
	}
}
