import java.util.ArrayList;
import java.util.Collection;

public class Product {
	private String id;
	private Collection<Cell> cells;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Collection<Cell> getCells() {
		return new ArrayList<Cell>(cells);
	}
	public void setCells(Collection<Cell> cells) {
		this.cells = cells;
	}
	
	
}