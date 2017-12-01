package test;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Scanner;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
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
        PCMParser parser = new PCMParser(jsonTxt);
        parser.transformToJavaObject();
        PCM pcm = parser.getPCMJavaObject();
        
        if (pcm != null) {
	        // Récupération d'un objet de type JSONObject correspondant au JSON contenu dans jsonTxt
	        JSONObject compare = (JSONObject) new JSONParser().parse(jsonTxt);
	        
	        // On récupère la représentation de pcm en JSONObject et on la compare à l'objet compare
	        assertEquals(pcm.toJSONObject(), compare);
        }
	}
}