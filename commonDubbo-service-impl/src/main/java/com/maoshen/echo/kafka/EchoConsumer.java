package com.maoshen.echo.kafka;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.maoshen.component.kafka.BaseConsumer;
import com.maoshen.component.kafka.BaseProducer;
import com.maoshen.component.kafka.dto.MessageDto;
import com.maoshen.component.kafka.dto.MessageVo;
import com.maoshen.component.rest.UserRestContext;

@Service
public class EchoConsumer extends BaseConsumer {
	@Autowired
	@Qualifier("baseProducer")
	private BaseProducer baseProducer;
	
	private static final Logger LOGGER = Logger.getLogger(BaseConsumer.class);
	public EchoConsumer(){
		super();
	}
	@Override
	public void onMessage(MessageDto dto) {
		LOGGER.warn("EchoConsumer receive message start,value is:" + JSONObject.toJSONString(dto) + ",time is:" + new Date());
		LOGGER.warn("EchoConsumer receive message end,time is:"+ new Date());
		
		Map<String,Object> sendMapSub = new HashMap<String,Object>();
		sendMapSub.put("jdxSub", UUID.randomUUID().toString());
		
		LOGGER.warn(dto.getUserRestContext().getAccessToken());
		LOGGER.warn(dto.getUserRestContext().getRequestId());
		
		LOGGER.warn(UserRestContext.get().getAccessToken());
		LOGGER.warn(UserRestContext.get().getRequestId());
	}

	@Override
	public MessageVo getGroupIdANdTopicName() {		
		return MessageVo.ECHO_MESSAGE;
	}
}
