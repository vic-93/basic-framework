/* **************************************************************
 *
 * 文件名称：HttpClientUtil.java
 *
 * 包含类名：cn.cooperlink.util.http.HttpClientUtil
 * 创建日期：2014年3月28日
 * 创建作者：潘云峰
 * 版权声明：Copyright 2014 北京酷博灵科信息科技有限公司 保留所有权利。
 *
 * **************************************************************/
package cn.cooperlink.util.http;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

/**
 * httpclient。
 * <p>HttpClient4.X</p>
 *
 * 创建日期：2014年3月28日
 * 创建作者：潘云峰
 */
public class HttpClientUtil {
	
	/** 请求重试次数，默认重试3次 */
	public static final int SIMPLE_RETY_COUNT = 3;
	
	/**
	 * Get请求，返回字符串，默认请求重试3次。
	 *
	 * @param url
	 * @param params
	 * @return
	 */
	public static final String doGet(String url, Map<String, String> params) {
		return doGet(url, params, SIMPLE_RETY_COUNT);
	}
	
	/**
	 * Get请求，返回字符串。
	 *
	 * @param url
	 * @param params
	 * @return
	 */
	public static final String doGet(String url, Map<String, String> params, 
			int retryCount) {
		CloseableHttpClient httpClient = HttpClients.custom()
				.setRetryHandler(new SimpleRequestRetryHandler(retryCount))
				.build();
		StringBuilder urlBuilder = new StringBuilder();
		urlBuilder.append(setProtocol(url));
		if (params != null) {
			for (String key : params.keySet()) {
				if (params.get(key) != null) {
					urlBuilder.append(key);
					urlBuilder.append("=");
					urlBuilder.append(params.get(key));
				}
			}
		}
		HttpGet getRequest = new HttpGet(urlBuilder.toString());
		CloseableHttpResponse response = null;
		try {
			response = httpClient.execute(getRequest);
			int httpStatuCode = response.getStatusLine().getStatusCode();
			if (httpStatuCode == HttpStatus.SC_OK) {
				HttpEntity entity = response.getEntity();
				return EntityUtils.toString(entity);
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (response != null) {
				try {
					response.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (httpClient != null) {
				try {
					httpClient.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}
	
	/**
	 * Post请求，，返回字符串，默认重试3次
	 * 
	 * @param url
	 * @param params
	 * @return
	 */
	public static final String doPost(String url, Map<String, String> params) {
		return doPost(url, params, SIMPLE_RETY_COUNT);
	}
	
	/**
	 * Post请求，返回字符串。
	 *
	 * @param url
	 * @param params
	 * @return
	 */
	public static final String doPost(String url, Map<String, String> params, 
			int retryCount) {
		CloseableHttpClient httpClient = HttpClients.custom()
				.setRetryHandler(new SimpleRequestRetryHandler(retryCount))
				.build();
		List<NameValuePair> formParams = new ArrayList<NameValuePair>();
		if (params != null) {
			for (String key : params.keySet()) {
				if (params.get(key) != null) {
					formParams.add(new BasicNameValuePair(key, params.get(key)));
				}
			}
		}
		UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formParams, Consts.UTF_8);
		HttpPost postRequest = new HttpPost(setProtocol(url));
		postRequest.setEntity(entity);
		CloseableHttpResponse response = null;
		try {
			response = httpClient.execute(postRequest);
			if (HttpStatus.SC_OK == response.getStatusLine().getStatusCode()) {
				return EntityUtils.toString(response.getEntity());
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (response != null) {
				try {
					response.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (httpClient != null) {
				try {
					httpClient.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}
	
	/**
	 * htpp协议处理，如果url不以http://或https://开头，
	 * <p>则默认使用http://
	 *
	 * @param url
	 * @return
	 */
	public static final String setProtocol(String url) {
		if (!url.startsWith("http://") && 
				!url.startsWith("https://")) {
			url = url + "http://";
		}
		return url;
	}
	
}
