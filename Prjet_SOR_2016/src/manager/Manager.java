package manager;

public class Manager {

	// classe pour la création
	// d'un objet persistant
	
	boolean identifie = true;
	boolean admin = false;
	int num = -1;

	public boolean isIdentifie() {
		return identifie;
	}

	public void setIdentifie(boolean identifie) {
		this.identifie = identifie;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
	
	public void setAdmin(boolean admin){
		this.admin = admin;
	}
	
	public boolean isAdmin(){
		return admin;
	}
}
