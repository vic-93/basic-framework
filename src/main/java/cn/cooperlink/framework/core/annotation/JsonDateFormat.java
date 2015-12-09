/* **************************************************************
 *
 * 文件名称：JsonDateFormat.java
 *
 * 包含类名：cn.cooperlink.framework.core.annotation.JsonDateFormat
 * 创建日期：2014年3月15日
 * 创建作者：潘云峰
 * 版权声明：Copyright 2014 北京酷博灵科信息科技有限公司 保留所有权利。
 *
 * **************************************************************/
package cn.cooperlink.framework.core.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import cn.cooperlink.framework.core.Constants;

/**
 * json 日期转换注解。
 * 格式化pattern
 *
 * 创建日期：2014年3月15日
 * 创建作者：潘云峰
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(value=ElementType.FIELD)
public @interface JsonDateFormat {

	/**
	 * 默认 yyyy-MM-dd
	 *
	 * @return
	 */
	String pattern() default Constants.DATE_FORMAT_SIMPLE;
}
