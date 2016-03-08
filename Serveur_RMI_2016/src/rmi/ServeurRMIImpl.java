package rmi;

import java.rmi.AccessException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import Bean.*;
import Database.*;
 
public class ServeurRMIImpl implements ServeurRMI{



	
	public static void main(String[] args) throws RemoteException{
		int port = 10000;
		Registry registry = null;
		try {
			LocateRegistry.createRegistry(port);
			 registry = LocateRegistry.getRegistry(port);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			System.out.println("Erreur createRegistry"+e.getMessage());
		}
		
		ServeurRMIImpl srmii = new ServeurRMIImpl();
		ServeurRMI srmi = null;
		
		try{
			srmi = (ServeurRMI) UnicastRemoteObject.exportObject(srmii,0);
		}catch(RemoteException e){
			System.out.println("Erreur createRegistry"+e.getMessage());
		}
		
		try {
			registry.rebind("serveurRMI", srmi);
		} catch (AccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Systeme lancé");
	}


	@Override
	public boolean isValideCode(int codeBillet) throws RemoteException {
		// TODO Auto-generated method stub
		BilletTable tabBil = new BilletTable();
		return tabBil.isValideCode(codeBillet);
	}


	@Override
	public boolean isAdmin(int codeBillet) throws RemoteException {
		// TODO Auto-generated method stub
		BilletTable tabBil = new BilletTable();
		return tabBil.isAdmin(codeBillet);
	}


	@Override
	public Animation getAnim(String nomAnim) throws RemoteException {
		// TODO Auto-generated method stub
		AnimationTable tabAnim = new AnimationTable();
		return tabAnim.getAnim(nomAnim);
	}


	@Override
	public ArrayList<Animation> getAnimByGroupe(String nomGroupe) throws RemoteException {
		// TODO Auto-generated method stub
		AnimationTable tabAnim = new AnimationTable();
		return tabAnim.getAnimByGroupe(nomGroupe);
	}


	@Override
	public ArrayList<Animation> getAllAnim() throws RemoteException {
		// TODO Auto-generated method stub
		AnimationTable tabAnim = new AnimationTable();
		return tabAnim.getAllAnim();
	}


	@Override
	public void addAnim(String nom_anim, String desc, String photo, int duree, int nbPlaces, String nom_Groupe)
			throws RemoteException {
		// TODO Auto-generated method stub
		AnimationTable tabAnim = new AnimationTable();
		tabAnim.addAnim(nom_anim, desc, photo, duree, nbPlaces, nom_Groupe);
	}


	@Override
	public void deleteAnim(String nom_anim) throws RemoteException {
		// TODO Auto-generated method stub
		AnimationTable tabAnim = new AnimationTable();
		tabAnim.deleteAnim(nom_anim);
	}


	@Override
	public void updateAnim(String nom_anim, ArrayList<String> champ, ArrayList<String> val) throws RemoteException {
		// TODO Auto-generated method stub
		AnimationTable tabAnim = new AnimationTable();
		tabAnim.updateAnim(nom_anim, champ, val);
	}


	@Override
	public Groupe getGroupe(String nom_groupe) throws RemoteException {
		// TODO Auto-generated method stub
		GroupeTable tabGrp = new GroupeTable();
		return tabGrp.getGroupe(nom_groupe);
	}


	@Override
	public ArrayList<Groupe> getAllGroupe() throws RemoteException {
		// TODO Auto-generated method stub
		GroupeTable tabGrp = new GroupeTable();
		return tabGrp.getAllGroupe();
	}


	@Override
	public void addGroupe(String nom_groupe, String desc) throws RemoteException {
		// TODO Auto-generated method stub
		GroupeTable tabGrp = new GroupeTable();
		tabGrp.addGroupe(nom_groupe, desc);
		
	}


	@Override
	public void addResa(int code_Billet, String nom_Anim, int time) throws RemoteException {
		// TODO Auto-generated method stub
		ReservationTable tabResa = new ReservationTable();
		tabResa.addResa(code_Billet, nom_Anim, time);
	}
		

}
