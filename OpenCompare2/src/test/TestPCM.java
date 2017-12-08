package test;

import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Objects;
import java.util.Scanner;

import org.junit.Test;

import classes.PCM;
import classes.PCMParser;

public class TestPCM {
	@Test
	public void test() throws Exception {
		// Demande de saisie de l'id d'une PCM au clavier
		Scanner sc = new Scanner(System.in);
		System.out.print("ID de la PCM : ");
		String pcmId = sc.nextLine();
		
		// Récupération du JSON correspondant à la PCM qui possède l'id renseigné
		URL url = new URL("https://opencompare.org/api/" + pcmId);
        BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));

        String jsonTxt = in.readLine();
        
        // Transformation du JSON contenu dans jsonTxt en un objet de type PCM
        PCMParser parser1 = new PCMParser(jsonTxt);
        parser1.transformToJavaObject();
        PCM pcm = parser1.getPCMJavaObject();
        
        if (pcm != null) {
        	System.out.println("La PCM n'est pas nulle, on peut donc poursuivre le test");
        	
        	PCM compareTo = pcm;
        	PCMParser parser2;
        	
        	// Pour s'assurer du bon fonctionnement de l'API, on réalise 10 fois l'opération suivante :
        	for (int i = 0; i < 10; i++) {
        		// On récupère le JSON correspondant à l'objet compareTo et on le transforme en objet PCM
	        	parser2 = new PCMParser(compareTo.toJSONObject().toJSONString());
		    	parser2.transformToJavaObject();
		    	// On affecte à compareTo la nouvelle PCM obtenue
		    	compareTo = parser2.getPCMJavaObject();
		    	
		    	// On compare l'objet compareTo à la PCM d'origine
		    	assertTrue(Objects.equals(pcm, compareTo));
        	}
        }
        
        sc.close();
	}
}