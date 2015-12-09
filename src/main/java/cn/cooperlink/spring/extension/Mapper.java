/* **************************************************************
 *
 * 文件名称：MybatisMapper.java
 *
 * 包含类名：cn.cooperlink.spring.extension.Mapper
 * 创建日期：2014年8月1日
 * 创建作者：潘云峰
 * 版权声明：Copyright 2014 大唐云动力科技股份有限公司 保留所有权利。
 *
 * **************************************************************/
package cn.cooperlink.spring.extension;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Mapper 标注类。
 * <p>标注系统中的Mapper接口</p>
 * 
 * 创建日期：2014年8月1日
 * 创建作者：潘云峰
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(value=ElementType.TYPE)
public @interface Mapper {
}
