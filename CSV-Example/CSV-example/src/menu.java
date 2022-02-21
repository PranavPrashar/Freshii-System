import java.util.ArrayList;

public class menu {
	
	ArrayList<Product> menuProducts = new ArrayList<Product>();
	String productName = "";
	
	int price =0;
	
	String ingredients = "";
	String allergens = "";
	
	String foodCategories = "";
	
	String itemSize = "";
	
	
	
	public menu(String productName, int price, String ingredients, String allergens, String foodCategories, String itemSize ) {
		this.productName = productName;
		this.price = price;
		this.ingredients = ingredients;
		this.allergens = allergens;
		this.foodCategories = foodCategories;
		this.itemSize = itemSize;
	}
	
	public String getProductName() {
		return this.productName;
	}
	
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	public int getProductPrice() {
		return this.price;
	}
	
	public void setProductPrice(int price) {
		this.price = price;
	}
	
	public String getProductIngredients() {
		return this.ingredients;
	}
	
	public void setProductIngredients(String ingredients ) {
		this.ingredients = ingredients;
		
		
	}
	
	public String getProductAllergens() {
		return this.allergens;
	}
	public void setProductAllergens(String allergens) {
		this.allergens = allergens;
	}
	
	public String getFoodCategories() {
		return this.foodCategories;
	}
	
	public void setFoodCategories(String foodCategories ) {
		this.foodCategories = foodCategories;
	}
	public String getItemSize() {
		return this.itemSize;
	}
	
	public void setItemSize(String itemSize) {
		this.itemSize = itemSize;
	}
}
