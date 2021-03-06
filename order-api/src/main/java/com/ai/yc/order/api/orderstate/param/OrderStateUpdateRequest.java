package com.ai.yc.order.api.orderstate.param;

import java.io.Serializable;

public class OrderStateUpdateRequest implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 订单编号
	 */
	private Long orderId;
	/**
	 * 订单状态
	 */
	private String state;
	/**
	 * 客户端显示状态
	 */
	private String displayFlag;// DISPLAY_FLAG
	/**
	 * 用户id
	 */
	private String userId;
	/**
	 * 轨迹信息,目前包括operName属性，需要前台登录用户传递
	 */
	private UpdateStateChgInfo stateChgInfo;

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public String getDisplayFlag() {
		return displayFlag;
	}

	public void setDisplayFlag(String displayFlag) {
		this.displayFlag = displayFlag;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public UpdateStateChgInfo getStateChgInfo() {
		return stateChgInfo;
	}

	public void setStateChgInfo(UpdateStateChgInfo stateChgInfo) {
		this.stateChgInfo = stateChgInfo;
	}

}
