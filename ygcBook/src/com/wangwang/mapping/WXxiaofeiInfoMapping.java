package com.wangwang.mapping;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import com.wangwang.db.EntityMapping;
import com.wangwang.entity.CusInfo;
import com.wangwang.entity.WXxiaofeiInfo;

public class WXxiaofeiInfoMapping implements EntityMapping {

	@Override
	public WXxiaofeiInfo mapping(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		int i = 1;

		WXxiaofeiInfo WXxiaofeiInfo = new WXxiaofeiInfo(rs.getString(i++),
				rs.getString(i++), rs.getString(i++), rs.getString(i++),
				rs.getDate(i++), rs.getDouble(i++), rs.getDouble(i++),
				rs.getInt(i++));
		return WXxiaofeiInfo;
	}

	
}
