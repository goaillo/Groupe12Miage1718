package classes;

import org.json.simple.JSONObject;

public interface ConvertibleToJSONObject {
	/**
	 * Renvoie un objet JSONObject permettant de vérifier si la transformation du JSON en objet Java a fonctionné correctement
	 * @return un objet JSONObject correspondant à this
	 */
	public JSONObject toJSONObject();
}