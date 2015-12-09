/* **************************************************************
 *
 * 文件名称：Log4jImpl.java
 *
 * 包含类名：cn.cooperlink.util.logging.Log4jImpl
 * 创建日期：2014年3月28日
 * 创建作者：潘云峰
 * 版权声明：Copyright 2014 北京酷博灵科信息科技有限公司 保留所有权利。
 *
 * **************************************************************/
package cn.cooperlink.util.logging;

import org.apache.log4j.Logger;

/**
 * 原生的log4j类。
 *
 * 创建日期：2014年3月28日
 * 创建作者：潘云峰
 */
public class Log4jImpl extends Log {
	
	private Logger log;
	
	public Log4jImpl(Class<?> clazz) {
		log = Logger.getLogger(clazz);
	}

	@Override
	public void debug(Object message) {
		log.debug(message);
	}

	@Override
	public void info(Object message) {
		log.info(message);
	}

	@Override
	public void warn(Object message) {
		log.warn(message);
	}

	@Override
	public void error(Object message) {
		log.error(message);
	}

	@Override
	public void exception(Object message, Throwable e) {
		log.error(message, e);
	}

	@Override
	public void db(DbLogInfo dbLog) {
		log.warn("原生Log4j实现，没有数据库日志能力。");
	}

	@Override
	public void exceptionDb(ErrorDbLogInfo errorDbLogInfo) {
		log.warn("原生Log4j实现，没有数据库日志能力。");
	}

}
