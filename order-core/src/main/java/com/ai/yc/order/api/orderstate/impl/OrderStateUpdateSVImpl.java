package com.ai.yc.order.api.orderstate.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.base.vo.ResponseHeader;
import com.ai.opt.sdk.constants.ExceptCodeConstants;
import com.ai.opt.sdk.util.StringUtil;
import com.ai.yc.order.api.orderstate.interfaces.IOrderStateUpdateSV;
import com.ai.yc.order.api.orderstate.param.OrderStateUpdateRequest;
import com.ai.yc.order.api.orderstate.param.OrderStateUpdateResponse;
import com.ai.yc.order.service.business.interfaces.IOrdOrderBusiSV;
import com.ai.yc.order.service.business.interfaces.search.IOrderIndexBusiSV;
import com.alibaba.dubbo.config.annotation.Service;

@Service
@Component
public class OrderStateUpdateSVImpl implements IOrderStateUpdateSV {
	private static Logger logger = LoggerFactory.getLogger(OrderStateUpdateSVImpl.class);
	@Autowired
	private IOrdOrderBusiSV ordOrderBusiSV;
	@Autowired
	private IOrderIndexBusiSV orderIndexBusiSV;//订单搜索引擎添加服务
	@Override
	public OrderStateUpdateResponse updateState(OrderStateUpdateRequest request)
			throws BusinessException, SystemException {
		OrderStateUpdateResponse response = new OrderStateUpdateResponse();
		ResponseHeader responseHeader = new ResponseHeader();
		try {
			if(null == request){
				throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL,"请求参数不能为空");
			}
			if(null == request.getOrderId()){
				throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL,"订单编号不能为空");
			}
			if(StringUtil.isBlank(request.getState())){
				throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL,"订单状态不能为空");
			}
			
			response = this.ordOrderBusiSV.updateState(request);
			Long orderId = response.getOrderId();
			logger.info("订单状态修改结果处理返回订单编号：>>>>>>"+orderId);
			this.orderIndexBusiSV.insertSesData(response.getOrderId());
			
			responseHeader.setIsSuccess(true);
			responseHeader.setResultCode(ExceptCodeConstants.Special.SUCCESS);
			responseHeader.setResultMessage("订单状态修改成功");
			response.setResponseHeader(responseHeader);
			
		} catch (BusinessException | SystemException e) {
			responseHeader.setIsSuccess(false);
			responseHeader.setResultCode(e.getErrorCode());
			responseHeader.setResultMessage(e.getErrorMessage());
			response.setResponseHeader(responseHeader);
		} catch (Exception e){
			
		}
		return response;
	}

}
