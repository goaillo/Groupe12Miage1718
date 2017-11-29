package classes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class PCMParser {
	private String jsonString;
	private PCM result;
	
	public PCMParser(String jsonString) {
		this.jsonString = jsonString;
	}

	public void transformToJavaObject() {
		try {
			result = new PCM();
			
			JSONParser parser = new JSONParser();
			
			JSONObject o = (JSONObject) parser.parse(jsonString);
			
			if (o == null || o.containsKey("error")) {
				result = null;
			} else {
				result.set_id((String) o.get("_id"));
				result.setName((String) o.get("name"));
				result.setFeatureIdGen((long) o.get("featureIdGen"));
				result.setProductIdGen((long) o.get("productIdGen"));
				result.setDescription((String) o.get("description"));
				result.setLicense((String) o.get("license"));
				result.setSource((String) o.get("source"));
				result.setAuthor((String) o.get("author"));
				result.setPrimaryFeatureId((String) o.get("primaryFeatureId"));
				
				// Features
				result.setFeatures(getFeaturesArrayList((JSONArray) o.get("features")));
	
				// Products
				result.setProducts(getProductsArrayList((JSONArray) o.get("products")));
			}
		} catch (ParseException e) {
			e.printStackTrace();
			result = null;
		}
	}

	public PCM getPCMJavaObject() {
		return result;
	}
	
	private ArrayList<Feature> getFeaturesArrayList(JSONArray array) {
		Iterator<JSONObject> it = array.iterator();
		ArrayList<Feature> result = new ArrayList<Feature>();
		
		while (it.hasNext()) {
			JSONObject feature = it.next();
			result.add(new Feature((String) feature.get("id"), (String) feature.get("name"), (String) feature.get("type")));
		}
		
		return result;
	}
	
	private ArrayList<Product> getProductsArrayList(JSONArray array) {
		Iterator<JSONObject> it = array.iterator();
		ArrayList<Product> result = new ArrayList<Product>();
		
		while (it.hasNext()) {
			JSONObject product = it.next();
			result.add(new Product((String) product.get("id"), getCellsArrayList((JSONArray) product.get("cells"))));
		}
		
		return result;
	}
	
	private ArrayList<Cell> getCellsArrayList(JSONArray array) {
		Iterator<JSONObject> it = array.iterator();
		ArrayList<Cell> result = new ArrayList<Cell>();
		
		while (it.hasNext()) {
			JSONObject cell = it.next();
			result.add(new Cell((String) cell.get("featureId"), (String) cell.get("type"), (boolean) cell.get("isPartial"), (String) cell.get("unit"), (Object) cell.get("value")));
		}
		
		return result;
	}
}
