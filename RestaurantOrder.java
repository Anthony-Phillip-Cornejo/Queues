
public class RestaurantOrder {

	private String order;
	private String customer;
	private int minutes;
	
	public RestaurantOrder(String cus, String or, int min) {
		customer = cus;
		order = or;
		minutes = min;
	}
	
	public String getOrder() {
		return order;
	}
	
	public int getTime() {
		return minutes;
	}
	
	public String getCustomer() {
		return customer;
	}
	
	public void setOrder(String newOrder) {
		order = newOrder;
	}
	
	public void setTime(int newTime) {
		minutes = newTime;
	}
	
	public void setCustomer(String newCustomer) {
		customer = newCustomer;
	}
	
}
