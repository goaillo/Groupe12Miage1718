package classes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class PCM implements ConvertibleToJSONObject {
	private String _id;
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
				String _source, String _author, String _primaryFeatureId, Collection<Feature> _features, Collection<Product> _products ) {
		
		this._id = _id;
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
		return _id;
	}
	
	public void set_id(String _id) {
		this._id = _id;
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
	
	public int getFeaturesCount() {
		return features.size();
	}
	
	public void addFeature(Feature f) {
		if (!features.contains(f)) {
			features.add(f);
		}
	}
	
	/**
	 * Ajoute tous les features de la collection passée en paramètre qui ne sont pas déjà présentes dans les features de la PCM
	 * @param features la liste des features à ajouter
	 */
	public void addFeatures(Collection<Feature> features) {
		for (Feature f : features) {
			addFeature(f);
		}
	}
	
	public void removeFeature(Feature f) {
		features.remove(f);
	}
	
	/**
	 * Supprime des features de la PCM tous les features présentes dans la collection passée en paramètre
	 * @param features la liste des features à supprimer
	 */
	public void removeFeatures(Collection<Feature> features) {
		this.features.removeAll(features);
	}
	
	public void setFeatures(Collection<Feature> _features) {
		this.features = _features;
	}
	
	public Collection<Product> getProducts() {
		return new ArrayList<Product>(products);
	}
	
	public int getProductsCount() {
		return products.size();
	}
	
	public void addProduct(Product p) {
		if (!products.contains(p)) {
			products.add(p);
		}
	}
	
	/**
	 * Ajoute tous les products de la collection passée en paramètre qui ne sont pas déjà présents dans les products de la PCM
	 * @param products la liste des products à ajouter
	 */
	public void addProducts(Collection<Product> products) {
		for (Product p : products) {
			addProduct(p);
		}
	}
	
	public void removeProduct(Product p) {
		products.remove(p);
	}
	
	/**
	 * Supprime des products de la PCM tous les products présents dans la collection passée en paramètre
	 * @param products la liste des products à supprimer
	 */
	public void removeProducts(Collection<Product> products) {
		this.products.removeAll(products);
	}
	
	public void setProducts(Collection<Product> _products) {
		this.products = _products;
	}
	
	@Override
	public JSONObject toJSONObject() {
		JSONObject result = new JSONObject();
		result.put("_id", _id);
		result.put("name", name);
		result.put("featureIdGen", featureIdGen);
		result.put("productIdGen", productIdGen);
		result.put("description", description);
		result.put("license", license);
		result.put("source", source);
		result.put("author", author);
		result.put("primaryFeatureId", primaryFeatureId);
		
		// Features
		JSONArray featuresToJSONArray = new JSONArray();
		
		for (Feature f : features) {
			featuresToJSONArray.add(f.toJSONObject());
		}
		
		result.put("features", featuresToJSONArray);
		
		// Products
		JSONArray productsToJSONArray = new JSONArray();
		
		for (Product p : products) {
			productsToJSONArray.add(p.toJSONObject());
		}
		
		result.put("products", productsToJSONArray);
		
		return result;
	}
	
	@Override
	public boolean equals(Object o) {
		if (o == this) return true;
		if (o == null) return false;
		if (!(o instanceof PCM)) return false;
		
		PCM p = (PCM) o;
		return Objects.equals(p._id, this._id)
				&& Objects.equals(p.name, this.name)
				&& p.featureIdGen == this.featureIdGen
				&& p.productIdGen == this.productIdGen
				&& Objects.equals(p.description, this.description)
				&& Objects.equals(p.license, this.license)
				&& Objects.equals(p.source, this.source)
				&& Objects.equals(p.author, this.author)
				&& Objects.equals(p.primaryFeatureId, this.primaryFeatureId)
				&& p.features.equals(this.features)
				&& p.products.equals(this.products);
	}
	
	@Override
	public String toString() {
		System.err.println("ATTENTION : la représentation suivante n'est pas une représentation JSON de l'objet PCM. Elle permet juste une lecture facile des données de la PCM.\n");
		
		return "{\n\tid : " + _id + ",\n\tname : " + name + ",\n\tfeatureIdGen : " + Long.toString(featureIdGen) + ",\n\tproductIdGen : " + Long.toString(productIdGen) + ",\n\tdescription : " + description + ",\n\tlicense : " + license + ",\n\tsource : " + source + ",\n\tauthor : " + author + ",\n\tprimaryFeatureId : " + primaryFeatureId + ",\n\tfeatures : " + features + ",\n\tproducts : " + products + "\n}";
	}
}