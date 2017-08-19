package com.wangwang.gwc;

import java.util.Collection;
import java.util.Hashtable;
import java.util.Set;



public class Gwc {
	
	Hashtable<Integer,GwcItem> gwcItems = new Hashtable<Integer,GwcItem>();
	
	
	/**
	 * 得到购物车中所有商品集合
	 * @return
	 */
	public Collection<GwcItem> getItems() {
		return gwcItems.values();
	}
	
	/**
	 * 往购物车中添加一种商品
	 * @param item
	 */
	public void addBook(GwcItem item) {
		//返回所有键集合（购物车中所有商品编号集合）
		Set<Integer> ids = gwcItems.keySet();
		//得到新增商品编号
		Integer itemId = item.getBookId();
		//检测此编号是否在原有商品编号集合中
		if (ids.contains(itemId)) {//如果已有
			GwcItem oldGwcItem = gwcItems.get(itemId);//得到原始商品
			oldGwcItem.setNum(oldGwcItem.getNum() + 1);//数量加一
			gwcItems.put(itemId, oldGwcItem);//把老商品覆盖，此代码可省略
			
		}else{//若没，直接放
			gwcItems.put(itemId, item);
		}
	}
	
	/**
	 * 修改购物车中某种商品数量
	 * @param id 要修改的商品编号
	 * @param num  具体数量
	 */
	public void updateNum(int id , int num) {
		GwcItem oldGwcItem = gwcItems.get(id);//得到原始物品
		oldGwcItem.setNum(num);//直接输入数量
		gwcItems.put(id, oldGwcItem);//覆盖，可省略
	}
	
	/**
	 * 删除购物车中某种商品
	 * @param id
	 */
	public void delete(int id) {
		gwcItems.remove(id);
	}
	/**
	 * 清空购物车
	 * 
	 */
	public void clear() {
		gwcItems.clear();
	}
	
/*	*//**
	 * 云工厂会员价
	 * @return
	 *//*
	public float getYgcPriceCount() {
		float sum = 0;
		Collection<GwcItem> items = gwcItems.values();
		for (GwcItem gwcItem : items) {
			sum += gwcItem.getYgcprice() * gwcItem.getNum();
		}
		return sum;
	}
	*//**
	 * 原始总价
	 * @return
	 *//*
	public float getPriceCount() {
		float sum = 0;
		Collection<GwcItem> items = gwcItems.values();
		for (GwcItem gwcItem : items) {
			sum += gwcItem.getPrice() * gwcItem.getNum();
		}
		return sum;
	}*/
	
	/**
	 * 0为原价 1为会员价
	 * @return
	 */
	public float[] getSumPrice () {
		float [] prices = new float[]{0,0};
		Collection<GwcItem> items = gwcItems.values();
		for (GwcItem gwcItem : items) {
			prices[0] += gwcItem.getPrice() * gwcItem.getNum();
			prices[1] += gwcItem.getYgcprice() * gwcItem.getNum();
		}
		return prices;
	}
	public int getNum() {
		int num  = 0;
		Collection<GwcItem> items = gwcItems.values();
		for (GwcItem gwcItem : items) {
			 num += gwcItem.getNum();
		}
		
		return num;
	}
}
