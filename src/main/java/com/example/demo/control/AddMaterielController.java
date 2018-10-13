package com.example.demo.control;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.ProjApplication;
import com.example.demo.dao.ArticleRepository;
import com.example.demo.dao.CatArticleRepositroy;
import com.example.demo.dao.DemandeRepository;
import com.example.demo.dao.EnseignantRepository;
import com.example.demo.entities.Article;
import com.example.demo.entities.CatArticle;
import com.example.demo.entities.DemandeM;
import com.example.demo.entities.Enseignant;
import com.example.demo.entities.EtatCat;
import com.example.demo.entities.EtatM;
import com.example.demo.entities.EtatP;
import com.example.demo.entities.TypeService;

@Controller
@RequestMapping(value="/NDM")
public class AddMaterielController {
	@Autowired
	private EnseignantRepository enseignantRepository;
	@Autowired
	private DemandeRepository demandeRepository;
	
	@Autowired
	private ArticleRepository articleRepository;
	
	@Autowired
	private CatArticleRepositroy catArticleRepositroy;
	
	@RequestMapping(value="/Index")
	public String Index(Model model)
	{
		List <CatArticle> mListes= catArticleRepositroy.getItemBymEtatCat(EtatCat.Validated);
		model.addAttribute("catArticles",mListes.stream().collect(Collectors.toList()));
		List <Article> mListe= articleRepository.findAll();
		model.addAttribute("Articles",mListe.stream().collect(Collectors.toList()));
		return "AddMateriel";
	}
	
	@RequestMapping(value="/AddM",method=RequestMethod.GET)
	public ModelAndView Add(Model model,
			@RequestParam(name="categorie",defaultValue="")String categorie,
			@RequestParam(name="article",defaultValue="")String article,
			@RequestParam(name="qte",defaultValue="")int qte,
			@RequestParam(name="comment",defaultValue="")String comm,
			HttpServletRequest request, 
	        HttpSession session)
	{   session=request.getSession();
		DemandeM dm =(DemandeM) session.getAttribute("demande");
		//System.out.println("===>"+categorie+"  "+article+"  "+qte+"  "+categorie.matches("\\d+"));
		Enseignant E1=(Enseignant) request.getSession().getAttribute("Enseignant");
		Enseignant E =enseignantRepository.findByIdEnseignant(E1.getIdEnseignant());
		if(dm==null)
		{	
			dm = E.addDemandeM("Demande de Materiel",comm);
			session.setAttribute("demande", dm);	
		}
		//demandeRepository.save(dm);
		//if(!categorie.matches("\\d+")) {
			//CatArticle mCatArticle  = catArticleRepositroy.findByNom(categorie).get(0);
			CatArticle mCatArticle  = new CatArticle(categorie, EtatCat.NotValidated);
			catArticleRepositroy.save(mCatArticle);
			Article A=dm.add(mCatArticle,article,EtatP.NotValidated,qte,comm);
			articleRepository.saveAndFlush(A);
			demandeRepository.saveAndFlush(dm);
			//articleRepository.save(mArticle);			
		//}
		
		
		return new ModelAndView("redirect:/NDM/Index");
	}
	
	
	@RequestMapping(value="/typeArticleAjax" ,method=RequestMethod.POST)
	public @ResponseBody List <Article> GetTypeArticle(@RequestParam(name="id_cat",defaultValue="")int id)
	{
		List <Article> mListes= articleRepository.findArticleBytCat(id);
		return mListes;
	}
}