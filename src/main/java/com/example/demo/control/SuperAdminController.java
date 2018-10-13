package com.example.demo.control;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.experimental.categories.Categories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.ArticleRepository;
import com.example.demo.dao.CatArticleRepositroy;
import com.example.demo.dao.DemandeRepository;
import com.example.demo.dao.EnseignantRepository;
import com.example.demo.dao.ServiceRepository;
import com.example.demo.dao.TypeServiceRepository;
import com.example.demo.entities.Article;
import com.example.demo.entities.CatArticle;
import com.example.demo.entities.Demande;
import com.example.demo.entities.DemandeS;
import com.example.demo.entities.Enseignant;
import com.example.demo.entities.EtatCat;
import com.example.demo.entities.EtatDemande;
import com.example.demo.entities.EtatP;
import com.example.demo.entities.EtatService;
import com.example.demo.entities.Service;

@Controller
@RequestMapping(value="/Admin")
public class SuperAdminController {
	@Autowired
	private EnseignantRepository enseignantRepository;
	@Autowired
	private DemandeRepository demandeRepository;
	@Autowired
	private ServiceRepository serviceRepository;
	@Autowired
	private TypeServiceRepository typeService;
	@Autowired
	private ArticleRepository articleRepository;
	@Autowired
	private CatArticleRepositroy catArticleRepositroy;
	
	
	@RequestMapping(value="/Index")
	public String Index(Model model)
	{
		//Liste des catégories non validées
	   List<CatArticle> cat = catArticleRepositroy.getItemBymEtatCat(EtatCat.NotValidated);
	   //Liste des articles non validées 
	   List<Article> articles = articleRepository.getItemBymEtatP(EtatP.NotValidated);
	   //Liste des services non validées 
	   List<Service> services = serviceRepository.getItemByEtatS(EtatService.nonEffectue);
	 //Liste des enseignants
	   List<Enseignant> mListes= enseignantRepository.findAll(); 
	   
	   model.addAttribute("enseignants",mListes.stream().collect(Collectors.toList()));
	 
	   model.addAttribute("listCat",cat.stream().collect(Collectors.toList()));
	   model.addAttribute("listArticle",articles.stream().collect(Collectors.toList()));
	   model.addAttribute("listServices",services.stream().collect(Collectors.toList()));
		   
	   return "AdminList";
	}
	
	@RequestMapping(value="/ListE")
	public String ListE(Model model)
	{
		 List<Enseignant> mListes= enseignantRepository.findAll(); 
		   model.addAttribute("enseignants",mListes.stream().collect(Collectors.toList()));

	   return "AdminListE";
	}
	
	@RequestMapping(value="/validers")
	public String ValiderService(@RequestParam(name="idService",defaultValue="")int idService)
	{
	   Service  mService= serviceRepository.findByIdService(idService);
	   if(mService!=null) {
		   mService.setEtatS(EtatService.Effectue);
		   serviceRepository.save(mService);
	   }
	   return "AdminList";
	}
	@RequestMapping(value="/AddEE",method=RequestMethod.POST)
	public String Add(Model model,
			@RequestParam(name="ref",defaultValue="")String ref,
			@RequestParam(name="login",defaultValue="")String login,
			@RequestParam(name="nom",defaultValue="")String nom,
	        @RequestParam(name="prenom",defaultValue="")String prenom,
            @RequestParam(name="pwd",defaultValue="")String pwd)
	{
		System.out.println("Debug"+prenom+" "+nom);
		enseignantRepository.save(new Enseignant(nom, prenom, login, pwd, ref ));
		List<Enseignant> mListes= enseignantRepository.findAll(); 
		  model.addAttribute("enseignants",mListes.stream().collect(Collectors.toList()));
		return "AdminListE";
	}
	
	@RequestMapping(value="/AddE")
	public String AddEnseignant(Model model)
	{
	   return "AddEnseignant";
	}
	
	
	@RequestMapping(value="/validera")
	public ModelAndView ValiderArticle(@RequestParam(name="idArticle",defaultValue="")int idArticle)
	{
		Article  mArticle= articleRepository.getItemByIdArticle(idArticle);
		   if(mArticle!=null) {
			   mArticle.setmEtatP(EtatP.Validated);
			   articleRepository.save(mArticle);
		   }
		return new ModelAndView("redirect:/Admin/Index");
	}
	@RequestMapping(value="/validerc")
	public ModelAndView ValiderCategorie(@RequestParam(name="idCategorie",defaultValue="")int idCategorie)
	{
		CatArticle  mCatArticle= catArticleRepositroy.getItemByIdCatArticle(idCategorie);
		   if(mCatArticle!=null) {
			   mCatArticle.setmEtatCat(EtatCat.Validated);
			   catArticleRepositroy.save(mCatArticle);
		   }
		return new ModelAndView("redirect:/Admin/Index");
	}
	
}