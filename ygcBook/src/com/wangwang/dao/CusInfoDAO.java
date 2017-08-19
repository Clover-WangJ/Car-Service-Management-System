package com.wangwang.dao;

import java.sql.SQLException;
import java.util.List;

import com.wangwang.db.Template;
import com.wangwang.entity.CusInfo;
import com.wangwang.mapping.AdminInfoMapping;
import com.wangwang.mapping.CusInfoMapping;

public class CusInfoDAO {

	private Template template = new Template();
	
	
	public boolean save(CusInfo cusInfo) {

		String sql = "insert into cusInfo" +
					"(customerName,pwd,tel,sex,age,qq,countManey,customerAddress,email,addTime,birthday) " +
					"values" +
					"(?,?,?,?,?,?,?,?,?,?,?)";
		try {
			return (template.update(sql, cusInfo.getCustomerName(),cusInfo.getPwd(),cusInfo.getTel(),
					cusInfo.getSex(),cusInfo.getAge(),cusInfo.getQq(),cusInfo.getCountManey(),
					cusInfo.getCustomerAddress(),cusInfo.getEmail(),cusInfo.getAddTime(),cusInfo.getBirthday()) == 1);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;	
	}
	
//	public boolean update(AdminInfo adminInfo) {
//		
//		String sql = "update adminInfo " +
//					"set " +
//					"	adminName = ?," +
//					"	adminPassword = ?," +
//					"	adminType = ? " +
//					"where adminId = ?" ;
//		try {
//			return (template.update(sql, adminInfo.getAdminName(),adminInfo.getAdminPassword(),
//					adminInfo.getAdminType(),adminInfo.getAdminId()) == 1);
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return false;	
//	}
	
//	public boolean delete(int  id) {
//		String sql = "delete from AdminInfo where adminId = " + id;
//		System.out.println(sql);
//		try {
//			return (template.update(sql) == 1);
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		
//		return false;
//	}
	
	public CusInfo findNameAndPwd(String tel,String pwd) {
		
		String sql = "select customerId,customerName,pwd,tel,sex,age,qq,countManey,customerAddress,email,addTime,birthday " +
					" from CusInfo " +
					" where tel = ? and pwd = ?";
		CusInfo cusInfo = null;
		List<CusInfo> cusInfos = null;
		try {
			cusInfos = template.query(sql, new CusInfoMapping(),tel,pwd );
			if (cusInfos.size() != 0) {
				cusInfo = cusInfos.get(0);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cusInfo;
	}
	public boolean findName(String name) {
		
		String sql = "select count(*) " +
					" from CusInfo " +
					" where customerName = ?";
		CusInfo cusInfo = null;
		List<CusInfo> cusInfos = null;
		try {
			cusInfos = template.query(sql, new CusInfoMapping(),name);
			if (cusInfos.size() != 0) {
				cusInfo = cusInfos.get(0);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}	
	
//	public List<AdminInfo> findType(int adminType) {
//		
//		String sql = "select adminId,adminName,adminPassword,adminType " +
//				"	from AdminInfo where adminType = " + adminType;
//		
//		List<AdminInfo> adminInfos = null;
//		try {
//			adminInfos = template.query(sql, new AdminInfoMapping() );
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return adminInfos;
//	}
//	
	public List<CusInfo> findAll() {
		
		String sql = "select customerId,customerName,pwd,tel,sex,age,qq,countManey,customerAddress,email,addTime,birthday from AdminInfo";
		
		List<CusInfo> CusInfos = null;
		try {
			CusInfos = template.query(sql, new CusInfoMapping() );
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return CusInfos;
	}
//	public AdminInfo findById(int id) {
//		
//		String sql = "select " +
//					 "	adminId,adminName,adminPassword,adminType " +
//					 "from AdminInfo" +
//					 " where adminId = " + id;
//		
//		List<AdminInfo> adminInfos = null;
//		try {
//			adminInfos = template.query(sql, new AdminInfoMapping() );
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return adminInfos.get(0);
//	}
}
