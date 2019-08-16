package my.group;

public class Test01 {

	public static void main(String[] args) {
		Test01.te01(40, 10);

	}
	
	public static void te01(int a, int b) {
		int sub = a++ - a++ - ++a - b++;
		System.out.println(sub);
		
	}

}
