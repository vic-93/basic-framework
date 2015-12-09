/* **************************************************************
 *
 * 文件名称：ExtjsTreeUtil.java
 *
 * 包含类名：cn.cooperlink.framework.core.util.ExtjsTreeUtil
 * 创建日期：2014年8月4日
 * 创建作者：潘云峰
 * 版权声明：Copyright 2014 北京酷博灵科信息科技有限公司 保留所有权利。
 *
 * **************************************************************/
package cn.cooperlink.framework.core.util;

import static cn.cooperlink.util.StringUtil.null2Empty;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.cooperlink.framework.core.BaseEUITreeEntity;
import cn.cooperlink.framework.core.annotation.EscapeField;
import cn.cooperlink.util.StringUtil;

/**
 * Extjs处理类。
 *
 * 创建日期：2014年8月4日
 * 创建作者：潘云峰
 */
public class EUITreeUtil {
	
	/** 树根节点ID */
	public static final String TREE_ROOT_ID = new String("-1");
	
	/**
	 * 获取一个空结构的树形Json串
	 *
	 * @return
	 */
	public static final String getEmptyTreeJson() {
		return "[]";
	}

	/**
	 * 返回可选的extjs树所要求的 json字符串。
	 * 
	 * @param nodesList 树节点List
	 * @return
	 */
	public static final <T extends BaseEUITreeEntity> String 
			buildCheckableTreeJson(List<T> nodesList) {
		return buildTreeJson(nodesList, true);
	}

	/**
	 * 返回extjs树所要求的 json字符串，此树默认为不可选形式。
	 * 
	 * @param nodesList 树节点List
	 * @return
	 */
	public static final <T extends BaseEUITreeEntity> String 
			buildTreeJson(List<T> nodesList) {
		return buildTreeJson(nodesList, false);
	}
	
	/**
	 * 返回extjs树所要求的 json字符串。
	 * 
	 * @param nodesList	树节点List
	 * @param checkable	树节点是否可选 true - 可选， false - 不可选 
	 * @return
	 */
	public static final <T extends BaseEUITreeEntity> String 
			buildTreeJson(List<T> nodesList, boolean checkable) {
		return buildTreeJson(nodesList, TREE_ROOT_ID, checkable);
	}
	
	public static final <T extends BaseEUITreeEntity> String 
		buildTreeJson(List<T> nodesList, String rootNodeId) {
		return buildTreeJson(nodesList, rootNodeId, false);
	}
	
	public static final <T extends BaseEUITreeEntity> String 
		buildTreeJson(List<T> nodesList, String rootNodeId, boolean checkable) {
		if (nodesList == null || nodesList.size() == 0) {
			return getEmptyTreeJson();
		}
		StringBuilder treeJson = new StringBuilder();
		Map<String, List<T>> nodeMap = listToNodesMap(nodesList);
		List<T> rootNodes = nodeMap.get(rootNodeId);
		buildChildNodesJson(nodeMap, rootNodes, treeJson, checkable);
		return treeJson.toString();
	}

	/**
	 * 将节点List 转换到Map中
	 * <p>返回的Map以 父节点ID为key， 子节点List为值。</p>
	 *
	 * @param nodesList
	 * @return
	 */
	public static final <T extends BaseEUITreeEntity> Map<String, List<T>> 
			listToNodesMap(List<T> nodesList) {
		Map<String, List<T>> map = new HashMap<String, List<T>>();
		if (nodesList == null || nodesList.size() == 0) {
			return map;
		}
		List<T> childreen = null;
		String parentId = null;
		for (T node : nodesList) {
			parentId = node.getParentId();
			if (parentId == null ) {
				parentId = TREE_ROOT_ID;
			}
			/*
			if (parentId == null || parentId < 0) {
				parentId = TREE_ROOT_ID;
			}*/
			childreen = (List<T>) map.get(parentId);
			if (childreen == null) {
				childreen = new ArrayList<T>();
				map.put(parentId, childreen);
			}
			childreen.add(node);
		}
		return map;
	}
	
	/**
	 * 构建树节点
	 *
	 * @param nodeMap
	 * @param childNodes
	 * @param treeJson
	 * @param checkable
	 */
	public static final <T extends BaseEUITreeEntity> 
			void buildChildNodesJson(Map<String, List<T>> nodeMap, 
					List<T> childNodes,StringBuilder treeJson,
					boolean checkable) {
		if (childNodes == null || childNodes.size() == 0) {
			treeJson.append("[]");
			return;
		}
		treeJson.append("[");
		T t = null;
		int len = childNodes.size();
		for (int i = 0; i < len; i++) {
			t = childNodes.get(i);
			treeJson.append("{");
			buildNodeFields(t, treeJson, checkable, false);
			treeJson.append(",\"children\":");
			buildChildNodesJson(nodeMap, nodeMap.get(
					t.getId()), treeJson, checkable);
			treeJson.append("}");
			if (i < (len - 1)) {
				treeJson.append(",");
			}
		}
		treeJson.append("]");
	}
	
	public static final <T extends BaseEUITreeEntity> 
			void buildCheckableNodeFields(T t, StringBuilder treeJson, 
					boolean hasBaseProperty) {
		
	}
	
	/**
	 * 构建节点字段。
	 * <p>将节点属性拼装为'prop':'val','prop1':'val1'...形式。</p>
	 *
	 * @param t
	 * @param treeJson
	 * @param hasBaseProperty
	 */
	public static final <T extends BaseEUITreeEntity> 
			void buildNodeFields(T t, StringBuilder treeJson, 
					boolean checkable, boolean hasBaseProperty) {
		buildNodeFields(t, treeJson, checkable, true, hasBaseProperty);
//		Class<?> clazz = t.getClass();
//		Field[] fields = clazz.getDeclaredFields();
//		EscapeField a = null;
//		Method m = null;
//		try {
//			treeJson.append("'id':'")
//				.append(t.getId())
//				.append("',")
//				.append("'parentId':'")
//		   		.append(null2Empty(t.getParentId()))
//		   		.append("',");
//			for (Field f : fields) {
//				if (Modifier.isStatic(f.getModifiers())) {
//					continue;
//				}
//				a = f.getAnnotation(EscapeField.class);
//				if (a != null || "serialVersionUID".equals(f.getName())) {
//					continue;
//				}
//				m = clazz.getMethod("get" + StringUtil.initcap(f.getName()));
//				if (m == null) {
//					continue;
//				}
//				treeJson.append("'")
//					.append(f.getName())
//					.append("':'")
//					.append(null2Empty(m.invoke(t)))
//				    .append("',");
//			}
//			if (hasBaseProperty) {
//				treeJson.append("'createPerson':'")
//					.append(null2Empty(t.getCreatePerson()))
//					.append("',")
//					.append("'createTime':'")
//					.append(null2Empty(t.getCreateTime()))
//					.append("',")
//					.append("'updatePerson':'")
//					.append(null2Empty(t.getUpdatePerson()))
//					.append("',")
//					.append("'updateTime':'")
//					.append(null2Empty(t.getUpdateTime()))
//					.append("',")
//					.append("'orgIdFullpath':'")
//					.append(null2Empty(t.getOrgIdFullpath()))
//					.append("',");
//			}
//			if (checkable) {
//				treeJson.append("'checked':")
//						.append(t.getChecked())
//						.append(",");
//			}
//			treeJson.append("'text':'")
//				.append(null2Empty(t.getText()))
//				.append("','leaf':")
//				.append(t.isLeaf())
//				.append(",")
//				.append("'expanded':")
//				.append(t.isExpanded())
//				.append(",")
//				.append("'iconCls':'")
//				.append(null2Empty(t.getIconCls()))
//				.append("'");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
	}
	
	/**
	 * 构建节点字段。
	 * <p>将节点属性拼装为'prop':'val','prop1':'val1'...形式。</p>
	 *
	 * @param t
	 * @param treeJson
	 * @param checkable           是否为可选中的节点。
	 * @param hasExpanded         是否标记展开属性。
	 * @param hasBaseProperty     是否包含实体基础字段信息。
	 */
	public  static final <T extends BaseEUITreeEntity> 
	void buildNodeFields(T t, StringBuilder treeJson, 
			boolean checkable, boolean hasExpanded, boolean hasBaseProperty) {
		Class<?> clazz = t.getClass();
		Field[] fields = clazz.getDeclaredFields();
		EscapeField a = null;
		Method m = null;
		try {
			treeJson.append("\"id\":\"")
				.append(t.getId())
				.append("\",")
				.append("\"parentId\":\"")
		   		.append(null2Empty(t.getParentId()))
		   		.append("\",");
			for (Field f : fields) {
				if (Modifier.isStatic(f.getModifiers())) {
					continue;
				}
				a = f.getAnnotation(EscapeField.class);
				if (a != null || "serialVersionUID".equals(f.getName())) {
					continue;
				}
				m = clazz.getMethod("get" + StringUtil.initcap(f.getName()));
				if (m == null) {
					continue;
				}
				treeJson.append("\"")
					.append(f.getName())
					.append("\":\"")
					.append(null2Empty(m.invoke(t)))
				    .append("\",");
			}
			if (hasBaseProperty) {
				treeJson.append("\"createPerson\":\"")
					.append(null2Empty(t.getCreateUserId()))
					.append("\",")
					.append("\"createTime\":\"")
					.append(null2Empty(t.getCreateDate()))
					.append("\",")
					.append("\"updatePerson\":\"")
					.append(null2Empty(t.getModifyUserId()))
					.append("\",")
					.append("\"updateTime\":\"")
					.append(null2Empty(t.getModifyDate()))
					.append("\",");
			}
			if (checkable) {
				treeJson.append("\"checked\":")
						.append(t.getChecked())
						.append(",");
			}
			if (hasExpanded) {
				treeJson.append("\"state\":\"")
				.append(t.getState())
				.append("\",");
			}
			treeJson.append("\"text\":\"")
				.append(null2Empty(t.getText()))
				.append("\",\"leaf\":")
				.append(t.isLeaf())
				.append(",")
				.append("\"iconCls\":\"");
			   // add yangming 20141119 start
				if(t.getOrgType().equals("1")){
					treeJson.append("icon-corp");
				}else if(t.getOrgType().equals("2")) {
					treeJson.append("icon-org");
				}else {
					treeJson.append(null2Empty(t.getIconCls()));
				}
				// add yangming 2014119 end
				treeJson.append("\"");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
