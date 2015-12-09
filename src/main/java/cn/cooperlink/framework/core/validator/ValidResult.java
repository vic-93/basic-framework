/* **************************************************************
 *
 * 文件名称：ValidResult.java
 *
 * 包含类名：cn.cooperlink.framework.core.validator.ValidResult
 * 创建日期：2014年5月14日
 * 创建作者：潘云峰
 * 版权声明：Copyright 2014 北京酷博灵科信息科技有限公司 保留所有权利。
 *
 * **************************************************************/
package cn.cooperlink.framework.core.validator;
/**
 * 验证结果类。
 *
 * 创建日期：2014年5月14日
 * 创建作者：潘云峰
 */
public class ValidResult {

	/** 成功 */
	private boolean success;
	
	/** 消息 */
	private String msg;
	
	public ValidResult(boolean success, String msg) {
		super();
		this.success = success;
		this.msg = msg;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
