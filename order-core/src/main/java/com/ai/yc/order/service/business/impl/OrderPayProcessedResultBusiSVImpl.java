package com.ai.yc.order.service.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ai.opt.sdk.util.BeanUtils;
import com.ai.opt.sdk.util.DateUtil;
import com.ai.yc.order.api.orderpay.param.OrderPayProcessedResultRequest;
import com.ai.yc.order.api.orderpay.param.OrderPayProcessedResultResponse;
import com.ai.yc.order.constants.OrdersConstants;
import com.ai.yc.order.dao.mapper.bo.OrdBalacneIf;
import com.ai.yc.order.dao.mapper.bo.OrdOdFeeTotal;
import com.ai.yc.order.dao.mapper.bo.OrdOdProdWithBLOBs;
import com.ai.yc.order.dao.mapper.bo.OrdOrder;
import com.ai.yc.order.service.atom.interfaces.IOrdBalacneIfAtomSV;
import com.ai.yc.order.service.atom.interfaces.IOrdOdFeeTotalAtomSV;
import com.ai.yc.order.service.atom.interfaces.IOrdOdProdAtomSV;
import com.ai.yc.order.service.atom.interfaces.IOrdOrderAtomSV;
import com.ai.yc.order.service.business.interfaces.IOrderPayProcessedResultBusiSV;
import com.ai.yc.order.util.SequenceUtil;

@Service
public class OrderPayProcessedResultBusiSVImpl implements IOrderPayProcessedResultBusiSV {
	@Autowired
	private IOrdOrderAtomSV ordOrderAtomSV;
	@Autowired
	private IOrdOdFeeTotalAtomSV ordOdFeeTotalAtomSV;
	@Autowired
	private IOrdOdProdAtomSV ordOdProdAtomSV;
	@Autowired
	private IOrdBalacneIfAtomSV ordBalacneIfAtomSV;
	
	
	@Override
	public OrderPayProcessedResultResponse updateOrderPayProcessedResult(OrderPayProcessedResultRequest request) {
		OrderPayProcessedResultResponse response = new OrderPayProcessedResultResponse();
		
		//订单基本信息修改
		OrdOrder ordOrder = new OrdOrder();
		//
		BeanUtils.copyVO(ordOrder, request.getBaseInfo());
		//订单状态
		ordOrder.setState(OrdersConstants.OrderState.STATE_WAIT_RECEIVE);//待领取
		//客户端显示状态
		ordOrder.setDisplayFlag(OrdersConstants.OrderDisplayFlag.FLAG_TRASLATING);//翻译中
		//客户端显示状态修改时间
		ordOrder.setDisplayFlagChgTime(DateUtil.getSysDate());
		//
		this.ordOrderAtomSV.updateByPrimaryKeySelective(ordOrder);
		//订单费用信息修改
		OrdOdFeeTotal ordOdFeeTotal = new OrdOdFeeTotal();
		//
		BeanUtils.copyVO(ordOdFeeTotal, request.getFeeInfo());
		//
		this.ordOdFeeTotalAtomSV.updateByOrderIdSelective(request.getBaseInfo().getOrderId(), ordOdFeeTotal);
		//订单产品下单成功时间修改
		OrdOdProdWithBLOBs ordOdProdWithBLOBs = new OrdOdProdWithBLOBs();
		ordOdProdWithBLOBs.setStateTime(request.getProdInfo().getStateTime());
		//
		this.ordOdProdAtomSV.updateByOrderIdSelective(ordOdProdWithBLOBs, request.getBaseInfo().getOrderId());
		//添加支付机构信息
		OrdBalacneIf ordBalacneIf = new OrdBalacneIf();
		//
		Long balacneIfId = SequenceUtil.createBalacneIfId();
		ordBalacneIf.setBalacneIfId(balacneIfId);//自动编号
		//订单编号
		ordBalacneIf.setOrderId(request.getBaseInfo().getOrderId());
		//支付方式
		ordBalacneIf.setPayStyle(request.getFeeInfo().getPayStyle());
		//币种
		ordBalacneIf.setCurrencyUnit(request.getFeeInfo().getCurrencyUnit());
		//支付费用
		ordBalacneIf.setPayFee(request.getFeeInfo().getTotalFee());
		//支付中心编号 默认为1
		ordBalacneIf.setPaySystemId("1");
		//支付时间
		ordBalacneIf.setPayTime(request.getFeeInfo().getPayTime());
		//外部流水号
		ordBalacneIf.setExternalId("123");
		//
		response.setOrderId(request.getBaseInfo().getOrderId());
		//
		return response;
	}

}