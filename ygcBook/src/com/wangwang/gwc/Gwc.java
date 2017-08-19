package com.wangwang.gwc;

import java.util.Collection;
import java.util.Hashtable;
import java.util.Set;



public class Gwc {
	
	Hashtable<Integer,GwcItem> gwcItems = new Hashtable<Integer,GwcItem>();
	
	
	/**
	 * �õ����ﳵ��������Ʒ����
	 * @return
	 */
	public Collection<GwcItem> getItems() {
		return gwcItems.values();
	}
	
	/**
	 * �����ﳵ�����һ����Ʒ
	 * @param item
	 */
	public void addBook(GwcItem item) {
		//�������м����ϣ����ﳵ��������Ʒ��ż��ϣ�
		Set<Integer> ids = gwcItems.keySet();
		//�õ�������Ʒ���
		Integer itemId = item.getBookId();
		//���˱���Ƿ���ԭ����Ʒ��ż�����
		if (ids.contains(itemId)) {//�������
			GwcItem oldGwcItem = gwcItems.get(itemId);//�õ�ԭʼ��Ʒ
			oldGwcItem.setNum(oldGwcItem.getNum() + 1);//������һ
			gwcItems.put(itemId, oldGwcItem);//������Ʒ���ǣ��˴����ʡ��
			
		}else{//��û��ֱ�ӷ�
			gwcItems.put(itemId, item);
		}
	}
	
	/**
	 * �޸Ĺ��ﳵ��ĳ����Ʒ����
	 * @param id Ҫ�޸ĵ���Ʒ���
	 * @param num  ��������
	 */
	public void updateNum(int id , int num) {
		GwcItem oldGwcItem = gwcItems.get(id);//�õ�ԭʼ��Ʒ
		oldGwcItem.setNum(num);//ֱ����������
		gwcItems.put(id, oldGwcItem);//���ǣ���ʡ��
	}
	
	/**
	 * ɾ�����ﳵ��ĳ����Ʒ
	 * @param id
	 */
	public void delete(int id) {
		gwcItems.remove(id);
	}
	/**
	 * ��չ��ﳵ
	 * 
	 */
	public void clear() {
		gwcItems.clear();
	}
	
/*	*//**
	 * �ƹ�����Ա��
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
	 * ԭʼ�ܼ�
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
	 * 0Ϊԭ�� 1Ϊ��Ա��
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
