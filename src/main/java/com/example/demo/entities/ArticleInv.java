package com.example.demo.entities;

import java.io.Serializable;
import java.util.Date;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToMany;
//import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class ArticleInv implements Serializable{
	    @Id
	    @GeneratedValue
        private Long id;
	    private String ref;
	    
        private String nom;
        @Enumerated(EnumType.STRING)
    	private typeArticle type;
        private String marque ;
    	
    
    	private String local ;
    	private String ressourceBeneficaire ;
    	@Enumerated(EnumType.STRING)
    	private EtatM etat ;
    	
    	public EtatM getEtat() {
			return etat;
		}
		public void setEtat(EtatM etat) {
			this.etat = etat;
		}
		@DateTimeFormat(pattern = "yyyy-MM-dd")
    	private Date dateSortie ;
    	private String destinataire ;
    	@DateTimeFormat(pattern = "yyyy-MM-dd")
    	private Date dateEntree ;
	
    	
	public String getRef() {
			return ref;
		}
		public void setRef(String ref) {
			this.ref = ref;
		}
	public typeArticle getType() {
			return type;
		}
		public void setType(typeArticle type) {
			this.type = type;
		}
		public String getMarque() {
			return marque;
		}
		public void setMarque(String marque) {
			this.marque = marque;
		}
		
		public String getLocal() {
			return local;
		}
		public void setLocal(String local) {
			this.local = local;
		}
		public String getRessourceBeneficaire() {
			return ressourceBeneficaire;
		}
		public void setRessourceBeneficaire(String ressourceBeneficaire) {
			this.ressourceBeneficaire = ressourceBeneficaire;
		}
		
		public Date getDateSortie() {
			return dateSortie;
		}
		public void setDateSortie(Date dateSortie) {
			this.dateSortie = dateSortie;
		}
		
		public String getDestinataire() {
			return destinataire;
		}
		public void setDestinataire(String destinataire) {
			this.destinataire = destinataire;
		}
		public Date getDateEntree() {
			return dateEntree;
		}
		public void setDateEntree(Date dateEntree) {
			this.dateEntree = dateEntree;
		}
		/*public DemandeMateriel getDM() {
			return DM;
		}
	public void setDM(DemandeMateriel dM) {
			DM = dM;
		}*/
		public ArticleInv(Long id, String nom) {
			this.id = id;
			this.nom = nom;
		}
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getNom() {
			return nom;
		}
		public void setNom(String nom) {
			this.nom = nom;
		}
		public ArticleInv() {
		}
		
        
}
