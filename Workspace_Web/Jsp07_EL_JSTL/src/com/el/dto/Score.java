package com.el.dto;

public class Score {
   
   private String name;
   private int kor;
   private int eng;
   private int math;
   private int sum;
   private double avg;
   private String grade;
   
   public Score() {
      
   }
   
   public Score(String name, int kor, int eng, int math) {
      this.name = name;
      this.kor = kor;
      this.eng = eng;
      this.math = math;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public int getKor() {
      return kor;
   }

   public void setKor(int kor) {
      this.kor = kor;
   }

   public int getEng() {
      return eng;
   }

   public void setEng(int eng) {
      this.eng = eng;
   }

   public int getMath() {
      return math;
   }

   public void setMath(int math) {
      this.math = math;
   }

   public int getSum() {
      int sum = kor+eng+math;
      return sum;
   }
   
   public double getAvg() {
      double avg = (double)getSum()/3;
      return avg;
   }
   
   public String getGrade() {
      String grade = "";
      switch((int)getAvg()/10) {
      case 10 :
      case 9 :
         grade = "A";
         break;
      case 8 :
         grade = "B";
         break;
      case 7 : 
         grade = "C";
         break;
      case 6 : 
         grade = "D";
         break;
      default :
         grade = "F";
      }
      return grade;
   }

   @Override
	public String toString() {
		return "이름 : " + getName() + "\t 국어 : " + getKor() + "\t 영어 : " + getEng() + "\t 수학 : " + getMath() 
				+ "\n 총점 : " + getSum() + "\t 평균 : " + getAvg() + "\t 등급 : " + getGrade();
	}

}