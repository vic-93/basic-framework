/* **************************************************************
 *
 * 文件名称：StringUtil.java
 *
 * 包含类名：cn.cooperlink.util.StringUtil
 * 创建日期：2013-6-26
 * 创建作者：潘云峰
 * 版权声明：Copyright 2013 北京酷博灵科信息科技有限公司 保留所有权利。
 *
 * **************************************************************/
package cn.cooperlink.util;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Random;

/**
 * 字符串Util类。
 * <p>字符串通用处理</p>
 * 
 * 创建日期：2013-6-27
 * 创建作者：潘云峰
 */
public final class  StringUtil {
	
	/**
	 * 验证为空（不对入参去空格处理，" " 也表示有字符）
	 * 
	 * @param str
	 * @return true 空；false 非空
	 */
	public static final boolean isEmpty(String str) {
		if (str == null || "".equals(str)) {
			return true;
		}
		return false;
	}

	/**
	 * 验证非空（不对入参去空格处理，" " 也表示有字符）
	 * 
	 * @param str
	 * @return true 非空；false 空
	 */
	public static final boolean isNotEmpty(String str) {
		if (str != null && str.length() > 0) {
			return true;
		}
		return false;
	}
	
	/**
	 * 验证为空（会对入参去空格处理）
	 * 
	 * @param str
	 * @return true 空；false 非空
	 */
	public static final boolean isBlank(String str) {
		if (str == null || "".equals(str.trim())) {
			return true;
		}
		return false;
	}
	
	/**
	 * 验证非空（会对入参去空格处理）
	 * 
	 * @param str
	 * @return true 非空；false 空
	 */
	public static final boolean isNotBlank(String str) {
		if (str != null && str.trim().length() > 0) {
			return true;
		}
		return false;
	}
	
	/**
	 * 将年月日合并为给定分隔符的字符串
	 * 例：year=2013，month=1，day=31，toten=/
	 *   合并结果 2013/01/31
	 *   
	 * @param year 年
	 * @param month 月 1-12
	 * @param day 日 1-31
	 * @param token 分割符号
	 * @return 日期字符串
	 */
	public static final String combinateDate2String(int year, 
			int month, int day, String token) {
		String m = (month > 9 ? String.valueOf(month) : "0" + 
				month);
		return year + token + m + token + day; 
	}
	
	/**
	 * null 转  ""
	 *
	 * @param val
	 * @return
	 */
	public static final String null2Empty(Object val) {
		return val == null ? "" : val.toString();
	}
	
	/**
	 * 字符串是否是纯数字
	 * 
	 * @param c
	 * @return true 数字； false 非数字
	 */
	public static final boolean isNumber(String str) {
		if (isBlank(str)) {
			return false;
		}
		char c;
		int len = str.length();
		for (int i = 0; i < len; i++) {
			c = str.charAt(i);
			if (c < '0' || c > '9') {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * 字符串为非纯数字
	 * 
	 * @param c
	 * @return true 非数字； false 数字
	 */
	public static boolean isNotNumber(String str) {
		if (isBlank(str)) {
			return false;
		}
		char c;
		int len = str.length();
		for (int i = 0; i < len; i++) {
			c = str.charAt(i);
			if (c < '0' || c > '9') {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 字符是否是数字
	 * 
	 * @param c
	 * @return true 数字； false 非数字
	 */
	public static boolean isNumber(char c) {
		if (c < '0' || c > '9') {
			return false;
		}
		return true;
	}
	
	/**
	 * 将首字符转换为大写
	 * 
	 * @param str
	 * @return
	 */
	public static final String initcap(String str) {
		if (isBlank(str)) {
			return null;
		}
		return str.substring(0,1).toUpperCase() 
				+ str.substring(1);
	}

	/**
	 * 输出异常的完整信息
	 * 
	 * @param e 异常
	 * @return 异常堆栈信息
	 */
	public static final String getTrace(Throwable e) {
		StringWriter stringWriter = null;
		try {
			stringWriter= new StringWriter();
			PrintWriter writer= new PrintWriter(stringWriter);
			e.printStackTrace(writer);
			StringBuffer buffer= stringWriter.getBuffer();
			return buffer.toString();
		} finally {
			if (stringWriter != null) {
				try {
					stringWriter.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * 分割的字符串数组
	 * 
	 * @Author 张海浪
	 * @param 字符串
	 * @return 分割的字符串数组
	 */
	public static final String[] getAppendString(String target){	
		String[] s=target.split("@");		
		return s;
	}
	
	
	 public static String generateCode() {
	        Random rd = new Random(); // 创建随机对象
	        String n = "";            //保存随机数
	        int rdGet; // 取得随机数
	        do {
	        
	        /*
	            if (rd.nextInt() % 2 == 1) {
	         */
	        	rdGet = Math.abs(rd.nextInt()) % 10 + 48; // 产生48到57的随机数(0-9的键位值)
	         /*
	            } else
	           {
	             rdGet = Math.abs(rd.nextInt()) % 26 + 97; // 产生97到122的随机数(a-z的键位值)
	           }
	           */
	        char num1 = (char) rdGet;            //int转换char
	        String dd = Character.toString(num1);
	        n += dd;
	   } while (n.length() < 8);// 设定长度，此处假定长度小于8
	     
	     return n;
	 }
	 
	 
	 public static String generateEToken() {
	        Random rd = new Random(); // 创建随机对象
	        String n = "";            //保存随机数
	        int rdGet; // 取得随机数
	        do {
	        
	     
	            if (rd.nextInt() % 2 == 1) {
	         
	        	rdGet = Math.abs(rd.nextInt()) % 10 + 48; // 产生48到57的随机数(0-9的键位值)
	         
	            } else
	           {
	             rdGet = Math.abs(rd.nextInt()) % 26 + 97; // 产生97到122的随机数(a-z的键位值)
	           }
	           
	        char num1 = (char) rdGet;            //int转换char
	        String dd = Character.toString(num1);
	        n += dd;
	   } while (n.length() < 20);// 设定长度，此处假定长度小于8
	     
	     return n;
	 }
	 
	 public static void main(String[] args) {
		 for (int i = 0; i < 100; i++) {
			 System.out.println(StringUtil.generateCode());
		}
	  }
	
}
