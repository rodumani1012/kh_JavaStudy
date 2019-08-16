package exception.ex;

public class Exception1_1 {
	
	public static void main(String[] args) {
		
		// 예외 발생
//		try {
//			throw new Exception();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
		// 1. NullPointException
//		String str = null;
//		
//		for (int i = 0; i < str.length(); i++) {
//			System.out.println(str.charAt(i));
//		}
		
		// 2. ArrayIndexOutOfBoundsException
//		int[] arr = new int[3];
//		for (int i = 0; i < 4; i++) {
//			arr[i] = i;
//			System.out.println(i);
//		}
		
		// 3. ClassCastException
		String str = "1";
		Object obj = str;
		Integer integer = (Integer) obj; // Object type 이지만 내부엔 String이 들어있으므로
										// String 을 Integer로 강제 형변환하려다 에러 발생.
		
		System.out.println(integer);
		
		
	}
}
