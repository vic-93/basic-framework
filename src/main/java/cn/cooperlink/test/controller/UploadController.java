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

import cn.cooperlink.util.FileUtil;
/**
 * 
 * @ClassName UploadController
 * @Description 文件上传
 * @author andy.hu
 * @Date 2015年12月8日
 */
@Controller
@RequestMapping(value="UploadController" , method={RequestMethod.GET, RequestMethod.POST})
public class UploadController {

	@RequestMapping("/go")
	public String go(){
		return "/load";
	}
	
	@RequestMapping("/upload")
	public String fileUpload(@RequestParam("file") CommonsMultipartFile[] files,HttpServletRequest request){
		for (int i = 0; i < files.length; i++) {
			int pre = (int) System.currentTimeMillis();
			try {
				FileOutputStream out = new FileOutputStream(FileUtil.getRelPath()+"../views/file/"+new Date().getTime() + files[i].getOriginalFilename());
				FileInputStream in = (FileInputStream) files[i].getInputStream();
				int b = 0;
				while ((b = in.read()) != -1) {
					out.write(b);
				}
				out.flush();
				out.close();
				in.close();
				int pre2 = (int) System.currentTimeMillis();
				System.out.println("time = "+ (pre2 - pre));
			} catch (Exception e) {
				System.out.println("上传出错！");
				e.printStackTrace();
			}
			
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
