package com.test.monja.mongodao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.test.monja.mongodto.MongoDto;

@Repository
public class MongoDao {

	/*
	 * db.score.insert({name:"홍길동", kor:50, eng:40, math:100})
	 * db.score.insert({name:"김선달", kor:100, eng:50, math:20})
	 * db.score.insert({name:"이순신", kor:80, eng:70, math:100})
	 */
	@Autowired
	private MongoTemplate mongoTemplate;
	
	public List<MongoDto> findAll(){
		
		List<MongoDto> list = mongoTemplate.findAll(MongoDto.class,"score");
		
		return list;
	}
}
