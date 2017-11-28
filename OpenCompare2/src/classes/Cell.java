package classes;

import org.json.simple.JSONObject;

public class Cell implements ConvertibleToJSONObject {
	private String featureId;
	private String type;
	private boolean isPartial;
	private String unit;
	private Object value;
	
	public Cell(String featureId, String type, boolean isPartial, String unit, Object value) {
		super();
		this.featureId = featureId;
		this.type = type;
		this.isPartial = isPartial;
		this.unit = unit;
		this.value = value;
	}
	
	public String getFeatureId() {
		return featureId;
	}
	
	public void setFeatureId(String featureId) {
		this.featureId = featureId;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public boolean isPartial() {
		return isPartial;
	}
	
	public void setPartial(boolean isPartial) {
		this.isPartial = isPartial;
	}
	
	public String getUnit() {
		return unit;
	}
	
	public void setUnit(String unit) {
		this.unit = unit;
	}
	
	public Object getValue() {
		return value;
	}
	
	public void setValue(Object value) {
		this.value = value;
	}
	
	@Override
	public JSONObject toJSONObject() {
		JSONObject result = new JSONObject();
		
		result.put("featureId", featureId);
		result.put("type", type);
		result.put("isPartial", isPartial);
		result.put("unit", unit);
		result.put("value", value);
		
		return result;
	}
	
	@Override
	public String toString() {
		return null;//return "{\n\t\t\tfeatureId : " + featureId + ",\n\t\t\ttype : " + type + ",\n\t\t\tisPartial : " + Boolean.toString(isPartial) + ",\n\t\t\tunit : " + unit + ",\n\t\t\tvalue : " + value + "\n\t\t}";
	}
}