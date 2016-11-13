package com.maoshen.echo.kafka;

import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.maoshen.component.kafka.BaseConsumer;
import com.maoshen.component.kafka.dto.MessageDto;
import com.maoshen.component.kafka.dto.MessageVo;

@Service
public class EchoConsumer extends BaseConsumer {
	private static final Logger LOGGER = Logger.getLogger(BaseConsumer.class);
	public EchoConsumer(){
		super();
	}
	@Override
	public void onMessage(MessageDto dto) {
		LOGGER.info("EchoConsumer receive message start,value is:" + JSONObject.toJSONString(dto) + ",time is:" + new Date());
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			LOGGER.error(e.getMessage(),e);
		}
		LOGGER.info("EchoConsumer receive message end,time is:"+ new Date());
	}

	@Override
	public MessageVo getGroupIdANdTopicName() {		
		return MessageVo.ECHO_MESSAGE;
	}
}
