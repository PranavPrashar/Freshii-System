import java.util.ArrayList;

public class Order {
	ArrayList<Order> order = new ArrayList<Order>();
	int orderNumber = 0;
	int clientUserId = 0;
	String clientName = "";
	String orderItems = "";
	String orderStatus = "";
	int orderTotal = 0;
	String deliveryLocation= "";
	String clientPhoneNumber = "";

	public Order(int orderNumber, int clientUserId, String clientName, String orderItems, String orderStatus,
			int orderTotal, String deliveryLocation, String clientPhoneNumber) {
		this.orderNumber = orderNumber;
		this.clientUserId = clientUserId;
		this.orderItems = orderItems;
		this.orderStatus = orderStatus;
		this.orderTotal = orderTotal;
		this.deliveryLocation = deliveryLocation;
		this.clientPhoneNumber = clientPhoneNumber;
		this.clientName = clientName;
	}

	
	public Order() {
		super();
	}
	public int getOrderNumber() {
		return this.orderNumber;
	}

	public void setOrderNumber(int orderNumber) {
		int orderNum = order.size() + 1;
		this.orderNumber = orderNum;
	}

	public int getClientUserID() {
		return this.clientUserId;
	}

	public void setclientUserId(int clientUserID) {
		this.clientUserId = clientUserID;
	}
	
	public String getclientName() {
		return this.clientName;
	}
	
	public void setclientName(String clientName) {
		this.clientName = clientName;
	}
	
	public String getOrderItems() {
		return this.orderItems;
	}
	
	public void setOrderItems(String orderItems) {
		this.orderItems = orderItems;
	}
	
	
//	public ArrayList<String> getOrder() {
//		return this.order;
//	}
//
//	public void setOrder(ArrayList<String> order) {
//		this.order = order;
//	}

	public String getOrderStatus() {
		return this.orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public int getOrderTotal() {
		return this.orderTotal;
	}

	public void setOrderTotal(int orderTotal) {
		this.orderTotal = orderTotal;
	}
	
	public String getdeliveryLocation() {
		return this.deliveryLocation;
	}
	public void setdeliveryLocation(String deliveryLocation) {
		this.deliveryLocation = deliveryLocation;
	}
	
	public String getclientPhoneNumber() {
		return this.clientPhoneNumber;
	}
	
	public void setclientPhoneNumber(String clientPhoneNumber) {
		this.clientPhoneNumber = clientPhoneNumber;
	}

	@Override
	public String toString() {
		return "order [orderNumber=" + orderNumber + ", clientUserId=" + clientUserId + ", clientName=" + clientName
				+ ", order=" + order + ", orderStatus=" + orderStatus + ", orderTotal=" + orderTotal
				+ ", deliveryLocation=" + deliveryLocation + ", clientPhoneNumber=" + clientPhoneNumber + "]";
	}
	
	
	
	
	
	
	
	

}
