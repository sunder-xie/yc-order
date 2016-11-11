package com.ai.yc.order.api.orderpay.param;

import java.io.Serializable;
import java.sql.Timestamp;

public class OrderPayProcessedResultFeeInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 币种 "1：RMB 2：$"
	 */
	private String currencyUnit;// CURRENCY_UNIT

	/**
	 * 支付方式
	 */
	private String payStyle;
	/**
	 * 总费用 单位厘
	 */
	private Long totalFee;// TOTAL_FEE;
	/**
	 * 总优惠金额 一期不需要此字段 单位厘
	 */
	private Long discountFee;// DISCOUNT_FEE
	/**
	 * 总减免费用 一期不需要此字段 单位厘
	 */
	private Long operDiscountFee;// OPER_DISCOUNT_FEE
	/**
	 * 减免原因
	 */
	private String operDiscountDesc;// OPER_DISCOUNT_DESC
	/**
	 * 总应收费用 单位厘
	 */
	private Long adjustFee;// ADJUST_FEE
	/**
	 * 总实收费用 单位厘
	 */
	private Long paidFee;// PAID_FEE
	// 总已收费用
	/**
	 * 支付时间
	 */
	private Timestamp payTime;
	/**
	 * 赠送积分
	 */
	private Long totalJf;

	public String getPayStyle() {
		return payStyle;
	}

	public void setPayStyle(String payStyle) {
		this.payStyle = payStyle;
	}

	public String getCurrencyUnit() {
		return currencyUnit;
	}

	public void setCurrencyUnit(String currencyUnit) {
		this.currencyUnit = currencyUnit;
	}

	public Long getTotalFee() {
		return totalFee;
	}

	public void setTotalFee(Long totalFee) {
		this.totalFee = totalFee;
	}

	public Long getDiscountFee() {
		return discountFee;
	}

	public void setDiscountFee(Long discountFee) {
		this.discountFee = discountFee;
	}

	public Long getOperDiscountFee() {
		return operDiscountFee;
	}

	public void setOperDiscountFee(Long operDiscountFee) {
		this.operDiscountFee = operDiscountFee;
	}

	public String getOperDiscountDesc() {
		return operDiscountDesc;
	}

	public void setOperDiscountDesc(String operDiscountDesc) {
		this.operDiscountDesc = operDiscountDesc;
	}

	public Long getAdjustFee() {
		return adjustFee;
	}

	public void setAdjustFee(Long adjustFee) {
		this.adjustFee = adjustFee;
	}

	public Long getPaidFee() {
		return paidFee;
	}

	public void setPaidFee(Long paidFee) {
		this.paidFee = paidFee;
	}

	public Timestamp getPayTime() {
		return payTime;
	}

	public void setPayTime(Timestamp payTime) {
		this.payTime = payTime;
	}

	public Long getTotalJf() {
		return totalJf;
	}

	public void setTotalJf(Long totalJf) {
		this.totalJf = totalJf;
	}
}