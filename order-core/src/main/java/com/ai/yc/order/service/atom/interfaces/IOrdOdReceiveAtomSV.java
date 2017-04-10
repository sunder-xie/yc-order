package com.ai.yc.order.service.atom.interfaces;

import com.ai.yc.order.dao.mapper.bo.OrdOdReceive;

public interface IOrdOdReceiveAtomSV {
	
	public int insertByPrimaryKeySelective(OrdOdReceive record);
	
	public OrdOdReceive findByFollowId(long followId);
}
