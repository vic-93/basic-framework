/* **************************************************************
 *
 * 文件名称：ResponseUtil.java
 *
 * 包含类名：cn.cooperlink.framework.core.util.ResponseUtil
 * 创建日期：2014年3月27日
 * 创建作者：潘云峰
 * 版权声明：Copyright 2014 北京酷博灵科信息科技有限公司 保留所有权利。
 *
 * **************************************************************/
package cn.cooperlink.framework.core.util;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * springmvc中HttpServletResponse直取工具类。
 *
 * 创建日期：2014年3月27日
 * 创建作者：潘云峰
 */
public class ResponseUtil {

	private ResponseUtil(){}
	
	public static final HttpServletResponse getResponse() {
		return ((ServletWebRequest) RequestContextHolder
				.getRequestAttributes()).getResponse();
	}
}
