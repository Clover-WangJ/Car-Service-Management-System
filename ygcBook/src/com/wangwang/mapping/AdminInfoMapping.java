package com.wangwang.mapping;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.wangwang.db.EntityMapping;
import com.wangwang.entity.AdminInfo;

public class AdminInfoMapping  implements EntityMapping{

	@Override
	public AdminInfo mapping(ResultSet rs) throws SQLException {
		int i = 1;
		AdminInfo adminInfo = new AdminInfo(rs.getInt(i++),rs.getString(i++),rs.getString(i++),rs.getInt(i++));
		return adminInfo;
	}

}
