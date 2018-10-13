package com.example.demo.entities;
import javax.persistence.*;

@Entity
public class Service {
	@Id
	@GeneratedValue
	private Integer idService;
	
	private String Description;
	private String commentaire;
	@Enumerated(EnumType.STRING)
	private EtatService etatS;
	@JoinColumn(referencedColumnName = "IdDemande")
	@ManyToOne(optional = false)
	private DemandeS Demandeservice;
	@ManyToOne
	@JoinColumn(name = "typeService")
	private TypeService typeService;
	
	public Integer getIdService() {
		return idService;
	}
	public void setIdService(Integer idService) {
		this.idService = idService;
	}
	public Service() {super();}
	
	
	
	public Service(String commentaire, TypeService typeService) {
		super();
		this.commentaire = commentaire;
		this.typeService = typeService;
	}
	public Service(TypeService typeService, EtatService etatS, DemandeS demandeservice,String commentaire) {
		super();
		this.commentaire = commentaire;
		this.etatS = etatS;
		Demandeservice = demandeservice;
		this.typeService = typeService;
	}
	
	public Service(String description, EtatService etatS, DemandeS demandeservice) {
		super();
		Description = description;
		etatS = etatS;
		Demandeservice = demandeservice;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public EtatService getEtatS() {
		return etatS;
	}

	public void setEtatS(EtatService etatS) {
		etatS = etatS;
	}

	public DemandeS getDemandeservice() {
		return Demandeservice;
	}

	public void setDemandeservice(DemandeS demandeservice) {
		Demandeservice = demandeservice;
	}

	
	
	public String getCommentaire() {
		return commentaire;
	}
	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}
	public TypeService getTypeService() {
		return typeService;
	}
	public void setTypeService(TypeService typeService) {
		this.typeService = typeService;
	}
	@Override
	public String toString() {
		return "              Service ==> Description: " + Description + ", EtatS: " + etatS +"\n";
	}	
	
}
