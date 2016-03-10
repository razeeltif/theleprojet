package Database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.mysql.fabric.xmlrpc.base.Array;

import Bean.Horaires;

public class Horaires_AnimationTable {
	Base maBase = new Base();

	public ArrayList<Horaires> getHoraires(String nom_Anim){
		maBase.ouvrir();
		ArrayList<Horaires> res = new ArrayList<Horaires>();
		try {
			String sql = 
			 "select * from Horaires_Animation where Nom_Animation like ?";
			PreparedStatement ps = maBase.co.prepareStatement(sql);
			ps.setString(1, nom_Anim); // num param
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Horaires horTmp = new Horaires();
				horTmp.setNom_anim(rs.getString("Nom_Animation"));
				horTmp.setHeure_Debut(rs.getInt("Heure_Debut"));
				horTmp.setHeure_Debut(rs.getInt("Nb_Places_Restantes"));
				res.add(horTmp);
			}
			try {rs.close();}catch(Exception e){}
			try {ps.close();}catch(Exception e){}
		}
		catch (Exception e) {
			System.out.println("Erreur Horaires_AnimationTable.getNb_Places_Dispo "+e.getMessage());
		}

		maBase.fermer();
		return res;
	}
	
	
	public int getNb_Places_Dispo(String nom_Anim, String time){
		maBase.ouvrir();
		int res = -1;
		try {
			String sql = 
			 "select `Nb_Places_Restantes` from Horaires_Animation where Nom_Animation like ? and Heure_Debut LIKE ?";
			PreparedStatement ps = maBase.co.prepareStatement(sql);
			ps.setString(1, nom_Anim); // num param
			ps.setString(2, time); // num param
			ResultSet rs = ps.executeQuery();
			if(rs.first()){
				res = rs.getInt("Nb_Places_Restantes");
			}
			try {rs.close();}catch(Exception e){}
			try {ps.close();}catch(Exception e){}
		}
		catch (Exception e) {
			System.out.println("Erreur Horaires_AnimationTable.getNb_Places_Dispo "+e.getMessage());
		}

		maBase.fermer();
		return res;
	}
	
	public boolean decrementeNbPlaces(String nom_Anim, String time, int nb_Places_Dec) {
		
		int nb_places = this.getNb_Places_Dispo(nom_Anim, time) -nb_Places_Dec;
		maBase.ouvrir();
		try {
			String sql = 
					"UPDATE Horaires_Animation SET Nb_Places_Restantes = ? WHERE Nom_Animation LIKE ? AND Heure_Debut LIKE ?";
			PreparedStatement ps = maBase.co.prepareStatement(sql);
			ps.setInt(1, nb_places); // num param
			ps.setString(2, nom_Anim); // num param
			ps.setString(3, time); // num param
			ps.executeUpdate();
			try {ps.close();}catch(Exception e){}
		}
		catch (Exception e) {
			System.out.println("Erreur Horaires_AnimationTable.decrementeNbPlaces "+e.getMessage());
			maBase.fermer();
			return false;
		}

		maBase.fermer();
		return true;
	}
	
	public boolean createHorairesAnimation(String nom_Anim, int time){
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
			maBase.fermer();
			return false;
		}

		maBase.fermer();
		return true;
	}
	
	public boolean deleteHorairesAnimation(String nom_Anim, String time){
		maBase.ouvrir();
		try {
			String sql = 
					"DELETE FROM Horaires_Animation WHERE Nom_Animation LIKE ? AND Heure_Debut LIKE ?";
			PreparedStatement ps = maBase.co.prepareStatement(sql);
			ps.setString(1, nom_Anim); // num param
			ps.setString(2, time); // num param
			ps.executeUpdate();
			try {ps.close();}catch(Exception e){}
		}
		catch (Exception e) {
			System.out.println("Erreur Horaires_AnimationTable.deleteHorairesAnimation "+e.getMessage());
			maBase.fermer(); 
			return false;
		}

		maBase.fermer(); 
		return true;
	}
}
