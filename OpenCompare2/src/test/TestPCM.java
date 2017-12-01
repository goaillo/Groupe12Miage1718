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
		
		// R�cup�ration du JSON correspondant � la PCM qui poss�de l'id renseign�
		URL url = new URL("https://opencompare.org/api/" + pcmId);
        BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));

        String jsonTxt = in.readLine();
        
        // Transformation du JSON contenu dans jsonTxt en un objet de type PCM
        PCMParser parser = new PCMParser(jsonTxt);
        parser.transformToJavaObject();
        PCM pcm = parser.getPCMJavaObject();
        
        if (pcm != null) {
	        // R�cup�ration d'un objet de type JSONObject correspondant au JSON contenu dans jsonTxt
	        JSONObject compare = (JSONObject) new JSONParser().parse(jsonTxt);
	        
	        // On r�cup�re la repr�sentation de pcm en JSONObject et on la compare � l'objet compare
	        assertEquals(pcm.toJSONObject(), compare);
        }
	}
}