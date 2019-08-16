package bean.jspbasic;

public class Coffee {
	private String name; //이름
	private int price; //가격
		
	
	public Coffee() {
	}

	public Coffee(String name, int price) {
		this.name = name;
		this.price = price;
	}
	
	public String getName() {
		return name;
	}
	public int getPrice() {
		return price;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	public void printInfo() {
		System.out.println("커피명= " + getName());
		System.out.println("가격= " + getPrice());

	}
}
