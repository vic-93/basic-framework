package cn.cooperlink.test.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import cn.cooperlink.framework.core.util.UploadHandler;
import cn.cooperlink.util.FileUtil;

@Controller
@RequestMapping(value="UploadController2" ,method={RequestMethod.POST,RequestMethod.GET})
public class UploadController2 {

	@RequestMapping("/go")
	public String go(){
		return "/load";
	}
	
	@RequestMapping("/upload")
	public String fileUpload(@RequestParam("file") MultipartFile[] files,HttpServletRequest request){
		String[] a = UploadHandler.upload(files, FileUtil.getRelPath()+"../views/file/");
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
		return "/success";
	}
	
	@RequestMapping("/upload2")
	public String fileUpload2(HttpServletRequest request,HttpServletResponse response){
		//创建一个通用的多部分解析器
		CommonsMultipartResolver cmr = new CommonsMultipartResolver(request.getSession().getServletContext());
		//判断是否有文件上传
		if (cmr.isMultipart(request)) {
			MultipartHttpServletRequest mhsr = (MultipartHttpServletRequest) request;
			//取得request中的所有文件名
			Iterator<String> iterator = mhsr.getFileNames();
			while (iterator.hasNext()) {
				int pre = (int) System.currentTimeMillis();
				MultipartFile file = mhsr.getFile(iterator.next());
				if (null != file) {
					String fileName = file.getOriginalFilename();
					if ("" !=fileName.trim() && !"".equals(fileName.trim())) {
						String myFileName = "demoUpload"+ new Date().getTime() + file.getOriginalFilename();
						String relPath = FileUtil.getRelPath() + "../views/file/" + myFileName;
						File localFile = new File(relPath);
						try {
							file.transferTo(localFile);
						}catch (Exception e) {
							System.out.println("上传失败！");
							e.printStackTrace();
						}
					}
				}
			}
		}
		return "/success";
	}
	
}
