package com.example.demo.control;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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

import com.example.demo.dao.DemandeRepository;
import com.example.demo.dao.EnseignantRepository;
import com.example.demo.entities.Demande;
import com.example.demo.entities.Enseignant;
import com.example.demo.entities.EtatDemande;

@Controller
@RequestMapping(value="/Enseignant")
public class EnseignantConroller {
	@Autowired
	private EnseignantRepository enseignantRepository;
	@Autowired
	private DemandeRepository demandeRepository;
	@RequestMapping(value="/Index")
	public String Index(Model model,
			 HttpServletRequest request, 
	         HttpSession session)
	{    //session = request.getSession(true);
		//HttpSession session=request.getSession(true);
	   List<EtatDemande> EtatD= Arrays.asList(EtatDemande.values());
	   List<Enseignant> Demandeur=enseignantRepository.findAll();
	   //Enseignant E = (Enseignant)session.getAttribute("Enseignant");
	   Enseignant E = (Enseignant) request.getSession().getAttribute("Enseignant");
	   List <Demande> D=demandeRepository.findByEnseigant(E.getIdEnseignant());
	   model.addAttribute("demandes",D.stream().filter(a->a.getClass().getName().contains("DemandeS")).collect(Collectors.toList()));
	   model.addAttribute("demandem",D.stream().filter(a->a.getClass().getName().contains("DemandeM")).collect(Collectors.toList()));
	   model.addAttribute("EtatD", EtatD);
	   model.addAttribute("Demandeur", Demandeur);
	   model.addAttribute("E",E);
	   return "Enseignant";
	}
	@RequestMapping(value="/Chercher",method=RequestMethod.GET)
	public String chercher(Model model,
			@RequestParam(name="MotCle",defaultValue="")String motcle,
			@RequestParam(name="etat",defaultValue="")EtatDemande etatD,
			@RequestParam(name="type",defaultValue="")String typeD,
			@RequestParam(name="demandeur",defaultValue="")String nomdemandeur,
			HttpServletRequest request, 
	        HttpSession session)
	{
		
		//HttpSession session=request.getSession(true);
		Enseignant E = (Enseignant) request.getSession().getAttribute("Enseignant");
		List<EtatDemande> EtatD= Arrays.asList(EtatDemande.values());
		List<Enseignant> Demandeur=enseignantRepository.findAll();
		//Enseignant E = (Enseignant)session.getAttribute("Enseignant");
	   Enseignant demandeur=enseignantRepository.findByNom(nomdemandeur);
	   List <Demande> Denseingnant=demandeRepository.findByEnseigant(E.getIdEnseignant());
	   E.setDemandes(Denseingnant);
	   List <Demande> D = E.RechercheMul(motcle, null, null,etatD,typeD);
	   model.addAttribute("demandes",D.stream().filter(a->a.getClass().getName().contains("DemandeS")).collect(Collectors.toList()));
	   model.addAttribute("demandem",D.stream().filter(a->a.getClass().getName().contains("DemandeM")).collect(Collectors.toList()));
	   model.addAttribute("EtatD",EtatD);
	   model.addAttribute("Demandeur", Demandeur);
	   model.addAttribute("E",E);
	   return "Enseignant";
	}
	
	
}