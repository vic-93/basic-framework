/* **************************************************************
 *
 * 文件名称：UUID.java
 *
 * 包含类名：cn.cooperlink.framework.core.util.UUID
 * 创建日期：2014年2月24日
 * 创建作者：潘云峰
 * 版权声明：Copyright 2014 北京酷博灵科信息科技有限公司 保留所有权利。
 *
 * **************************************************************/
package cn.cooperlink.framework.core.util;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.security.SecureRandom;

/**
 * UUID类。
 * <p>getUUID() 方法 使用了java自带的UUID生成工具生成UUID。</p>
 * <p>create() 完全拷贝了seasar2框架的生成算法代码。</p>
 * 
 * 创建日期：2014年2月24日
 * 创建作者：潘云峰
 */
public class UUID {

	/**
	 * 获得32位UUID。
	 * 通过jdk 的UUID工具类生成uuid。
	 * 
	 * @return
	 */
	public static String getUUID() {
		return java.util.UUID.randomUUID()
				.toString().replace("-", "");
	}
	
    private static final byte[] DEFAULT_ADDRESS = new byte[] { (byte) 127,
            (byte) 0, (byte) 0, (byte) 1 };

    private static SecureRandom _random = new SecureRandom();

    private static String _base = toHex(getAddress())
            + toHex(System.identityHashCode(_random));
 
    /**
     * UUIDを作成します。
     * 
     * @return
     */
    public static String create() {
        StringBuffer buf = new StringBuffer(_base.length() * 2);
        buf.append(_base);
        int lowTime = (int) System.currentTimeMillis() >> 32;
        appendHex(buf, lowTime);
        appendHex(buf, _random.nextInt());
        return buf.toString();
    }
    
    /**
     * 16進数の文字列に変換します。
     * 
     * @param bytes
     *            バイトの配列
     * @return 16進数の文字列
     */
    public static String toHex(final byte[] bytes) {
        if (bytes == null) {
            return "";
        }
        StringBuffer sb = new StringBuffer(bytes.length * 2);
        for (int i = 0; i < bytes.length; ++i) {
            appendHex(sb, bytes[i]);
        }
        return sb.toString();
    }    
    
    /**
     * 16進数の文字列に変換します。
     * 
     * @param i
     *            int
     * @return 16進数の文字列
     */
    public static String toHex(final int i) {
        StringBuffer buf = new StringBuffer();
        appendHex(buf, i);
        return buf.toString();
    }
    
    /**
     * 文字列に、数値を16進数に変換した文字列を追加します。
     * 
     * @param buf
     *            追加先の文字列
     * @param i
     *            数値
     */
    public static void appendHex(final StringBuffer buf, final byte i) {
        buf.append(Character.forDigit((i & 0xf0) >> 4, 16));
        buf.append(Character.forDigit((i & 0x0f), 16));
    }

    private static byte[] getAddress() {
        try {
            return InetAddress.getLocalHost().getAddress();
        } catch (UnknownHostException ignore) {
            return DEFAULT_ADDRESS;
        }
    }
    
    /**
     * 文字列に、数値を16進数に変換した文字列を追加します。
     * 
     * @param buf
     *            追加先の文字列
     * @param i
     *            数値
     */
    public static void appendHex(final StringBuffer buf, final int i) {
        buf.append(Integer.toHexString((i >> 24) & 0xff));
        buf.append(Integer.toHexString((i >> 16) & 0xff));
        buf.append(Integer.toHexString((i >> 8) & 0xff));
        buf.append(Integer.toHexString(i & 0xff));
    }
    
}
