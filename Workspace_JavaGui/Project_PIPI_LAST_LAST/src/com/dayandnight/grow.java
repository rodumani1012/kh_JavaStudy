package com.dayandnight;

import java.util.Timer;
import java.util.TimerTask;

import com.EGGDisplay.Main;
import com.pipi.dao.pipiDao;
import com.pipi.dto.pipiDto;

public class grow {
	public static Timer timer = new Timer();

	public grow() {
		System.out.println("grow");
		timer = new Timer();
		start();
	}
	public void start() {

		TimerTask task = new TimerTask() {
			@Override
			public void run() {
				
				System.out.println("grow run");

				pipiDto dto = new pipiDto();
				dto = Main.getDto();
				int Myno = dto.getMyno();

				pipiDto retDto = pipiDao.selectData(Myno);
				int mydate = retDto.getMydate();

				int myheart = retDto.getMyheart();// 애정
				int myfull = retDto.getMyfull();// 포만
				int myclean = retDto.getMyclean();// 청결
				int mystamina = retDto.getMystamina();// 체력
				String mydisease = retDto.getMydisease();// 질병

				// 병아리 모양 변화
				if (mydate > 0 && mydate <= 10) {// 병아리시절!!chgBody(1~10사용)
					if (myheart >= 80 && myheart <= 100) {
						// <1> 행복한 병아리
						if (myfull <= 0 || mystamina <= 0 || myclean <= 0) {
							// 1)병아리 사망엔딩
							Main.chgBody(1);
							Main.endGame();  // 20190509
						} else if (myfull >= 1 && myfull <= 60 && myclean >= 1 && myclean <= 50) {
							// 2)배고픔+아픔 = 아픈병아리 => disease : "y"인 상황
							Main.chgBody(2);
						} else if (myfull >= 1 && myfull <= 60) {
							// 3)포만60이하 배고픈 병아리
							Main.chgBody(3);
						} else if (myclean >= 1 && myclean <= 50) {
							// 2)청결 50이하 => disease : "y"인 상황
							Main.chgBody(2);
						} else {
							// 4)행복한 병아리
							Main.chgBody(4);
						}
					} else if (myheart >= 41 && myheart <= 79) {
						// <2> 기본 병아리
						if (myfull <= 0 || mystamina <= 0 || myclean <= 0) {
							// 1)병아리 사망엔딩
							Main.chgBody(1);
							Main.endGame();  // 20190509
						} else if (myfull >= 1 && myfull <= 60 && myclean >= 1 && myclean <= 50) {
							// 2)배고픔+아픔 = 아픈병아리 => disease : "y"인 상황
							Main.chgBody(2);
						} else if (myfull >= 1 && myfull <= 60) {
							// 3)포만60이하 배고픈 병아리
							Main.chgBody(3);
						} else if (myclean >= 1 && myclean <= 50) {
							// 2)청결 50이하 => disease : "y"인 상황
							Main.chgBody(2);
						} else {
							// 5)기본병아리
							Main.chgBody(5);
						}
					} else if (myheart >= 31 && myheart <= 40) {
						// <3> 슬픈병아리
						if (myfull <= 0 || mystamina <= 0 || myclean <= 0) {
							// 1)병아리 사망엔딩
							Main.chgBody(1);
							Main.endGame();  // 20190509
						} else if (myfull >= 1 && myfull <= 60 && myclean >= 1 && myclean <= 50) {
							// 2)배고픔+아픔 = 아픈병아리 => disease : "y"인 상황
							Main.chgBody(2);
						} else if (myfull >= 1 && myfull <= 60) {
							// 3)포만60이하 배고픈 병아리
							Main.chgBody(3);
						} else if (myclean >= 1 && myclean <= 50) {
							// 2)청결 50이하 => disease : "y"인 상황
							Main.chgBody(2);
						} else {
							// 6)슬픈병아리
							Main.chgBody(6);
						}
					} else if (myheart >= 1 && myheart <= 30) {
						// <4> 화난 병아리
						if (myfull <= 0 || mystamina <= 0 || myclean <= 0) {
							// 1)병아리 사망엔딩
							Main.chgBody(1);
							Main.endGame();  // 20190509
						} else if (myfull >= 1 && myfull <= 60 && myclean >= 1 && myclean <= 50) {
							// 2)배고픔+아픔 = 아픈병아리 => disease : "y"인 상황
							Main.chgBody(2);
						} else if (myfull >= 1 && myfull <= 60) {
							// 3)포만60이하 배고픈 병아리
							Main.chgBody(3);
						} else if (myclean >= 1 && myclean <= 50) {
							// 2)청결 50이하 => disease : "y"인 상황
							Main.chgBody(2);
						} else {
							// 7)화난 병아리
							Main.chgBody(7);
						}
					} else if (myheart <= 0) {
						// <5>
						// 8)병아리 가출엔딩
						Main.chgBody(8);
						Main.endGame();  // 20190509
					}

//==========중간닭================================================================================================
				}else if (mydate > 11 && mydate <= 20) {//중간닭시절!!chgBody(11~20사용)
					if (myheart >= 80 && myheart <= 100) {
						// <1> 행복한 중간닭
						if (myfull <= 0 || mystamina <= 0 || myclean <= 0) {
							// 1)중간닭 사망엔딩
							Main.chgBody(11);
							Main.endGame();  // 20190509
						} else if (myfull >= 1 && myfull <= 60 && myclean >= 1 && myclean <= 50) {
							// 2)배고픔+아픔 = 아픈중간닭 => disease : "y"인 상황
							Main.chgBody(12);
						} else if (myfull >= 1 && myfull <= 60) {
							// 3)포만60이하 배고픈 중간닭
							Main.chgBody(13);
						} else if (myclean >= 1 && myclean <= 50) {
							// 2)청결 50이하 => disease : "y"인 상황
							Main.chgBody(12);
						} else {
							// 4)행복한 중간닭
							Main.chgBody(14);
						}
					} else if (myheart >= 41 && myheart <= 79) {
						// <2> 기본 중간닭
						if (myfull <= 0 || mystamina <= 0 || myclean <= 0) {
							// 1)중간닭 사망엔딩
							Main.chgBody(11);
							Main.endGame();  // 20190509
						} else if (myfull >= 1 && myfull <= 60 && myclean >= 1 && myclean <= 50) {
							// 2)배고픔+아픔 = 중간닭 => disease : "y"인 상황
							Main.chgBody(12);
						} else if (myfull >= 1 && myfull <= 60) {
							// 3)포만60이하 배고픈 중간닭
							Main.chgBody(13);
						} else if (myclean >= 1 && myclean <= 50) {
							// 2)청결 50이하 => disease : "y"인 상황
							Main.chgBody(12);
						} else {
							// 5)기본중간닭
							Main.chgBody(15);
						}
					} else if (myheart >= 31 && myheart <= 40) {
						// <3> 슬픈중간닭
						if (myfull <= 0 || mystamina <= 0 || myclean <= 0) {
							// 1)중간닭 사망엔딩
							Main.chgBody(11);
							Main.endGame();  // 20190509
						} else if (myfull >= 1 && myfull <= 60 && myclean >= 1 && myclean <= 50) {
							// 2)배고픔+아픔 = 아픈중간닭 => disease : "y"인 상황
							Main.chgBody(12);
						} else if (myfull >= 1 && myfull <= 60) {
							// 3)포만60이하 배고픈 중간닭
							Main.chgBody(13);
						} else if (myclean >= 1 && myclean <= 50) {
							// 2)청결 50이하 => disease : "y"인 상황
							Main.chgBody(12);
						} else {
							// 6)슬픈중간닭
							Main.chgBody(16);
						}
					} else if (myheart >= 1 && myheart <= 30) {
						// <4> 화난 중간닭
						if (myfull <= 0 || mystamina <= 0 || myclean <= 0) {
							// 1)중간닭 사망엔딩
							Main.chgBody(11);
							Main.endGame();  // 20190509
						} else if (myfull >= 1 && myfull <= 60 && myclean >= 1 && myclean <= 50) {
							// 2)배고픔+아픔 = 아픈중간닭 => disease : "y"인 상황
							Main.chgBody(12);
						} else if (myfull >= 1 && myfull <= 60) {
							// 3)포만60이하 배고픈 중간닭
							Main.chgBody(13);
						} else if (myclean >= 1 && myclean <= 50) {
							// 2)청결 50이하 => disease : "y"인 상황
							Main.chgBody(12);
						} else {
							// 7)화난 중간닭
							Main.chgBody(17);
						}
					} else if (myheart <= 0) {
						// <5>
						// 8)중간닭 가출엔딩
						Main.chgBody(18);
						Main.endGame();  // 20190509
					}

				
//==========큰닭================================================================================================
				}else if (mydate > 21 && mydate <= 30) {// 큰닭시절!!chgBody(21~30사용)
					if (myheart >= 80 && myheart <= 100) {
						// <1> 행복한 큰닭
						if (myfull <= 0 || mystamina <= 0 || myclean <= 0) {
							// 1)큰닭 사망엔딩
							Main.chgBody(21);
							Main.endGame();  // 20190509
						} else if (myfull >= 1 && myfull <= 60 && myclean >= 1 && myclean <= 50) {
							// 2)배고픔+아픔 = 아픈큰닭 => disease : "y"인 상황
							Main.chgBody(22);
						} else if (myfull >= 1 && myfull <= 60) {
							// 3)포만60이하 배고픈 큰닭
							Main.chgBody(23);
						} else if (myclean >= 1 && myclean <= 50) {
							// 2)청결 50이하 => disease : "y"인 상황
							Main.chgBody(22);
						} else {
							// 4)행복한 큰닭
							Main.chgBody(24);
						}
					} else if (myheart >= 41 && myheart <= 79) {
						// <2> 기본 큰닭
						if (myfull <= 0 || mystamina <= 0 || myclean <= 0) {
							// 1)큰닭 사망엔딩
							Main.chgBody(21);
							Main.endGame();  // 20190509
						} else if (myfull >= 1 && myfull <= 60 && myclean >= 1 && myclean <= 50) {
							// 2)배고픔+아픔 = 아픈큰닭 => disease : "y"인 상황
							Main.chgBody(22);
						} else if (myfull >= 1 && myfull <= 60) {
							// 3)포만60이하 배고픈 큰닭
							Main.chgBody(23);
						} else if (myclean >= 1 && myclean <= 50) {
							// 2)청결 50이하 => disease : "y"인 상황
							Main.chgBody(22);
						} else {
							// 5)기본큰닭
							Main.chgBody(25);
						}
					} else if (myheart >= 31 && myheart <= 40) {
						// <3> 슬픈큰닭
						if (myfull <= 0 || mystamina <= 0 || myclean <= 0) {
							// 1)큰닭 사망엔딩
							Main.chgBody(21);
							Main.endGame();  // 20190509
						} else if (myfull >= 1 && myfull <= 60 && myclean >= 1 && myclean <= 50) {
							// 2)배고픔+아픔 = 아픈큰닭 => disease : "y"인 상황
							Main.chgBody(22);
						} else if (myfull >= 1 && myfull <= 60) {
							// 3)포만60이하 배고픈 큰닭
							Main.chgBody(23);
						} else if (myclean >= 1 && myclean <= 50) {
							// 2)청결 50이하 => disease : "y"인 상황
							Main.chgBody(22);
						} else {
							// 6)슬픈큰닭
							Main.chgBody(26);
						}
					} else if (myheart >= 1 && myheart <= 30) {
						// <4> 화난 큰닭
						if (myfull <= 0 || mystamina <= 0 || myclean <= 0) {
							// 1)큰닭 사망엔딩
							Main.chgBody(21);
							Main.endGame();  // 20190509
						} else if (myfull >= 1 && myfull <= 60 && myclean >= 1 && myclean <= 50) {
							// 2)배고픔+아픔 = 아픈큰닭 => disease : "y"인 상황
							Main.chgBody(22);
						} else if (myfull >= 1 && myfull <= 60) {
							// 3)포만60이하 배고픈 중간닭
							Main.chgBody(23);
						} else if (myclean >= 1 && myclean <= 50) {
							// 2)청결 50이하 => disease : "y"인 상황
							Main.chgBody(22);
						} else {
							// 7)화난 큰닭
							Main.chgBody(27);
						}
					} else if (myheart <= 0) {
						// <5>
						// 8)큰닭 가출엔딩
						Main.chgBody(28);
						Main.endGame();  // 20190509
					}
				
//====================================================================================================
					
					
					//엔딩
				} else if (mydate >= 30) {
					Main.chgBody(40);
					Main.endGame();  // 20190509
				}

				// 병아리 에너지 상태 반영
				Main.chgMyheart(retDto);
			}
		};

		timer.scheduleAtFixedRate(task, 0, 1000L); // 마이데이트 검사 주기 설정, 1초당 한 번

	}

}