package com.example.demo.control;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.ArticleRepository;
import com.example.demo.dao.DemandeRepository;
import com.example.demo.dao.EnseignantRepository;
import com.example.demo.dao.ServiceRepository;
import com.example.demo.dao.TypeServiceRepository;
import com.example.demo.entities.Article;
import com.example.demo.entities.CatArticle;
import com.example.demo.entities.DataForm;
import com.example.demo.entities.DemandeM;
import com.example.demo.entities.DemandeS;
import com.example.demo.entities.Enseignant;
import com.example.demo.entities.EtatCat;
import com.example.demo.entities.EtatP;
import com.example.demo.entities.EtatService;
import com.example.demo.entities.Service;
import com.example.demo.entities.TypeService;
import com.fasterxml.jackson.annotation.JsonView;
@Controller
@RequestMapping(value="/NDS")
public class AddServiceController {
	@Autowired
	private EnseignantRepository enseignantRepository;
	@Autowired
	private DemandeRepository demandeRepository;
	@Autowired
	private ServiceRepository serviceRepository;
	@Autowired
	private TypeServiceRepository typeServiceRepsitory;
	@Autowired
	private ServiceRepository serviceRepsitory;
	
	@RequestMapping(value="/Index")
	public String Index(Model model)
	{
		List <TypeService> mListe= typeServiceRepsitory.findAll().stream().distinct().collect(Collectors.toList());
		model.addAttribute("typeService",mListe.stream().collect(Collectors.toList()));
		return "AddService";
	}
	
	@RequestMapping(value="/AddS",method=RequestMethod.POST)
	public ModelAndView Add(Model model,
			@RequestParam(name="typeser",defaultValue="")String typeser,
			@RequestParam(name="comment",defaultValue="")String comm,
			HttpServletRequest request, 
	        HttpSession session)
	{
		session=request.getSession();
		DemandeS ds =(DemandeS) session.getAttribute("demande");
		//System.out.println("===>"+categorie+"  "+article+"  "+qte+"  "+categorie.matches("\\d+"));
		Enseignant E1=(Enseignant) request.getSession().getAttribute("Enseignant");
		Enseignant E =enseignantRepository.findByIdEnseignant(E1.getIdEnseignant());
		if(ds==null)
		{
			ds = E.addDemandeS("Demande de Service",comm);
			session.setAttribute("demande", ds);
		}
		TypeService typeservice=new TypeService(typeser);
		typeServiceRepsitory.save(typeservice);
			Service S=ds.add(typeservice,comm);
			serviceRepsitory.save(S);
			demandeRepository.save(ds);
		/*List<Service> mServices = dataForm.getFormData();
		if(mServices!=null) {
			Enseignant E = enseignantRepository.getOne(1); // Amodifier
			DemandeS ds = E.addDemandeS("DemandeS","");
			for(Service mData:mServices) {				
				TypeService obj = typeService.getItemByIdTypeService(mData.getTypeService().getIdTypeService());
				ds.add(new Service(obj,EtatService.nonEffectue,ds, mData.getCommentaire()));
			}		
			demandeRepository.save(ds);
		}*/
		//return "redirect:/NDS/Index";
			/*List <TypeService> mListe= typeServiceRepsitory.findAll().stream().distinct().collect(Collectors.toList());
			model.addAttribute("typeService",mListe.stream().collect(Collectors.toList()));*/
			return new ModelAndView("redirect:/NDS/Index");
	}
	
	@RequestMapping(value="/typeServicesAjax" ,method=RequestMethod.GET)
	public @ResponseBody List <TypeService> GetTypeServices()
	{
		List <TypeService> mListes= typeServiceRepsitory.findAll();
		return mListes;
	}

}
