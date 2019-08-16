package com.ant;

public class AntQuizTeacher {

   // 베르나르 베르베르 '개미'
   public static void main(String[] args) {
      antPrn(10);
   }
   
   public static void antPrn(int stage) {
      String start = "1";
      System.out.println(start); // 처음 입력한 1 출력.
      for(int i=1; i<stage; i++) {
         start = ant(start); // 그다음 부터 
         System.out.println(start);
      }
   }
   
   public static String ant(String input) {
      // 결과값 저장
      String res = "";
      
      // 기준값
      char index = input.charAt(0); // 0번째에 있는 1을 index에 넣음 // 11 일때 index -> 1
      
      // 기준값과 다음에 나오는 값이 같으면 ++
      int count = 1;
      
      for(int i=1; i<input.length(); i++) { 
         if(index == input.charAt(i)) {
            count++;
         } else {
            res = res + index + count;
            index = input.charAt(i);
            count = 1;
         }
      }
      
      res = res + index + count; // 
      return res;
   }
}