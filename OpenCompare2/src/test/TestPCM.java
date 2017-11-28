package test;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.Test;

import classes.PCM;
import classes.PCMParser;

public class TestPCM {
	@Test
	public void test() throws Exception {
		// Récupération du contenu d'un fichier au format JSON que l'on stocke dans jsonTxt
		InputStream is = new FileInputStream(new File("jsonFiles/premierJson.txt"));
        String jsonTxt = IOUtils.toString(is);
        
        // Transformation du JSON contenu dans jsonTxt en un objet de type PCM
        PCMParser parser = new PCMParser(jsonTxt);
        parser.transformToJavaObject();
        PCM pcm = parser.getPCMJavaObject();
        
        // Récupération d'un objet de type JSONObject correspondant au JSON contenu dans jsonTxt
        JSONObject compare = (JSONObject) new JSONParser().parse(jsonTxt);
        
        // On récupère la représentation de pcm en JSONObject et on la compare à l'objet compare
        assertEquals(pcm.toJSONObject(), compare);
	}
}