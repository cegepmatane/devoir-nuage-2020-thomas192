package controleur;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

import donnee.MoutonDAO;
import vue.Vue;
import vue.VueTroupeau;

public class Controleur {

	public static Vue selectionnerVuePrincipale() throws InterruptedException, ExecutionException, IOException 
	{
		MoutonDAO dao = new MoutonDAO();
		VueTroupeau.getInstance().afficherNombreMoutons(dao.compterMoutons());
		VueTroupeau.getInstance().afficherListeMoutons(dao.listerMoutons());
		return VueTroupeau.getInstance();
	}

		
}
