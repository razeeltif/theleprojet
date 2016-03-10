package Database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Bean.Groupe;
 
public class GroupeTable {

	Base maBase = new Base();
	
	public Groupe getGroupe(String nom_groupe){
		maBase.ouvrir();
		Groupe groupeTmp = new Groupe();
		try {
			String sql = 
			 "select * from Groupe where Nom_Groupe = ?";
			PreparedStatement ps = maBase.co.prepareStatement(sql);
			ps.setString(1, nom_groupe); // num param
			ResultSet rs = ps.executeQuery();
			if(rs.first()){
				groupeTmp.setNom_groupe(rs.getString("Nom_Groupe"));
				groupeTmp.setDescription(rs.getString("Description"));
			}
			try {rs.close();}catch(Exception e){}
			try {ps.close();}catch(Exception e){}
		}
		catch (Exception e) {
			System.out.println("Erreur GroupeTable.getGroupe "+e.getMessage());
		}

		maBase.fermer(); 
		return groupeTmp;
	}
	
	public ArrayList<Groupe> getAllGroupe(){
		maBase.ouvrir();
		ArrayList<Groupe> listRes = new ArrayList<Groupe>();
		try {
			String sql = 
			 "select * from Groupe";
			PreparedStatement ps = maBase.co.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Groupe groupeTmp = new Groupe();
				groupeTmp.setNom_groupe(rs.getString("Nom_Groupe"));
				groupeTmp.setDescription(rs.getString("Description"));
				listRes.add(groupeTmp);
			}
			try {rs.close();}catch(Exception e){}
			try {ps.close();}catch(Exception e){}
		}
		catch (Exception e) {
			System.out.println("Erreur GroupeTable.getAllGroupe "+e.getMessage());
		}

		maBase.fermer(); 
		return listRes;
	}
	
	public boolean addGroupe(String nom_groupe, String desc){
		maBase.ouvrir();
		try {
			String sql = 
			 "INSERT INTO `Groupe`(`Nom_Groupe`, `Description`) VALUES (?,?)";
			PreparedStatement ps = maBase.co.prepareStatement(sql);
			ps.setString(1, nom_groupe); // num param
			ps.setString(2, desc); // num param
			ps.executeUpdate();
			
			try {ps.close();}catch(Exception e){}
		}
		catch (Exception e) {
			System.out.println("Erreur GroupeTable.addGroupe "+e.getMessage());
			maBase.fermer(); 
			return false;
		}

		maBase.fermer(); 
		return true;
	}
	
	public boolean deleteGroupe(String nom_groupe){
		maBase.ouvrir();
		try {
			String sql = 
			 "DELETE FROM `Groupe` WHERE `Nom_Groupe` LIKE ?";
			PreparedStatement ps = maBase.co.prepareStatement(sql);
			ps.setString(1, nom_groupe); // num param
			ps.executeUpdate();
			try {ps.close();}catch(Exception e){}
		}
		catch (Exception e) {
			System.out.println("Erreur GroupeTable.addGroupe "+e.getMessage());
			maBase.fermer(); 
			return false;
		}

		maBase.fermer(); 
		return true;
	}
}
