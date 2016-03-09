package Database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Bean.Groupe;
 
public class GroupeTable {

	Base maBase = new Base();
	
	public Groupe getGroupe(String nom_groupe){
		Groupe groupeTmp = new Groupe();
		try {
			String sql = 
			 "select * from Groupe where Nom_Groupe like ?";
			PreparedStatement ps = maBase.co.prepareStatement(sql);
			ps.setString(1, nom_groupe); // num param
			ResultSet rs = ps.executeQuery();
			rs.next();
			groupeTmp.setNom_groupe(rs.getString("Nom_Groupe"));
			groupeTmp.setDescription(rs.getString("Description"));
			try {rs.close();}catch(Exception e){}
			try {ps.close();}catch(Exception e){}
		}
		catch (Exception e) {
			System.out.println("Erreur GroupeTable.getGroupe "+e.getMessage());
		}
		
		return groupeTmp;
	}
	
	public ArrayList<Groupe> getAllGroupe(){
		ArrayList<Groupe> listRes = new ArrayList<Groupe>();
		Groupe groupeTmp = new Groupe();
		try {
			String sql = 
			 "select * from Groupe";
			PreparedStatement ps = maBase.co.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
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
		
		return listRes;
	}
	
	public void addGroupe(String nom_groupe, String desc){
		maBase.ouvrir();
		try {
			String sql = 
			 "INSERT INTO `Groupe`(`Nom_Animation`, `Description`) VALUES (?,?)";
			PreparedStatement ps = maBase.co.prepareStatement(sql);
			ps.setString(1, nom_groupe); // num param
			ps.setString(2, desc); // num param
			ps.executeUpdate();
			
			try {ps.close();}catch(Exception e){}
		}
		catch (Exception e) {
			System.out.println("Erreur GroupeTable.addGroupe "+e.getMessage());
		}

		maBase.fermer();
	}
}
