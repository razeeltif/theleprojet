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
	public boolean addAnim(String nom_anim, String desc, String photo, int duree, int nbPlaces, String nom_Groupe)
			throws RemoteException {
		// TODO Auto-generated method stub
		AnimationTable tabAnim = new AnimationTable();
		return tabAnim.addAnim(nom_anim, desc, photo, duree, nbPlaces, nom_Groupe);
	}


	@Override
	public boolean deleteAnim(String nom_anim) throws RemoteException {
		// TODO Auto-generated method stub
		this.deleteHorairesAnimation(nom_anim, "%");
		AnimationTable tabAnim = new AnimationTable();
		return tabAnim.deleteAnim(nom_anim);
	}


	@Override
	public boolean updateAnim(String nom_anim, ArrayList<String> champ, ArrayList<String> val) throws RemoteException {
		// TODO Auto-generated method stub
		AnimationTable tabAnim = new AnimationTable();
		return tabAnim.updateAnim(nom_anim, champ, val);
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
	public boolean addGroupe(String nom_groupe, String desc) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("coucou 1");
		GroupeTable tabGrp = new GroupeTable();
		System.out.println("coucou 2");
		return tabGrp.addGroupe(nom_groupe, desc);
		
	}


	public boolean deleteGroupe(String nom_groupe) throws RemoteException{
		ArrayList<Animation> animTmp = this.getAnimByGroupe(nom_groupe);
		for(int i = 0; i < animTmp.size();i++){
			this.deleteAnim(animTmp.get(i).getNom_animation());
		}

		GroupeTable tabGrp = new GroupeTable();
		return tabGrp.deleteGroupe(nom_groupe);
		
	}
	

	@Override
	public ArrayList<Reservation> getResa(int code_Billet) throws RemoteException{
		ReservationTable tabResa = new ReservationTable();
		return tabResa.getResa(code_Billet);
	}
	
	
	@Override
	public boolean addResa(int code_Billet, String nom_Anim, String time) throws RemoteException {
		// TODO Auto-generated method stub
		ReservationTable tabResa = new ReservationTable();
		Horaires_AnimationTable tabHor = new Horaires_AnimationTable();
		tabResa.addResa(code_Billet, nom_Anim, time);
		return tabHor.decrementeNbPlaces(nom_Anim, time, 1);
	}

	public boolean deleteResa(String code_Billet, String nom_Anim, String time) throws RemoteException{
		int i = 0;
		ReservationTable tabResa = new ReservationTable();
		Horaires_AnimationTable tabHor = new Horaires_AnimationTable();
		i=tabResa.deleteResa(code_Billet, nom_Anim, time);
		if(!time.equals("%")){
			tabHor.decrementeNbPlaces(nom_Anim, time, -i);
		}
		return false;
	}
	

	public ArrayList<Horaires> getHoraires(String nom_Anim) throws RemoteException{
		// TODO Auto-generated method stub
		Horaires_AnimationTable tabHor = new Horaires_AnimationTable();
		return tabHor.getHoraires(nom_Anim);
	}
	@Override
	public boolean createHorairesAnimation(String nom_Anim, int time) throws RemoteException {
		// TODO Auto-generated method stub
		Horaires_AnimationTable tabHor = new Horaires_AnimationTable();
		return tabHor.createHorairesAnimation(nom_Anim, time);
	}
		

	@Override
	public boolean deleteHorairesAnimation(String nom_Anim, String time) throws RemoteException {
		// TODO Auto-generated method stub
		this.deleteResa("%", nom_Anim, time);
		Horaires_AnimationTable tabHor = new Horaires_AnimationTable();
		return tabHor.deleteHorairesAnimation(nom_Anim, time);
	}
}
