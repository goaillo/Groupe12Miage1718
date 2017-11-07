import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import org.apache.commons.io.IOUtils;
import org.json.simple.JSONObject;

public class Execution {
	
	public static void main(String[] args) throws Exception{
		InputStream is = new FileInputStream(new File("jsonFiles/premierJson.txt"));
        String jsonTxt = IOUtils.toString(is);
        System.out.println(jsonTxt);
	}
}
