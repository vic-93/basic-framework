/* **************************************************************
 *
 * 文件名称：ErrorDbLog.java
 *
 * 包含类名：cn.cooperlink.util.logging.ErrorDbLog
 * 创建日期：2014年3月28日
 * 创建作者：潘云峰
 * 版权声明：Copyright 2014 北京酷博灵科信息科技有限公司 保留所有权利。
 *
 * **************************************************************/
package cn.cooperlink.util.logging;

/**
 * 需要入库的错误日志类。
 *
 * 创建日期：2014年3月28日
 * 创建作者：潘云峰
 */
public interface ErrorDbLogInfo extends DbLogInfo{
	public Throwable getThrowable();
}
