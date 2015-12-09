/* **************************************************************
 *
 * 文件名称：BaseEntity.java
 *
 * 包含类名：cn.cooperlink.framework.core.BaseEntity
 * 创建日期：2014年2月23日
 * 创建作者：潘云峰
 * 版权声明：Copyright 2014 北京酷博灵科信息科技有限公司 保留所有权利。
 *
 * **************************************************************/
package cn.cooperlink.framework.core;

import java.io.Serializable;
import java.util.Date;

/**
 * 实体类基类。
 * <p>定义id、创建人、创建时间、更新人、更新时间 5 个公共属性。</p>
 * 
 * 创建日期：2014年2月23日
 * 创建作者：潘云峰
 */
public class BaseEntity implements Serializable{
	
	/** validityFlag 1 代表数据有效 */
	public static final int VF_VALID = 1;
	
	/** validityFlag 2 代表数据无效 */
	public static final int VF_INVALID = 2;
	
	/** validityFlag 9 代表数据已删除 ( 逻辑删除标识 ) */
	public static final int VF_DELETED = 9;
	
	/** serialVersionUID */
	private static final long serialVersionUID = 1L;
	
	/** id */
	private String id;
	
	
	  /** create_user_id */
    private String createUserId;

    /** create_date */
    private String createDate;

    /** modify_user_id */
    private String modifyUserId;

    /** modify_date */
    private String modifyDate;
	
 

	
	/** 记录版本号 */
	private int version = 0;

	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	

	public String getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(String createUserId) {
		this.createUserId = createUserId;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getModifyUserId() {
		return modifyUserId;
	}

	public void setModifyUserId(String modifyUserId) {
		this.modifyUserId = modifyUserId;
	}

	public String getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(String modifyDate) {
		this.modifyDate = modifyDate;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

}
