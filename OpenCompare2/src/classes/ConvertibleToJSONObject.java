package classes;

import org.json.simple.JSONObject;

public interface ConvertibleToJSONObject {
	/**
	 * @return un objet JSONObject correspondant � this
	 */
	public JSONObject toJSONObject();
}
