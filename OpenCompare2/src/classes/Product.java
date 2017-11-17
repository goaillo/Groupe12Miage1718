package classes;
import java.util.ArrayList;
import java.util.Collection;

public class Product {
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
	public String toString() {
		return "{\n\t\tid : " + id + ",\n\t\tcells : " + cells + "\n\t}";
	}
}