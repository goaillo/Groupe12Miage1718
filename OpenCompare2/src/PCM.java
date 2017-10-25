
import java.util.Collection;
import java.util.ArrayList;
import java.util.Collection;

public class PCM {
	private String _id;
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
	public String get_id() {
		return _id;
	}
	public void set_id(String _id) {
		this._id = _id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getFeatureIdGen() {
		return featureIdGen;
	}
	public void setFeatureIdGen(int featureIdGen) {
		this.featureIdGen = featureIdGen;
	}
	public int getProductIdGen() {
		return productIdGen;
	}
	public void setProductIdGen(int productIdGen) {
		this.productIdGen = productIdGen;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getLicense() {
		return license;
	}
	public void setLicense(String license) {
		this.license = license;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPrimaryFeatureId() {
		return primaryFeatureId;
	}
	public void setPrimaryFeatureId(String primaryFeatureIyd) {
		this.primaryFeatureId = primaryFeatureId;
	}
	public Collection<Feature> getFeatures() {
		return new ArrayList<Feature>(features);
	}
	public void setFeatures(Collection<Feature> features) {
		this.features = features;
	}
	public Collection<Product> getProducts() {
		return new ArrayList<Product>(products);
	}
	public void setProducts(Collection<Product> products) {
		this.products = products;
	}
public void testCommit() {
		return;
	}
}