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
public class Card implements Serializable{
	private static final long serialVersionUID = -3186123068598491848L;

	private String cardNo;
	private String cardPws;
	private String expireDate;
	
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

	public String getCardPws() {
		return cardPws;
	}

	public void setCardPws(String cardPws) {
		this.cardPws = cardPws;
	}

	public String getExpireDate() {
		return expireDate;
	}

	public void setExpireDate(String expireDate) {
		this.expireDate = expireDate;
	}
}
