package classes;

import java.util.ArrayList;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class PCMParser {
	private String jsonString;
	private PCM result;
	
	public PCMParser(String jsonString) {
		this.jsonString = jsonString;
	}

	/**
	 * Transforme jsonString en un objet PCM
	 */
	public void transformToJavaObject() {
		try {
			result = new PCM();
			
			JSONParser parser = new JSONParser();
			
			JSONObject o = (JSONObject) parser.parse(jsonString);
			
			if (o == null || o.containsKey("error")) {
				// Si la PCM a été importée depuis OpenCompare :
				// - un ID non valide renvoie un objet JSON avec un attribut "error"
				// - un ID valide mais non assigné à une PCM renvoie null
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
			// Erreur de parsing, par exemple si le format du JSON n'est pas conforme au format attendu
			e.printStackTrace();
			result = null;
		}
	}
	
	public PCM getPCMJavaObject() {
		return result;
	}
	
	/**
	 * Transforme les caractéristiques contenues dans array en objets de type Feature et renvoie la liste de ces objets Feature
	 * @param array objet de type JSONArray contenant les caractéristiques de la PCM
	 * @return la liste des caractéristiques contenues dans array transformées en objet Feature
	 */
	private ArrayList<Feature> getFeaturesArrayList(JSONArray array) {
		Iterator<JSONObject> it = array.iterator();
		ArrayList<Feature> result = new ArrayList<Feature>();
		
		while (it.hasNext()) {
			JSONObject feature = it.next();
			result.add(new Feature((String) feature.get("id"), (String) feature.get("name"), (String) feature.get("type")));
		}
		
		return result;
	}
	
	/**
	 * Transforme les produits contenus dans array en objets de type Product et renvoie la liste de ces objets Product
	 * @param array objet de type JSONArray contenant les produits de la PCM
	 * @return la liste des produits contenus dans array transformés en objet Product
	 */
	private ArrayList<Product> getProductsArrayList(JSONArray array) {
		Iterator<JSONObject> it = array.iterator();
		ArrayList<Product> result = new ArrayList<Product>();
		
		while (it.hasNext()) {
			JSONObject product = it.next();
			result.add(new Product((String) product.get("id"), getCellsArrayList((JSONArray) product.get("cells"))));
		}
		
		return result;
	}
	
	/**
	 * Transforme les cellules contenues dans array en objets de type Cell et renvoie la liste de ces objets Cell
	 * @param array objet de type JSONArray contenant les cellules d'un produit
	 * @return la liste des cellules contenues dans array transformées en objet Cell
	 */
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
