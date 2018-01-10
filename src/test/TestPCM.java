package test;

import static org.junit.Assert.assertTrue;

import java.util.Objects;

import org.junit.Test;

import classes.PCM;
import classes.PCMParser;

public class TestPCM {
	@Test
	public void test() throws Exception {
		String jsonTxt = main.Execution.askImportMethod();

		// Transformation du JSON contenu dans jsonTxt en un objet de type PCM
		PCMParser parser1 = new PCMParser(jsonTxt);
		parser1.transformToJavaObject();
		PCM pcm = parser1.getPCMJavaObject();

		if (pcm != null) {
			System.out.println("La PCM n'est pas nulle, on peut donc poursuivre le test");

			PCM compareTo = pcm;
			PCMParser parser2;

			int nbTests = 10;

			// Pour s'assurer du bon fonctionnement de l'API, on réalise nbTests fois l'opération suivante :
			for (int i = 0; i < nbTests; i++) {
				// On récupère le JSON correspondant à l'objet compareTo et on le transforme en objet PCM
				parser2 = new PCMParser(compareTo.toJSONObject().toJSONString());
				parser2.transformToJavaObject();
				// On affecte à compareTo la nouvelle PCM obtenue
				compareTo = parser2.getPCMJavaObject();

				// On compare l'objet compareTo à la PCM d'origine
				assertTrue(Objects.equals(pcm, compareTo));
			}
		}
	}
	
}