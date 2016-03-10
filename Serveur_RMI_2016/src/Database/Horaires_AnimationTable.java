package Database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Horaires_AnimationTable {
	Base maBase = new Base();

	public int getNb_Places_Dispo(String nom_Anim, int time){
		maBase.ouvrir();
		int res = -1;
		try {
			String sql = 
			 "select `Nb_Places_Restantes` from Horaires_Animation where Nom_Animation like ? and Heure_Debut = ?";
			PreparedStatement ps = maBase.co.prepareStatement(sql);
			ps.setString(1, nom_Anim); // num param
			ps.setInt(2, time); // num param
			ResultSet rs = ps.executeQuery();
			rs.next();
			res = rs.getInt("Nb_Places_Restantes");
			try {rs.close();}catch(Exception e){}
			try {ps.close();}catch(Exception e){}
		}
		catch (Exception e) {
			System.out.println("Erreur Horaires_AnimationTable.getNb_Places_Dispo "+e.getMessage());
		}

		maBase.fermer();
		return res;
	}
	
	public void decrementeNbPlaces(String nom_Anim, int time) {
		maBase.ouvrir();
		
		int nb_places = this.getNb_Places_Dispo(nom_Anim, time) -1;
		try {
			String sql = 
					"UPDATE Horaires_Animation SET Nb_Places_Restantes = ? WHERE Nom_Animation LIKE ? AND Heure_Debut = ?";
			PreparedStatement ps = maBase.co.prepareStatement(sql);
			ps.setInt(1, nb_places); // num param
			ps.setString(2, nom_Anim); // num param
			ps.setInt(3, time); // num param
			ps.executeUpdate();
			try {ps.close();}catch(Exception e){}
		}
		catch (Exception e) {
			System.out.println("Erreur Horaires_AnimationTable.decrementeNbPlaces "+e.getMessage());
		}

		maBase.fermer(); 
	}
	
	public void createHorairesAnimation(String nom_Anim, int time){
		maBase.ouvrir();
		AnimationTable tabAnim = new AnimationTable();
		int nb_places = tabAnim.getAnim(nom_Anim).getNb_Places();
		try {
			String sql = 
					"INSERT INTO Horaires_Animation (Nom_Animation, Heure_Debut, Nb_Places_Restantes) VALUES (?,?,?)";
			PreparedStatement ps = maBase.co.prepareStatement(sql);
			ps.setString(1, nom_Anim); // num param
			ps.setInt(2, time); // num param
			ps.setInt(3, nb_places); // num param
			ps.executeUpdate();
			try {ps.close();}catch(Exception e){}
		}
		catch (Exception e) {
			System.out.println("Erreur Horaires_AnimationTable.createHorairesAnimation "+e.getMessage());
		}

		maBase.fermer(); 
	}
	
}
