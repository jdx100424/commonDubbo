package com.maoshen.echo.dubbo.impl;

import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.maoshen.echo.domain.Echo;
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
		LOGGER.info("dubbo method checkEchoIsExistByDubbo is start ,date:"+new Date());
		boolean result = echoService.checkEchoIsExist(id);
		LOGGER.info("dubbo method checkEchoIsExistByDubbo is end ,date:"+new Date());
		return result;
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void insertByDubbo(Echo echo) throws Exception {
		LOGGER.info("dubbo method insertByDubbo is start ,date:"+new Date());
		echoService.insert(echo);
		LOGGER.info("dubbo method insertByDubbo is end ,date:"+new Date());
	}

	@Override
	public boolean checkRedisByDubbo() throws Exception{
		LOGGER.info("dubbo method checkRedisByDubbo is start ,date:"+new Date());
		boolean result = echoService.checkRedis();
		LOGGER.info("dubbo method checkRedisByDubbo is end ,date:"+new Date());
		return result;
	}

}
