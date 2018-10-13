package com.example.demo.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.EnseignantRepository;
import com.example.demo.entities.ChefDept;
import com.example.demo.entities.Enseignant;



@Controller
@RequestMapping(value="/Login")
public class LoginController {
	@Autowired
	private EnseignantRepository enseignantRepository;
	@RequestMapping(value="/Index")
	public String Index(Model model,HttpServletRequest request,
	         HttpServletResponse response,
	         HttpSession session)
	
	{
		session = request.getSession(); // create session
		Enseignant E= (Enseignant) session.getAttribute("Enseignant");
		if(E!=null)
		{
			session.setAttribute("demande", null);
			if(E.getLogin().contains(ChefDept.getInstance().getLogin()) && E.getPwd().contains(ChefDept.getInstance().getPwd()))
				return "redirect:/ChefDept/Index";
			else
				return "redirect:/Enseignant/Index";	
		}
		else
		 return "index";	
	}
	
	@RequestMapping(value="/Connect",method=RequestMethod.POST)
	public String Index(Model model,
			@RequestParam(name="Login",defaultValue="7")String Login,
			@RequestParam(name="Password",defaultValue="7")String Password,
	         HttpServletRequest request,
	         HttpServletResponse response,
	         HttpSession session)
	{
		
		
		Enseignant E=enseignantRepository.checherEnseignant(Login, Password);
		//HttpSession session=request.getSession(true);
		if (E!=null)
		{
			if(E.getLogin().contains(ChefDept.getInstance().getLogin()) && E.getPwd().contains(ChefDept.getInstance().getPwd()))
				{
				session.setAttribute("Enseignant", E);
				return "redirect:/ChefDept/Index";
				}
			else
			{   if(E.getLogin().equals("admin") && E.getPwd().equals("admin"))
				return "redirect:/Admin/ListE";
			
				request.getSession().setAttribute("Enseignant",E);
				/*try {
					request.getRequestDispatcher("/Enseignant/Index").forward(request, response);
				} catch (ServletException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/
				//try {
					//response.sendRedirect("/Enseignant/Index");
				//} catch (IOException e) {
					// TODO Auto-generated catch block
				//	e.printStackTrace();
				//}
				 return "redirect:/Enseignant/Index";
				
			}
	     }
		else
			return "index";
		
				
		}
	}
			
