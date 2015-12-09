/* **************************************************************
 *
 * 文件名称：SpringMVCSimpleMappingExceptionResolver.java
 *
 * 包含类名：cn.cooperlink.framework.core.exception.SpringMVCSimpleMappingExceptionResolver
 * 创建日期：2014年4月6日
 * 创建作者：潘云峰
 * 版权声明：Copyright 2014 北京酷博灵科信息科技有限公司 保留所有权利。
 *
 * **************************************************************/
package cn.cooperlink.framework.core.exception;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import cn.cooperlink.framework.core.Return;
import cn.cooperlink.util.StringUtil;
import cn.cooperlink.util.logging.Log;
import cn.cooperlink.util.logging.LogFactory;

/**
 * 异常处理类。
 *
 * 创建日期：2014年4月6日
 * 创建作者：潘云峰
 */
public class SpringMVCSimpleMappingExceptionResolver extends SimpleMappingExceptionResolver {
	
	public static final Log log = LogFactory.getLog(SpringMVCSimpleMappingExceptionResolver.class);
	
	@Override
	protected ModelAndView doResolveException(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex) {
		ModelAndView mv = null;
		String accept = request.getHeader("accept");
        if (accept != null && !(accept.indexOf("application/json") > -1 
        		|| (request.getHeader("X-Requested-With") != null 
        		&& request.getHeader("X-Requested-With").indexOf("XMLHttpRequest") > -1))) {
            mv = super.doResolveException(request, response, handler, ex);
        } else {
            try { 
            	// json 请求返回
                PrintWriter writer = response.getWriter();  
                writer.write(Return.failure((ex.getMessage())));
                writer.flush();
            } catch (IOException e) {
            	if (log.isInfoEnabled()) {
            		log.info(StringUtil.getTrace(e));
            	}
            }
        }
        doLog((HandlerMethod) handler, ex);
        return mv;
	}
	
	/**
	 * 记录异常日志
	 * 
	 * @param handler
	 * @param excetpion
	 */
	private void doLog(HandlerMethod handler, Exception excetpion) {
        if (log.isEnabledExceptionDb()) {
        	// 异常信息日志入库
        }
	}
	
}
