package classes;

import org.json.simple.JSONObject;

public class Feature implements ConvertibleToJSONObject {
	private String id;
	private String name;
	private String type;
	
	public Feature(String id, String name, String type) {
		this.id = id;
		this.name = name;
		this.type = type;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	@Override
	public JSONObject toJSONObject() {
		JSONObject result = new JSONObject();
		
		result.put("id", id);
		result.put("name", name);
		result.put("type", type);
		
		return result;
	}
	
	@Override
	public boolean equals(Object o) {
		if (o == this) return true;
		if (o == null) return false;
		if (!(o instanceof Feature)) return false;
		
		Feature f = (Feature) o;
		return f.id.equals(this.id) && f.name.equals(this.name) && f.type.equals(this.type);
	}
	
	@Override
	public String toString() {
		return "{\n\t\tid : " + id + ",\n\t\tname : " + name + ",\n\t\ttype : " + type + "\n\t}";
	}
}