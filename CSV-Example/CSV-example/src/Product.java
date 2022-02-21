
public class Product {

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//	}
	public String productName;
	public int uniqueId;
	public int price;
//	public String[] ingredients = new String[10];
	public String ingredients;
//	public String[] allergens = new String[10];
	public String allergens;
	public int dimensions;
	public String foodCategories = "";
	// { "Wrap", "Salad", "Drink", "Dessert" };
	public int nutrition; // in calories
//	public String[] size = { "Small", "Medium", "Large" };
	public String size;

	public Product(String productName, int uniqueId, int price, String ingredients, String allergens, int dimensions,
			String foodCategories, int nutrition, String size) {
		this.productName = productName;
		this.uniqueId = uniqueId;
		this.price = price;
		this.ingredients = ingredients;
		this.allergens = allergens;
		this.dimensions = dimensions;
		this.foodCategories = foodCategories;
		this.nutrition = nutrition;
		this.size = size;

	}

	public Product() {
		super();
	}

	public String getProductName() {
		return this.productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getUniqueID() {
		return this.uniqueId;
	}

	public void setUniqueID(int uniqueId) {
		this.uniqueId = uniqueId;
	}

	public int getPrice() {
		return this.price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getIngredients() {
		return this.ingredients;
	}

	public void setIngredients(String ingredients) {
		this.ingredients = ingredients;
	}

	public String getAllergens() {
		return this.allergens;
	}

	public void setAllergens(String allergens) {
		this.allergens = allergens;
	}

	public int getDimensions() {
		return this.dimensions;
	}

	public void setDimensions(int dimensions) {
		this.dimensions = dimensions;
	}

	public String getFoodCategories() {
		return this.foodCategories;
	}

	public void setFoodCategories(String foodCategories) {
		this.foodCategories = foodCategories;
	}

	public int getNutrition() {
		return this.nutrition;
	}

	public void setNutrition(int nutrition) {
		this.nutrition = nutrition;
	}

	public String getSize() {
		return this.size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	@Override
	public String toString() {
		return "Product [productName=" + productName + ", uniqueId=" + uniqueId + ", price=" + price + ", ingredients="
				+ ingredients + ", allergens=" + allergens + ", dimensions=" + dimensions + ", foodCategories="
				+ foodCategories + ", nutrition=" + nutrition + ", size=" + size + "]";
	}
	
	

}
