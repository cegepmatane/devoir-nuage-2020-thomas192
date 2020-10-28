package donnee;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.google.auth.Credentials;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.FirestoreOptions;

public class BaseDeDonnees { //String ID_PROJET = "bergerie-84069";
	private Firestore base = null;
	
	private BaseDeDonnees() throws IOException
	{
		try {
			FileInputStream cle = new FileInputStream("bergerie-84069-firebase-adminsdk-5cs2v-1786aade70.json");
			Credentials credit = GoogleCredentials.fromStream(cle);
			FirestoreOptions options = FirestoreOptions.getDefaultInstance().toBuilder().setCredentials(credit).setProjectId("bergerie-84069").build();
			base = options.getService();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// SINGLETON - DEBUT
	private static BaseDeDonnees instance = null;
	public static BaseDeDonnees getInstance() throws IOException
	{
		if(null == instance) instance = new BaseDeDonnees();
		return instance;
	}
	// SINGLETON - FIN

	public Firestore getBase()
	{
		return this.base;
	}
	
}
