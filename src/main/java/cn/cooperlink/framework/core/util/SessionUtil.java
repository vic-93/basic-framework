/* **************************************************************
 *
 * 文件名称：SessionUtil.java
 *
 * 包含类名：cn.cooperlink.framework.core.util.SessionUtil
 * 创建日期：2014年2月24日
 * 创建作者：潘云峰
 * 版权声明：Copyright 2014 北京酷博灵科信息科技有限公司 保留所有权利。
 *
 * **************************************************************/
package cn.cooperlink.framework.core.util;

import javax.servlet.http.HttpSession;

/**
 * springmvc中HttpSession 工具类类。
 *
 * 创建日期：2014年2月24日
 * 创建作者：潘云峰
 */
public class SessionUtil {
	
	private SessionUtil(){}

	/**
     * 获得当前httpSession
     * 
     * @return session
     */
    public static HttpSession getSession() {        
        return RequestUtil.getRequest().getSession(); 
    }
    
    public static String getSessionId() {
    	return getSession().getId();
    }
    
    /**
     * 将参数保存到HttpSession中。
     * 
     * @param key	保存参数的键
     * @param attr  保存参数的值
     */
    public static void setAttribute(String key, Object attr) {
    	getSession().setAttribute(key, attr);
    }
    
    /**
     * 从HttpSerssion中获取指定key的值。
     * 
     * @param key	保存参数的键
     * @return
     */
    public static Object getAttribute(String key) {
    	return getSession().getAttribute(key);
    }
}
