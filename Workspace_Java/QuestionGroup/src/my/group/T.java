package my.group;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class T {

	public static void main(String[] args) {
//		starBox(2, 2);
		//첫째줄 a, 엔터 수는 b-1, 앞에 하나, 공백은 a-2, 뒤에 하나, 마지막줄 a
		
		int[] f = {1,2,3,5};
		boolean ddd = false;
		int sel = 1;
		for(int i=0; i<f.length; i++) {
			if(sel==f[i]) {
				ddd = true;
				break;
			} else {
				ddd = false;
			}
		}
		System.out.println(ddd);
		
		
		
		Map<String, int[]> map = new HashMap<String, int[]>();
		int[] a = new int[4];
		int[] b = new int[3];
		int[] c = new int[2];
		
		del(a);
		del(b);
		del(c);
		map.put("상", a);
		map.put("중", b);
		map.put("하", c);	
		Set<Map.Entry<String, int[]>> mySet = map.entrySet();
		for(Map.Entry<String, int[]> s : mySet) {
			System.out.println(Arrays.toString(s.getValue()));
		}
	}
	public static void MapLevel() {
		Map<String, int[]> map = new HashMap<String, int[]>();
		int[] a = new int[4];
		int[] b = new int[3];
		int[] c = new int[2];
		
		del(a);
		del(b);
		del(c);
		map.put("상", a);
		map.put("중", b);
		map.put("하", c);	
		Set<Map.Entry<String, int[]>> mySet = map.entrySet();
		for(Map.Entry<String, int[]> s : mySet) {
			System.out.println(Arrays.toString(s.getValue()));
		}
	}
	public static void del(int[] a) {
		for(int i=0; i<a.length; i++) {
			a[i] = (int)(Math.random()*6)+1;
			for(int j=0; j<i; j++) {
				if(a[i] == a[j]) {
					i--;
					break;
				}
			}
		}
	}
	
	public static void starBox(int a, int b) {
		// 첫째줄
		for (int i = 0; i < a; i++) {
			System.out.print("★");
			if (i == a - 1) {
				System.out.println(); // 첫째줄 엔터
			}
		}

		// 사이 줄
		for (int i = 0; i < b - 2; i++) {
			System.out.print("★");
			for (int j = 0; j < a - 2; j++) { // 공백 넣기
				System.out.print(" ");
			}
			System.out.print("★");
			System.out.println(); // 엔터치기
		}

		// 마지막 줄
		for (int i = 0; i < a; i++) {
			System.out.print("★");
		}
	}
}
