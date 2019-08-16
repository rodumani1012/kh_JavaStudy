package my.group;


public class CalOpr {
	int res = 0;
	
	public static void main(String[] args) {
		CalOpr c1 = new CalOpr();
		System.out.println(c1.calc('*', 5, 3));

	}
	
	public String calc(char op, int a, int b) {
		res = (op=='+') ? a+b : ((op=='-') ? a-b : ((op=='*') ? a*b : ((op=='/') ? a/b : ((op=='%') ? a%b : res))));
		
		return "연산자는 " + op + "입니다. \n" + "결과값 = " + res;

	}
}