/* **************************************************************
 *
 * 文件名称：Base64.java
 *
 * 包含类名：com.cloudpower.netsale.util.Base64
 * 创建日期：2013年9月3日
 * 创建作者：框架部
 * 版权声明：Copyright 2013 北京酷博灵科信息科技有限公司 保留所有权利。
 *
 * **************************************************************/
package cn.cooperlink.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.InflaterInputStream;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * Base64处理类类。
 * 创建日期：2013年9月3日
 * 创建作者：框架部
 */
public class Base64 {
	
	public static String getStrByBase64(byte[] b)
	  {
	    BASE64Encoder encoder = new BASE64Encoder();
	    String str = encoder.encode(b);
	    return str;
	  }

	  public static byte[] getByteByString(String source)
	  {
	    BASE64Decoder decoder = new BASE64Decoder();
	    byte[] buf = (byte[])null;
	    try {
	    	buf = decoder.decodeBuffer(source);
	    } catch (IOException e) {
	      e.printStackTrace();
	    }
	    return buf;
	  }

	  public static String compressByGZIP(String str)
	    throws IOException
	  {
	    ByteArrayOutputStream out = new ByteArrayOutputStream();
	    DeflaterOutputStream gout = new DeflaterOutputStream(out);
	    gout.write(str.getBytes());
	    gout.finish();
	    gout.close();
	    return getStrByBase64(out.toByteArray());
	  }

	  public static String decompressByGZIP(String str)
	    throws IOException
	  {
	    byte[] buf = getByteByString(str);

	    ByteArrayOutputStream out = new ByteArrayOutputStream();
	    ByteArrayInputStream in = new ByteArrayInputStream(buf);
	    InflaterInputStream gin = new InflaterInputStream(in);
	    int i = 1024;
	    byte[] buffer = new byte[i];
	    while ((i = gin.read(buffer)) > 0) {
	      out.write(buffer, 0, i);
	    }
	    gin.close();
	    out.close();

	    return new String(out.toByteArray(), "UTF-8");
	  }
}
