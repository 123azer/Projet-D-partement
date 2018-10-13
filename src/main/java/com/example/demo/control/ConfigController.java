package com.example.demo.control;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.dao.ArticleRepository;
import com.example.demo.dao.DemandeRepository;
import com.example.demo.dao.EnseignantRepository;
import com.example.demo.dao.ServiceRepository;
import com.example.demo.dao.TypeServiceRepository;
import com.example.demo.entities.CatArticle;
import com.example.demo.entities.DataForm;
import com.example.demo.entities.DemandeM;
import com.example.demo.entities.DemandeS;
import com.example.demo.entities.Enseignant;
import com.example.demo.entities.EtatService;
import com.example.demo.entities.Service;
import com.example.demo.entities.TypeService;
import com.fasterxml.jackson.annotation.JsonView;
@Controller
@RequestMapping(value="/Config")
public class ConfigController {
	@Autowired
	private EnseignantRepository enseignantRepository;
	@Autowired
	private DemandeRepository demandeRepository;
	@Autowired
	private ServiceRepository serviceRepository;
	@Autowired
	private TypeServiceRepository typeService;
	
	@RequestMapping(value="/Index")
	public String Index(Model model)
	{
		return "Configuration";
	}
	
	/*@RequestMapping(value="/AddS",method=RequestMethod.POST)
	public String Add(@ModelAttribute DataForm dataForm)
	{
		List<Service> mServices = dataForm.getFormData();
		if(mServices!=null) {
			Enseignant E = enseignantRepository.getOne(1); // Amodifier
			DemandeS ds = E.addDemandeS("DemandeS","");
			for(Service mData:mServices) {				
				TypeService obj = typeService.getItemByIdTypeService(mData.getTypeService().getIdTypeService());
				ds.add(new Service(obj,EtatService.nonEffectue,ds, mData.getCommentaire()));
			}		
			demandeRepository.save(ds);
		}
		return "AddService";
	}
	
	@RequestMapping(value="/typeServicesAjax" ,method=RequestMethod.GET)
	public @ResponseBody List <TypeService> GetTypeServices()
	{
		List <TypeService> mListes= typeService.findAll();
		return mListes;
	}
*/
}
