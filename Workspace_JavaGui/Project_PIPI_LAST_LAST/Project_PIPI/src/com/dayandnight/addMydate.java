package com.dayandnight;

import java.util.Timer;
import java.util.TimerTask;

import com.EGGDisplay.Main;
import com.pipi.dao.pipiDao;
import com.pipi.dto.pipiDto;


public class addMydate {
   public static Timer timer2 = new Timer();

   public addMydate() {
      System.out.println("addMydate");
      start();
   }
   

   public void start() {

        TimerTask task2 = new TimerTask() {
            @Override
            public void run() {
               pipiDto mainDto = new pipiDto();
               pipiDto newDto = new pipiDto();
               mainDto = Main.getDto();
               pipiDto retDto = pipiDao.selectData(mainDto.getMyno());
               if ( retDto.getMyallday().equals("D")){
                  newDto.setMyallday("N");
                  newDto.setMydate(retDto.getMydate());
                  System.out.println("addMydate 낮");
               }else{
                  newDto.setMyallday("D");
                  newDto.setMydate(retDto.getMydate()+1);
                  System.out.println("addMydate 밤 +  하루증가");
               }
               newDto.setMyno(mainDto.getMyno());
               pipiDao.updateMydate(newDto);
               
               //pipiDao.updateMydate(Myno);
            
               
            }
        };
      //timer2.scheduleAtFixedRate(task2, 24 * 60 * 60 * 1000L, 24 * 60 * 60 * 1000L); // 마이 데이트 증가 주기 설정 , 하루에  한 번
        //timer2.scheduleAtFixedRate(task2, 0, 30 * 1000L); // 30초 -낮,밤 = 1분
      timer2.scheduleAtFixedRate(task2, 0, 1000L); // 마이 데이트 증가 주기 설정 , 1초당 한 번
      

   }

}