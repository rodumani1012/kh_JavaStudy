package bean.jspbasic;

public class Item {
	private String name; //상품명
	private int count; //주문개수
	
	public Item() {
		
	}
	
	public Item(String name, int count) {
		this.name = name;
		this.count = count;
	}
	
	public String getName() {
		return name;
	}
	public int getCount() {
		return count;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setCount(int count) {
		this.count = count;
	}

	public void printInfo() {
		System.out.println("상품명= " + getName());
		System.out.println("주문개수= " + getCount());

	}
	
}
