package Database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Bean.Animation;

public class AnimationTable {

Base maBase = new Base();
	
	public Animation getAnim(String nomAnim){
		maBase.ouvrir();
		Animation validAnim = new Animation();
		try {
			String sql = 
			 "select * from Animation where Nom_Animation like ?";
			PreparedStatement ps = maBase.co.prepareStatement(sql);
			ps.setString(1, nomAnim); // num param
			ResultSet rs = ps.executeQuery();
			rs.next();
			validAnim.setNom_animation(rs.getString("Nom_Animation"));
			validAnim.setDescription(rs.getString("Description"));
			validAnim.setLien_photo(rs.getString("Lien_Photo"));
			validAnim.setDuree(rs.getInt("duree"));
			validAnim.setNb_Places(rs.getInt("Nb_Places"));
			validAnim.setNb_places_Restantes(rs.getInt("Nb_Places_Restantes"));
			validAnim.setGroupe_name(rs.getString("groupe_name"));
			try {rs.close();}catch(Exception e){}
			try {ps.close();}catch(Exception e){}
		}
		catch (Exception e) {
			System.out.println("Erreur AnimationTable.getAnim "+e.getMessage());
		}

		maBase.fermer();
		return validAnim;
	}
	
	public ArrayList<Animation> getAnimByGroupe(String nomGroupe){
		maBase.ouvrir();
		ArrayList<Animation> listRes = new ArrayList<Animation>();
		Animation validAnim = new Animation();
		try {
			String sql = 
			 "select * from Animation where Groupe_Name like ?";
			PreparedStatement ps = maBase.co.prepareStatement(sql);
			ps.setString(1, nomGroupe); // num param
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				validAnim.setNom_animation(rs.getString("Nom_Animation"));
				validAnim.setDescription(rs.getString("Description"));
				validAnim.setLien_photo(rs.getString("Lien_Photo"));
				validAnim.setDuree(rs.getInt("duree"));
				validAnim.setNb_Places(rs.getInt("Nb_Places"));
				validAnim.setNb_places_Restantes(rs.getInt("Nb_Places_Restantes"));
				validAnim.setGroupe_name(rs.getString("groupe_name"));
				listRes.add(validAnim);
			}
			try {rs.close();}catch(Exception e){}
			try {ps.close();}catch(Exception e){}
		}
		catch (Exception e) {
			System.out.println("Erreur AnimationTable.getAnim "+e.getMessage());
		}

		maBase.fermer();
		return listRes;
	}
	
	public ArrayList<Animation> getAllAnim(){
		maBase.ouvrir();
		ArrayList<Animation> listRes = new ArrayList<Animation>();
		Animation validAnim = new Animation();
		try {
			String sql = 
			 "select * from Animation";
			PreparedStatement ps = maBase.co.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				validAnim.setNom_animation(rs.getString("Nom_Animation"));
				validAnim.setDescription(rs.getString("Description"));
				validAnim.setLien_photo(rs.getString("Lien_Photo"));
				validAnim.setDuree(rs.getInt("duree"));
				validAnim.setNb_Places(rs.getInt("Nb_Places"));
				validAnim.setNb_places_Restantes(rs.getInt("Nb_Places_Restantes"));
				validAnim.setGroupe_name(rs.getString("groupe_name"));
				listRes.add(validAnim);
			}
			try {rs.close();}catch(Exception e){}
			try {ps.close();}catch(Exception e){}
		}
		catch (Exception e) {
			System.out.println("Erreur AnimationTable.getAnim "+e.getMessage());
		}

		maBase.fermer();
		return listRes;
	}
	
	public void addAnim(String nom_anim, String desc, String photo, int duree, int nbPlaces, String nom_Groupe){
		maBase.ouvrir();
		try {
			String sql = 
			 "INSERT INTO `animation`(`Nom_Animation`, `Description`, `Lien_Photo`, `duree`, `Nb_Places`, `Nb_Places_Restantes`, `groupe_name`) VALUES (?,?,?,?,?,?,?)";
			PreparedStatement ps = maBase.co.prepareStatement(sql);
			ps.setString(1, nom_anim); // num param
			ps.setString(2, desc); // num param
			ps.setString(3, photo); // num param
			ps.setInt(4, duree); // num param
			ps.setInt(5, nbPlaces); // num param
			ps.setInt(6, nbPlaces); // num param
			ps.setString(7, nom_Groupe); // num param
			ps.executeUpdate();
			
			try {ps.close();}catch(Exception e){}
		}
		catch (Exception e) {
			System.out.println("Erreur AnimationTable.addAnim "+e.getMessage());
		}

		maBase.fermer();
	}
	
	public void deleteAnim(String nom_anim){
		maBase.ouvrir();
		try {
			String sql = 
			 "DELETE FROM `animation` WHERE `Nom_Animation` like ?";
			PreparedStatement ps = maBase.co.prepareStatement(sql);
			ps.setString(1, nom_anim); // num param
			ps.executeUpdate();
			
			try {ps.close();}catch(Exception e){}
		}
		catch (Exception e) {
			System.out.println("Erreur AnimationTable.deleteAnim "+e.getMessage());
		}

		maBase.fermer();
	}
	
	public void updateAnim(String nom_anim, ArrayList<String> champ, ArrayList<String> val){
		maBase.ouvrir();
		int i;
		try {
			String sql = 
			 "UPDATE `animation` SET ";
			for(i = 0; i < champ.size(); i++){
				sql += "`"+champ.get(i)+"` = ? ";
			}
			sql += "WHERE `Nom_Animation` = ?;";
			PreparedStatement ps = maBase.co.prepareStatement(sql);
			for(i = 0; i < val.size(); i++){
				ps.setString(i, val.get(i)); // num param
			}
			ps.setString(i+1, nom_anim);
			ps.executeUpdate();
			
			try {ps.close();}catch(Exception e){}
		}
		catch (Exception e) {
			System.out.println("Erreur AnimationTable.updateAnim "+e.getMessage());
		}

		maBase.fermer();
	}
	
	
}
