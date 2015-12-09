/* **************************************************************
 *
 * 文件名称：BaseDaoMethod.java
 *
 * 包含类名：cn.cooperlink.framework.core.BaseDaoMethod
 * 创建日期：2014年3月27日
 * 创建作者：潘云峰
 * 版权声明：Copyright 2014 北京酷博灵科信息科技有限公司 保留所有权利。
 *
 * **************************************************************/
package cn.cooperlink.framework.core;

/**
 * BaseDao 方法枚举。
 * <p>
 * 	框架规范了部分数据库通用操作的命名规则：
 *  单行记录插入 - insert 或  save
 *  批量插入 - insertBatch 或  saveBatch
 *  删除 - delete
 *  批量删除 - deleteBatch
 *  更新 - update 或   modify
 *  批量更新 - updateBatch 或   modifyBatch
 *  获取单条记录 - get 或  getSingle
 *  查询所有 - findAll
 *  条件查询 - findByCondition
 *  统计记录数 - count
 * </p>
 * 创建日期：2014年3月27日
 * 创建作者：潘云峰
 */
public enum BaseDaoMethod {
	
	INSERT(".insert"), 						
	INSERT_BATCH(".insertBatch"),
	SAVE(".save"), 
	SAVE_BATCH(".saveBatch"),
	DELETE(".delete"), 
	DELETE_BATCH(".deleteBatch"),
	UPDATE(".update"),
	UPDATE_BATCH(".updateBatch"),
	MODIFY(".modify"),
	MODIFY_BATCH(".modifyBatch"),
	GET(".get"),
	GET_SINGLE(".getSingle"),
	FIND_ALL(".findAll"),
	FIND_BY_CONDITION(".findByCondition"),
	COUNT(".count");

	private String methodName;
	
	private BaseDaoMethod(String methodName){
		this.methodName = methodName;
	}
	
	public String toString() {
		return methodName;
	}
}
