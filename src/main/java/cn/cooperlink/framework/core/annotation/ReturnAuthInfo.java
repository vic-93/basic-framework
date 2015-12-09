/* **************************************************************
 *
 * 文件名称：ReturnAuthInfo.java
 *
 * 包含类名：cn.cooperlink.framework.core.annotation.ReturnAuthInfo
 * 创建日期：2014年4月22日
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
 * 标注是否返回登录认证信息和权限参数。
 * <p>此注解应用与Controller层，
 * <p>注释方法将通过response返回用户信息及权限信息到页面。
 *
 * 创建日期：2014年4月22日
 * 创建作者：潘云峰
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(value=ElementType.METHOD)
public @interface ReturnAuthInfo {
}
