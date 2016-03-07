package rmi;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class ServeurRMIImpl extends UnicastRemoteObject implements ServeurRMI{

	protected ServeurRMIImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}


	@Override
	public String meth() throws RemoteException {
		return "retour serveur rmi";
	}

	
	public static void main(String [] args) throws RemoteException{
		
		int port = 10000;
		Registry registry = null;
		
		try{
			LocateRegistry.createRegistry(port);
			registry = LocateRegistry.getRegistry(port);
		}catch (RemoteException e){
			System.err.println("erreur createRegistry");
		}
		ServeurRMIImpl srmi1 = new ServeurRMIImpl();//objet java
		ServeurRMI srmi = null; //objet distant
		try {
			srmi = (ServeurRMI) UnicastRemoteObject.exportObject(srmi1,0);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try{
			registry.rebind("serveurRMI", srmi);
		} catch (Exception e){
			System.err.println("Erreur RMI rebind");
		}
		
		
	}
	
}
