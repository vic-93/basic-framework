/* **************************************************************
 *
 * 文件名称：SpringContainer.java
 *
 * 包含类名：cn.cooperlink.framework.core.util.SpringContainer
 * 创建日期：2014-2-21
 * 创建作者：潘云峰
 * 版权声明：Copyright 2014 北京酷博灵科信息科技有限公司 保留所有权利。
 *
 * **************************************************************/
package cn.cooperlink.framework.core.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * Spring容器工具类。
 * 
 * 创建日期：2014-2-21
 * 创建作者：潘云峰
 */
public class SpringContainer implements ApplicationContextAware {
	
	private static ApplicationContext applicationContext;
	
	/**
	 * byType 获取bean
	 * 
	 * @param clazz		bean类
	 * @return
	 */
	public static <T> T getBean(Class<T> clazz) {
		return applicationContext.getBean(clazz);
	}
	
	/**
	 * byName 获取bean
	 * 
	 * @param beanName	bean名称
	 * @param clazz		bean类
	 * @return
	 */
	public static <T> T getBean(String beanName, Class<T> clazz) {
		return applicationContext.getBean(beanName, clazz);
	}
	
	/**
	 * byName 获取bean
	 * 
	 * @param beanName	bean名称
	 * @return
	 */
	public static Object getBean(String beanName) {
		return applicationContext.getBean(beanName);
	}
	
	public static ApplicationContext getContext() {
		return applicationContext;
	}


	public void setApplicationContext(ApplicationContext ctx)
			throws BeansException {
		applicationContext = ctx;
	}
	
}
