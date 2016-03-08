package obj;

import java.util.ArrayList;

public class ListeReservation {
	
	ArrayList<Animation> listReserv = new ArrayList<Animation>();
	
	
	
	boolean add(Animation a){
		
		boolean res = false;
		
		/*if isValid*/
		
			/*ajout bdd*/
			res = listReserv.add(a);
			listReserv = listerReservation();
			
		return res;
		
	}

	
	void removeAll(){
		listReserv.clear();
		
		listReserv = listerReservation();
	}
	
	ArrayList<Animation> listerReservation(){
		
		removeAll();
		
		/*appel base de donnee*/
		/*recup info*/
		
		return listReserv;
		
		
	}

	public ArrayList<Animation> getListReserv() {
		return listReserv;
	}

	public void setListReserv(ArrayList<Animation> listReserv) {
		this.listReserv = listReserv;
	}

}
