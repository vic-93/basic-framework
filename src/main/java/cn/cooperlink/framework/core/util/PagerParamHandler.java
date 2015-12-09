/* **************************************************************
 *
 * 文件名称：PagerParamHandler.java
 *
 * 包含类名：cn.cooperlink.framework.core.util.PagerParamHandler
 * 创建日期：2014年4月16日
 * 创建作者：潘云峰
 * 版权声明：Copyright 2014 北京酷博灵科信息科技有限公司 保留所有权利。
 *
 * **************************************************************/
package cn.cooperlink.framework.core.util;

import java.util.Map;

/**
 * 处理Map参数中的分页参数。
 *
 * 创建日期：2014年4月16日
 * 创建作者：潘云峰
 */
public class PagerParamHandler {
	
	public static final String PAGE = "page";			// jquery easyui 当前页，从1开始
	
	public static final String ROWS = "rows";           // jquery easyui 查询行数，默认20
	
	public static final String START_PARAM = "start";
	
	public static final String LIMIT_PARAM = "limit";

	private PagerParamHandler() {
	}
	// page=1, rows=20
	public static void convertFormat(Map<String, Object> paramMap) {
		Object rows = paramMap.get(ROWS);
		if (rows == null) {
			paramMap.remove(PAGE);
			return;
		}
		if (!(rows instanceof String)) {
			return;
		}
		Object page = paramMap.get(PAGE);
		int limit = Integer.parseInt((String) rows);
		if (page == null) {
			paramMap.put(START_PARAM, 0);
			paramMap.put(LIMIT_PARAM, Integer.parseInt((String) rows));
		} else {
			if (page instanceof String) {
				int temp = Integer.parseInt((String) page);
				paramMap.put(START_PARAM, (temp - 1) * limit);
				paramMap.put(LIMIT_PARAM, limit);
			}
		}
	}
	
	public static void clearPagerParam(Map<String, Object> paramMap) {
		paramMap.remove(START_PARAM);
		paramMap.remove(LIMIT_PARAM);
	}
	
	public static boolean needPager(Map<String, Object> paramMap) {
		if (paramMap.containsKey(START_PARAM) &&
				paramMap.containsKey(LIMIT_PARAM)) {
			return true;
		}
		return false;
	}
	
}
