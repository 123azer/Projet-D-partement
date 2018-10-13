package com.example.demo.control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/Logout")
public class LogoutController {
	HttpSession session;
	@RequestMapping(value="/Index")
	public String Index(Model model,
			HttpServletRequest request, 
	        HttpServletResponse response)
	{
		session = request.getSession();
		session.invalidate();
		return "redirect:/Login/Index";	
	}
}
