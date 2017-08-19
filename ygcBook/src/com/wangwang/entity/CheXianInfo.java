package com.wangwang.entity;

import java.util.Date;

public class CheXianInfo {
	private String baoxiangs;
	private String chepaihao;
	private String shenfenzheng;
	private String tel;
	private String leixing;
	private String xinghao;
	private String shibiehao;
	private String fadongjihao;
	private String chushiriqi;
	public String getBaoxiangs() {
		return baoxiangs;
	}
	public void setBaoxiangs(String baoxiangs) {
		this.baoxiangs = baoxiangs;
	}
	public String getChepaihao() {
		return chepaihao;
	}
	public void setChepaihao(String chepaihao) {
		this.chepaihao = chepaihao;
	}
	public String getShenfenzheng() {
		return shenfenzheng;
	}
	public void setShenfenzheng(String shenfenzheng) {
		this.shenfenzheng = shenfenzheng;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getLeixing() {
		return leixing;
	}
	public void setLeixing(String leixing) {
		this.leixing = leixing;
	}
	public String getXinghao() {
		return xinghao;
	}
	public void setXinghao(String xinghao) {
		this.xinghao = xinghao;
	}
	public String getShibiehao() {
		return shibiehao;
	}
	public void setShibiehao(String shibiehao) {
		this.shibiehao = shibiehao;
	}
	public String getFadongjihao() {
		return fadongjihao;
	}
	public void setFadongjihao(String fadongjihao) {
		this.fadongjihao = fadongjihao;
	}
	public String getChushiriqi() {
		return chushiriqi;
	}
	public void setChushiriqi(String chushiriqi) {
		this.chushiriqi = chushiriqi;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((baoxiangs == null) ? 0 : baoxiangs.hashCode());
		result = prime * result
				+ ((chepaihao == null) ? 0 : chepaihao.hashCode());
		result = prime * result
				+ ((chushiriqi == null) ? 0 : chushiriqi.hashCode());
		result = prime * result
				+ ((fadongjihao == null) ? 0 : fadongjihao.hashCode());
		result = prime * result + ((leixing == null) ? 0 : leixing.hashCode());
		result = prime * result
				+ ((shenfenzheng == null) ? 0 : shenfenzheng.hashCode());
		result = prime * result
				+ ((shibiehao == null) ? 0 : shibiehao.hashCode());
		result = prime * result + ((tel == null) ? 0 : tel.hashCode());
		result = prime * result + ((xinghao == null) ? 0 : xinghao.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CheXianInfo other = (CheXianInfo) obj;
		if (baoxiangs == null) {
			if (other.baoxiangs != null)
				return false;
		} else if (!baoxiangs.equals(other.baoxiangs))
			return false;
		if (chepaihao == null) {
			if (other.chepaihao != null)
				return false;
		} else if (!chepaihao.equals(other.chepaihao))
			return false;
		if (chushiriqi == null) {
			if (other.chushiriqi != null)
				return false;
		} else if (!chushiriqi.equals(other.chushiriqi))
			return false;
		if (fadongjihao == null) {
			if (other.fadongjihao != null)
				return false;
		} else if (!fadongjihao.equals(other.fadongjihao))
			return false;
		if (leixing == null) {
			if (other.leixing != null)
				return false;
		} else if (!leixing.equals(other.leixing))
			return false;
		if (shenfenzheng == null) {
			if (other.shenfenzheng != null)
				return false;
		} else if (!shenfenzheng.equals(other.shenfenzheng))
			return false;
		if (shibiehao == null) {
			if (other.shibiehao != null)
				return false;
		} else if (!shibiehao.equals(other.shibiehao))
			return false;
		if (tel == null) {
			if (other.tel != null)
				return false;
		} else if (!tel.equals(other.tel))
			return false;
		if (xinghao == null) {
			if (other.xinghao != null)
				return false;
		} else if (!xinghao.equals(other.xinghao))
			return false;
		return true;
	}
	public CheXianInfo(String baoxiangs, String chepaihao, String shenfenzheng,
			String tel, String leixing, String xinghao, String shibiehao,
			String fadongjihao, String chushiriqi) {
		super();
		this.baoxiangs = baoxiangs;
		this.chepaihao = chepaihao;
		this.shenfenzheng = shenfenzheng;
		this.tel = tel;
		this.leixing = leixing;
		this.xinghao = xinghao;
		this.shibiehao = shibiehao;
		this.fadongjihao = fadongjihao;
		this.chushiriqi = chushiriqi;
	}
	public CheXianInfo() {
		super();
		this.baoxiangs = baoxiangs;
		this.chepaihao = chepaihao;
		this.shenfenzheng = shenfenzheng;
		this.tel = tel;
		this.leixing = leixing;
		this.xinghao = xinghao;
		this.shibiehao = shibiehao;
		this.fadongjihao = fadongjihao;
		this.chushiriqi = chushiriqi;
	}

	
}
