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
		Scanner sc = new Scanner(System.in);
		System.out.print("ID de la PCM : ");
		String pcmId = sc.nextLine();
		URL url = new URL("https://opencompare.org/api/" + pcmId);
        BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));

        String jsonTxt = in.readLine();
        System.out.println(jsonTxt);
        
        PCMParser p = new PCMParser(jsonTxt);
        p.transformToJavaObject();
        System.out.println(p.getPCMJavaObject());
	}
}
