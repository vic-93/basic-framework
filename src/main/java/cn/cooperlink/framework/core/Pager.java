/* **************************************************************
 *
 * 文件名称：Pager.java
 *
 * 包含类名：cn.cooperlink.framework.core.Pager
 * 创建日期：2014-2-21
 * 创建作者：潘云峰
 * 版权声明：Copyright 2014 北京酷博灵科信息科技有限公司 保留所有权利。
 *
 * **************************************************************/
package cn.cooperlink.framework.core;

import java.util.List;

import net.sf.json.JsonConfig;

/**
 * 分页结果包裹类。
 * 
 * 创建日期：2014-2-21
 * 创建作者：潘云峰
 */
public class Pager<T> {
	
	public static final String JSON_EMPTY = "{'total':'0','rows':[]}";
	
	/** 记录总数 */
	private long total;
	
	/** 结果集 */
	private List<T> resultList;

	public long getTotal() {
		return total;
	}
	
	public void setTotal(long total) {
		this.total = total;
	}
	
	public List<T> getResultList() {
		return resultList;
	}

	public void setResultList(List<T> resultList) {
		this.resultList = resultList;
	}
	
	/**
	 * 转换为Json对象
	 * <p>
	 * 	{'total':'0', 'list':[]}
	 * </p>
	 *
	 * @return
	 */
	public String toJsonString() {
		return toJsonString(Constants.DATE_FORMAT_FULL, null);
	}

	/**
	 * 转换为Json对象，指定日期转换格式
	 * <p>
	 * 	{'total':'0', 'list':[]}
	 * </p>
	 *
	 * @param dateFormat 日期格式
	 * @return
	 */
	public String toJsonString(String dateFormat) {
		return toJsonString(dateFormat, null);
	}
	
	/**
	 * 转换为Json对象，指定json转换配置
	 * <p>
	 * 	{'total':'0', 'rows':[]}
	 * </p>
	 *
	 * @param jsonConfig json转换配置
	 * @return
	 */
	public String toJsonString(JsonConfig jsonConfig) {
		return toJsonString(null, jsonConfig);
	}

	// 基础方法
	private String toJsonString(String dateFormat, JsonConfig jsonConfig) {
		StringBuilder pagerString = new StringBuilder();
		pagerString.append("{\"total\":\"");
		pagerString.append(total);
		pagerString.append("\",\"rows\":");
		if (dateFormat != null) {
			pagerString.append(Return.list2String(resultList, dateFormat));
		} else {
			pagerString.append(Return.list2String(resultList, jsonConfig));
		}
		pagerString.append("}");
		return pagerString.toString();
	}
	
}
