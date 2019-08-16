package com.dayandnight;

import java.util.Timer;
import java.util.TimerTask;

import com.EGGDisplay.Main;
import com.pipi.dao.pipiDao;
import com.pipi.dto.pipiDto;


public class chgStus {
   public static Timer timer = new Timer();

   public chgStus() {
      System.out.println("chgStus");
      timer = new Timer();
      start();
   }
   

   public void start() {

        TimerTask task2 = new TimerTask() {
            @Override
            public void run() {
			   pipiDto dto = new pipiDto();
			   dto = Main.getDto();
			   int Myno = dto.getMyno();
			   pipiDto retDto = pipiDao.selectData(Myno);
			   pipiDto newDto = new pipiDto();
			   
	           newDto.setMyno(dto.getMyno());
		       newDto.setMyheart( retDto.getMyheart() -1 );  // 초당 1씩 감소
			   newDto.setMyfull( retDto.getMyfull() -2 ); // 초당 2씩 감소
			   newDto.setMystamina( retDto.getMystamina() -3 ); // 초당 3씩 감소
			   newDto.setMyclean( retDto.getMyclean() -4); // 초당 4씩 감소
			
			   pipiDao.updateStatus(newDto);
                  
               
            }
        };
      //timer.scheduleAtFixedRate(task2, 24 * 60 * 60 * 1000L, 24 * 60 * 60 * 1000L); //  증가 주기 설정 , 하루에  한 번
      timer.scheduleAtFixedRate(task2, 0, 1000L); //  증가 주기 설정 , 1초당 한 번
      

   }

}