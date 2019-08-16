package com.dayandnight;

import java.util.Timer;
import java.util.TimerTask;

import com.EGGDisplay.Main;
import com.pipi.dao.pipiDao;
import com.pipi.dto.pipiDto;

public class grow {
	Timer timer = new Timer();

	public grow() {
		System.out.println("grow");
		start();
	}

	public void start() {

		TimerTask task = new TimerTask() {
			@Override
			public void run() {

				pipiDto dto = new pipiDto();
				dto = Main.getDto();
				int Myno = dto.getMyno();

				// int mydate =pipiDao.growselect(Myno);
				pipiDto retDto = pipiDao.selectData(Myno);
				int mydate = retDto.getMydate();

				int myheart = retDto.getMyheart();// 애정
				int myfull = retDto.getMyheart();// 포만
				int myclean = retDto.getMyclean();// 청결
				int mystamina = retDto.getMystamina();// 체력
				String mydisease = retDto.getMydisease();// 질병

				// 병아리 모양 변화
				if (mydate > 0 && mydate <= 10) {// 병아리시절!!chgBody(1~20사용)
					if (myheart > 80 && myheart < 100) {
						// <1> 행복한 병아리
						if (myfull == 0 || mystamina == 0 || myclean == 0) {
							// 1)병아리 사망엔딩
							Main.chgBody(1);

							timer.cancel();
							addMydate.timer2.cancel();
							chgStus.timer.cancel();
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
					} else if (myheart > 41 && myheart < 79) {
						// <2> 기본 병아리
						if (myfull == 0 || mystamina == 0 || myclean == 0) {
							// 1)병아리 사망엔딩
							Main.chgBody(1);

							timer.cancel();
							addMydate.timer2.cancel();
							chgStus.timer.cancel();
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
					} else if (myheart > 31 && myheart < 40) {
						// <3> 슬픈병아리
						if (myfull == 0 || mystamina == 0 || myclean == 0) {
							// 1)병아리 사망엔딩
							Main.chgBody(1);

							timer.cancel();
							addMydate.timer2.cancel();
							chgStus.timer.cancel();
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
					} else if (myheart > 1 && myheart < 30) {
						// <4> 화난 병아리
						if (myfull == 0 || mystamina == 0 || myclean == 0) {
							// 1)병아리 사망엔딩
							Main.chgBody(1);

							timer.cancel();
							addMydate.timer2.cancel();
							chgStus.timer.cancel();
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
					} else if (myheart == 0) {
						// <5>
						// 8)병아리 가출엔딩
						Main.chgBody(8);

						timer.cancel();
						addMydate.timer2.cancel();
						chgStus.timer.cancel();
					}

//==========================================================================================================
				} else if (mydate > 10 && mydate <= 20) {// 중간닭21~30
					
					 if (myheart <= 100 && myheart >= 80) {// 행복
		                  if (myclean <= 50) {// 질병
		                     if (mystamina == 0 || myfull == 0) {// 죽음
		                        Main.chgBody(26);// 죽음
		                        timer.cancel();
		                        addMydate.timer2.cancel();
		                        chgStus.timer.cancel();
		                        
		                     } else if (myfull <= 60) {// 배고픔
		                        Main.chgBody(27);// 배고픔
		                        
		                     } else {
		                        Main.chgBody(25);// 질병
		                     }

		                  } else if (myclean == 0 || mystamina == 0 || myfull == 0) {// 죽음
		                     Main.chgBody(26);
		                     timer.cancel();
		                     addMydate.timer2.cancel();
		                     chgStus.timer.cancel();
		                     
		                     
		                  } else if (myfull <= 60) {// 배고픔
		                     if (myclean <= 50) {// 질병
		                        Main.chgBody(25);// 질병
		                     } else if (myclean == 0 || mystamina == 0) {// 죽음
		                        Main.chgBody(26);// 죽음
		                        timer.cancel();
		                        addMydate.timer2.cancel();
		                        chgStus.timer.cancel();
		                     } else {
		                        Main.chgBody(27);//배고픔
		                     }

		                  } else {
		                     Main.chgBody(21);// 행복
		                  }

		               }
		               // -----------------------------------------

		               if (myheart <= 79 && myheart >= 41) {// 기본

		                  if (myclean <= 50) {// 질병
		                     if (mystamina == 0 || myfull == 0) {// 죽음
		                        Main.chgBody(26);// 죽음
		                        timer.cancel();
		                        addMydate.timer2.cancel();
		                        chgStus.timer.cancel();
		                     } else if (myfull <= 60) {// 배고픔
		                        Main.chgBody(27);// 배고픔
		                     } else {
		                        Main.chgBody(25);// 질병
		                     }

		                  } else if (myclean == 0 || mystamina == 0 || myfull == 0) {// 죽음
		                     Main.chgBody(26);
		                     timer.cancel();
		                     addMydate.timer2.cancel();
		                     chgStus.timer.cancel();

		                  } else if (myfull <= 60) {// 배고픔
		                     if (myclean <= 50) {// 질병
		                        Main.chgBody(25);// 질병
		                     } else if (myclean == 0 || mystamina == 0) {// 죽음
		                        Main.chgBody(26);// 죽음
		                        timer.cancel();
		                        addMydate.timer2.cancel();
		                        chgStus.timer.cancel();
		                     } else {
		                        Main.chgBody(27);//배고픔
		                     }

		                  } else {
		                     Main.chgBody(28);// 기본
		                  }
		               }
		               if (myheart <= 40 && myheart >= 31) {// 슬픔
		                  if (myclean <= 50) {// 질병
		                     if (mystamina == 0 || myfull == 0) {// 죽음
		                        Main.chgBody(27);// 죽음
		                        timer.cancel();
		                        addMydate.timer2.cancel();
		                        chgStus.timer.cancel();
		                     } else if (myfull <= 60) {// 배고픔
		                        Main.chgBody(27);// 배고픔
		                     } else {
		                        Main.chgBody(25);// 질병
		                     }

		                  } else if (myclean == 0 || mystamina == 0 || myfull == 0) {// 죽음
		                     Main.chgBody(26);
		                     timer.cancel();
		                     addMydate.timer2.cancel();
		                     chgStus.timer.cancel();

		                  } else if (myfull <= 60) {// 배고픔
		                     if (myclean <= 50) {// 질병
		                        Main.chgBody(25);// 질병
		                     } else if (myclean == 0 || mystamina == 0) {// 죽음
		                        Main.chgBody(26);// 죽음
		                        timer.cancel();
		                        addMydate.timer2.cancel();
		                        chgStus.timer.cancel();
		                     } else {
		                        Main.chgBody(27);//배고픔
		                     }

		                  } else {
		                     Main.chgBody(22);// 슬픔
		                  }
		               }
		               if (myheart <= 30 && myheart >= 1) {// 화
		                  if (myclean <= 50) {// 질병
		                     if (mystamina == 0 || myfull == 0) {// 죽음
		                        Main.chgBody(26);// 죽음
		                        timer.cancel();
		                        addMydate.timer2.cancel();
		                        chgStus.timer.cancel();
		                     } else if (myfull <= 60) {// 배고픔
		                        Main.chgBody(27);// 배고픔
		                     } else {
		                        Main.chgBody(25);// 질병
		                     }

		                  } else if (myclean == 0 || mystamina == 0 || myfull == 0) {// 죽음
		                     Main.chgBody(26);
		                     timer.cancel();
		                     addMydate.timer2.cancel();
		                     chgStus.timer.cancel();

		                  } else if (myfull <= 60) {// 배고픔
		                     if (myclean <= 50) {// 질병
		                        Main.chgBody(25);// 질병
		                     } else if (myclean == 0 || mystamina == 0) {// 죽음
		                        Main.chgBody(26);// 죽음
		                        timer.cancel();
		                        addMydate.timer2.cancel();
		                        chgStus.timer.cancel();
		                     } else {
		                        Main.chgBody(27);
		                     }

		                  } else {
		                     Main.chgBody(23);// 화
		                  }
		               }
		               if (myheart == 0) {// 가출
		                  if (myclean <= 50) {// 질병
		                     if (mystamina == 0 || myfull == 0) {// 죽음
		                        Main.chgBody(26);// 죽음
		                        timer.cancel();
		                        addMydate.timer2.cancel();
		                        chgStus.timer.cancel();
		                     } else if (myfull <= 60) {// 배고픔
		                        Main.chgBody(27);// 배고픔
		                     } else {
		                        Main.chgBody(25);// 질병
		                     }

		                  } else if (myclean == 0 || mystamina == 0 || myfull == 0) {// 죽음
		                     Main.chgBody(26);
		                     timer.cancel();
		                     addMydate.timer2.cancel();
		                     chgStus.timer.cancel();

		                  } else if (myfull <= 60) {// 배고픔
		                     if (myclean <= 50) {// 질병
		                        Main.chgBody(25);// 질병
		                     } else if (myclean == 0 || mystamina == 0) {// 죽음
		                        Main.chgBody(26);// 죽음
		                        timer.cancel();
		                        addMydate.timer2.cancel();
		                        chgStus.timer.cancel();
		                     } else {
		                        Main.chgBody(27);// 배고픔
		                     }

		                  } else {
		                     Main.chgBody(24);// 가출
		                  }
		               }

					// 잠

					// 샤워
					// 더럽

				} else if (mydate > 20 && mydate <= 29) {// 큰닭31~40
				     
		               if (myheart <= 100 && myheart >= 80) {// 행복

		                  if (myclean <= 50) {// 질병
		                     if (mystamina == 0 || myfull == 0) {// 죽음
		                        Main.chgBody(32);// 죽음
		                        timer.cancel();
		                        addMydate.timer2.cancel();
		                        chgStus.timer.cancel();
		                     } else if (myfull <= 60) {// 배고픔
		                        Main.chgBody(33);// 배고픔
		                     } else {
		                        Main.chgBody(34);// 질병
		                     }

		                  } else if (myclean == 0 || mystamina == 0 || myfull == 0) {// 죽음
		                     Main.chgBody(31);
		                     timer.cancel();
		                     addMydate.timer2.cancel();
		                     chgStus.timer.cancel();
		                  } else if (myfull <= 60) {// 배고픔
		                     if (myclean <= 50) {// 질병
		                        Main.chgBody(34);// 질병
		                     } else if (myclean == 0 || mystamina == 0) {// 죽음
		                        Main.chgBody(32);// 죽음
		                        timer.cancel();
		                        addMydate.timer2.cancel();
		                        chgStus.timer.cancel();
		                     } else {
		                        Main.chgBody(33);
		                     }

		                  } else {
		                     Main.chgBody(31);// 행복
		                  }

		               }
		               // -----------------------------------------

		               if (myheart <= 79 && myheart >= 41) {// 기본

		                  if (myclean <= 50) {// 질병
		                     if (mystamina == 0 || myfull == 0) {// 죽음
		                        Main.chgBody(32);// 죽음
		                        timer.cancel();
		                        addMydate.timer2.cancel();
		                        chgStus.timer.cancel();
		                     } else if (myfull <= 60) {// 배고픔
		                        Main.chgBody(33);// 배고픔
		                     } else {
		                        Main.chgBody(34);// 질병
		                     }

		                  } else if (myclean == 0 || mystamina == 0 || myfull == 0) {// 죽음
		                     Main.chgBody(32);
		                     timer.cancel();
		                     addMydate.timer2.cancel();
		                     chgStus.timer.cancel();

		                  } else if (myfull <= 60) {// 배고픔
		                     if (myclean <= 50) {// 질병
		                        Main.chgBody(34);// 질병
		                     } else if (myclean == 0 || mystamina == 0) {// 죽음
		                        Main.chgBody(32);// 죽음
		                        timer.cancel();
		                        addMydate.timer2.cancel();
		                        chgStus.timer.cancel();
		                     } else {
		                        Main.chgBody(33);
		                     }

		                  } else {
		                     Main.chgBody(38);// 기본
		                  }
		               }
		               if (myheart <= 40 && myheart >= 31) {// 슬픔
		                  if (myclean <= 50) {// 질병
		                     if (mystamina == 0 || myfull == 0) {// 죽음
		                        Main.chgBody(32);// 죽음
		                        timer.cancel();
		                        addMydate.timer2.cancel();
		                        chgStus.timer.cancel();
		                     } else if (myfull <= 60) {// 배고픔
		                        Main.chgBody(33);// 배고픔
		                     } else {
		                        Main.chgBody(34);// 질병
		                     }

		                  } else if (myclean == 0 || mystamina == 0 || myfull == 0) {// 죽음
		                     Main.chgBody(32);
		                     timer.cancel();
		                     addMydate.timer2.cancel();
		                     chgStus.timer.cancel();

		                  } else if (myfull <= 60) {// 배고픔
		                     if (myclean <= 50) {// 질병
		                        Main.chgBody(34);// 질병
		                     } else if (myclean == 0 || mystamina == 0) {// 죽음
		                        Main.chgBody(32);// 죽음
		                        timer.cancel();
		                        addMydate.timer2.cancel();
		                        chgStus.timer.cancel();
		                     } else {
		                        Main.chgBody(33);
		                     }

		                  } else {
		                     Main.chgBody(37);// 슬픔
		                  }
		               }
		               if (myheart <= 30 && myheart >= 1) {// 화
		                  if (myclean <= 50) {// 질병
		                     if (mystamina == 0 || myfull == 0) {// 죽음
		                        Main.chgBody(32);// 죽음
		                        timer.cancel();
		                        addMydate.timer2.cancel();
		                        chgStus.timer.cancel();
		                     } else if (myfull <= 60) {// 배고픔
		                        Main.chgBody(33);// 배고픔
		                     } else {
		                        Main.chgBody(34);// 질병
		                     }

		                  } else if (myclean == 0 || mystamina == 0 || myfull == 0) {// 죽음
		                     Main.chgBody(32);
		                     timer.cancel();
		                     addMydate.timer2.cancel();
		                     chgStus.timer.cancel();

		                  } else if (myfull <= 60) {// 배고픔
		                     if (myclean <= 50) {// 질병
		                        Main.chgBody(34);// 질병
		                     } else if (myclean == 0 || mystamina == 0) {// 죽음
		                        Main.chgBody(32);// 죽음
		                        timer.cancel();
		                        addMydate.timer2.cancel();
		                        chgStus.timer.cancel();
		                     } else {
		                        Main.chgBody(33);
		                     }

		                  } else {
		                     Main.chgBody(36);// 화
		                  }
		               }
		               if (myheart == 0) {// 가출
		                  if (myclean <= 50) {// 질병
		                     if (mystamina == 0 || myfull == 0) {// 죽음
		                        Main.chgBody(32);// 죽음
		                        timer.cancel();
		                        addMydate.timer2.cancel();
		                        chgStus.timer.cancel();
		                     } else if (myfull <= 60) {// 배고픔
		                        Main.chgBody(33);// 배고픔
		                     } else {
		                        Main.chgBody(34);// 질병
		                     }

		                  } else if (myclean == 0 || mystamina == 0 || myfull == 0) {// 죽음
		                     Main.chgBody(32);
		                     timer.cancel();
		                     addMydate.timer2.cancel();
		                     chgStus.timer.cancel();

		                  } else if (myfull <= 60) {// 배고픔
		                     if (myclean <= 50) {// 질병
		                        Main.chgBody(34);// 질병
		                     } else if (myclean == 0 || mystamina == 0) {// 죽음
		                        Main.chgBody(32);// 죽음
		                        timer.cancel();
		                        addMydate.timer2.cancel();
		                        chgStus.timer.cancel();
		                     } else {
		                        Main.chgBody(33);
		                     }

		                  } else {
		                     Main.chgBody(35);// 가출
		                  }
		               }
//====================================================================================================
					
					
					//엔딩
				} else if (mydate >= 30) {
					Main.chgBody(40);
					timer.cancel();
					addMydate.timer2.cancel();
					chgStus.timer.cancel();
				}

				// 병아리 에너지 상태 반영
				Main.chgMyheart(retDto);
			}
		};

		timer.scheduleAtFixedRate(task, 0, 1000); // 마이데이트 검사 주기 설정, 1초당 한 번

	}

}
