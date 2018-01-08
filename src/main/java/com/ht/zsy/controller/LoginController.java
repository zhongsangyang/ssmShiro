package com.ht.zsy.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ht.zsy.exception.CustomException;
import com.ht.zsy.service.Impl.PasswordHelper;

@Controller
@RequestMapping("/login")
public class LoginController {
	@RequestMapping(value = "/login",method = RequestMethod.POST)  
	public String login(HttpServletRequest request, Model model){  
	       CustomException customException=null;  
	       String username=request.getParameter("username");  
	       String password=request.getParameter("password");
	       System.out.println(username+">>>>>"+password);
	       
	       if((username!=null && password!=null)){  
	           UsernamePasswordToken token=new UsernamePasswordToken(username,password);  
	           Subject subject= SecurityUtils.getSubject();  
	           try{  
	               subject.login(token);  
	           }catch (AuthenticationException e){  
	               customException=new CustomException(e.getMessage());  
	               System.out.println(customException.getMessage());
	           }  
	           if( subject.isAuthenticated()){  
	               subject.logout();  
	               System.out.println("认证成功");  
	               model.addAttribute("username",username);  
	               return "/success";  
	           }else {  
	               model.addAttribute("exception",customException.getMessage());  
	               return "/refuse";  
	           }  
	       }  
	       return "success";  
	   }  
	@RequestMapping("/test")
	public String teString(){
		System.out.println("我已经进来了");
		return "success";
	}
}
