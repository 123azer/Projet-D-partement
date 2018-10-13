package com.example.demo.entities;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.*;
import javax.validation.constraints.Size;

import java.io.Serializable;
import java.util.Date;
//import java.util.ArrayList;
import java.time.LocalDate;
//import java.util.stream.Stream;

@Entity
public class Enseignant implements Serializable  {
	@Id
	@GeneratedValue
	protected Integer idEnseignant;
	@Size(max = 45)
	protected String nom;
	@Size(max = 45)
	protected String prenom;
	protected String login;
	protected String pwd;
	protected String RefEnseignant;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "enseigant")
    List <Demande> demandes =new ArrayList<Demande>();
	
	public Enseignant() {super();}
	
	public Enseignant(@Size(max = 45) String nom, @Size(max = 45) String prenom, String login, String pwd,
			String refEnseignant) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.login = login;
		this.pwd = pwd;
		RefEnseignant = refEnseignant;
	}

	public Enseignant(String nom, String prenom, String refEnseignant) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		RefEnseignant = refEnseignant;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getRefEnseignant() {
		return RefEnseignant;
	}
	public void setRefEnseignant(String refEnseignant) {
		RefEnseignant = refEnseignant;
	}
	
	public DemandeS addDemandeS(String objet,String Commentaire) {
		DemandeS demande = new DemandeS(new Date(), this,objet,EtatDemande.encours,Commentaire);
		ChefDept.getInstance().addDemande(demande);
		demandes.add(demande);
		return demande;
	}
	
	public DemandeM addDemandeM(String objet,String Commentaire) {
		DemandeM demande = new DemandeM(new Date(), this,objet,EtatDemande.encours,Commentaire);
		ChefDept.getInstance().addDemande(demande);
		demandes.add(demande);
		return demande;
	}
	
	@Override
	public String toString() {
		return "Enseignant nom:" + nom + "  prenom:" + prenom + "\n  ses demandes:\n" + demandes + "";
	}
	
	public boolean remove(Demande d) 
	{
		ChefDept.getInstance().removeDemande(d);
		return demandes.remove(d);
	}
	
	private List<Demande> getDemandeByEtat(EtatDemande Etat)
	{
		if (Etat!=null)
		return demandes.stream().filter(a->a.getEtat()==Etat).collect(Collectors.toList());
		else
		return demandes;
	}
	
	private List<Demande> getDemandeByDate(Date date)
	{   
		if(date!=null)
		return demandes.stream().filter(a->a.getDate()==date).collect(Collectors.toList());
		else
		return demandes;
	}
	
	private List <Demande> getDemandebyobjet(String objet)
	{   
		if(objet!=null)
		return demandes.stream().filter(a->a.getObjet()==objet).collect(Collectors.toList());
		else
		return demandes;
	}
	
	public List <Demande> geDemandeM()
	{   
		 return demandes.stream().filter(a->a.getClass().getName()=="DemandeM").collect(Collectors.toList());
	     	
	}
	
	public List <Demande> getDemandeS()
	{  
		 return demandes.stream().filter(a->a.getClass().getName()=="DemandeS").collect(Collectors.toList());
	       	
	}
	
	private List <Demande> getTypeDemande(String typeDemande)
	{   if (typeDemande!=null)
		 return demandes.stream().filter(a->a.getClass().getName().contains(typeDemande)).collect(Collectors.toList());
	    else
	     return demandes;  	
	}
	
	private List <Demande> getDemandeByMotCle(String Motcle)
	{   
		if (Motcle!=null)
		return demandes.stream().filter(a->a.getCommentaire().contains(Motcle) || a.getObjet().contains(Motcle)).collect(Collectors.toList());
		else
		return demandes;
		
	}
	
	public List <Demande> RechercheMul(String MotCle,String objet,Date date,EtatDemande Etat,String typeDemande)
	{
		return getDemandeByMotCle(MotCle)
				.stream()
				.filter(getDemandebyobjet(objet)::contains)
				.collect(Collectors.toList())
				.stream()
				.filter(getDemandeByDate(date)::contains)
				.collect(Collectors.toList())
				.stream()
				.filter(getDemandeByEtat(Etat)::contains)
				.collect(Collectors.toList())
				.stream()
				.filter(getTypeDemande(typeDemande)::contains)
				.collect(Collectors.toList());
	}
	public Integer getIdEnseignant() {
		return idEnseignant;
	}
	public void setIdEnseignant(Integer idEnseignant) {
		this.idEnseignant = idEnseignant;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public List<Demande> getDemandes() {
		return demandes;
	}
	public void setDemandes(List<Demande> demandes) {
		this.demandes = demandes;
	}
		
}
	