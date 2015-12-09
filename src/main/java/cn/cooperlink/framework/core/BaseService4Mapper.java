/* **************************************************************
 *
 * 文件名称：BaseService4Mapper.java
 *
 * 包含类名：cn.cooperlink.framework.core.BaseService4Mapper
 * 创建日期：2014-2-21
 * 创建作者：潘云峰
 * 版权声明：Copyright 2014 北京酷博灵科信息科技有限公司 保留所有权利。
 *
 * **************************************************************/
package cn.cooperlink.framework.core;

import java.util.List;

/**
 * 引用 BaseMapper 操作的  Service 基类。
 * <p>子类实现getMapper()方法为基本操作指定Mapper实现，
 * 此Mapper必须是BaseMapper的子类</p>
 *
 * 创建日期：2014-2-21
 * 创建作者：潘云峰
 */
public abstract class BaseService4Mapper {
	
	/**
	 * 保存
	 * 
	 * @param entity	要保存的实体
	 * @return
	 */	
	public int save(Object entity) throws Exception {
		return getMapper().save(entity);
	}
	
	/**
	 * 批量保存
	 * 
	 * @param entityList	要保存的实体
	 * @return
	 */	
	public int saveBatch(List<?> entityList) 
			throws Exception {
		return getMapper().saveBatch(entityList);
	}

	
	/**
	 * 删除
	 * 
	 * @param paramObj	条件参数
	 * @return
	 */
	public int delete(Object paramObj) throws Exception {
		return getMapper().delete(paramObj);
	}
	
	/**
	 * 批量保存
	 *
	 * @param paramObjList
	 * @return
	 * @throws Exception
	 */
	public int deleteBatch(List<?> paramObjList) 
			throws Exception {
		return getMapper().deleteBatch(paramObjList);
	}
	
	/**
	 * 更新
	 * 
	 * @param entity	要更的新实体
	 * @return
	 */
	public int update(Object entity) throws Exception {
		return getMapper().update(entity);
	}

	/**
	 * 获取单个实体
	 * 
	 * @param paramObj	查询条件参数
	 * @return	实体
	 */
	public <T> T getSingle(Object paramObj) throws Exception {
		return getMapper().getSingle(paramObj);
	}
	
	/**
	 * 获取全部
	 * 
	 * @return
	 */
	public <T> List<T> findAll() throws Exception {
		return getMapper().findAll();
	}

	/**
	 * 条件查询
	 * 
	 * @param paramObj	查询条件参数
	 * @return
	 */
	public <T> List<T> findByCondition(Object paramObj) 
			throws Exception {
		return getMapper().findByCondition(paramObj);
	}

	/**
	 * 条件查询
	 * 
	 * @param paramObj	查询条件参数
	 * @return
	 */
	public String findByCondition2ListString(Object paramObj) 
			throws Exception {
		return Return.list2String(getMapper()
				.findByCondition(paramObj));
	}
	
	/**
	 * 记录总数
	 * <p>全表记录总数</p>
	 * 
	 * @return
	 */
	public long count() throws Exception {
		return count(null);
	}
	
	/**
	 * 符合条件的记录总数
	 * 
	 * @param paramObj	过滤条件
	 * @return
	 */
	public long count(Object paramObj) throws Exception {
		return getMapper().count(paramObj);
	}
	
	/**
	 * 分页查询
	 *
	 * @param paramObj	查询条件参数,可以是Map 或者 JavaBean
	 * @return Pager对象
	 */
	@SuppressWarnings("unchecked")
	public <T> Pager<T> findByCondition2Pager(Object paramObj) 
			throws Exception {
		Pager<T> pager = new Pager<T>();
		pager.setTotal(count(paramObj));
		pager.setResultList((List<T>)findByCondition(paramObj));
		return pager;
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
	 * 获得 Mapper 对象。
	 */
	public abstract <T extends BaseMapper> T getMapper();
	
}
