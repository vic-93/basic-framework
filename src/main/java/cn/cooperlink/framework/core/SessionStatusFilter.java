/** 
 * 文件名称：SessionStatusFilter.java 
 * 包含类名：cn.cooperlink.framework.core.SessionStatusFilter
 * 创建时间：2014-10-17 上午9:35:46 
 * 版本声明：Copyright (c) 2014, cooperlink.cn All Rights Reserved. 
 * 北京酷博灵科信息技术有限公司
 */
package cn.cooperlink.framework.core;

import java.io.IOException;
import java.security.Principal;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jasig.cas.client.validation.Assertion;

/**
 * @Title：
 * @Description：
 * @Package cn.cooperlink.framework.core
 * @ClassName SessionStatusFilter
 * @author John.He
 * @date 2014-10-17 上午9:35:46
 * @version
 */
public class SessionStatusFilter implements Filter {

    
    public static final String CONST_CAS_ASSERTION = "_const_cas_assertion_";
    public static final String CONST_CAS_LOGIN_URL = "_const_cas_login_url_";
    public static final String CONST_CAS_LOGOUT_URL = "_const_cas_logout_url_";
    
    protected final Log log = LogFactory.getLog(getClass());
    private String portalUrl;
    private String casServerLoginUrl;
    private String casServerLogoutUrl;
    
    public void init(FilterConfig filterConfig) throws ServletException {
	log.info("init");
	portalUrl = filterConfig.getInitParameter("portalUrl");
	casServerLoginUrl = filterConfig.getInitParameter("casServerLoginUrl");
	casServerLogoutUrl = filterConfig.getInitParameter("casServerLogoutUrl");
	log.info("Loading portalUrl property: " + this.portalUrl); 
//	log.info("Loading casServerLoginUrl property: " + this.casServerLoginUrl); 
	log.info("Loading casServerLoginOutUrl property: " + this.casServerLogoutUrl); 
    }
    
    
    public void doFilter(ServletRequest request, ServletResponse response,
	    FilterChain chain) throws IOException, ServletException {
	
	HttpServletRequest httpRequest = (HttpServletRequest) request;
	HttpServletResponse httpResponse = (HttpServletResponse) response;
	HttpSession session = httpRequest.getSession();
	
	 ////如果是ajax请求响应头会有，x-requested-with；  值为 XMLHttpRequest
	//String xRequestedWith = httpRequest.getHeader("x-requested-with");
	//xRequestedWith = "XMLHttpRequest";
	
	//log.info("request:" + httpRequest.getRequestURL().toString());
	
	//获取cas单点登录Session
	Object assertion= session.getAttribute(CONST_CAS_ASSERTION);
	if(assertion != null) {
	    chain.doFilter(request, response);// 放行。让其走到下个链或目标资源中
	    //log.info("auth-user: " + ((Assertion)assertion).getPrincipal().getName()); 
	} else {
	    if(session.getAttribute(CONST_CAS_LOGIN_URL)!=null) { //session已经创建
		 //log.info("放行：" +httpRequest.getRequestURL().toString());
		 chain.doFilter(request, response);// 放行。让其走到下个链或目标资源中
	    } else {                                           //session没有创建或丢失
		 String toLoginUrl = this.casServerLoginUrl + "?service=" +  httpRequest.getRequestURL().toString() + ";jsessionid="  + session.getId();
		 session.setAttribute(CONST_CAS_LOGIN_URL, toLoginUrl);
		 log.info("cas-login-url: " + toLoginUrl);
		 
		 String toLogoutUrl = this.casServerLogoutUrl + "?service=" +  this.portalUrl + "&rnd=" + String.valueOf(System.currentTimeMillis());
		 //session.setAttribute(CONST_CAS_LOGOUT_URL, toLogoutUrl);
		 
		 Cookie cookie = new Cookie(CONST_CAS_LOGOUT_URL,toLogoutUrl);
		 cookie.setPath("/");
		 httpResponse.addCookie(cookie);

		 log.info("cas-logout-url: " + toLogoutUrl);
		 httpResponse.sendError(509);
	    }
//	    httpResponse.sendRedirect("http://192.168.0.26:8084/authServer/login");
	    log.info("auth-user: none");
	}
    }


    public void destroy() {
	System.out.println("销毁了");
    }

    

}
