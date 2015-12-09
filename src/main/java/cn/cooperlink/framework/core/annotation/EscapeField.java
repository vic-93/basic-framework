/* **************************************************************
 *
 * 文件名称：EscapeField.java
 *
 * 包含类名：cn.cooperlink.framework.core.annotation.EscapeField
 * 创建日期：2014年3月5日
 * 创建作者：潘云峰
 * 版权声明：Copyright 2014 北京酷博灵科信息科技有限公司 保留所有权利。
 *
 * **************************************************************/
package cn.cooperlink.framework.core.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * ext树结构忽视字段注解。
 *
 * 创建日期：2014年3月5日
 * 创建作者：潘云峰
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(value=ElementType.FIELD)
public @interface EscapeField {
}
