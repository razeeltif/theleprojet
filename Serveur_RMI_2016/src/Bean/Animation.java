package Bean;

import java.io.Serializable;

public class Animation implements Serializable{

	String nom_animation;
	String description;
	String lien_photo;
	int duree;
	int nb_Places;
	String groupe_name;
	
	
	
	
	public String getNom_animation() {
		return nom_animation;
	}
	public void setNom_animation(String nom_animation) {
		this.nom_animation = nom_animation;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getLien_photo() {
		return lien_photo;
	}
	public void setLien_photo(String lien_photo) {
		this.lien_photo = lien_photo;
	}
	public int getDuree() {
		return duree;
	}
	public void setDuree(int duree) {
		this.duree = duree;
	}
	public int getNb_Places() {
		return nb_Places;
	}
	public void setNb_Places(int nb_Places) {
		this.nb_Places = nb_Places;
	}
	public String getGroupe_name() {
		return groupe_name;
	}
	public void setGroupe_name(String groupe_name) {
		this.groupe_name = groupe_name;
	}
	
	
}
