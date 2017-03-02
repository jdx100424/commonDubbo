package com.maoshen.echo.dubbo.impl;

import java.util.Date;
import java.util.Random;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.maoshen.component.rest.UserRestContext;
import com.maoshen.echo.dubbo.EchoDubbo;
import com.maoshen.echo.service.EchoService;

@Service("echoDubboImpl")
public class EchoDubboImpl implements EchoDubbo {
	@Autowired
	@Qualifier("echoServiceImpl")
	private EchoService echoService;
	
	private static final Logger LOGGER = Logger.getLogger(EchoDubboImpl.class);

	@Override
	public boolean checkEchoIsExistByDubbo(Long id) {
		LOGGER.warn("dubbo method checkEchoIsExistByDubbo is start ,date:"+new Date());
		boolean result = echoService.checkEchoIsExist(id);
		LOGGER.warn("dubbo method checkEchoIsExistByDubbo is end ,date:"+new Date());
		
		LOGGER.warn("dubboRpc:"+UserRestContext.get().getAccessToken());
		LOGGER.warn("dubboRpc:"+UserRestContext.get().getRequestId());
		
		Random r = new Random();
		if(r.nextBoolean()){
			LOGGER.info("random result is true");
			try {
				Thread.sleep(15*1000);
			} catch (InterruptedException e) {
				LOGGER.error(e.getMessage(),e);
			}
		}
		
		return result;
	}
}
