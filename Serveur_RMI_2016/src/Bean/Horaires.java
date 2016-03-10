package Bean;

import java.io.Serializable;

public class Horaires  implements Serializable{

	String nom_anim;
	int heure_Debut;
	int nb_Places_dispo;
	
	
	public String getNom_anim() {
		return nom_anim;
	}
	public void setNom_anim(String nom_anim) {
		this.nom_anim = nom_anim;
	}
	public int getHeure_Debut() {
		return heure_Debut;
	}
	public void setHeure_Debut(int heure_Debut) {
		this.heure_Debut = heure_Debut;
	}
	public int getNb_Places_dispo() {
		return nb_Places_dispo;
	}
	public void setNb_Places_dispo(int nb_Places_dispo) {
		this.nb_Places_dispo = nb_Places_dispo;
	}
	
}
