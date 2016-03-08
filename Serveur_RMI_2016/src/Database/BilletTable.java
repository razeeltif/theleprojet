package Database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class BilletTable { 

	Base maBase = new Base();
	
	public boolean isValideCode(int codeBillet){
		maBase.ouvrir();
		boolean valideCode = false;
		try {
			String sql = 
			 "select code from billet where code = ?";
			PreparedStatement ps = maBase.co.prepareStatement(sql);
			ps.setInt(1, codeBillet); // num param
			ResultSet rs = ps.executeQuery();
			rs.next();
			if( rs.getInt("code") != 0){
				valideCode = true;
			}
			try {rs.close();}catch(Exception e){}
			try {ps.close();}catch(Exception e){}
			maBase.fermer();
			return valideCode;
		}
		catch (Exception e) {
			System.out.println("Erreur BilletTable.isValideCode "+e.getMessage());
		}

		maBase.fermer();
		return false;
	}
	
	
	
	public boolean isAdmin(int codeBillet){
		maBase.ouvrir();
		boolean admin = false;
		try {
			String sql = 
			 "select isAdmin from billet where code = ?";
			PreparedStatement ps = maBase.co.prepareStatement(sql);
			ps.setInt(1, codeBillet); // num param
			ResultSet rs = ps.executeQuery();
			rs.next();
			admin = rs.getBoolean("isAdmin");
			try {rs.close();}catch(Exception e){}
			try {ps.close();}catch(Exception e){}
			maBase.fermer();
			return admin;
		}
		catch (Exception e) {
			System.out.println("Erreur BilletTable.isAdmin "+e.getMessage());
		}

		maBase.fermer();
		return false;
	}
}
