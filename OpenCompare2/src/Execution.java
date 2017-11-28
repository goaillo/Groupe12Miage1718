import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import org.apache.commons.io.IOUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import classes.*;

public class Execution {
	
	public static void main(String[] args) throws Exception{
		InputStream is = new FileInputStream(new File("jsonFiles/premierJson.txt"));
        String jsonTxt = IOUtils.toString(is);
        System.out.println(jsonTxt);
        
        PCMParser p = new PCMParser(jsonTxt);
        p.transformToJavaObject();
        System.out.println(p.getPCMJavaObject().toString());
	}
}
