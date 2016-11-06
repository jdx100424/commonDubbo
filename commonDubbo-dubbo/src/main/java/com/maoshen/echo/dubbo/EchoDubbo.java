package com.maoshen.echo.dubbo;

public interface EchoDubbo {
	/**
	 * 从库健康检测查询
	 * @param id
	 * @return
	 */
	public boolean checkEchoIsExistByDubbo(Long id);
}
