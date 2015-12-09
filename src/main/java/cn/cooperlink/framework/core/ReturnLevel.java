/* **************************************************************
 *
 * 文件名称：ReturnLevel.java
 *
 * 包含类名：cn.cooperlink.framework.core.ReturnLevel
 * 创建日期：2014年3月15日
 * 创建作者：潘云峰
 * 版权声明：Copyright 2014 北京酷博灵科信息科技有限公司 保留所有权利。
 *
 * **************************************************************/
package cn.cooperlink.framework.core;

/**
 * 返回级别类。
 * <p>成功、失败、信息、警告、错误、异常</p>
 *
 * 创建日期：2014年3月15日
 * 创建作者：潘云峰
 */
public enum ReturnLevel {
	
	DEFAULT("info"), 
	SUCCESS("success"),  
	FAILURE("failure"), 
	INFO("info"), 
	WARNING("warning"), 
	ERROR("error"), 
	EXCEPTION("exception");
	
	private final String value;
	
	private ReturnLevel(String value) {
		this.value = value;
	}
	
	public String toString() {
		return value;
	}
}
