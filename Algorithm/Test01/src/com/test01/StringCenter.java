package com.test01;

public class StringCenter {
	 public String solution(String s) {
	      String answer = "";
	      if(s.length()>=1 && s.length()<=100) {
	        switch(s.length()%2) {
	            case 0:
	                answer += s.charAt(s.length()/2 - 1);
	                answer += s.charAt(s.length()/2);
	                return answer;
	            case 1:
	                answer += s.charAt((int) Math.ceil(s.length()/2));
	                return answer;
	        }
	      } 
		return answer;
	  }
}
