package com.wangwang.dao;

import java.sql.SQLException;
import java.util.List;

import com.wangwang.conver.Conver;
import com.wangwang.db.Template;

import com.wangwang.entity.FavoritesInfo;
import com.wangwang.mapping.FavoritesInfoMapping;

public class FavoritesInfoDAO {

	private Template template = new Template();

	public boolean save(FavoritesInfo favoritesInfo) {

		String sql = "insert into favoritesInfo"
				+ "	(bookId,customerId,date,context) " +
				"	values" + 
				"	(?,?,?,?)";
		String date = Conver.ConverToString(favoritesInfo.getDate());
		Object[] values = { favoritesInfo.getBookId(),
				favoritesInfo.getCustomerId(), date, favoritesInfo.getContext() };

		try {
			return (template.update(sql, values) == 1);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	public boolean update(FavoritesInfo favoritesInfo) {

		String sql = "update favoritesInfo" +
					"set" +
					"	bookId = ?," +
					"	customerId = ?," +
					"	date = ?," +
					"	context = ? "  +
					"where favoritesId = ?";
		String date = Conver.ConverToString(favoritesInfo.getDate());
		Object[] values = { favoritesInfo.getBookId(),
				favoritesInfo.getCustomerId(), date, favoritesInfo.getContext(),favoritesInfo.getFavoritesId() };

		try {
			return (template.update(sql, values) == 1);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	public boolean delete(int id) {
		
		String sql = "delete from favoritesInfo where favoritesId = " + id;
		
		try {
			return (template.update(sql) == 1);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public List<FavoritesInfo> findAll() {
		String sql = "select" +
					"	favoritesId,bookId,customerId,date,context" +
					"from favoritesInfo";
		List<FavoritesInfo> favoritesInfos = null;
		
		try {
			favoritesInfos = template.query(sql, new FavoritesInfoMapping());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return favoritesInfos;
	}

	public FavoritesInfo findById(int id) {
		String sql = "select" +
					"	favoritesId,bookId,customerId,date,context" +
					"from favoritesInfo" +
					"where favoritesId = " + id;
		
		List<FavoritesInfo> favoritesInfos = null;
		
		try {
			favoritesInfos = template.query(sql, new FavoritesInfoMapping());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return favoritesInfos.get(0);
	}
}
