package classes;

import org.json.simple.JSONObject;

public interface ConvertibleToJSONObject {
	/**
	 * @return un objet JSONObject correspondant à this
	 */
	public JSONObject toJSONObject();
}
