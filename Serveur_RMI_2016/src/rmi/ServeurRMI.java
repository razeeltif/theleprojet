package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import Bean.Animation;
import Bean.Groupe;
 
public interface ServeurRMI extends Remote{

	//méthodes concernant la table billets
	public boolean isValideCode(int codeBillet) throws RemoteException;
	
	public boolean isAdmin(int codeBillet) throws RemoteException;

	//méthodes concernant la table Animation
	public Animation getAnim(String nomAnim) throws RemoteException;
	
	public ArrayList<Animation> getAnimByGroupe(String nomGroupe) throws RemoteException;
	
	public ArrayList<Animation> getAllAnim() throws RemoteException;

	public void addAnim(String nom_anim, String desc, String photo, int duree, int nbPlaces, String nom_Groupe) throws RemoteException;
	
	public void deleteAnim(String nom_anim) throws RemoteException;
	
	public void updateAnim(String nom_anim, ArrayList<String> champ, ArrayList<String> val) throws RemoteException;

	//méthodes concernant la table Groupe
	public Groupe getGroupe(String nom_groupe) throws RemoteException;
	
	public ArrayList<Groupe> getAllGroupe() throws RemoteException;
	
	public void addGroupe(String nom_groupe, String desc) throws RemoteException;

	//méthodes concernant la table Reservation
	public void addResa(int code_Billet, String nom_Anim, int time) throws RemoteException;
}
