package obj;

import java.util.ArrayList;

public class ListeReservation {
	
	ArrayList<Macouille> listReserv = new ArrayList<Macouille>();
	
	
	
	boolean add(Macouille a){
		
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
	
	ArrayList<Macouille> listerReservation(){
		
		removeAll();
		
		/*appel base de donnee*/
		/*recup info*/
		
		return listReserv;
		
		
	}

	public ArrayList<Macouille> getListReserv() {
		return listReserv;
	}

	public void setListReserv(ArrayList<Macouille> listReserv) {
		this.listReserv = listReserv;
	}

}
