/* **************************************************************
 *
 * 文件名称：ObjectUtil.java
 *
 * 包含类名：cn.cooperlink.util.ObjectUtil
 * 创建日期：2014年3月27日
 * 创建作者：潘云峰
 * 版权声明：Copyright 2014 北京酷博灵科信息科技有限公司 保留所有权利。
 *
 * **************************************************************/
package cn.cooperlink.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * 对象序列化、反序列化工具类。
 *
 * 创建日期：2014年3月27日
 * 创建作者：潘云峰
 */
public class ObjectUtil {

	public static final byte[] serialize2ByteArray(Object obj) {
		ByteArrayOutputStream  byteArrayOut = null;
		ObjectOutputStream objectOut = null;
		try {
			byteArrayOut = new ByteArrayOutputStream();
			objectOut = new ObjectOutputStream(byteArrayOut);
			objectOut.writeObject(obj);
			
			return byteArrayOut.toByteArray();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (objectOut != null) {
				try {
					objectOut.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (byteArrayOut != null) {
				try {
					byteArrayOut.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}
	
	public static final Object deserializeFromByteArray(byte[] byteArr) {
		ByteArrayInputStream byteArrayInput = null;
		ObjectInputStream objectInput = null;
		try {
			byteArrayInput = new ByteArrayInputStream(byteArr);
			objectInput = new ObjectInputStream(byteArrayInput);
			return objectInput.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (objectInput != null) {
				try {
					objectInput.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (byteArrayInput != null) {
				try {
					byteArrayInput.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}
}
