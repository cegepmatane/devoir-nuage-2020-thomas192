/*
package donnee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modele.Mouton;

public class MoutonDAOPostgreSQL {
	
	public static final String SQL_LISTER_MOUTONS = "SELECT * FROM mouton";
	public static final String SQL_DETAILLER_MOUTON = "SELECT * from mouton WHERE id = ?";
	public static final String SQL_AJOUTER_MOUTON = "INSERT into mouton(nom, couleur, poids) VALUES(?,?,?)";
	public static final String SQL_MODIFIER_MOUTON = "";
	public static final String SQL_COMPTER_MOUTON = "SELECT COUNT(*) as nombre from mouton";
	
	public int compterMoutons()
	{
		Connection connection = BaseDeDonnees.getInstance().getConnection();
		
		Statement requete;
		try {
			requete = connection.createStatement();
			ResultSet curseur = requete.executeQuery(SQL_COMPTER_MOUTON);
			if(curseur.next())
			{
				int nombre = curseur.getInt("nombre");
				return nombre;
			}
		} catch (SQLException e) {
				e.printStackTrace();
		}
		
		return 0;		
	}
	
	public List<Mouton> listerMoutons()
	{
		Connection connection = BaseDeDonnees.getInstance().getConnection();
		
		List<Mouton> moutons =  new ArrayList<Mouton>();			
		Statement requete;
		try {
			requete = connection.createStatement();
			ResultSet curseur = requete.executeQuery(SQL_LISTER_MOUTONS);
			while(curseur.next())
			{
				int id = curseur.getInt("id");
				String nom = curseur.getString("nom");
				String couleur = curseur.getString("couleur");
				double poids = curseur.getDouble("poids");
				Mouton mouton = new Mouton();
				mouton.setId(id);
				mouton.setNom(nom);
				mouton.setCouleur(couleur);
				mouton.setPoids(poids);
				moutons.add(mouton);
			}
		} catch (SQLException e) {
				e.printStackTrace();
		}
		
		return moutons;
	}

	public void ajouterMouton(Mouton mouton)
	{
		Connection connection = BaseDeDonnees.getInstance().getConnection();
		
		System.out.println("MoutonDAO.ajouterMouton()");
		try {
			PreparedStatement requete = connection.prepareStatement(SQL_AJOUTER_MOUTON);
			requete.setString(1, mouton.getNom());
			requete.setString(2, mouton.getCouleur());
			requete.setDouble(3, mouton.getPoids());
			
			requete.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Mouton detaillerMouton(int numero)
	{
		Connection connection = BaseDeDonnees.getInstance().getConnection();
		
		Mouton mouton =  new Mouton();			
		PreparedStatement requete;
			try {
				requete = connection.prepareStatement(SQL_DETAILLER_MOUTON);
				requete.setInt(1, numero);
				
				ResultSet curseurCollection = requete.executeQuery();
				curseurCollection.next();
				int id = curseurCollection.getInt("id");
				String nom = curseurCollection.getString("nom");
				String couleur = curseurCollection.getString("couleur");
				double poids = curseurCollection.getDouble("poids");
				mouton.setId(id);
				mouton.setNom(nom);
				mouton.setCouleur(couleur);
				mouton.setPoids(poids);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
		return mouton;
	}
	
}
*/