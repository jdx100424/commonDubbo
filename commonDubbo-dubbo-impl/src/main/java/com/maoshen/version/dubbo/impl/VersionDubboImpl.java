package com.maoshen.version.dubbo.impl;

import org.springframework.stereotype.Service;

import com.maoshen.version.dubbo.VersionDubbo;

@Service("versionDubboImpl")
public class VersionDubboImpl implements VersionDubbo{
	@Override
	public String getVersion() {
		return System.getProperty("env");
	}
}
