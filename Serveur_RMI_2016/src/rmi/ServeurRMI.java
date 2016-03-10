package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import Bean.Animation;
import Bean.Groupe;
import Bean.Horaires;
 
public interface ServeurRMI extends Remote{

	//méthodes concernant la table billets
	//retour : true si le billet selectionné existe
	public boolean isValideCode(int codeBillet) throws RemoteException;
	//retour : true si le billet sélectionné est un billet administrateur
	public boolean isAdmin(int codeBillet) throws RemoteException;

	//méthodes concernant la table Animation
	//retour : l'animation dont le nom est nomAnim
	public Animation getAnim(String nomAnim) throws RemoteException;
	//retour : la liste des animations pour le groupe sélectionné
	public ArrayList<Animation> getAnimByGroupe(String nomGroupe) throws RemoteException;
	//retour la liste des animations
	public ArrayList<Animation> getAllAnim() throws RemoteException;
	//retour : true si la methode n'a rencontrée aucun problèmes
	public boolean addAnim(String nom_anim, String desc, String photo, int duree, int nbPlaces, String nom_Groupe) throws RemoteException;
	//retour : true si la methode n'a rencontrée aucun problèmes
	public boolean deleteAnim(String nom_anim) throws RemoteException;
	//retour : true si la methode n'a rencontrée aucun problèmes
	public boolean updateAnim(String nom_anim, ArrayList<String> champ, ArrayList<String> val) throws RemoteException;

	//méthodes concernant la table Groupe
	//retour : le groupe correspondant au nom passé en paramètre, null sinon
	public Groupe getGroupe(String nom_groupe) throws RemoteException;
	//retour : la liste de tous les groupes
	public ArrayList<Groupe> getAllGroupe() throws RemoteException;
	//retour : true si la methode n'a rencontrée aucun problèmes
	public boolean addGroupe(String nom_groupe, String desc) throws RemoteException;
	//retour : true si la methode n'a rencontrée aucun problèmes
	public boolean deleteGroupe(String nom_groupe) throws RemoteException;
	
	//méthodes concernant la table Reservation
	//retour : true si la methode n'a rencontrée aucun problèmes
	public boolean addResa(int code_Billet, String nom_Anim, String time) throws RemoteException;
	//retour : true si la methode n'a rencontrée aucun problèmes
	public boolean deleteResa(String code_Billet, String nom_Anim, String time) throws RemoteException;
	
	// Méthodes concernant la table Horaires_Animation
	//retour : 
	public ArrayList<Horaires> getHoraires(String nom_Anim) throws RemoteException;
	//retour : true si la methode n'a rencontrée aucun problèmes
	public boolean createHorairesAnimation(String nom_Anim, int time) throws RemoteException;
	//retour : true si la methode n'a rencontrée aucun problèmes
	public boolean deleteHorairesAnimation(String nom_Anim, String time) throws RemoteException;
}
