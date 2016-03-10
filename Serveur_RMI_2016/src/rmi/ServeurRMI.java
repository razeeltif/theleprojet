package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import Bean.Animation;
import Bean.Groupe;
import Bean.Horaires;
 
public interface ServeurRMI extends Remote{

	//m�thodes concernant la table billets
	//retour : true si le billet selectionn� existe
	public boolean isValideCode(int codeBillet) throws RemoteException;
	//retour : true si le billet s�lectionn� est un billet administrateur
	public boolean isAdmin(int codeBillet) throws RemoteException;

	//m�thodes concernant la table Animation
	//retour : l'animation dont le nom est nomAnim
	public Animation getAnim(String nomAnim) throws RemoteException;
	//retour : la liste des animations pour le groupe s�lectionn�
	public ArrayList<Animation> getAnimByGroupe(String nomGroupe) throws RemoteException;
	//retour la liste des animations
	public ArrayList<Animation> getAllAnim() throws RemoteException;
	//retour : true si la methode n'a rencontr�e aucun probl�mes
	public boolean addAnim(String nom_anim, String desc, String photo, int duree, int nbPlaces, String nom_Groupe) throws RemoteException;
	//retour : true si la methode n'a rencontr�e aucun probl�mes
	public boolean deleteAnim(String nom_anim) throws RemoteException;
	//retour : true si la methode n'a rencontr�e aucun probl�mes
	public boolean updateAnim(String nom_anim, ArrayList<String> champ, ArrayList<String> val) throws RemoteException;

	//m�thodes concernant la table Groupe
	//retour : le groupe correspondant au nom pass� en param�tre, null sinon
	public Groupe getGroupe(String nom_groupe) throws RemoteException;
	//retour : la liste de tous les groupes
	public ArrayList<Groupe> getAllGroupe() throws RemoteException;
	//retour : true si la methode n'a rencontr�e aucun probl�mes
	public boolean addGroupe(String nom_groupe, String desc) throws RemoteException;
	//retour : true si la methode n'a rencontr�e aucun probl�mes
	public boolean deleteGroupe(String nom_groupe) throws RemoteException;
	
	//m�thodes concernant la table Reservation
	//retour : true si la methode n'a rencontr�e aucun probl�mes
	public boolean addResa(int code_Billet, String nom_Anim, String time) throws RemoteException;
	//retour : true si la methode n'a rencontr�e aucun probl�mes
	public boolean deleteResa(String code_Billet, String nom_Anim, String time) throws RemoteException;
	
	// M�thodes concernant la table Horaires_Animation
	//retour : 
	public ArrayList<Horaires> getHoraires(String nom_Anim) throws RemoteException;
	//retour : true si la methode n'a rencontr�e aucun probl�mes
	public boolean createHorairesAnimation(String nom_Anim, int time) throws RemoteException;
	//retour : true si la methode n'a rencontr�e aucun probl�mes
	public boolean deleteHorairesAnimation(String nom_Anim, String time) throws RemoteException;
}
