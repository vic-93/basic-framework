/* **************************************************************
 *
 * 文件名称：BeanUtil.java
 *
 * 包含类名：cn.cooperlink.framework.core.util.BeanUtil
 * 创建日期：2014年2月24日
 * 创建作者：潘云峰
 * 版权声明：Copyright 2014 北京酷博灵科信息科技有限公司 保留所有权利。
 *
 * **************************************************************/
package cn.cooperlink.framework.core.util;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import cn.cooperlink.framework.core.BaseEntity;
import cn.cooperlink.util.DateUtil;

/**
 * 实体工具类。
 * 
 * 创建日期：2014年2月24日
 * 创建作者：潘云峰
 */
public class EntityUtil {

	/**
	 * 初始化实体基本属性（定义在BaseEntity中的属性）的值。
	 * 
	 * @param entity
	 */
	public static void setBaseProps4Save(BaseEntity entity,HttpServletRequest request) {
		if (entity == null) {
			throw new NullPointerException("实体对象为空 (null)。");
		}
		//daniel.hu delete 2015-01-08
		//String adminName = request.getUserPrincipal().getName();
		String adminName="hahah";
		Date now = new Date();
		entity.setCreateUserId(adminName);
		entity.setCreateDate(DateUtil.toFullTimeFormat(now));
		entity.setModifyUserId(adminName);
		entity.setModifyDate(DateUtil.toFullTimeFormat(now));
	}
	
	/**
	 * 为更新人和更新时间属性赋值。
	 * 
	 * @param entity
	 */
	public static void setBaseProps4Update(BaseEntity entity,HttpServletRequest request) {
		if (entity == null) {
			throw new NullPointerException("实体对象为空 (null)。");
		}
		//daniel.hu delete 2015-01-13
		//String adminName = request.getUserPrincipal().getName();
		String adminName="hahah";
		Date now = new Date();
		entity.setModifyUserId(adminName);
		entity.setModifyDate(DateUtil.toFullTimeFormat(now));

	}
	
}
