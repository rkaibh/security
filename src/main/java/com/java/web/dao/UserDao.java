package com.java.web.dao;

import java.util.HashMap;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao implements UserDaoInterface {

	@Resource(name="sqlSession")
	SqlSession session;
	

	@Override
	public int addUser(HashMap<String, Object> param) {
		return session.insert("sql.insert", param);
	}

}
