package my.group;

public class Fruit {

	public static void main(String[] args) {
		Fruit apple = new Fruit();
		System.out.println(apple.fruit("사과", 1200, 5));

	}
	
	public String fruit(String a, int i, int j) {
		int total = i*j;
		
		return a + "의 개당 가격은 : " + i + "원 이며, 갯수는 : " + j + "개 이다.\n"
		+ a + " " + j +  "개의 가격은 " + total + "원이다.";
	}

}
