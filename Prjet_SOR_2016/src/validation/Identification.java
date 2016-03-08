package validation;

import annotation.NonVide;

public class Identification {
	
	@NonVide(mess="Veuillez saisir votre identifiant situé sur votre billet")
	String id;
	
	public String getId(){
		return id;
	}
	
	public void setId(String id){
		this.id = id;
	}
	

}
