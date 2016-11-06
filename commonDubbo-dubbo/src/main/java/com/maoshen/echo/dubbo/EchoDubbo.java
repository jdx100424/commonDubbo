package com.maoshen.echo.dubbo;

import com.maoshen.echo.domain.Echo;

public interface EchoDubbo {
	/**
	 * 从库健康检测查询
	 * @param id
	 * @return
	 */
	public boolean checkEchoIsExistByDubbo(Long id);
    
	/**
	 * 主库健康检测插入
	 * @param echo
	 * @throws Exception
	 */
	public void insertByDubbo(Echo echo) throws Exception;
	
	/**
	 * 缓存健康检测
	 * @return
	 */
	public boolean checkRedisByDubbo() throws Exception;
	
}
