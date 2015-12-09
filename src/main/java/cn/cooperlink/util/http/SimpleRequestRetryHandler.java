/* **************************************************************
 *
 * 文件名称：SimpleRequestRetryHandler.java
 *
 * 包含类名：cn.cooperlink.util.http.SimpleRequestRetryHandler
 * 创建日期：2014年3月28日
 * 创建作者：潘云峰
 * 版权声明：Copyright 2014 北京酷博灵科信息科技有限公司 保留所有权利。
 *
 * **************************************************************/
package cn.cooperlink.util.http;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.UnknownHostException;

import javax.net.ssl.SSLException;

import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpRequest;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.protocol.HttpContext;

/**
 * 简单的请求重试处理类。
 * <p>代码直接引用官方实现。</p>
 *
 * 创建日期：2014年3月28日
 * 创建作者：潘云峰
 */
public class SimpleRequestRetryHandler implements HttpRequestRetryHandler{
	
	private int retyCount = 0;
	
	public SimpleRequestRetryHandler(){}
	
	public SimpleRequestRetryHandler(int retyCount) {
		this.retyCount = retyCount;
	}
	
    public boolean retryRequest(
            IOException exception,
            int executionCount,
            HttpContext context) {
        if (executionCount >= retyCount) {
            // Do not retry if over max retry count
            return false;
        }
        if (exception instanceof InterruptedIOException) {
            // Timeout
            return false;
        }
        if (exception instanceof UnknownHostException) {
            // Unknown host
            return false;
        }
        if (exception instanceof ConnectTimeoutException) {
            // Connection refused
            return false;
        }
        if (exception instanceof SSLException) {
            // SSL handshake exception
            return false;
        }
        HttpClientContext clientContext = HttpClientContext.adapt(context);
        HttpRequest request = clientContext.getRequest();
        boolean idempotent = !(request instanceof HttpEntityEnclosingRequest);
        if (idempotent) {
            // Retry if the request is considered idempotent
            return true;
        }
        return false;
    }
}
