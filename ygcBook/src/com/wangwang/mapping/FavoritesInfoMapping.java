package com.wangwang.mapping;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.wangwang.db.EntityMapping;
import com.wangwang.entity.FavoritesInfo;

public class FavoritesInfoMapping implements EntityMapping{

	@Override
	public FavoritesInfo mapping(ResultSet rs) throws SQLException {
		int i = 1;
		
		FavoritesInfo favoritesInfo = new FavoritesInfo(rs.getInt(i++),rs.getInt(i++),rs.getInt(i++),rs.getDate(i++),rs.getString(i++));
		return favoritesInfo;
	}

}
