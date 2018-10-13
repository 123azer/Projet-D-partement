package com.example.demo;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.example.demo.dao.ArticleRepository;
import com.example.demo.dao.CatArticleRepositroy;
import com.example.demo.dao.DemandeRepository;
import com.example.demo.dao.EnseignantRepository;
import com.example.demo.dao.ServiceRepository;
import com.example.demo.dao.TypeServiceRepository;
import com.example.demo.entities.Article;
import com.example.demo.entities.CatArticle;
import com.example.demo.entities.ChefDept;
import com.example.demo.entities.DemandeM;
import com.example.demo.entities.DemandeS;
//import com.example.demo.entities.Demande;
import com.example.demo.entities.Enseignant;
import com.example.demo.entities.EtatCat;
//import com.example.demo.entities.EtatDemande;
import com.example.demo.entities.EtatDemande;
import com.example.demo.entities.EtatP;
import com.example.demo.entities.TypeService;
import com.example.demo.entities.typeArticle;

@SpringBootApplication
public class ProjApplication {

	public static void main(String[] args) {
   ApplicationContext ctx =SpringApplication.run(ProjApplication.class, args);	
   EnseignantRepository enseignentRepository = ctx.getBean(EnseignantRepository.class);
   Enseignant e=new Enseignant("BAH","slimane","122BBB");
   Enseignant e1=new Enseignant("RETBI","asmae","122RRR");
   Enseignant admin=new Enseignant("admin","admin","122Admin");
   ChefDept e2=ChefDept.getInstance();
   e.setLogin("Bah");
   e1.setLogin("Retbi");
   e2.setLogin("Belouadha");
   e.setPwd("Bah");
   e1.setPwd("Retbi");
   e2.setPwd("Belouadha");
   admin.setLogin("admin");
   admin.setPwd("admin");
   enseignentRepository.save(e);
   enseignentRepository.save(e1);
   enseignentRepository.save(e2);
   enseignentRepository.save(admin);
   DemandeRepository demandeRepository = ctx.getBean(DemandeRepository.class);
   DemandeS ds1= e.addDemandeS("Demande de Service","c'est urgent");
   DemandeM dm1= e.addDemandeM("Demande de Materiel","pour la semaine prochaine");
   DemandeS ds2= e.addDemandeS("Demande de Service","pour après demain");
   //DemandeM dm = e.addDemandeM("DemandeMat","m");
   ds2.setEtat(EtatDemande.validee);
   dm1.setEtat(EtatDemande.validee);
   DemandeS ds3= e1.addDemandeS("Demande de Service","com4");
   DemandeS ds4= e2.addDemandeS("Demande de Service","comChefDept");
   demandeRepository.save(ds1);
   demandeRepository.save(ds2);
   demandeRepository.save(ds3);
   demandeRepository.save(ds4);
   demandeRepository.save(dm1);
   //demandeRepository.save(dm);
   TypeServiceRepository typeserviceRepository = ctx.getBean(TypeServiceRepository.class);
   TypeService type1=new TypeService("Plomberie");
   TypeService type2=new TypeService("Menuiserie");
   typeserviceRepository.save(type1);
   typeserviceRepository.save(type2);
   ServiceRepository serviceRepository = ctx.getBean(ServiceRepository.class);
   serviceRepository.save(ds1.add(type1,"service urgent"));
   serviceRepository.save(ds1.add(type1,"pour demain"));
   serviceRepository.save(ds1.add(type2,"pour la semaine prochaine"));
   serviceRepository.save(ds2.add(type1,"pour après demains"));
   serviceRepository.save(ds4.add(type2,"service de ChefDept"));
   serviceRepository.save(ds2.add(type1,"c'est urgent"));
   serviceRepository.save(ds3.add(type2,"pour demain"));
   CatArticleRepositroy catarticleRepository = ctx.getBean(CatArticleRepositroy.class);
   CatArticle CAT1=new CatArticle();
   CAT1.setLabel("Fournitures de bureau");
   CAT1.setmEtatCat(EtatCat.Validated);
   CatArticle CAT2=new CatArticle();
   CAT2.setLabel("Materiel electrique");
   CAT2.setmEtatCat(EtatCat.Validated);
   catarticleRepository.save(CAT1);
   catarticleRepository.save(CAT2);
   ArticleRepository articleRepository = ctx.getBean(ArticleRepository.class);
   articleRepository.save(dm1.add(CAT1,"Table",EtatP.Validated,5,"Pour quatre personnes"));
   
 //**** Category Article ***//
   CatArticleRepositroy mCatArticleRepositroy = ctx.getBean(CatArticleRepositroy.class);
   
   CatArticle catArticl1 = new CatArticle("Materiel informatique", EtatCat.Validated);
   
   mCatArticleRepositroy.save(catArticl1);
   
   //**** Type Articles ***//
   ArticleRepository mArticleRepository = ctx.getBean(ArticleRepository.class);
   Article A= dm1.add(catArticl1,"Stylo",EtatP.Validated,5,"C'est urgent");
   mArticleRepository.save(A);
	}
}
