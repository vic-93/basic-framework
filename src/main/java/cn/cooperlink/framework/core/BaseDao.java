/* **************************************************************
 *
 * 文件名称：BaseDao.java
 *
 * 包含类名：cn.cooperlink.framework.core.BaseDao
 * 创建日期：2014-2-21
 * 创建作者：潘云峰
 * 版权声明：Copyright 2014 北京酷博灵科信息科技有限公司 保留所有权利。
 *
 * **************************************************************/
package cn.cooperlink.framework.core;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * Dao 基类。
 * <p>如果需要通过传统Dao方式调用Mybatis， </p>
 * <p>可继承此类。基类中提供了常用的增、删、改、分页查询方法。</p>
 * 
 * 创建日期：2014-2-21
 * 创建作者：潘云峰
 */
@Repository
public abstract class BaseDao extends SqlSessionDaoSupport{
	
	/**
	 * 保存
	 * 
	 * @param entity	要保存的实体
	 * @return
	 */	
	public int save(Object entity) throws Exception {
		return getSqlSession().insert(getMapper() 
				+ BaseDaoMethod.SAVE, entity);
	}
	
	/**
	 * 批量保存
	 * 
	 * @param entity	要保存的实体
	 * @return
	 */	
	public int saveBatch(List<Object> entity) throws Exception {
		return getSqlSession().insert(getMapper() 
				+ BaseDaoMethod.SAVE_BATCH, entity);
	}
	
	/**
	 * 保存
	 * 
	 * @param entity	要保存的实体
	 * @return
	 */	
	public int insert(Object entity) throws Exception {
		return getSqlSession().insert(getMapper() 
				+ BaseDaoMethod.INSERT, entity);
	}
	
	/**
	 * 批量保存
	 * 
	 * @param entity	要保存的实体
	 * @return
	 */	
	public int insertBatch(List<Object> entity) throws Exception {
		return getSqlSession().insert(getMapper() 
				+ BaseDaoMethod.INSERT_BATCH, entity);
	}
	
	/**
	 * 删除
	 * 
	 * @param paramObj	条件参数
	 * @return
	 */
	public int delete(Object paramObj)  throws Exception {
		return getSqlSession().delete(getMapper() 
				+ BaseDaoMethod.DELETE, paramObj);
	}
	
	/**
	 * 批量删除
	 *
	 * @param paramList
	 * @return
	 * @throws Exception
	 */
	public int deleteBatch(List<Object> paramList) throws Exception {
		return getSqlSession().delete(getMapper() 
				+ BaseDaoMethod.DELETE_BATCH, paramList);
	}
	
	/**
	 * 更新
	 * 
	 * @param entity	要更的新实体
	 * @return
	 */
	public int update(Object entity)  throws Exception {
		return getSqlSession().update(getMapper() 
				+ BaseDaoMethod.UPDATE, entity);
	}

	/**
	 * 获取单个实体
	 * 
	 * @param paramObj	查询条件参数
	 * @return	实体
	 */
	public <T> T getSingle(Object paramObj)  throws Exception {
		return getSqlSession().selectOne(getMapper() 
				+ BaseDaoMethod.GET_SINGLE, paramObj);
	}
	
	/**
	 * 获取全部
	 * 
	 * @return
	 */
	public <T> List<T> findAll()  throws Exception {
		return getSqlSession().selectList(getMapper() 
				+ BaseDaoMethod.FIND_ALL);
	}

	/**
	 * 条件查询
	 * 
	 * @param paramObj	查询条件参数
	 * @return
	 */
	public <T> List<T> findByCondition(Object paramObj) throws Exception {
		return getSqlSession().selectList(getMapper() 
				+ BaseDaoMethod.FIND_BY_CONDITION, paramObj);
	}
	
	/**
	 * 合计
	 *
	 * @param paramObj
	 * @return
	 * @throws Exception
	 */
	public long count(Object paramObj) throws Exception {
		return getSqlSession().selectOne(getMapper() 
				+ BaseDaoMethod.COUNT, paramObj);
	}

	
	/**
	 * 分页查询
	 * 
	 * @param paramObj	查询条件参数
	 * @return Pager对象
	 */
	@SuppressWarnings("unchecked")
	public <T> Pager<T> findByCondition2Pager(Object paramObj) 
			throws Exception {
		Pager<T> pager = new Pager<T>();
		long total = count(paramObj);
		pager.setTotal(total);
		pager.setResultList((List<T>) findByCondition(paramObj));
		return pager;
	}
	
//	/**
//	 * 分页查询
//	 * 
//	 * @param paramObj	查询条件参数
//	 * @param offset	查询起始位置
//	 * @param limit		查询结束位置
//	 * @return Pager对象
//	 */
//	@SuppressWarnings("unchecked")
//	public <T> Pager<T> findByCondition2Pager(Object paramObj, 
//			int offset, int limit)  throws Exception {
//		Pager<T> pager = new Pager<T>();
//		long total = count(paramObj);
//		pager.setTotal(total);
//		pager.setResultList((List<T>)(getSqlSession()
//				.selectList(getMapper() 
//						+ BaseDaoMethod.FIND_BY_CONDITION, 
//						paramObj, new RowBounds(offset, limit))));
//		return pager;
//	}
	
	/**
	 * 分页查询
	 * 
	 * @param key		mapper id
	 * @param countKey	总计的 mapper id
	 * @param paramObj	查询条件参数
	 * @return Pager对象
	 */
	@SuppressWarnings("unchecked")
	public <T> Pager<T> findByCondition2Pager(String key, String countKey, 
			Object paramObj)  throws Exception {
		Pager<T> pager = new Pager<T>();
		long total = getSqlSession().selectOne(getMapper() 
				+ countKey, paramObj);
		pager.setTotal(total);
		pager.setResultList((List<T>)(getSqlSession()
				.selectList(getMapper() + key, paramObj)));
		return pager;
	}
	
	/**
	 * 获取 mapper 名称
	 * <p>子类必须实现的方法。</p>
	 * <p>返回 mapper.xml文件中mapper的命名空间名称</p>
	 * 
	 * @return mapper 名称
	 */
	public abstract String getMapper();

	@Override
	@Resource(name="sqlSessionTemplate")
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		super.setSqlSessionTemplate(sqlSessionTemplate);
	}
	
}
