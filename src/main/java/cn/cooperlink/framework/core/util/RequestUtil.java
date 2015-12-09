/* **************************************************************
 *
 * 文件名称：RequestUtil.java
 *
 * 包含类名：cn.cooperlink.framework.core.util.RequestUtil
 * 创建日期：2014年2月24日
 * 创建作者：潘云峰
 * 版权声明：Copyright 2014 北京酷博灵科信息科技有限公司 保留所有权利。
 *
 * **************************************************************/
package cn.cooperlink.framework.core.util;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * springmvc中HttpServletRequest直取工具类。
 *
 * 创建日期：2014年2月24日
 * 创建作者：潘云峰
 */
public class RequestUtil {

	private RequestUtil(){}
	
	public static HttpServletRequest getRequest() {
    	return ((ServletRequestAttributes) RequestContextHolder
    			.getRequestAttributes())
    			.getRequest(); 
	}
}
