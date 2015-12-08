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
public class QueryOrderReq extends BaseReq implements Serializable{
	private static final long serialVersionUID = -6905128634350634778L;

	private String merId;
	private String merPwd;
	private String orderId;
	private String orderTime;
	private String ncOrderId;
	private String ncOrderTime;
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

	public String getNcOrderId() {
		return ncOrderId;
	}

	public void setNcOrderId(String ncOrderId) {
		this.ncOrderId = ncOrderId;
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

	public String getNcOrderTime() {
		return ncOrderTime;
	}

	public void setNcOrderTime(String ncOrderTime) {
		this.ncOrderTime = ncOrderTime;
	}
}
