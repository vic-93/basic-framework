/* **************************************************************
 *
 * 文件名称：JsonValueProcessor4Date.java
 *
 * 包含类名：cn.cooperlink.framework.core.util.JsonValueProcessor4Date
 * 创建日期：2014年2月27日
 * 创建作者：潘云峰
 * 版权声明：Copyright 2014 北京酷博灵科信息科技有限公司 保留所有权利。
 *
 * **************************************************************/
package cn.cooperlink.framework.core.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;

import cn.cooperlink.framework.core.Constants;

/**
 * Json日期转换类。
 *
 * 创建日期：2014年2月27日
 * 创建作者：潘云峰
 */
public class JsonValueProcessor4Date implements JsonValueProcessor{
	
	private SimpleDateFormat sdf;
	
	/**
	 * 默认格式：yyyy-MM-dd
	 */
	public JsonValueProcessor4Date() {
		this(Constants.DATE_FORMAT_SIMPLE);
	}
	
	/**
	 * 默认格式：yyyy-MM-dd hh:mm:ss
	 */
	public JsonValueProcessor4Date(String format) {
		if (format == null) {
			format = Constants.DATE_FORMAT_SIMPLE;
		}
		sdf = new SimpleDateFormat(format);
	}


	public Object processArrayValue(Object arg0, JsonConfig arg1) {
		return format(arg0);
	}


	public Object processObjectValue(String arg0, Object arg1, JsonConfig arg2) {
		return format(arg1);
	}
	
	/**
	 * 格式化
	 * 
	 * @param dateObj
	 * @return
	 */
	private Object format(Object dateObj) {
		if (dateObj instanceof Date) {
			return sdf.format(dateObj);
		}
		return dateObj;
	}
}
