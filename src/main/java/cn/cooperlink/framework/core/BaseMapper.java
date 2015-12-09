/* **************************************************************
 *
 * 文件名称：BaseMapper.java
 *
 * 包含类名：cn.cooperlink.framework.core.BaseMapper
 * 创建日期：2014-2-21
 * 创建作者：潘云峰
 * 版权声明：Copyright 2014 北京酷博灵科信息科技有限公司 保留所有权利。
 *
 * **************************************************************/
package cn.cooperlink.framework.core;

import java.util.List;

/**
 * Mapper 接口基类。
 * 
 * 创建日期：2014-2-21
 * 创建作者：潘云峰
 */
public interface BaseMapper {

	/**
	 * 保存
	 * 
	 * @param entity	要保存的实体
	 * @return
	 */
	public int save(Object entity) throws Exception;

	/**
	 * 保存
	 * 
	 * @param entityList	要保存的实体
	 * @return
	 */
	public int saveBatch(List<?> entityList) throws Exception;
	
	/**
	 * 删除
	 * 
	 * @param paramObj	条件参数
	 * @return
	 */
	public int delete(Object paramObj) throws Exception;
	
	/**
	 * 批量删除
	 * 
	 * @param paramObjList	条件参数
	 * @return
	 */
	public int deleteBatch(List<?> paramObjList) throws Exception;
	
	/**
	 * 更新
	 * 
	 * @param entity	要更新实体
	 * @return
	 */
	public int update(Object entity) throws Exception;
	
	/**
	 * 获取单个实体
	 * 
	 * @param paramObj	查询条件参数
	 * @return	实体
	 */
	public <T> T getSingle(Object paramObj) throws Exception;
	
	/**
	 * 获取全部
	 * 
	 * @return
	 */
	public <T> List<T> findAll() throws Exception;
	
	
	/**
	 * 统计记录总数
	 * 
	 * @param paramObj	查询条件
	 * @return
	 */
	public long count(Object paramObj) throws Exception;
	
	/**
	 * 条件查询
	 * 
	 * @param paramObj	查询条件参数
	 * @return
	 */
	public <T> List<T> findByCondition(Object paramObj) throws Exception;
	
}
