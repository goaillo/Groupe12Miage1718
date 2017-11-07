package classes;

import java.util.Collection;
import java.util.ArrayList;
import java.util.Collection;

public class PCM {
	private String id;
	private String name;
	private int featureIdGen;
	private int productIdGen;
	private String description;
	private String license;
	private String source;
	private String author;
	private String primaryFeatureId;
	private Collection<Feature> features;
	private Collection<Product> products;
	
	public PCM (String _id, String _name, int _featureIdGen, int _productIdGen, String _description, String _license,
				String _source, String _author, String _primaryFeatureId, Collection<Feature> _features, Collection<Product> _products ){
		
		this.id = _id;
		this.name = _name;
		this.featureIdGen = _featureIdGen;
		this.productIdGen = _productIdGen;
		this.description = _description;
		this.license = _license;
		this.source = _source;
		this.author = _author;
		this.primaryFeatureId = _primaryFeatureId;
		this.features = _features;
		this.products = _products;
		
	}
	public String get_id() {
		return id;
	}
	public void set_id(String _id) {
		this.id = _id;
	}
	public String getName() {
		return name;
	}
	public void setName(String _name) {
		this.name = _name;
	}
	public int getFeatureIdGen() {
		return featureIdGen;
	}
	public void setFeatureIdGen(int _featureIdGen) {
		this.featureIdGen = _featureIdGen;
	}
	public int getProductIdGen() {
		return productIdGen;
	}
	public void setProductIdGen(int _productIdGen) {
		this.productIdGen = _productIdGen;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String _description) {
		this.description = _description;
	}
	public String getLicense() {
		return license;
	}
	public void setLicense(String _license) {
		this.license = _license;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String _source) {
		this.source = _source;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String _author) {
		this.author = _author;
	}
	public String getPrimaryFeatureId() {
		return primaryFeatureId;
	}
	public void setPrimaryFeatureId(String _primaryFeatureId) {
		this.primaryFeatureId = _primaryFeatureId;
	}
	public Collection<Feature> getFeatures() {
		return new ArrayList<Feature>(features);
	}
	public void setFeatures(Collection<Feature> _features) {
		this.features = _features;
	}
	public Collection<Product> getProducts() {
		return new ArrayList<Product>(products);
	}
	public void setProducts(Collection<Product> _products) {
		this.products = _products;
	}

}