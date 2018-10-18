package com.javen.controller;

 
import java.io.File;
import java.io.IOException;
import java.util.Map;

import javax.annotation.Resource;
import javax.print.DocFlavor.STRING;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.javen.dao.UserMapper;
import com.javen.model.User;

@Controller
@RequestMapping("/user")
public class UserController {

	private static Logger log = LoggerFactory.getLogger(UserController.class);
	
	
	
	@Resource
	private UserMapper userMapper;
	
	// user/test?id=1
	
	@RequestMapping(value ="/test",method= RequestMethod.GET)
	public String  test(HttpServletRequest request, Model model)
	{
	    int userId = Integer.parseInt(request.getParameter("id"));
	    
	    System.out.println("userid:" + userId);

	    User  user = null;
	    
	    if(userId ==1)
	    {
	    	user = new User();
	    	user.setAge(11);
	    	user.setId(1);
	    	user.setPassword("124");
	    	user.setUserName("javen");
	    	
	    	
	    }
	    
	    log.debug(user.toString());
	    model.addAttribute("user", user);
	    return "user/user";
		
		
	}
	
	
	
	@RequestMapping(value="/showUser", method =RequestMethod.GET)
	public String toIndex(HttpServletRequest request, Model model)
	{
		int userId = Integer.parseInt(request.getParameter("id"));
		
		System.out.println("userid" + userId);
		
		User user = this.userMapper.selectByPrimaryKey(userId);
		
		log.debug(user.toString());
		
		model.addAttribute("user", user);
		
		return "user/showUser";
		
	}
	
	// user/{id}

	@RequestMapping(value="/showUser/{id}", method = RequestMethod.GET)
	@ResponseBody
	
	 public User getUserInJson(@PathVariable String id, Map<String, Object> model)
	{
		int userId = Integer.parseInt(id);
		User user =this.userMapper.selectByPrimaryKey(userId);
		
		 return  user;
		
	}
	
	@RequestMapping(value ="/upload")
	public String showUploadPage()
	{
		return "user_admin/file";
		
	}
	
	@RequestMapping(value="/doUpload", method = RequestMethod.POST)
	public String doUploadFile(@RequestParam("file") MultipartFile file) throws IOException
	
	{
		if(!file.isEmpty())
		{
			log.info("Process file:{}", file.getOriginalFilename());
		}
		
		FileUtils.copyInputStreamToFile(file.getInputStream(), new File("e:\\"+ System.currentTimeMillis()+ file.getOriginalFilename()));
		return "success";
	}
	
	
	
}
