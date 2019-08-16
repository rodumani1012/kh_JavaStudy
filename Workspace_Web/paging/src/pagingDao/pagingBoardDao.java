package pagingDao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import pagingDto.pagingBoardDto;

public class pagingBoardDao extends SqlMapConfig {
	String namespace = "pagingmapper.";
	
	public List<pagingBoardDto> boardlist(int page){
		int startnum = (page-1)*10+1;	//	페이지 시작번호
		int endnum = page*10;			//	페이지 끝번호
		
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("startNum", startnum);
		map.put("endNum",endnum);
		
		List<pagingBoardDto> list = new ArrayList<pagingBoardDto>();
		SqlSession session = null;
		
		try {
			session = getSqlSessionFactory().openSession();
			list = session.selectList(namespace + "boardlist",map);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return list;
	}
	
	
	public int getAllcount() {
		int count = 0;
		
		SqlSession session = null;
		try {
			session = getSqlSessionFactory().openSession();
			count = session.selectOne(namespace + "pagecount");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}
	
	
	public int insertpage() {
		SqlSession session = null;
		
		int res = 0;
		
		int res1 = 0;
		int res2 = 0;
		int res3 = 0;
		int res4 = 0;
		
		int a = 0;
		
		HashMap<String,String> map = new HashMap<String, String>();
		
		try {
			session = getSqlSessionFactory().openSession(false);
			
			for(int i = 0 ; i <33 ; i++) {
				map.clear();

				if(i%2 == 1) {
					a = (int)(Math.random() * 100) + 1 ;
					map.put("board_title1", (i+1 + a)+" 번글입니다!");
					map.put("board_content1", (i+1 + a)+ " 번글 내용입니다!");
					res1 = session.insert(namespace + "insertpage1", map);
					map.clear();
					
					if(res1 > 0 ) {
						session.commit();
					}
					
					a = (int)(Math.random() * 100) + 1 ;
					map.put("board_title2",(i+2 + a)+" 번글입니다!");
					map.put("board_content2", (i+2 + a)+ " 번글 내용입니다!");
					res2 = session.insert(namespace + "insertpage2", map);
					map.clear();
					
					if(res2 > 0 ) {
						session.commit();
					}
					
					a = (int)(Math.random() * 100) + 1 ;
					map.put("board_title3", (i+3 + a)+" 번글입니다!");
					map.put("board_content3", (i+3 + a)+ " 번글 내용입니다!");
					res3 = session.insert(namespace + "insertpage3" , map);
					map.clear();
					
					if(res3 > 0 ) {
						session.commit();
					}
					
					a = (int)(Math.random() * 100) + 1 ;
					map.put("board_title4", (i+4+a)+" 번글입니다!");
					map.put("board_content4", (i+4+a)+ " 번글 내용입니다!");
					res4 = session.insert(namespace + "insertpage4", map);
					map.clear();
					
					if(res4 > 0 ) {
						session.commit();
					}
				} else if (i%2 == 2) {
					
					a = (int)(Math.random() * 100) + 1 ;
					map.put("board_title3", (i+3+a)+" 번글입니다!");
					map.put("board_content3", (i+3+a)+ " 번글 내용입니다!");
					res3 = session.insert(namespace + "insertpage3" , map);
					map.clear();
					
					if(res3 > 0 ) {
						session.commit();
					}
					
					map.put("board_title2",i+2+" 번글입니다!");
					map.put("board_content2", i+2+ " 번글 내용입니다!");
					res2 = session.insert(namespace + "insertpage2", map);
					map.clear();
					
					if(res2 > 0 ) {
						session.commit();
					}
					
					a = (int)(Math.random() * 100) + 1 ;
					map.put("board_title1",i+1+a+" 번글입니다!");
					map.put("board_content1", i+1+a+ " 번글 내용입니다!");
					res1 = session.insert(namespace + "insertpage1", map);
					map.clear();
					
					if(res1 > 0 ) {
						session.commit();
					}
					
					map.put("board_title4",i+4+" 번글입니다!");
					map.put("board_content4", i+4+ " 번글 내용입니다!");
					res4 = session.insert(namespace + "insertpage4", map);
					map.clear();
					
					if(res4 > 0 ) {
						session.commit();
					}
				} else {
					a = (int)(Math.random() * 100) + 1 ;

					map.put("board_title2", (i+2+a)+" 번글입니다!");
					map.put("board_content2", (i+2+a)+ " 번글 내용입니다!");
					res2 = session.insert(namespace + "insertpage2", map);
					map.clear();
					
					if(res2 > 0 ) {
						session.commit();
					}
					
					a = (int)(Math.random() * 100) + 1 ;

					map.put("board_title4",i+4+a+" 번글입니다!");
					map.put("board_content4", i+a+4+ " 번글 내용입니다!");
					res4 = session.insert(namespace + "insertpage4", map);
					map.clear();
					
					if(res4 > 0 ) {
						session.commit();
					}
					
					a = (int)(Math.random() * 100) + 1 ;

					map.put("board_title1",i+1+a+" 번글입니다!");
					map.put("board_content1", i+1+a+ " 번글 내용입니다!");
					res1 = session.insert(namespace + "insertpage1", map);
					map.clear();
					
					if(res1 > 0 ) {
						session.commit();
					}
					
					a = (int)(Math.random() * 100) + 1 ;

					map.put("board_title3",i+3+a+" 번글입니다!");
					map.put("board_content3", i+a+3+ " 번글 내용입니다!");
					res3 = session.insert(namespace + "insertpage3", map);
					map.clear();
					
					if(res3 > 0 ) {
						session.commit();
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return res;
	}
}
