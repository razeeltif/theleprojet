package Database;

import java.util.ArrayList;

import Bean.Animation;
 
public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		AnimationTable testAnim = new AnimationTable();
		Animation res_Anim;
		ArrayList<Animation> list_res_Anim;
		BilletTable testBillet = new BilletTable();
		
		if(testBillet.isAdmin(6)){
			System.out.println("Je suis Admin");
		}else{

			System.out.println("Je ne suis pas Admin");
		}
		
		if(testBillet.isValideCode(6)){
			System.out.println("Je suis un bon code");
		}else{

			System.out.println("Je ne suis pas un bon code");
		}
		
		res_Anim = testAnim.getAnim("Titanic");
		System.out.println(res_Anim.getGroupe_name());
		
		list_res_Anim = testAnim.getAnimByGroupe("bobato");
		System.out.println(list_res_Anim.size()+" bobatos");
		
		list_res_Anim = testAnim.getAllAnim();
		System.out.println(list_res_Anim.size()+" anims");
		

		res_Anim = testAnim.getAnim("Belem");
		System.out.println(res_Anim.getNom_animation());
		
		testAnim.deleteAnim("Belem");
		

		res_Anim = testAnim.getAnim("Belem");
		System.out.println(res_Anim.getNom_animation());
		
		testAnim.addAnim("Belem", "tretretre bobato", "bobato", 60, 50, "bobato");
		res_Anim = testAnim.getAnim("Belem");
		System.out.println(res_Anim.getNom_animation());
		System.out.println(res_Anim.getDuree());
		
		ArrayList<String> champs = new ArrayList<String>();
		champs.add("duree");

		ArrayList<String> vals = new ArrayList<String>();
		vals.add("120");
		
		testAnim.updateAnim("Belem", champs, vals);
		res_Anim = testAnim.getAnim("Belem");
		System.out.println(res_Anim.getNom_animation());
		System.out.println(res_Anim.getDuree());
		
		
		
	}

}
