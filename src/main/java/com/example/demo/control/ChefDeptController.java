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

import com.example.demo.dao.DemandeRepository;
import com.example.demo.dao.EnseignantRepository;
import com.example.demo.entities.ChefDept;
import com.example.demo.entities.Demande;
import com.example.demo.entities.Enseignant;
import com.example.demo.entities.EtatDemande;

@Controller
@RequestMapping(value="/ChefDept")
public class ChefDeptController {
	HttpSession session;
	@Autowired
	private EnseignantRepository enseignantRepository;
	@Autowired
	private DemandeRepository demandeRepository;
	@RequestMapping(value="/Index")
	public String Index(Model model,
			@RequestParam(name="IdD",defaultValue="0")Integer id,
			@RequestParam(name="EtatD",defaultValue="")String etatD,HttpServletRequest request, 
	         HttpServletResponse response)
	{  session = request.getSession();
	   List<EtatDemande> EtatD= Arrays.asList(EtatDemande.values());
	   List<Enseignant> Demandeur=enseignantRepository.findAll();
	   ChefDept E = ChefDept.getInstance();
	   if(id!=0)
	   {
	   Demande De = demandeRepository.findByIdDemande(id);
	   De.setEtat(EtatDemande.valueOf(etatD));
	   demandeRepository.save(De);
	   }
	   List <Demande> D=  demandeRepository.findAll();
	   model.addAttribute("demandes",D.stream().filter(a->a.getClass().getName().contains("DemandeS")).collect(Collectors.toList()));
	   model.addAttribute("demandem",D.stream().filter(a->a.getClass().getName().contains("DemandeM")).collect(Collectors.toList()));
	   model.addAttribute("EtatD", EtatD);
	   model.addAttribute("Demandeur", Demandeur);
	   model.addAttribute("E",E);
	   return "ChefDept";
	}
	@RequestMapping(value="/Chercher",method=RequestMethod.GET)
	public String chercher(Model model,
			@RequestParam(name="MotCle",defaultValue="")String motcle,
			@RequestParam(name="etat",defaultValue="")EtatDemande etatD,
			@RequestParam(name="type",defaultValue="")String typeD,
			@RequestParam(name="demandeur",defaultValue="")Integer demandeur,
			HttpServletRequest request, 
	         HttpServletResponse response)
	{   session = request.getSession();
	   //Enseignant E = enseignantRepository.getOne(1);
		List<EtatDemande> EtatD= Arrays.asList(EtatDemande.values());
		List<Enseignant> Demandeur=enseignantRepository.findAll();
		ChefDept E=ChefDept.getInstance();
	   E.setEnsembleDemande((List<Demande>)demandeRepository.findAll());
	   //Enseignant De = enseignantRepository.findByIdEnseignant(demandeur);
	   List <Demande> D = E.RechercheMulAll(motcle, null, null,etatD,typeD,demandeur);
	   model.addAttribute("demandes",D.stream().filter(a->a.getClass().getName().contains("DemandeS")).collect(Collectors.toList()));
	   model.addAttribute("demandem",D.stream().filter(a->a.getClass().getName().contains("DemandeM")).collect(Collectors.toList()));
	   model.addAttribute("EtatD", EtatD);
	   model.addAttribute("Demandeur", Demandeur);
	   model.addAttribute("E",E);
	   return "ChefDept";
	}

}
