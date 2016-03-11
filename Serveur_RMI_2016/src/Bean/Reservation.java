package Bean;

import java.io.Serializable;

public class Reservation  implements Serializable{

	int code_Billet;
	String nom_Animation;
	String time;
	
	
	public int getCode_Billet() {
		return code_Billet;
	}
	public void setCode_Billet(int code_Billet) {
		this.code_Billet = code_Billet;
	}
	public String getNom_Animation() {
		return nom_Animation;
	}
	public void setNom_Animation(String nom_Animation) {
		this.nom_Animation = nom_Animation;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
	
}
