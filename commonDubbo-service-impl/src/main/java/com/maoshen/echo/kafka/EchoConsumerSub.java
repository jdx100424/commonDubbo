package com.maoshen.echo.kafka;

import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.maoshen.component.kafka.BaseConsumer;
import com.maoshen.component.kafka.dto.MessageDto;
import com.maoshen.component.kafka.dto.MessageVo;

@Service
public class EchoConsumerSub extends BaseConsumer {
	private static final Logger LOGGER = Logger.getLogger(BaseConsumer.class);
	public EchoConsumerSub(){
		super();
	}
	@Override
	public void onMessage(MessageDto dto) {
		LOGGER.warn("EchoConsumerSub receive message start,value is:" + JSONObject.toJSONString(dto) + ",time is:" + new Date());
		LOGGER.warn("EchoConsumerSub receive message end,time is:"+ new Date());
		String s = "5";
		int i = Integer.parseInt(s);
	}

	@Override
	public MessageVo getGroupIdANdTopicName() {		
		return MessageVo.ECHO_MESSAGE_SUB;
	}
	@Override
	public boolean isResend() {
		return true;
	}
}
