package com.ssm07.controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.ssm07.entity.Student;
import com.ssm07.service.StuService;

@Controller
public class StuController {
	@Autowired
	private StuService service;
	@RequestMapping("first")
	public String first(int sid,Model m) {
		Student s=service.cha(sid);
		m.addAttribute("s", s);
		return "a1";
	}
	//多文件上传用数组MultipartFile[] ziliao，jsp中type=file的name取名一样为ziliao
	@RequestMapping(value="chuan",method=RequestMethod.POST)
	public String chuan(@RequestParam(value="touxiang",required=false)MultipartFile touxiang,Student stu,HttpServletRequest request) {
//		for (int i = 0; i < ziliao.length; i++) {
//		}
		if (!touxiang.isEmpty()) {
			String fileNameOld=touxiang.getOriginalFilename();
			String prefix=FilenameUtils.getExtension(fileNameOld);
			String path="D:\\eclipse\\EclipseWorkSpace\\SSM_0820\\WebContent\\images";
//			String pathReal=request.getSession().getServletContext().getRealPath("ziyuan"+File.separator+"images");
//			System.out.println(pathReal);
			if (prefix.equalsIgnoreCase("jpg")||prefix.equalsIgnoreCase("png")||prefix.equalsIgnoreCase("jpeg")||prefix.equalsIgnoreCase("pneg")) {
				File target=new File(path,fileNameOld);
				if (!target.exists()) {
					target.mkdirs();
				}
				try {
					touxiang.transferTo(target);
					stu.setPic(fileNameOld);
					service.update(stu);
				} catch (Exception e) {
					System.out.println("上传失败");
					e.printStackTrace();
				}
			} else {
				System.out.println("上传格式不正确");
			}
		} else {
			System.out.println("没传到");
		}
		return "index";
	}
    
}
