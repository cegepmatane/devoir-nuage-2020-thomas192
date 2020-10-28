import java.io.IOException;

import donnee.MoutonDAO;
import modele.Mouton;
import vue.Fenetre;

public class App {

	public static void main(String[] parametres) throws IOException {
		
		MoutonDAO moutonDAO = new MoutonDAO();
		Mouton mouton = new Mouton();
		mouton.setNom("Birdy");
		mouton.setCouleur("Rose");
		mouton.setPoids(64);
		moutonDAO.ajouterMouton(mouton);
		System.out.println(mouton.getNom());
		//Fenetre.launch(Fenetre.class, parametres);	
	}

}
