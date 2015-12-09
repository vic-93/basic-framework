/* **************************************************************
 *
 * 文件名称：DbLogInfo.java
 *
 * 包含类名：cn.cooperlink.apps.framework.logging.DbLogInfo
 * 创建日期：2014年3月24日
 * 创建作者：潘云峰
 * 版权声明：Copyright 2014 北京酷博灵科信息科技有限公司 保留所有权利。
 *
 * **************************************************************/
package cn.cooperlink.util.logging;

/**
 * 需要入库的错误日志。
 * 功能描述
 *
 * 创建日期：2014年3月24日
 * 创建作者：潘云峰
 */
public interface DbLogInfo {
	public void save();
}
