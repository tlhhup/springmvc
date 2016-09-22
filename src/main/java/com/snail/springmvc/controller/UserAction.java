package com.snail.springmvc.controller;

import java.io.File;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.snail.springmvc.entity.User;
import com.snail.springmvc.service.UserService;

@Controller
@RequestMapping("/UserAction")
public class UserAction {
	
	@Resource
	private UserService userService;

	@RequestMapping("/list")
	public String list(Model model){
		model.addAttribute("users", userService.findUsers());
		return "user/list";
	}
	
	@RequestMapping("/delete")
	public String delete(User user){
		userService.deleteUserInfoById(user.getId());
		return "redirect:list";
	}
	
	@RequestMapping("/edit/{id}")
	public String edit(@PathVariable("id") int id,Model model){
		model.addAttribute("user", userService.findUserInfoById(id));
		return "user/edit";
	}
	
	@SuppressWarnings("deprecation")
	@RequestMapping("/save")
	public String save(User user,MultipartFile headPic,HttpServletRequest request){
		if(headPic!=null){
			String filename = headPic.getOriginalFilename();
			//构建文件名
			filename=UUID.randomUUID().toString()+filename.substring(filename.lastIndexOf("."));
			String dirPath = request.getRealPath("/resources/upload");
			File dir=new File(dirPath);
			if(!dir.exists()){
				dir.mkdirs();
			}
			File file=new File(dir,filename);
			try {
				//保存文件
				headPic.transferTo(file);
				user.setPhoto(filename);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		this.userService.saveUserInfo(user);
		return "redirect:list";
	}
	
	@RequestMapping("/jsonData")
	public @ResponseBody List<User> jsonData(){
		return userService.findUsers();
	}
	
}
