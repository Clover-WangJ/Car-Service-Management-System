package com.wangwang.dao;

import java.sql.SQLException;
import java.util.List;

import com.wangwang.db.Template;
import com.wangwang.entity.AdminInfo;
import com.wangwang.mapping.AdminInfoMapping;

public class AdminInfoDAO {
	
	private Template template = new Template();
	
	
	public boolean save(AdminInfo adminInfo) {
		
		String sql = "insert into adminInfo" +
					"	(adminName,adminPassword,adminType) " +
					"values" +
					"	(?,?,?)";
		try {
			return (template.update(sql, adminInfo.getAdminName(),adminInfo.getAdminPassword(),adminInfo.getAdminType()) == 1);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;	
	}
	
	public boolean update(AdminInfo adminInfo) {
		
		String sql = "update adminInfo " +
					"set " +
					"	adminName = ?," +
					"	adminPassword = ?," +
					"	adminType = ? " +
					"where adminId = ?" ;
		try {
			return (template.update(sql, adminInfo.getAdminName(),adminInfo.getAdminPassword(),
					adminInfo.getAdminType(),adminInfo.getAdminId()) == 1);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;	
	}
	
	public boolean delete(int  id) {
		String sql = "delete from AdminInfo where adminId = " + id;
		System.out.println(sql);
		try {
			return (template.update(sql) == 1);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	public AdminInfo findNameAndPwd(String name, String pwd) {
		
		String sql = "select adminId,adminName,adminPassword,adminType " +
					" from AdminInfo " +
					" where adminName = ? and adminPassword = ?";
		AdminInfo adminInfo = null;
		List<AdminInfo> adminInfos = null;
		try {
			adminInfos = template.query(sql, new AdminInfoMapping(),name, pwd );
			if (adminInfos.size() != 0) {
				adminInfo = adminInfos.get(0);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return adminInfo;
	}
	
	
	public List<AdminInfo> findType(int adminType) {
		
		String sql = "select adminId,adminName,adminPassword,adminType " +
				"	from AdminInfo where adminType = " + adminType;
		
		List<AdminInfo> adminInfos = null;
		try {
			adminInfos = template.query(sql, new AdminInfoMapping() );
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return adminInfos;
	}
	
	public List<AdminInfo> findAll() {
		
		String sql = "select adminId,adminName,adminPassword,adminType from AdminInfo";
		
		List<AdminInfo> adminInfos = null;
		try {
			adminInfos = template.query(sql, new AdminInfoMapping() );
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return adminInfos;
	}
	public AdminInfo findById(int id) {
		
		String sql = "select " +
					 "	adminId,adminName,adminPassword,adminType " +
					 "from AdminInfo" +
					 " where adminId = " + id;
		
		List<AdminInfo> adminInfos = null;
		try {
			adminInfos = template.query(sql, new AdminInfoMapping() );
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return adminInfos.get(0);
	}
}
