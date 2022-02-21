import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;

public class searchCLI {
	public static Scanner scanner = new Scanner(System.in);

	static boolean value = true;

	static ArrayList<Product> products = new ArrayList<Product>();
	static ArrayList<Order> orders = new ArrayList<Order>();

	public static String path = "menu.csv";
	public static String path2 = "orders.csv";

	public static int input1;// 1 or 2 ....
	public static String input2 = ""; // Search type, Name or Group
	public static String input3; // group to search(Wrap, Salad, Drink, Dessert)
	public static String input4;
	public static Boolean bValue = true;
	public static String name;
	public static String clientPhoneNumber;
	public static String clientAddress;
	public static String exitString;
	
	public static String managerMenuInput;
	public static String updateInput;

	
	//Edit Menu
	public static String mEdit_productName,mEdit_uniqueId,mEdit_price,mEdit_ingredients,mEdit_allergens,mEdit_dimensions,mEdit_foodCategories,mEdit_nutrition,mEdit_size;
	
	
	//
	public static void main(String args[]) throws Exception {
		loadMenu(path);
		step1();

		searchCLI value = new searchCLI();
		value.loadMenu(path);

	}

	public static void loadMenu(String path) throws Exception {
		CsvReader reader = new CsvReader(path);
		reader.readHeaders();

		while (reader.readRecord()) {
			Product product = new Product();
			// user.setName(reader.get("name"));
			product.setProductName(reader.get("productName"));
			// user.setId(Integer.valueOf(reader.get("id")));
			product.setUniqueID(Integer.valueOf(reader.get("uniqueId")));
			product.setPrice(Integer.valueOf(reader.get("price")));
			product.setIngredients(reader.get("ingredients"));
			product.setAllergens(reader.get("allergens"));
			product.setDimensions(Integer.valueOf(reader.get("dimensions")));
			product.setFoodCategories(reader.get("foodCategories"));
			product.setNutrition(Integer.valueOf(reader.get("nutrition")));
			product.setSize(reader.get("size"));
			products.add(product);

		}

//		for(int i =0 ; i < products.size() ;i ++) {
//			System.out.println(products.get(i));
//		}

	}

	public void updateMenu(String path) throws Exception {
		try {
			CsvWriter csvOutput = new CsvWriter(new FileWriter(path, false), ',');
			csvOutput.write("productName");
			csvOutput.write("uniqueId");
			csvOutput.write("price");
			csvOutput.write("ingredients");
			csvOutput.write("allergens");
			csvOutput.write("dimensions");
			csvOutput.write("foodCategories");
			csvOutput.write("nutrition");
			csvOutput.write("size");
			csvOutput.endRecord();

			for (Product p : products) {
				csvOutput.write(p.getProductName());
				csvOutput.write(String.valueOf(p.getUniqueID()));
				csvOutput.write(String.valueOf(p.getPrice()));
				csvOutput.write(p.getIngredients());
				csvOutput.write(p.getAllergens());
				csvOutput.write(String.valueOf(p.getDimensions()));
				csvOutput.write(p.getFoodCategories());
				csvOutput.write(String.valueOf(p.getNutrition()));
				csvOutput.write(p.getSize());
			}
			csvOutput.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void loadOrders(String path) throws Exception {
		CsvReader reader = new CsvReader(path);
		reader.readHeaders();

		while (reader.readRecord()) {
			Order order = new Order();
			// user.setName(reader.get("name"));
			order.setOrderNumber(Integer.valueOf(reader.get("orderNumber")));
			order.setclientUserId(Integer.valueOf(reader.get("clientUserId")));
			order.setclientName(reader.get("clientName"));
			order.setOrderItems(reader.get("orderItems"));
			order.setOrderStatus(reader.get("orderStatus"));
			order.setOrderTotal(Integer.valueOf(reader.get("orderTotal")));
			order.setdeliveryLocation(reader.get("deliveryLocation"));
			order.setclientPhoneNumber(reader.get("clientPhoneNumber"));
			orders.add(order);

		}

		for (int i = 0; i < orders.size(); i++) {
			System.out.println(orders.get(i));
		}
	}

	public static void updateOrders(String path) {
		try {
			CsvWriter csvOutputOrders = new CsvWriter(new FileWriter(path, false), ',');
			csvOutputOrders.write("orderNumber");
			csvOutputOrders.write("clientUserId");
			csvOutputOrders.write("clientName");
			csvOutputOrders.write("orderItems");
			csvOutputOrders.write("orderStatus");
			csvOutputOrders.write("orderTotal");
			csvOutputOrders.write("deliveryLocation");
			csvOutputOrders.write("clientPhoneNumber");
			csvOutputOrders.endRecord();

			for (Order o : orders) {
				csvOutputOrders.write(String.valueOf(o.getOrderNumber()));
				csvOutputOrders.write(String.valueOf(o.getClientUserID()));
				csvOutputOrders.write(o.getclientName());
				csvOutputOrders.write(o.getOrderItems());
				csvOutputOrders.write(o.getOrderStatus());
				csvOutputOrders.write(String.valueOf(o.getOrderTotal()));
				csvOutputOrders.write(o.getdeliveryLocation());
				csvOutputOrders.write(o.getclientPhoneNumber());
				csvOutputOrders.endRecord();
			}
			csvOutputOrders.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String printMenu(String foodCat) {
		String output = "";
		for (Product p : products) {
			if (p.getFoodCategories().equals(foodCat)) {
				System.out.println(p + "\n");
				output = p.toString();
			}
		}
		return output;

	}

	public static void step1() throws Exception {
		System.out.println("Welcome to the Freshii ordering system \n\n");
		System.out.println("Search by Name: Enter 1" + "\n" + "Search by Group(Wrap, Salad, Drink, Dessert): Enter 2 ");

		input1 = scanner.nextInt();

		// System.out.println(input1);

		if (input1 == 1) {// search by name
			System.out.print("please enter item to search: \n");
			input2 = scanner.next();
			for (Product p : products) {
				if (input2.equals(p.getProductName())) {
					System.out.println("true");
				} else {
					System.out.println("false");
				}
			}

		} else if (input1 == 2) {
			System.out.print("please enter group to search: \n");
			input3 = scanner.next();
//			System.out.println(input3);

			if (input3.equals("wrap")) {
				System.out.println("The Wrap menu is: \n");

				printMenu("wrap");
//				String size = scanner.next();

				for (Product p : products) {
					if (p.getFoodCategories().equals("wrap")) {
//						System.out.println(p + "\n");
						System.out.print("Select size of wrap (Small, Medium, Large): ");
						input4 = scanner.next();

//						
						if (input4.equals("small")) {
							System.out.println("small");
						} else if (input4.equals("medium")) {
							System.out.println("medium");
						} else if (input4.equals("large")) {
							System.out.println("large");
						}

						System.out.print("Enter Qty of Wraps: ");
						int input5 = scanner.nextInt();// qty

						if (input5 <= 0 && input5 > 10) {
							System.out.println("Error invalid quantity");
							System.out.print("Enter Qty of Wraps: ");
							input5 = scanner.nextInt();
						}

						System.out.print("What is your name: ");
						name = scanner.next();

						System.out.print("What is your phone number: ");
						clientPhoneNumber = scanner.next();

						System.out.print("What is delivery address: ");
						clientAddress = scanner.next();

						System.out.print("Order done, enter " + " YES " + "to finish order");
						exitString = scanner.next();

//						System.out.println(input4 + name);

						if (exitString.equals("yes")) {
							System.out.println("YES ELSE");
							sendOrder();
							
						}
					}
				}

			}

			else if (input3.equals("salad")) {
				System.out.println("The Salad menu is: \n");

				printMenu("salad");
//				String size = scanner.next();

				for (Product p : products) {
					if (p.getFoodCategories().equals("salad")) {
//						System.out.println(p + "\n");
						System.out.print("Select size of Salad (Small, Medium, Large): ");
						input4 = scanner.next();

//						
						if (input4.equals("small")) {
							System.out.println("small");
						} else if (input4.equals("medium")) {
							System.out.println("medium");
						} else if (input4.equals("large")) {
							System.out.println("large");
						}

						System.out.print("Enter Qty of Salad: ");
						int input5 = scanner.nextInt();// qty

						if (input5 <= 0 && input5 > 10) {
							System.out.println("Error invalid quantity");
							System.out.print("Enter Qty of Wraps: ");
							input5 = scanner.nextInt();
						}

						System.out.print("What is your name: ");
						name = scanner.next();

						System.out.print("What is your phone number: ");
						clientPhoneNumber = scanner.next();

						System.out.print("What is delivery address: ");
						clientAddress = scanner.next();

						System.out.print("Order done, enter " + " YES " + "to finish order");
						exitString = scanner.next();

//						System.out.println(input4 + name);

						if (exitString.equals("yes")) {
							System.out.println("YES ELSE");
							sendOrder();
						}
					}
				}

			} 
			else if (input3 == "drink") {
				System.out.println("The Drink menu is: \n");

				printMenu("drink");
//				String size = scanner.next();

				for (Product p : products) {
					if (p.getFoodCategories().equals("drink")) {
//						System.out.println(p + "\n");
						System.out.print("Select size of drink (Small, Medium, Large): ");
						input4 = scanner.next();

//						
						if (input4.equals("small")) {
							System.out.println("small");
						} else if (input4.equals("medium")) {
							System.out.println("medium");
						} else if (input4.equals("large")) {
							System.out.println("large");
						}

						System.out.print("Enter Qty of Drinks: ");
						int input5 = scanner.nextInt();// qty

						if (input5 <= 0 && input5 > 10) {
							System.out.println("Error invalid quantity");
							System.out.print("Enter Qty of Wraps: ");
							input5 = scanner.nextInt();
						}

						System.out.print("What is your name: ");
						name = scanner.next();

						System.out.print("What is your phone number: ");
						clientPhoneNumber = scanner.next();

						System.out.print("What is delivery address: ");
						clientAddress = scanner.next();

						System.out.print("Order done, enter " + " YES " + "to finish order");
						exitString = scanner.next();

//						System.out.println(input4 + name);

						if (exitString.equals("yes")) {
							System.out.println("YES ELSE");
							sendOrder();
						}
					}
				}
			} 
			else if (input3 == "dessert") {
				
				System.out.println("The dessert menu is: \n");

				printMenu("dessert");
//				String size = scanner.next();

				for (Product p : products) {
					if (p.getFoodCategories().equals("dessert")) {
//						System.out.println(p + "\n");
						System.out.print("Select size of Salad (Small, Medium, Large): ");
						input4 = scanner.next();

//						
						if (input4.equals("small")) {
							System.out.println("small");
						} else if (input4.equals("medium")) {
							System.out.println("medium");
						} else if (input4.equals("large")) {
							System.out.println("large");
						}

						System.out.print("Enter Qty of Desserts: ");
						int input5 = scanner.nextInt();// qty

						if (input5 <= 0 && input5 > 10) {
							System.out.println("Error invalid quantity");
							System.out.print("Enter Qty of Wraps: ");
							input5 = scanner.nextInt();
						}

						System.out.print("What is your name: ");
						name = scanner.next();

						System.out.print("What is your phone number: ");
						clientPhoneNumber = scanner.next();

						System.out.print("What is delivery address: ");
						clientAddress = scanner.next();

						System.out.print("Order done, enter " + " YES " + "to finish order");
						exitString = scanner.next();

//						System.out.println(input4 + name);

						if (exitString.equals("yes")) {
							System.out.println("YES ELSE");
							sendOrder();
						}
					}
				}

			}

		} 
		
		else if (input1 == 3) {// This will bring to the manager screen
			
			System.out.println("Welcome to Manager Portal \n");
			
			System.out.println("Select  1  to update menu or Select  2  to check status of order");
//			System.out.println("Select");
			
			managerMenuInput = scanner.next();
			
			
			if(managerMenuInput.equals("1")) {
				System.out.println("Update Menu, Select 1 to Add Items, Select 2 to Delete Items");
				updateInput = scanner.next();
				
				if(updateInput.equals("1")) {
					System.out.println("add");
					System.out.print("What is productName");
					mEdit_productName = scanner.next();
					
					//productName,uniqueId,price,ingredients,allergens,dimensions,foodCategories,nutrition,size
					
					System.out.println("What is ");
				}
				else if(updateInput.equals("2")) {
					System.out.println("delete");
				}
				
				
				
				
				
			}
			else if(managerMenuInput.equals("2")) {
				System.out.println("2");
			}
			
			
			
			
			

		} 
		
		
		else if (input1 == 4) {
			System.out.println("Check status of order");
		} else if (input1 == 5) {
			System.out.println("Cancel Order ");
		}

	}

	public static int ordersArrSize() throws Exception {
		Order orderObj = new Order();
		searchCLI.loadOrders(path2);
		int ogSize = orderObj.order.size();
		int newSize = ogSize + 1;
		return newSize;
	}

	public static int orderTotal(String foodType, String size) {
		int price = 0;
		for (Product p : products) {
			if (p.getFoodCategories().equals(foodType) && p.getSize().equals(size)) {
				price = p.getPrice();
			}
		}
		return price;
	}

	public static void sendOrder() throws Exception {
		int size = orders.size();
		searchCLI.loadOrders(path2);
		orders.add(new Order(searchCLI.ordersArrSize() + 1, searchCLI.ordersArrSize() + 1, name, input3, "unpaid",
				searchCLI.orderTotal(input3, input4), clientAddress, clientPhoneNumber));
		searchCLI.updateOrders(path2);
		int size2 = orders.size();

		if (size2 > size) {
			System.out.println("success, size was " + size + "now its" + size2);
		}
		// Order(int orderNumber, int clientUserId, String clientName, String
		// orderItems, String orderStatus,int orderTotal, String deliveryLocation,
		// String clientPhoneNumber)
	}
	

}
