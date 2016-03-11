package Database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Bean.Reservation;
 
public class ReservationTable {

	Base maBase = new Base();
	
	public ArrayList<Reservation> getResa(int code_Billet){
		maBase.ouvrir();
		ArrayList<Reservation> listResa = new ArrayList<Reservation>();
		try {
			String sql = 
			 "SELECT * FROM `Reservation` WHERE `Code_Billet` LIKE ?";
			PreparedStatement ps = maBase.co.prepareStatement(sql);
			ps.setInt(1, code_Billet); // num param
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Reservation resaTmp = new Reservation();
				resaTmp.setCode_Billet(rs.getInt("Code_Billet"));
				resaTmp.setNom_Animation(rs.getString("Nom_Animation"));
				resaTmp.setTime(rs.getString("Heure_Debut"));
				listResa.add(resaTmp);
			}
			try {rs.close();}catch(Exception e){}
			try {ps.close();}catch(Exception e){}
		}
		catch (Exception e) {
			System.out.println("Erreur ReservationTable.getResa "+e.getMessage());
		}

		maBase.fermer();
		return listResa;
	}
	
	public int addResa(int code_Billet, String nom_Anim, String time){
		maBase.ouvrir();
		int i=0;
		try {
			String sql = 
			 "INSERT INTO `Reservation`(`Code_Billet`, `Nom_Animation`,`Heure_Debut`) VALUES (?,?,?)";
			PreparedStatement ps = maBase.co.prepareStatement(sql);
			ps.setInt(1, code_Billet); // num param
			ps.setString(2, nom_Anim); // num param
			ps.setString(3, time); // num param
			i=ps.executeUpdate();
			try {ps.close();}catch(Exception e){}
		}
		catch (Exception e) {
			System.out.println("Erreur ReservationTable.addResa "+e.getMessage());
			maBase.fermer();
			return -1;
		}

		maBase.fermer();
		return i;
	}
	
	public int deleteResa(String code_Billet, String nom_Anim, String time){
		maBase.ouvrir();
		int i=0;
		try {
			String sql = 
					"DELETE FROM Reservation WHERE Code_Billet LIKE ? AND Nom_Animation LIKE ? AND Heure_Debut LIKE ?";
			PreparedStatement ps = maBase.co.prepareStatement(sql);
			ps.setString(1, code_Billet); // num param
			ps.setString(2, nom_Anim); // num param
			ps.setString(3, time); // num param
			i=ps.executeUpdate();
			try {ps.close();}catch(Exception e){}
		}
		catch (Exception e) {
			System.out.println("Erreur ReservationTable.deleteResaByAnim "+e.getMessage());
			maBase.fermer();
			return -1;
		}

		maBase.fermer();
		System.out.println(i);
		return i;
	}
}
