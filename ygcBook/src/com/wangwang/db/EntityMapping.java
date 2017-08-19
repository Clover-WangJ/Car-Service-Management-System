package com.wangwang.db;

import java.sql.ResultSet;
import java.sql.SQLException;



public interface EntityMapping {
	public Object mapping(ResultSet rs) throws SQLException;
}
