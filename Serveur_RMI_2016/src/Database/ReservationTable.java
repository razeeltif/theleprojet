package Database;

import java.sql.PreparedStatement;

public class ReservationTable {

	Base maBase = new Base(); 
	
	public void addResa(int code_Billet, String nom_Anim, int time){
		maBase.ouvrir();
		try {
			String sql = 
			 "INSERT INTO `reservation`(`Code_Billet`, `Nom_Animation`,`Heure_Debut`) VALUES (?,?,?)";
			PreparedStatement ps = maBase.co.prepareStatement(sql);
			ps.setInt(1, code_Billet); // num param
			ps.setString(2, nom_Anim); // num param
			ps.setInt(3, time); // num param
			ps.executeUpdate();
			
			try {ps.close();}catch(Exception e){}
		}
		catch (Exception e) {
			System.out.println("Erreur ReservationTable.addResa "+e.getMessage());
		}

		maBase.fermer();
	}
}
