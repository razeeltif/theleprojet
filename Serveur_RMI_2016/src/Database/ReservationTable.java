package Database;

import java.sql.PreparedStatement;
 
public class ReservationTable {

	Base maBase = new Base();
	
	public void addResa(int code_Billet, String nom_Anim, int time){
		maBase.ouvrir();
		try {
			String sql = 
			 "INSERT INTO `Reservation`(`Code_Billet`, `Nom_Animation`,`Heure_Debut`) VALUES (?,?,?)";
			PreparedStatement ps = maBase.co.prepareStatement(sql);
			ps.setInt(1, code_Billet); // num param
			ps.setString(2, nom_Anim); // num param
			ps.setInt(3, time); // num param
			ps.executeUpdate();
			/*
			sql = "UPDATE `Horaires_Animation` SET `Nb_Places_Restantes` "
					+"= ((SELECT `Nb_Places_Restantes` FROM `Horaires_Animation` "
					+"WHERE `Nom_Animation` like ? and `Heure_Debut` = ?) - 1) "
					+"WHERE `Nom_Animation` like ? and `Heure_Debut` = ?";
			ps = maBase.co.prepareStatement(sql);
			ps.setString(1, nom_Anim); // num param
			ps.setInt(2, time); // num param
			System.out.println(ps.toString());
			*/
			try {ps.close();}catch(Exception e){}
		}
		catch (Exception e) {
			System.out.println("Erreur ReservationTable.addResa "+e.getMessage());
		}

		maBase.fermer();
	}
}
