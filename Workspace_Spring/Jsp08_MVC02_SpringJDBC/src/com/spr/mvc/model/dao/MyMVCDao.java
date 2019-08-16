package com.spr.mvc.model.dao;

import java.util.List;

import com.spr.mvc.model.dto.MyMVCDto;

public interface MyMVCDao {

	String selectListSql = " SELECT SEQ,WRITER,TITLE,CONTENT,REGDATE FROM MYMVCBOARD ";
	String selectOneSql = " SELECT SEQ,WRITER,TITLE,CONTENT,REGDATE FROM MYMVCBOARD WHERE SEQ = ? ";
	String insertSql = " INSERT INTO MYMVCBOARD(SEQ, WRITER, TITLE, CONTENT, REGDATE) VALUES(MYMVCBOARDSEQ.NEXTVAL, ?, ?, ?, SYSDATE) ";
	String updateSql = " UPDATE MYMVCBOARD SET TITLE = ?, CONTENT = ? WHERE SEQ = ? ";
	String deleteSql = " DELETE FROM MYMVCBOARD WHERE SEQ = ? ";
	
	public List<MyMVCDto> selectList();
	public MyMVCDto selectOne(int seq);
	public int insert(MyMVCDto dto);
	public int update(MyMVCDto dto);
	public int delete(int seq);
	public int muldel(int[] seq);
	
}
