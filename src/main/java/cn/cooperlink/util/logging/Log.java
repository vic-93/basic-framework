/* **************************************************************
 *
 * 文件名称：Log.java
 *
 * 包含类名：cn.cooperlink.apps.framework.logging.Log
 * 创建日期：2014年3月24日
 * 创建作者：潘云峰
 * 版权声明：Copyright 2014 北京酷博灵科信息科技有限公司 保留所有权利。
 *
 * **************************************************************/
package cn.cooperlink.util.logging;

import java.io.PrintStream;

/**
 * 日志操作类。
 *
 * 创建日期：2014年3月24日
 * 创建作者：潘云峰
 */
public abstract class Log {
	
	public static String SYS_NAME = null;
	
	private boolean isEnabledExceptionDb =  false;
	
	private boolean isEnabledDb = false;

	public boolean isEnabledExceptionDb() {
		return isEnabledExceptionDb;
	}

	public void setEnabledExceptionDb(boolean isEnabledExceptionDb) {
		this.isEnabledExceptionDb = isEnabledExceptionDb;
	}

	public boolean isEnabledDb() {
		return isEnabledDb;
	}

	public void setEnabledDb(boolean isEnabledDb) {
		this.isEnabledDb = isEnabledDb;
	}

	public void out(String message) {
		System.out.println(message);
	}
	
	public void out(PrintStream out, Object message) {
		out.print(message);
	}
	
	public void outLn(PrintStream out, Object message) {
		out.println(message);
	}
	
	public boolean isDebugEnabled() {
		return false;
	}
	
	public boolean isInfoEnabled() {
		return false;
	}
	public boolean isTraceEnabled() {
		return false;
	}
	
	public abstract void debug(Object message);

	public abstract void info(Object message);
	
	public abstract void warn(Object message);
	
	public abstract void error(Object message);
	
	public abstract void exception(Object message, Throwable e);
	
	public abstract void exceptionDb(ErrorDbLogInfo errorDbLogInfo);
	
	public void db(DbLogInfo dbLog) {
		dbLog.save();
	}
	
}
