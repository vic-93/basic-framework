/* **************************************************************
 *
 * 文件名称：AbstractLogFactory.java
 *
 * 包含类名：cn.cooperlink.apps.framework.logging.AbstractLogFactory
 * 创建日期：2014年3月24日
 * 创建作者：潘云峰
 * 版权声明：Copyright 2014 北京酷博灵科信息科技有限公司 保留所有权利。
 *
 * **************************************************************/
package cn.cooperlink.util.logging;
/**
 * 日志工厂类。
 *
 * 创建日期：2014年3月24日
 * 创建作者：潘云峰
 */
public interface AbstractLogFactory {

	public Log getLog(Class<?> clazz);
	
}
