package com.handpay.obm.pg.simulator.bean;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * 
 * @author zqjiang
 * @version 1.0  2015年9月18日
 */
public class NotifyResult implements Serializable{
	private static final long serialVersionUID = -2958322626666244427L;

	private String retCode;
	private String errMsg;
	private String merId;
	private String orderId;
	private String orderTime;
	private String ncOrderId;
	private String ncOrderTime;
	private String cardId;
	private String num;
	private String sign;
	private List<CardStatus> cards;
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
	
	public String getRetCode() {
		return retCode;
	}
	public void setRetCode(String retCode) {
		this.retCode = retCode;
	}
	public String getErrMsg() {
		return errMsg;
	}
	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}
	public String getMerId() {
		return merId;
	}
	public void setMerId(String merId) {
		this.merId = merId;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getNcOrderId() {
		return ncOrderId;
	}
	public void setNcOrderId(String ncOrderId) {
		this.ncOrderId = ncOrderId;
	}
	public String getCardId() {
		return cardId;
	}
	public void setCardId(String cardId) {
		this.cardId = cardId;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public List<CardStatus> getCards() {
		return cards;
	}
	public void setCards(List<CardStatus> cards) {
		this.cards = cards;
	}

	public String getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(String orderTime) {
		this.orderTime = orderTime;
	}

	public String getNcOrderTime() {
		return ncOrderTime;
	}

	public void setNcOrderTime(String ncOrderTime) {
		this.ncOrderTime = ncOrderTime;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}
}
