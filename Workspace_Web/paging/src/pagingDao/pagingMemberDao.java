package pagingDao;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;

import pagingDto.pagingMemberDto;

public class pagingMemberDao extends SqlMapConfig{
	
	String namespace = "pagingmapper.";
	
	public pagingMemberDto login(String id, String pw) {
		pagingMemberDto dto = new pagingMemberDto();
		
		SqlSession session = null;
		
		HashMap<String, String> map = new HashMap<String, String>();
		
		map.put("paging_id", id);
		map.put("paging_pw", pw);
		
		System.out.println("dao= : " + id + " : " + pw);
		

		session = getSqlSessionFactory().openSession(false);
			
		dto = session.selectOne(namespace + "login", map);
		
		session.close();
	
		return dto;
	}
}
