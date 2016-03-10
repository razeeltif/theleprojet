package Database;
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Base {

	String url = "jdbc:mysql://obiwan.univ-brest.fr/zim1-rouaulul";
	String user = "rouaulul";
	String passwd = "s20jvqq1";
	
	Connection co = null;
	
	public void ouvrir() {
		try {
			co = DriverManager.getConnection(
					url, user, passwd);
			//System.out.println("Base.ouvrir "+url);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(
					"erreur Base.ouvrir "+
							e.getMessage());
			e.printStackTrace();
		}
	}
	
	public void fermer() {
		if (co != null) 
			try {co.close();}catch(Exception e){}
		
	}
}
