/* **************************************************************
 *
 * 文件名称：LogFactory.java
 *
 * 包含类名：cn.cooperlink.apps.framework.logging.LogFactory
 * 创建日期：2014年3月24日
 * 创建作者：潘云峰
 * 版权声明：Copyright 2014 北京酷博灵科信息科技有限公司 保留所有权利。
 *
 * **************************************************************/
package cn.cooperlink.util.logging;

/**
 * 日志工厂。
 * <p>提供getLog方法返回日志。</p>
 *
 * 创建日期：2014年3月24日
 * 创建作者：潘云峰
 */
public class LogFactory {
	
	private static AbstractLogFactory logFactory;

	public static final Log getLog(Class<?> clazz) {
		if (logFactory == null) {
			//logFactory = new Log4jLogFactory();
			//logFactory = new Log4jAndDBLogFactory();
		}
		return logFactory.getLog(clazz);
	}

	public static void setLogFactory(AbstractLogFactory logFactory) {
		LogFactory.logFactory = logFactory;
	}
	
}
