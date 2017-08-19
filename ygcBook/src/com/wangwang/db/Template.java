package com.wangwang.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import com.wangwang.db.DBManager;
import com.wangwang.entity.BookType;

public class Template {
	
	
	public int update(String sql, Object... values) throws ClassNotFoundException, SQLException {
		PreparedStatement psta = null;
		System.out.println(sql);
		int row = 0;
		try {
			Connection con = DBManager.getConnection();
			psta = con.prepareStatement(sql);
			for (int i = 0; i < values.length; i++) {
				psta.setObject(i + 1, values[i]);
			}
			row = psta.executeUpdate();
		}finally {
			if (psta != null) {
				psta.close();
				psta = null;
			}
		}
		
		return row;
	}
	
	public List query(String sql, EntityMapping mapping, Object... values) throws ClassNotFoundException, SQLException {
		System.out.println(sql);
		PreparedStatement psta = null;
		ResultSet rs = null;
		
		List<Object> list = new Vector<Object>();
		
		Connection con;
		try {
			con = DBManager.getConnection();
			psta = con.prepareStatement(sql);
			for (int i = 0; i < values.length; i++) {
				psta.setObject(i + 1, values[i]);
			}
			rs = psta.executeQuery();
			
			while (rs.next()) {
				list.add(mapping.mapping(rs));
				
			}
			
		} finally {
			if (rs != null) {
				rs.close();
				rs = null;
			}
			if (psta != null) {
				psta.close();
				psta = null;
			}
		}
		
		return list;
	}
	
	public int query(String sql) throws ClassNotFoundException, SQLException {
		int result = 0;
		PreparedStatement psta = null;
		ResultSet rs = null;
		try {
			Connection con = DBManager.getConnection();
			psta = con.prepareStatement(sql);
			rs = psta.executeQuery();
			if (rs.next()) {
				result = rs.getInt(1);
			}
		}finally {
				if (rs != null) {
					rs.close();
					rs = null;
				}
				if (psta != null) {
					psta.close();
					psta = null;
				}
			}
			return result;
		 
		
	}

}
