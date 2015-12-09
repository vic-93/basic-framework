/* **************************************************************
 *
 * 文件名称：QueryCondition.java
 *
 * 包含类名：cn.cooperlink.framework.core.QueryCondition
 * 创建日期：2014年3月25日
 * 创建作者：潘云峰
 * 版权声明：Copyright 2014 北京酷博灵科信息科技有限公司 保留所有权利。
 *
 * **************************************************************/
package cn.cooperlink.framework.core;

import java.util.HashMap;

/**
 * 查询条件类。
 * <p>继承自HashMap</p>
 *
 * 创建日期：2014年3月25日
 * 创建作者：潘云峰
 */
public class QueryCondition extends HashMap<String, Object> {
	
	public static final String PAGER_START = "start";
	
	public static final String PAGER_LIMIT = "limit";

	/** serialVersionUID */
	private static final long serialVersionUID = -8139079122411280982L;
	
	@Override
	public Object put(String key, Object value) {
		// 分页参数转换
		if (key != null && (PAGER_START.equals(key)
				|| PAGER_LIMIT.equals(key))) {
			value = parse2Int(value);
		}
		return super.put(key, value);
	}
	
	private int parse2Int(Object value) {
		if (value == null) {
			return 0;
		}
		if (value instanceof String) {
			try {
				return Integer.valueOf((String) value);
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}
		} else if (value instanceof Integer) {
			return (Integer) value;
		}
		return 0;
	}

}
