import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Scanner;

import org.apache.commons.io.IOUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import classes.*;

public class Execution {	
	public static void main(String[] args) throws Exception {
		// Affichage d'un menu de choix pour l'import de la PCM
		System.out.println("Menu :");
		System.out.println("1 - Importer depuis un fichier local");
		System.out.println("2 - Importer depuis OpenCompare");

		int choix = 0;
		Scanner sc = new Scanner(System.in);

		while (choix < 1 || choix > 2) {
			System.out.print("Votre choix : ");
			try {
				choix = Integer.valueOf(sc.nextLine());
			} catch (Exception e) {
				choix = 0;
			}

			if (choix < 1 || choix > 2) {
				System.out.println("Merci d'entrer une valeur valide.");
			}
		}
		
		PCMImporter importer = new PCMImporter();
		String json = null;

		switch (choix) {
		case 1: // Import depuis un fichier local			
			// Demande de saisie du nom du fichier
			System.out.print("Nom du fichier : ");
			String _fileName = sc.nextLine();
			
			// Stockage du JSON dans la variable json
			json = importer.importFromFile(_fileName);
			break;
		case 2: // Import depuis OpenCompare
			// Demande de saisie de l'ID de la PCM
			System.out.print("ID de la PCM : ");
			String pcmId = sc.nextLine();
			
			// Stockage du JSON dans la variable json
			json = importer.importFromOpenCompare(pcmId);
			break;
		}

		// Parsing du json en objet PCM
        PCMParser p = new PCMParser(json);
        p.transformToJavaObject();
        
        // Affichage de l'objet PCM sous un format facilement lisible par une personne
        // Pour afficher le JSON correspondant à l'objet PCM, utiliser la fonction p.getPCMJavaObject().toJSONObject().toJSONString()
        System.out.println(p.getPCMJavaObject());
        
        // Fermeture du scanner
		sc.close();
	}
}