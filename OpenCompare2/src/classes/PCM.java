package classes;

import java.util.Collection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class PCM {
	private String id;
	private String name;
	private long featureIdGen;
	private long productIdGen;
	private String description;
	private String license;
	private String source;
	private String author;
	private String primaryFeatureId;
	private Collection<Feature> features;
	private Collection<Product> products;
	
	public PCM() {}
	
	public PCM (String _id, String _name, long _featureIdGen, long _productIdGen, String _description, String _license,
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
	public long getFeatureIdGen() {
		return featureIdGen;
	}
	public void setFeatureIdGen(long _featureIdGen) {
		this.featureIdGen = _featureIdGen;
	}
	public long getProductIdGen() {
		return productIdGen;
	}
	public void setProductIdGen(long _productIdGen) {
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
	
	@Override
	public String toString() {
		return "id:"+id+"\nname:"+name+"\nfeatureIdGen:"+Long.toString(featureIdGen)+"\nproductIdGen:"+Long.toString(productIdGen)+"\ndescription:"+description+"\nlicense:"+license+"\nsource:"+source+"\nprimaryFeatureId:"+primaryFeatureId;
	}

}