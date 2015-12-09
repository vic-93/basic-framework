/* **************************************************************
 *
 * 文件名称：Log4jLogFactory.java
 *
 * 包含类名：cn.cooperlink.util.logging.Log4jLogFactory
 * 创建日期：2014年3月28日
 * 创建作者：潘云峰
 * 版权声明：Copyright 2014 北京酷博灵科信息科技有限公司 保留所有权利。
 *
 * **************************************************************/
package cn.cooperlink.util.logging;

/**
 * Log4j工厂。
 *
 * 创建日期：2014年3月28日
 * 创建作者：潘云峰
 */
public class Log4jLogFactory implements AbstractLogFactory{

	public Log getLog(Class<?> clazz) {
		return new Log4jImpl(clazz);
	}

}
