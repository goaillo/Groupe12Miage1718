package classes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import org.apache.commons.io.IOUtils;

public class PCMImporter {
	/*public String JsonParse(String fileName) {
		InputStream is;
		String returnValue = "";
		
		try {
			is = new FileInputStream(this.importFromFile(fileName));
			returnValue = IOUtils.toString(is);
		} catch (FileNotFoundException e) {
			System.out.println("ERREUR :  le fichier "+ fileName +" n'a pas été trouvé");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
		return returnValue;
	}*/
	
	/**
	 * @param file le fichier à importer (le fichier doit se trouver dans le dossier jsonFiles)
	 * @return le contenu du fichier jsonFiles/{fileName}, ou null si une erreur se produit
	 */
	public String importFromFile(File file) {
		try {
			return IOUtils.toString(new FileInputStream(file));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	/**
	 * @param fileName le nom du fichier à importer (le fichier doit se trouver dans le dossier jsonFiles)
	 * @return le contenu du fichier jsonFiles/{fileName}, ou null si une erreur se produit
	 */
	public String importFromFile(String fileName){
		return importFromFile(new File("jsonFiles/" + fileName));
	}
	
	/**
	 * @param pcmId l'ID de la PCM à importer depuis le site opencompare.org
	 * @return le contenu de la page Web à l'adresse https://opencompare.org/api/{pcmId}, ou null si une erreur se produit
	 */
	public String importFromOpenCompare(String pcmId) {
		try {
			URL url = new URL("https://opencompare.org/api/" + pcmId);
	        BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
	        String result = "", nextLine;
	        
	        while ((nextLine = in.readLine()) != null) {
	        	result += nextLine;
	        }
	        
	        return result;
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
