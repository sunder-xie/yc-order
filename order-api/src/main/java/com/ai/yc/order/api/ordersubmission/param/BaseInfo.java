package com.ai.yc.order.api.ordersubmission.param;

import java.io.Serializable;
import java.sql.Timestamp;
/**
 * 订单下单基本信息
 * @author zhangzd
 *
 */
public class BaseInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 *  业务标识
	 */
	private String flag;
	/**
	 *  订单来源
	 */
	private String chlId;
	/**
	 *  订单类型
	 */
	private String orderType;
	/**
	 * 业务类型
	 */
	private String busiType;
	/**
	 *  订单级别
	 */
	private String orderLevel;
	/**
	 *  报价标识
	 */
	private String subFlag;
	/**
	 *  用户类型
	 */
	private String userType;
	/**
	 *  用户ID
	 */
	private String userId;
	/**
	 *  企业ID
	 */
	private String corporaId;
	/**
	 *  账户ID
	 */
	private Long accountId;
	// 时区
	/**
	 * 下单时间
	 */
	private Timestamp orderTime;
	/**
	 * 省份
	 */
	private String provinceCode;
	/**
	 *  地市
	 */
	private String cityCode;
	/**
	 *  订单简要信息
	 */
	private String orderDesc;
	/**
	 *  订单关键词
	 */
	private String keywords;
	/**
	 *  订单备注
	 */
	private String remark;

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getChlId() {
		return chlId;
	}

	public void setChlId(String chlId) {
		this.chlId = chlId;
	}

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	public String getBusiType() {
		return busiType;
	}

	public void setBusiType(String busiType) {
		this.busiType = busiType;
	}

	public String getOrderLevel() {
		return orderLevel;
	}

	public void setOrderLevel(String orderLevel) {
		this.orderLevel = orderLevel;
	}

	public String getSubFlag() {
		return subFlag;
	}

	public void setSubFlag(String subFlag) {
		this.subFlag = subFlag;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getCorporaId() {
		return corporaId;
	}

	public void setCorporaId(String corporaId) {
		this.corporaId = corporaId;
	}

	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	public Timestamp getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(Timestamp orderTime) {
		this.orderTime = orderTime;
	}

	public String getProvinceCode() {
		return provinceCode;
	}

	public void setProvinceCode(String provinceCode) {
		this.provinceCode = provinceCode;
	}

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public String getOrderDesc() {
		return orderDesc;
	}

	public void setOrderDesc(String orderDesc) {
		this.orderDesc = orderDesc;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
