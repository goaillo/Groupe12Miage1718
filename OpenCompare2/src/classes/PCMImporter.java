package classes;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;

public class PCMImporter {
	
	public String JsonParse(String _fileName) {
		InputStream is;
		String returnValue = "";
		try {
			is = new FileInputStream(this.importFile(_fileName));
			returnValue = IOUtils.toString(is);
		} catch (FileNotFoundException e) {
			System.out.println("ERREUR :  le fichier "+ _fileName +"n'a pas été trouvé");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
		return returnValue;
		
	}
	
	private File importFile(String _fileName){
		return new File("jsonFiles/"+_fileName);
	}
}
