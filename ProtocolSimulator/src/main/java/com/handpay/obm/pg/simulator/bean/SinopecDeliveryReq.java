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
public class SinopecDeliveryReq extends BaseReq implements Serializable{
	private static final long serialVersionUID = 3679984027777654229L;

	private String merId;
	private String merPwd;
	private String cardId;
	private String num;
	private String orderId;
	private String orderTime;
	private String gasCardTel;
	private String gasCardName;
	private String isNotifyResult;
	private String notify_url;
	private String sign;
	private String version;
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}

	public String getMerId() {
		return merId;
	}

	public void setMerId(String merId) {
		this.merId = merId;
	}

	public String getMerPwd() {
		return merPwd;
	}

	public void setMerPwd(String merPwd) {
		this.merPwd = merPwd;
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

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(String orderTime) {
		this.orderTime = orderTime;
	}

	public String getGasCardTel() {
		return gasCardTel;
	}

	public void setGasCardTel(String gasCardTel) {
		this.gasCardTel = gasCardTel;
	}

	public String getGasCardName() {
		return gasCardName;
	}

	public void setGasCardName(String gasCardName) {
		this.gasCardName = gasCardName;
	}

	public String getIsNotifyResult() {
		return isNotifyResult;
	}

	public void setIsNotifyResult(String isNotifyResult) {
		this.isNotifyResult = isNotifyResult;
	}

	public String getNotify_url() {
		return notify_url;
	}

	public void setNotify_url(String notify_url) {
		this.notify_url = notify_url;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}
}
