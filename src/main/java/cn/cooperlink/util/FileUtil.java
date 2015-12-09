package cn.cooperlink.util;

import java.io.File;


public class FileUtil {

	public static String getRelPath(){
		String templatePath = FileUtil.class.getClassLoader().getResource("/").getPath();
		String rootPath = "";
		//windows下
		if("\\".equals(File.separator)){
			rootPath = templatePath.replace("/", "\\");
		}
		
		//linux下
		if("/".equals(File.separator)){
			rootPath = templatePath.replace("\\", "/");
		}
		
		System.out.println("测试路径："+rootPath);
		return rootPath;
	}
	
}
