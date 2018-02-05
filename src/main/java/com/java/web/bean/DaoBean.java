package com.java.web.bean;

import java.util.HashMap;

public class DaoBean {
	
	String type;
	String sql;
	HashMap<String, Object> params;
	
	
	
	public DaoBean(String type, String sql, HashMap<String, Object> params) {
		this.type = type;
		this.sql = sql;
		this.params = params;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getSql() {
		return sql;
	}
	public void setSql(String sql) {
		this.sql = sql;
	}
	public HashMap<String, Object> getParams() {
		return params;
	}
	public void setParams(HashMap<String, Object> params) {
		this.params = params;
	}
	@Override
	public String toString() {
		return "DaoBean [type=" + type + ", sql=" + sql + ", params=" + params + "]";
	}

}
	
	
