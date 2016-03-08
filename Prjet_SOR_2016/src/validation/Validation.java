package validation;

import java.lang.reflect.Field;
import java.util.Hashtable;

import annotation.NonVide;


public class Validation {

	boolean valide = true;
	Hashtable <String,String> valeurs = new Hashtable<String,String>();
	Hashtable <String,String> erreurs = new Hashtable<String,String>();
	
	public boolean nonVide(
			Class c,
			String param,
			String val) {
		boolean res = true;
		
		if (val == null) {
			res = false;
			val = "";
		}
		else if (val.trim().length() == 0) {
			res = false;
		}
		if (!res) {
			valide = false;
			String mess = "Veuillez remplir le champ";
			try {
				Field f = c.getDeclaredField(param);
				NonVide an = f.getAnnotation(NonVide.class);
				if (an != null) mess = an.mess();
			}
			catch (Exception e) {
			}
			erreurs.put(param,mess);
		}
		valeurs.put(param,val);
			

		return res;
	}
	
	
	public boolean estCorrect(String val){
		boolean res = true;
		if (val.trim().length() != 4) {
			res = false;
		}
		return res;
	}
	public boolean estCorrect(Class c, String param,String val) {
		boolean res = true;
		
		if (val == null) {
			res = false;
			val = "";
		}
		else if (val.trim().length() != 4) {
			res = false;
		}
		if (!res) {
			valide = false;
			erreurs.put(param, "Veuillez saisir les 4 chiffres pr�sents sur votre billet");
		}
		valeurs.put(param,val);

		return res;
	}
	
	
	public boolean estEntier(Class c, String param,String val) {
			boolean res = true;
			
			if (val == null) {
				res = false;
				val = "";
			}
			else {
				try {
					int num = Integer.parseInt(val);
					if(num < 0){
						res = false;
					}
				}
				catch (Exception e) {
					res = false;
				}
			}
			if (!res) {
				valide = false;
				erreurs.put(param, "Le champ doit �tre un entier");
			}
			valeurs.put(param,val);

			return res;
		}

	public boolean isValide() {
		return valide;
	}

	public void setValide(boolean valide) {
		this.valide = valide;
	}

	public Hashtable<String, String> getValeurs() {
		return valeurs;
	}

	public void setValeurs(Hashtable<String, String> valeurs) {
		this.valeurs = valeurs;
	}

	public Hashtable<String, String> getErreurs() {
		return erreurs;
	}

	public void setErreurs(Hashtable<String, String> erreurs) {
		this.erreurs = erreurs;
	}
	
}
