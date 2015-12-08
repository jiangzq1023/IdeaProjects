package com.handpay.obm.pg.simulator.bean;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

/**
 * 
 * 
 * @author zqjiang
 * @version 1.0  2015年9月8日
 */
public class CardStatus implements Serializable{
	private static final long serialVersionUID = 1303824737717077775L;

	private String cardNo;
	private String status;
	private String sinopecNo;
	private String useTime;
	private String useProvince;
	private String useDot;
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSinopecNo() {
		return sinopecNo;
	}

	public void setSinopecNo(String sinopecNo) {
		this.sinopecNo = sinopecNo;
	}

	public String getUseTime() {
		return useTime;
	}

	public void setUseTime(String useTime) {
		this.useTime = useTime;
	}

	public String getUseProvince() {
		return useProvince;
	}

	public void setUseProvince(String useProvince) {
		this.useProvince = useProvince;
	}

	public String getUseDot() {
		return useDot;
	}

	public void setUseDot(String useDot) {
		this.useDot = useDot;
	}
}
