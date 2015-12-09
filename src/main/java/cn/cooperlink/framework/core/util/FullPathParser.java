/* **************************************************************
 *
 * 文件名称：FullPathParser.java
 *
 * 包含类名：cn.cooperlink.framework.core.util.FullPathParser
 * 创建日期：2014年3月26日
 * 创建作者：潘云峰
 * 版权声明：Copyright 2014 北京酷博灵科信息科技有限公司 保留所有权利。
 *
 * **************************************************************/
package cn.cooperlink.framework.core.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.cooperlink.util.StringUtil;

/**
 * 全路径解析工具类。
 *
 * 创建日期：2014年3月26日
 * 创建作者：潘云峰
 */
public class FullPathParser {

	private FullPathParser(){}
	
	/**
	 * 全路径解析成列表
	 *
	 * @param fullpath
	 * @return
	 */
	public static final List<String> pathToList(String fullpath) {
		if (StringUtil.isBlank(fullpath)) {
			return null;
		}
		List<String> list = new ArrayList<String>();
		String[] arr = fullpath.split("/");
		for (String p : arr) {
			if (StringUtil.isNotBlank(p)) {
				list.add(p);
			}
		}
		return list;
	}
	
	public static final List<String> pathToPathList(String fullpath) {
		if (StringUtil.isBlank(fullpath)) {
			return null;
		}
		List<String> list = new ArrayList<String>();
		int index = -1;
		do {
			list.add(fullpath);
			index = fullpath.lastIndexOf("/");
			if (index > 0) {
				fullpath = fullpath.substring(0, index);
			}
		} while (index > 0);
		return list;
	}
	
	public static final String pathToInCondition(String fullpath) {
		StringBuilder fp = new StringBuilder();
		fp.append("(");
		int index = -1;
		do {
			fp.append("'");
			fp.append(fullpath);
			fp.append("'");
			index = fullpath.lastIndexOf("/");
			if (index > 0) {
				fullpath = fullpath.substring(0, index);
				fp.append(",");
			}
		} while (index > 0);
		fp.append(")");
		return fp.toString();
	}
	
	public static final List<String> personIdPathToIdList(String idFullpath) {
		if (StringUtil.isBlank(idFullpath)) {
			return null;
		}
		List<String> list = new ArrayList<String>();
		String[] ids = idFullpath.split("/");
		for (int i = 0; i < ids.length; i++) {
			if (StringUtil.isBlank(ids[i])) {
				continue;
			}
			if (ids[i].indexOf(".") != -1) {
				list.add(ids[i].substring(0, ids[i].indexOf(".")));
			}
		}
		return list;
	}
	
	public static Map<String, String> convert2OrgInfoMap(String idFullpath, 
			String nameFullpath, String codeFullpath) {
		if (StringUtil.isBlank(idFullpath) 
				|| StringUtil.isBlank(nameFullpath)
				|| StringUtil.isBlank(codeFullpath)) {
			return null;
		}
		
		Map<String, String> map = new HashMap<String, String>();
		
		String posId = null;
		String posIdFullpath = null;
		String posName = null;
		String posNameFullpath = null;
		String posCode = null;
		
		String deptId = null;
		String deptIdFullpath = null;
		String deptName = null;
		String deptNameFullpath = null;
		String deptCode = null;
		
		String orgId = null;
		String orgIdFullpath = null;
		String orgName = null;
		String orgNameFullpath = null;
		String orgCode = null;
		
		String topOrgId = null;
		String topOrgIdFullpath = null;
		String topOrgName = null;
		String topOrgNameFullpath = null;
		String topOrgCode = null;
		
		int orgLevel = 0;
		
		//String idFp = idFullpath;
		//String nameFp = nameFullpath;
		//String codeFp = codeFullpath;
		try {
			if (!idFullpath.startsWith("/")) {
				idFullpath = "/" + idFullpath;
			}
			
			if (!nameFullpath.startsWith("/")) {
				nameFullpath = "/" + nameFullpath;
			}
			
			if (!codeFullpath.startsWith("/")) {
				codeFullpath = "/" + codeFullpath;
			}
			
			String[] idFps = idFullpath.split("/");
			String[] nameFps = nameFullpath.split("/");
			String[] codeFps = codeFullpath.split("/");
			
			boolean hasSetDept = false;
			
			for (int i = idFps.length - 1; i > -1; i--) {
				if (idFps[i].endsWith(".pos")) {
					posId = idFps[i].substring(0, idFps[i].indexOf(".pos"));
					posIdFullpath = idFullpath;
					posName = nameFps[i];
					posNameFullpath = nameFullpath;
					posCode = codeFps[i];
				} else if (idFps[i].endsWith(".dept") && !hasSetDept) {
					deptId = idFps[i].substring(0, idFps[i].indexOf(".dept"));
					deptIdFullpath = idFullpath.substring(0, 
							idFullpath.lastIndexOf(".dept") + ".dept".length());
					deptName = nameFps[i];
					deptNameFullpath = nameFullpath.substring(0, 
							nameFullpath.indexOf(deptName) + deptName.length());
					deptCode = codeFps[i];
					hasSetDept = true;
				} else if (idFps[i].endsWith(".org")) {
					orgId = idFps[i].substring(0, idFps[i].indexOf(".org"));
					orgIdFullpath = idFullpath.substring(0, 
							idFullpath.lastIndexOf(".org") + ".org".length());
					orgName = nameFps[i];
					orgNameFullpath = nameFullpath.substring(0, 
							nameFullpath.indexOf(orgName) + orgName.length());
					orgCode = codeFps[i];
					break;
				}
			}
			
			for (int i = idFps.length - 1; i > -1; i--) {
				if (idFps[i].indexOf(".org") != -1) {
					orgLevel ++;
				}
			}
			
			if (idFps.length > 2) {
				topOrgId = idFps[1].substring(0, idFps[1].indexOf(".org"));
				topOrgIdFullpath = idFullpath.substring(0, 
						idFullpath.indexOf(".org") + ".org".length());
				topOrgName = nameFps[1];
				topOrgNameFullpath = nameFullpath.substring(0, 
						nameFullpath.indexOf(orgName) + orgName.length());
				topOrgCode = codeFps[1];
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}

		map.put("posId", posId);
		map.put("posIdFullpath", posIdFullpath);
		map.put("posName", posName);
		map.put("posNameFullpath", posNameFullpath);
		map.put("posCode", posCode);

		map.put("deptId", deptId);
		map.put("deptIdFullpath", deptIdFullpath);
		map.put("deptName", deptName);
		map.put("deptNameFullpath", deptNameFullpath);
		map.put("deptCode", deptCode);

		map.put("orgId", orgId);
		map.put("orgIdFullpath", orgIdFullpath);
		map.put("orgName", orgName);
		map.put("orgNameFullpath", orgNameFullpath);
		map.put("orgCode", orgCode);

		map.put("topOrgId", topOrgId);
		map.put("topOrgIdFullpath", topOrgIdFullpath);
		map.put("topOrgName", topOrgName);
		map.put("topOrgNameFullpath", topOrgNameFullpath);
		map.put("topOrgCode", topOrgCode);
		
		map.put("orgLevel", String.valueOf(orgLevel));
		
		return map;
	}
	
	public static void main(String[] args) {
		System.out.println(personIdPathToIdList("/c941f3a8823d4d96b837e97c70e5da2b.org/6a4a789251c542cd9f46594fa76a03ad.dept/23626f5ceb6b40eaa57f02e730ce9e98.psn"));
	}
			
 }
