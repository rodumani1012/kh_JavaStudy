package com.dayandnight;

import java.util.TimerTask;

import com.EGGDisplay.Main;
import com.pipi.dao.pipiDao;
import com.pipi.dto.pipiDto;

public class AllDay extends TimerTask {
   // 밤 낮 바꾸고 태어난 일수 +하는 클래스

   public static String MYALLDAY = "D";// 밤 낮 담는 변수
   public static int day = 0;// 태어난 일수 담는 변수

   @Override
   public void run() {
      
      if (Night_Stamina.MYSTAMINA > 0) {
         switch (MYALLDAY) {
         case "D":
            MYALLDAY = "N";

            //System.out.println("D/N : " + MYALLDAY);

            break;

         case "N":
            MYALLDAY = "D";
            
            pipiDto dto = new pipiDto();
               dto = Main.getDto();
               int Myno = dto.getMyno();
               
               // 하루 증가
               //int mydate =pipiDao.updateMydate(Myno);
               
            //day++;
            //System.out.println("D/N : " + MYALLDAY);
            //System.out.println("태어난지 " + day + "일");
               System.out.println("하루 증가");
               
            break;
         }
      }
   }

}