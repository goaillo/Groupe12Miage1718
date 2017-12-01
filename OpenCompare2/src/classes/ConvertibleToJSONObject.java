package classes;

import org.json.simple.JSONObject;

public interface ConvertibleToJSONObject {
	/**
	 * Renvoie un objet JSONObject permettant de v�rifier si la transformation du JSON en objet Java a fonctionn� correctement
	 * @return un objet JSONObject correspondant � this
	 */
	public JSONObject toJSONObject();
}