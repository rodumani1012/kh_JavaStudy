package dto.sellist;

public class SellistRamen {
	private String name;
	private int price;
	private int amount;
	private int total;
	
	public SellistRamen() {
		
	}
	public SellistRamen(String name, int price, int amount, int total) {
		this.name = name;
		this.price = price;
		this.amount = amount;
		this.total = total;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
}
