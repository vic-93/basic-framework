/* **************************************************************
 *
 * 文件名称：BaseService4Dao.java
 *
 * 包含类名：cn.cooperlink.framework.core.BaseService4Dao
 * 创建日期：2014-2-21
 * 创建作者：潘云峰
 * 版权声明：Copyright 2014 北京酷博灵科信息科技有限公司 保留所有权利。
 *
 * **************************************************************/
package cn.cooperlink.framework.core;

import java.util.List;

/**
 * 引用 BaseDao 操作的 Service 基类。
 * 
 * 创建日期：2014-2-21
 * 创建作者：潘云峰
 */
public abstract class BaseService4Dao {
	
	/**
	 * 保存
	 * 
	 * @param entity	要保存的实体
	 * @return
	 */	
	public int save(Object entity) throws Exception {
		return getDao().save(entity);
	}
	
	/**
	 * 删除
	 * 
	 * @param paramObj	条件参数
	 * @return
	 */
	public int delete(Object paramObj) throws Exception {
		return getDao().delete(paramObj);
	}
	
	/**
	 * 更新
	 * 
	 * @param entity	要更的新实体
	 * @return
	 */
	public int update(Object entity) throws Exception {
		return getDao().update(entity);
	}

	/**
	 * 获取单个实体
	 * 
	 * @param paramObj	查询条件参数
	 * @return	实体
	 */
	public <T> T getSingle(Object paramObj) throws Exception {
		return getDao().getSingle(paramObj);
	}
	
	/**
	 * 获取全部
	 * 
	 * @return
	 */
	public <T> List<T> findAll() throws Exception {
		return getDao().findAll();
	}

	/**
	 * 条件查询
	 * 
	 * @param paramObj	查询条件参数
	 * @return
	 */
	public <T> List<T> findByCondition(Object paramObj) 
			throws Exception {
		return getDao().findByCondition(paramObj);
	}
	
	/**
	 * 条件查询
	 * 
	 * @param paramObj	查询条件参数
	 * @return
	 */
	public String findByCondition2ListString(Object paramObj) 
			throws Exception {
		return Return.list2String(getDao()
				.findByCondition(paramObj));
	}
	
	/**
	 * 分页查询
	 * 
	 * @param paramObj	查询条件参数
	 * @return Pager对象
	 */
	public <T> Pager<T> findByCondition2Pager(Object paramObj) 
			throws Exception {
		return getDao().findByCondition2Pager(paramObj);
	}
	
	/**
	 * 返回分页后的json格式字符流
	 * 
	 * @param paramObj
	 * @return
	 */
	public String findByCondition2PagerString(Object paramObj) 
			throws Exception {
		return Return.pager2String(findByCondition2Pager(paramObj));
	}
	
	/**
	 * 返回BaseDao的实现类。
	 * 
	 * @return
	 */
	public abstract <T extends BaseDao> T getDao();
	
}
