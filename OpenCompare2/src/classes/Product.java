package classes;
import java.util.ArrayList;
import java.util.Collection;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Product implements ConvertibleToJSONObject {
	private String id;
	private Collection<Cell> cells;
	
	public Product(String id, Collection<Cell> cells) {
		super();
		this.id = id;
		this.cells = cells;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public Collection<Cell> getCells() {
		return new ArrayList<Cell>(cells);
	}
	
	public int getCellsCount() {
		return cells.size();
	}
	
	public void setCells(Collection<Cell> cells) {
		this.cells = cells;
	}
	
	public void addCell(Cell cell) {
		cells.add(cell);
	}
	
	public void removeCell(Cell cell) {
		cells.remove(cell);
	}

	@Override
	public JSONObject toJSONObject() {
		JSONObject result = new JSONObject();
		
		result.put("id", id);
		
		JSONArray cellsToJsonArray = new JSONArray();
		
		for (Cell c : cells) {
			cellsToJsonArray.add(c.toJSONObject());
		}
		
		result.put("cells", cellsToJsonArray);
		
		return result;
	}
	
	@Override
	public String toString() {
		return "{\n\t\tid : " + id + ",\n\t\tcells : " + cells + "\n\t}";
	}
}