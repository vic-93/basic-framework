/* **************************************************************
 *
 * 文件名称：TransformUtil.java
 *
 * 包含类名：com.cloudpower.util.TransformUtil
 * 创建日期：2013-7-18
 * 创建作者：潘云峰
 * 版权声明：Copyright 2013 北京酷博灵科信息科技有限公司 保留所有权利。
 *
 * **************************************************************/
package cn.cooperlink.util;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

/**
 * xsl 转换类。
 * 将 xml 通过 xsl 进行装换
 * 
 * 创建日期：2013-7-18
 * 创建作者：潘云峰
 */
public class TransformUtil {

	/**
	 * 转换
	 * 
	 * @param reader xml 字符串 reader
	 * @param xslFile    xsl 文件对象
	 * @return
	 */
	public static String transform(StringReader reader, File xslFile) {
		StringWriter writer = null;
        try {
            TransformerFactory tFac = TransformerFactory.newInstance();
            Source xslSource = new StreamSource(xslFile);
            Transformer t = tFac.newTransformer(xslSource);
            Source source =  new StreamSource(reader);
            writer = new StringWriter();
            Result result = new StreamResult(writer);
            t.transform(source, result);
        	writer.flush();
            return writer.getBuffer().toString();
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        } finally {
        	reader.close();
        	if (writer != null) {
            	try {
					writer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
        	}
        }
        return "";
	}

	/**
	 * 转换
	 * 
	 * @param xmlReader xml 字符串 reader
	 * @param xslReader    xsl 字符串 reader
	 * @return
	 */
	public static String transform(StringReader xmlReader, StringReader xslReader) {
		StringWriter writer = null;
        try {
            TransformerFactory tFac = TransformerFactory.newInstance();
            Source xslSource = new StreamSource(xslReader);
            Transformer t = tFac.newTransformer(xslSource);
            Source source =  new StreamSource(xmlReader);
            writer = new StringWriter();
            Result result = new StreamResult(writer);
            t.transform(source, result);
        	writer.flush();
            return writer.getBuffer().toString();
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        } finally {
        	xslReader.close();
        	xmlReader.close();
        	if (writer != null) {
            	try {
					writer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
        	}
        }
        return "";
	}
}
