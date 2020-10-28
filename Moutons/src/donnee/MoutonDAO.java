package donnee;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import com.google.api.core.ApiFuture;
import com.google.auth.Credentials;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.FirestoreOptions;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;

import modele.Mouton;

public class MoutonDAO {
	public static final String SQL_LISTER_MOUTONS = "SELECT * FROM mouton";
	public static final String SQL_DETAILLER_MOUTON = "SELECT * from mouton WHERE id = ?";
	public static final String SQL_AJOUTER_MOUTON = "INSERT into mouton(nom, couleur, poids) VALUES(?,?,?)";
	public static final String SQL_MODIFIER_MOUTON = "";
	public static final String SQL_COMPTER_MOUTON = "SELECT COUNT(*) as nombre from mouton";
	
	public int compterMoutons()
	{	
		return 0;		
	}
	
	public List<Mouton> listerMoutons() throws InterruptedException, ExecutionException, IOException
	{
		Firestore base = BaseDeDonnees.getInstance().getBase();
		
		List<Mouton> moutons = new ArrayList<Mouton>();			
		
		try {
			ApiFuture<QuerySnapshot> demande = base.collection("mouton").get();
			QuerySnapshot resultat = demande.get();
			List<QueryDocumentSnapshot> moutonsNuage = resultat.getDocuments();
			for(QueryDocumentSnapshot moutonNuage : moutonsNuage) {
				String id = moutonNuage.getId();
				String nom = moutonNuage.getString("nom");
				String couleur = moutonNuage.getString("couleur");
				int poids = Math.toIntExact(moutonNuage.getLong("poids"));
				
				Mouton mouton = new Mouton();
				//mouton.setId(id);
				mouton.setNom(nom);
				mouton.setCouleur(couleur);
				mouton.setPoids(poids);
				
				moutons.add(mouton);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return moutons;
	}

	public void ajouterMouton(Mouton mouton)
	{
	}
	
	public Mouton detaillerMouton(int numero)
	{
		Mouton mouton =  new Mouton();			
		
		return mouton;
	}
	
}
