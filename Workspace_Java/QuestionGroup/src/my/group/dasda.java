package my.group;

public class dasda {

	public static void main(String[] args) {
//		div(88,4);
		
		String[] s = {"김", "최", "전", "조","문","천"};
		
		for (int i = 0; i < s.length; i++) {
			int a = (int)(Math.random()*6)+1;
			System.out.println(s[i] + "= " + a + "입니다.");
		}

	}
	public static void div(int i, int j) {
		int div01 = i / j;
		int div02 = i % j;
		
		System.out.printf("나누기 : 몫(%d).나머지(%d)", div01, div02);
	}

}
