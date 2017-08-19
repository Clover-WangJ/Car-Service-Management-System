package com.wangwang.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.wangwang.db.DBManager;
import com.wangwang.db.Template;
import com.wangwang.entity.CheXianInfo;
import com.wangwang.entity.CustomInfo;
import com.wangwang.entity.Pinglun;
import com.wangwang.entity.Telmsg;
import com.wangwang.entity.WXxiaofeiInfo;
import com.wangwang.mapping.CustomInfoMapping;
import com.wangwang.mapping.WXxiaofeiInfoMapping;

public class CustomInfoDAO {

	private Template template = new Template();
	Connection con; 
	PreparedStatement psta;
	ResultSet rs;
	public boolean save(CustomInfo customInfo) {

		String sql = "insert into t_custom"
				+ "(addTime,address,birthday,carBrand,carNo,carType,cardNo,charge,cjh,djEndTime,djStartTime,flag,jf,name,phone,type,userName,userPass,addSeller,chargeSeller,activityTimes) "
				+ "values" + "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			return (template.update(sql, customInfo.getAddTime(),customInfo.getAddress(),customInfo.getBirthday(),
					customInfo.getCarBrand(),customInfo.getCarNo(),customInfo.getCarType(),customInfo.getCardNo(),
					customInfo.getCharge(),customInfo.getCjh(),customInfo.getDjEndTime(),customInfo.getDjStartTime(),1,customInfo.getJf(),customInfo.getName(),customInfo.getPhone(),customInfo.getType(),
					customInfo.getUserName(),customInfo.getUserPass(),customInfo.getAddSeller(),customInfo.getChargeSeller(),customInfo.getActivityTimes()) == 1);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}

	// public boolean update(AdminInfo adminInfo) {
	//		
	// String sql = "update adminInfo " +
	// "set " +
	// " adminName = ?," +
	// " adminPassword = ?," +
	// " adminType = ? " +
	// "where adminId = ?" ;
	// try {
	// return (template.update(sql,
	// adminInfo.getAdminName(),adminInfo.getAdminPassword(),
	// adminInfo.getAdminType(),adminInfo.getAdminId()) == 1);
	// } catch (ClassNotFoundException e) {
	// e.printStackTrace();
	// } catch (SQLException e) {
	// e.printStackTrace();
	// }
	// return false;
	// }

	// public boolean delete(int id) {
	// String sql = "delete from AdminInfo where adminId = " + id;
	// System.out.println(sql);
	// try {
	// return (template.update(sql) == 1);
	// } catch (ClassNotFoundException e) {
	// e.printStackTrace();
	// } catch (SQLException e) {
	// e.printStackTrace();
	// }
	//		
	// return false;
	// }

	public CustomInfo findNameAndPwd(String phone, String userPass) {

		String sql = "select id,addTime,address,birthday,carBrand,carNo,carType,cardNo,charge,cjh,djEndTime,djStartTime,flag,jf,name,phone,type,userName,userPass,addSeller,chargeSeller,activityTimes "
				+ " from t_custom " + " where phone = ? and userPass = ?";
		CustomInfo customInfo = null;
		List<CustomInfo> customInfos = null;
		try {
			customInfos = template.query(sql, new CustomInfoMapping(), phone, userPass);
			if (customInfos.size() != 0) {
				customInfo = customInfos.get(0);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return customInfo;
	}
	public List<String> findWXxiaofei(String phone) {
		String sql = "SELECT c.name,c.phone,sr.name,s.name,o.addTime,o.money,o.jf,o.f " +
		"from t_xfcode x,t_order o,t_custom c,t_service s,t_seller sr" +
		" where x.orderId=o.id and o.customId=c.id and o.serviceId=s.id and s.sellerId=sr.id" +
		" and c.phone=" +phone+
		" ORDER BY o.addTime desc";
		List<String> WXxiaofei = new ArrayList<String>();	
		try {
			con = DBManager.getConnection();
			psta = con.prepareStatement(sql);
			rs = psta.executeQuery();
			
			while(rs.next()){
				if(rs.getInt(8)==0){
				WXxiaofei.add(
						rs.getString(3)+ ";" +rs.getString(4)+ ";" +
						rs.getDate(5)+ ";" +(int)rs.getDouble(6)+ ";消费码消费");
				}else{
					WXxiaofei.add(
						rs.getString(3)+ ";" +rs.getString(4)+ ";" +
						rs.getDate(5)+ ";" +(int)(rs.getDouble(6))+ ";现金消费");	
				}

				//System.out.println(Telmsgs);
				
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			
			if (psta != null) {
				try {
					psta.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				psta = null;
			}
		}
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			rs = null;
		}
		return WXxiaofei;
	}
//	public WXxiaofeiInfo findWXxiaofei(String phone) {
//
//		String sql = "SELECT c.name,c.phone,sr.name,s.name,o.addTime,o.money,o.jf,o.f " +
//				"from t_xfcode x,t_order o,t_custom c,t_service s,t_seller sr" +
//				" where x.orderId=o.id and o.customId=c.id and o.serviceId=s.id and s.sellerId=sr.id" +
//				" and c.phone= ? " +
//				" ORDER BY o.addTime desc";
//		WXxiaofeiInfo WXxiaofeiInfo = null;
//		List<WXxiaofeiInfo> WXxiaofeiInfos = null;
//		try {
//			WXxiaofeiInfos = template.query(sql, new WXxiaofeiInfoMapping(), phone);
//			if (WXxiaofeiInfos.size() != 0) {
//				WXxiaofeiInfo = WXxiaofeiInfos.get(0);
//			}
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return WXxiaofeiInfo;
//	}
	public CustomInfo findPwd(String phone) {

		String sql = "select id,addTime,address,birthday,carBrand,carNo,carType,cardNo,charge,cjh,djEndTime,djStartTime,flag,jf,name,phone,type,userName,userPass,addSeller,chargeSeller,activityTimes "
				+ " from t_custom " + " where phone = ?";
		CustomInfo customInfo = null;
		List<CustomInfo> customInfos = null;
		try {
			customInfos = template.query(sql, new CustomInfoMapping(), phone);
			if (customInfos.size() != 0) {
				customInfo = customInfos.get(0);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return customInfo;
	}

	// public List<AdminInfo> findType(int adminType) {
	//		
	// String sql = "select adminId,adminName,adminPassword,adminType " +
	// " from AdminInfo where adminType = " + adminType;
	//		
	// List<AdminInfo> adminInfos = null;
	// try {
	// adminInfos = template.query(sql, new AdminInfoMapping() );
	// } catch (ClassNotFoundException e) {
	// e.printStackTrace();
	// } catch (SQLException e) {
	// e.printStackTrace();
	// }
	// return adminInfos;
	// }
	//	
	public List<CustomInfo> findAll() {

		String sql = "select id,addTime,address,birthday,carBrand,carNo,carType,cardNo,charge,cjh,djEndTime,djStartTime,flag,jf,name,phone,type,userName,userPass,addSeller,chargeSeller,activityTimes from t_custom";

		List<CustomInfo> customInfos = null;
		try {
			customInfos = template.query(sql, new CustomInfoMapping());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return customInfos;
	}
	// public AdminInfo findById(int id) {
	//		
	// String sql = "select " +
	// " adminId,adminName,adminPassword,adminType " +
	// "from AdminInfo" +
	// " where adminId = " + id;
	//		
	// List<AdminInfo> adminInfos = null;
	// try {
	// adminInfos = template.query(sql, new AdminInfoMapping() );
	// } catch (ClassNotFoundException e) {
	// e.printStackTrace();
	// } catch (SQLException e) {
	// e.printStackTrace();
	//		}
	//		return adminInfos.get(0);
	//	}
	
	public boolean updatemima(String phone, String bound_pass) {
		int count = 0;
		String sql = "update t_custom " +
				"set " +
				" userPass = '" +  bound_pass +
				"' where phone = "+phone ;
		try {
			con = DBManager.getConnection();
			psta = con.prepareStatement(sql);
			count = psta.executeUpdate();
			if(count>0){
				return true;
			}else{
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			
			if (psta != null) {
				try {
					psta.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				psta = null;
			}
		}
		return false;	
	}
	
	public boolean updatechepai(String phone, String chepai) {
		int count = 0;
		String sql = "update t_custom " +
				"set " +
				"carNo = '" +  chepai +
				"' where phone = "+phone ;
		try {
			con = DBManager.getConnection();
			psta = con.prepareStatement(sql);
			count = psta.executeUpdate();
			if(count>0){
				return true;
			}else{
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			
			if (psta != null) {
				try {
					psta.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				psta = null;
			}
		}
		return false;	
	}
	
	public boolean updatedizhi(String phone, String dizhi) {
		int count = 0;
		String sql = "update t_custom " +
				"set " +
				"address = '" +  dizhi +
				"' where phone = "+phone ;
		try {
			con = DBManager.getConnection();
			psta = con.prepareStatement(sql);
			count = psta.executeUpdate();
			if(count>0){
				return true;
			}else{
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			
			if (psta != null) {
				try {
					psta.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				psta = null;
			}
		}
		return false;	
	}	
	
	public boolean updatename(String phone, String name) {
		int count = 0;
		String sql = "update t_custom " +
				"set " +
				"name = '" +  name +
				"' where phone = "+phone ;
		try {
			con = DBManager.getConnection();
			psta = con.prepareStatement(sql);
			count = psta.executeUpdate();
			if(count>0){
				return true;
			}else{
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			
			if (psta != null) {
				try {
					psta.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				psta = null;
			}
		}
		return false;	
	}	
	
	public boolean updateshouji(String phone,String shouji) {
		int count = 0;
		String sql = "update t_custom " +
				"set " +
				"phone = '" +  shouji +
				"' where phone = "+phone ;
		try {
			con = DBManager.getConnection();
			psta = con.prepareStatement(sql);
			count = psta.executeUpdate();
			if(count>0){
				return true;
			}else{
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			
			if (psta != null) {
				try {
					psta.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				psta = null;
			}
		}
		return false;	
	}
	public boolean updateinfo(String phone,String dizhi,String chepai) {
		int count = 0;
		String sql = "update t_custom " +
				"set " +
				"address = '" + dizhi +
				"',carNo='" + chepai +
				"' where phone = "+phone ;
		try {
			con = DBManager.getConnection();
			psta = con.prepareStatement(sql);
			count = psta.executeUpdate();
			if(count>0){
				return true;
			}else{
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			
			if (psta != null) {
				try {
					psta.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				psta = null;
			}
		}
		return false;	
	}	
public boolean addCheXian(CheXianInfo cheXianInfo) {
		
		String sql = "insert into t_chexian" +
				"	(baoxiangs,chepaihao,shenfenzheng,tel,leixing,xinghao,shibiehao,fadongjihao,chushiriqi)" +
				"values " +
				"	(?,?,?,?,?,?,?,?,?)";
		
		try {
			return (template.update(sql,
					cheXianInfo.getBaoxiangs(),
					cheXianInfo.getChepaihao(),
					cheXianInfo.getShenfenzheng(),
					cheXianInfo.getTel(),
					cheXianInfo.getLeixing(),
					cheXianInfo.getXinghao(),
					cheXianInfo.getShibiehao(),
					cheXianInfo.getFadongjihao(),
					cheXianInfo.getChushiriqi()) == 1);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean updatePL(Pinglun pinglun) {
		String sql = "insert into t_advise" +
				"	(tel,msg,level,time,shopid)" +
				"values " +
				"	(?,?,?,?,?)";
		
		try {
			return (template.update(sql,
					pinglun.getTel(),pinglun.getMsg(),pinglun.getLevel(),pinglun.getTime(),pinglun.getShopid()) == 1);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	public List<String> findtelmsg(String phone) {
	String sql = "select * from t_sms where phone ="+phone+" order by id desc";
	List<String> Telmsgs = new ArrayList<String>();	
	try {
		con = DBManager.getConnection();
		psta = con.prepareStatement(sql);
		rs = psta.executeQuery();
		
		while(rs.next()){

			Telmsgs.add(rs.getString(2).substring(0, rs.getString(2).length()-2)+"收到消息:"+rs.getString(3));
			//System.out.println(Telmsgs);
			
		}
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	} catch (SQLException e) {
		e.printStackTrace();
	}
	finally {
		
		if (psta != null) {
			try {
				psta.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			psta = null;
		}
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			rs = null;
		}
	}
	return Telmsgs;
}
	public boolean saveTelmsg(Telmsg telmsg) {

		String sql = "insert into t_sms" +
					"(addTime,content,phone) " +
					"values" +
					"(?,?,?)";
		try {
			return (template.update(sql,telmsg.getPhone(),telmsg.getContent(),telmsg.getAddTime()) == 1);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;	
	}
	public boolean update(String tel,String times) {
		int count = 0;
		String sql = "update t_custom " +
					"set " +
					" jf = 1,carBrand = '" +times+
					"' where phone = "+tel ;
		System.out.println(sql);
		try {
			con = DBManager.getConnection();
			psta = con.prepareStatement(sql);
			count = psta.executeUpdate();
			if(count>0){
				return true;
			}else{
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			
			if (psta != null) {
				try {
					psta.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				psta = null;
			}
		}
		return false;	
	}
	public List<String> findadvise(String shopid) {
		String sql = "select * from t_advise where shopid="+shopid+" order by id desc";
		List<String> advises = new ArrayList<String>();	
		try {
			con = DBManager.getConnection();
			psta = con.prepareStatement(sql);
			rs = psta.executeQuery();
			
			while(rs.next()){
				if(rs.getString(5)==null||rs.getString(5).length()<=0||rs.getString(5).trim()==""){
					advises.add(rs.getString(4)+rs.getString(2)+"2014-02-20"+rs.getString(3));
				}else{
					advises.add(rs.getString(4)+rs.getString(2)+rs.getString(5)+rs.getString(3));
				}
				System.out.println(rs.getString(4)+rs.getString(2)+rs.getString(5)+rs.getString(3));
		
				
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			
			if (psta != null) {
				try {
					psta.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				psta = null;
			}
		}
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			rs = null;
		}
		return advises;
	}
	public boolean checkshoujihao(String phone) {
		String sql = "select * from t_custom where phone ="+phone;
		try {
			con = DBManager.getConnection();
			psta = con.prepareStatement(sql);
			rs = psta.executeQuery();
			if(rs.next()){
				
				return true;
			}else{
				
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			
			if (psta != null) {
				try {
					psta.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				psta = null;
			}if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				rs = null;
			}
		}
		return false;	
	}

}
