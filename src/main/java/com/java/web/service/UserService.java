package com.java.web.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.web.bean.DaoBean;
import com.java.web.dao.DaoInterface;

@Service
public class UserService implements UserServiceInterface {

	@Autowired
	DaoInterface di;
	
	private final String ns = "sql";
	private HashMap<String, Object> result;
	private DaoBean bean;
	
	@Override
	public HashMap<String, Object> addUser(HashMap<String, Object> param) {
		bean = new DaoBean("Insert", ns+".insert", param);
		result = new HashMap<String, Object>();
		result.put("status", di.dao(bean));
		if(result.get("status").equals(1)) {
			return result;
		}
		return null;
	}

}
