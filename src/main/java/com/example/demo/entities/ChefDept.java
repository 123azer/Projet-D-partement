package com.example.demo.entities;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;


@Entity
public class ChefDept extends Enseignant {
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "enseigant")
	List<Demande> ensembleDemande = new ArrayList<Demande>();
	private static ChefDept instance = new ChefDept("belouadha","Fatim_Zahra","ref");
	
	private ChefDept(String nom, String prenom, String refEnseignant) {
		super(nom, prenom, refEnseignant);
	}
	public ChefDept() {
		
	}
	
	public static synchronized ChefDept getInstance() {
		return instance;
	}

	public boolean addDemande(Demande e) {
		ensembleDemande.add(0, e);
		return containsDemande(e);
	}

	public boolean containsDemande(Object o) {
		return ensembleDemande.contains(o);
	}
	
	public void validerDemande(Demande demande)
	{
		demande.setEtat(EtatDemande.validee);
	}
	
	public void refuserDemande(Demande demande)
	{
		demande.setEtat(EtatDemande.refusee);
	}
	
	public boolean removeDemande(Demande d) {
		return ensembleDemande.remove(d);
	}
	
	private List <Demande> getByTypeDemande(String typeDemande)
	{   if (typeDemande!=null)
		 return ensembleDemande.stream().filter(a->a.getClass().getName().contains(typeDemande)).collect(Collectors.toList());
	    else
	     return ensembleDemande;  	
	}
	
	private List<Demande> getEnsembleDemandeByEtat(EtatDemande Etat)
	{
		if (Etat!=null)
		return ensembleDemande
			   .stream()
			   .filter(a->a.getEtat()==Etat)
			   .collect(Collectors.toList());
		else
		return ensembleDemande;
	}
	
	private List<Demande> getEnsembleDemandeByDate(Date date)
	{   
		if(date!=null)
		return ensembleDemande
			   .stream()
			   .filter(a->a.getDate()==date)
			   .collect(Collectors.toList());
		else
		return ensembleDemande;
	}
	
	private List <Demande> getEnsembleDemandebyobjet(String objet)
	{   
		if(objet!=null)
		return ensembleDemande
			   .stream()
			   .filter(a->a.getObjet()==objet)
			   .collect(Collectors.toList());
		else
		return ensembleDemande;
	}
	
	public List <Demande> getEnsembleDemandesM()
	{
		return ensembleDemande
			   .stream().filter(a->a.getClass().getName()=="DemandeM")
			   .collect(Collectors.toList());
	}
	
	public List <Demande> getEnsembleDemandesS()
	{
		return ensembleDemande
			   .stream().filter(a->a.getClass().getName()=="DemandeS")
			   .collect(Collectors.toList());
	}
	
	private List <Demande> getEnsembleDemandeByMotCle(String Motcle)
	{   
		if (Motcle!=null)
		return ensembleDemande
				.stream()
				.filter(a->a.getCommentaire().contains(Motcle) || a.getObjet().contains(Motcle))
				.collect(Collectors.toList());
		else
		return ensembleDemande;
		
	}
	
	private List <Demande> getEnsembleDemandeByDemandeur(Integer enseignant)
	{   
		if(enseignant!=null)
		return ensembleDemande
		.stream()
		.filter(a->a.getEnseigant().getIdEnseignant()==enseignant)
		.collect(Collectors.toList());
		else
		return ensembleDemande;
	}
	
	public List <Demande> RechercheMulAll(String MotCle,String objet,Date date,EtatDemande Etat,String typeDemande,Integer enseignant)
	{
		return getEnsembleDemandeByMotCle(MotCle)
				.stream()
				.filter(getEnsembleDemandebyobjet(objet)::contains)
				.collect(Collectors.toList())
				.stream()
				.filter(getEnsembleDemandeByDate(date)::contains)
				.collect(Collectors.toList())
				.stream()
				.filter(getEnsembleDemandeByEtat(Etat)::contains)
				.collect(Collectors.toList())
				.stream()
				.filter(getEnsembleDemandeByDemandeur(enseignant)::contains)
				.collect(Collectors.toList())
				.stream()
				.filter(getByTypeDemande(typeDemande)::contains)
				.collect(Collectors.toList());
	}
	

	public List<Demande> getEnsembleDemande() {
		return ensembleDemande;
	}

	public void setEnsembleDemande(List<Demande> ensembleDemande) {
		this.ensembleDemande = ensembleDemande;
	}

	@Override
	public String toString() {
		return "ChefDept nom:" + nom + " prenom:" + prenom + "\n  l'ensemble des demandes:\n" + ensembleDemande;
	}

	
	
}
