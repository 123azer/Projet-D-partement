package com.example.demo.entities;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

import javax.persistence.*;


@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type", discriminatorType=DiscriminatorType.STRING)
@DiscriminatorValue("Demande")
public class Demande implements Serializable  {
	@Id
	@GeneratedValue
    protected Integer IdDemande;
	protected Date date;
	@JoinColumn(referencedColumnName = "idEnseignant")
	@ManyToOne(optional = false)
	protected Enseignant enseigant;
	

	protected String Objet;
	@Enumerated(EnumType.STRING)
	protected EtatDemande Etat;
	protected String Commentaire;
	
	public Demande() {super();}
	public Demande(Date date, Enseignant enseigant,String Objet,EtatDemande Etat,String Commentaire) {
		super();
		setDate(date);
		setEnseigant(enseigant);
		setObjet(Objet);
		setEtat(Etat);
		setCommentaire(Commentaire);
	}
	
	
	
	public void setIdDemande(Integer idDemande) {
		IdDemande = idDemande;
	}
	public Integer getIdDemande() {
		return IdDemande;
	}
	public String getCommentaire() {
		return Commentaire;
	}

	public void setCommentaire(String commentaire) {
		Commentaire = commentaire;
	}

	public String getObjet() {
		return Objet;
	}

	public void setObjet(String objet) {
		Objet = objet;
	}

	public EtatDemande getEtat() {
		return Etat;
	}

	public void setEtat(EtatDemande etat) {
		Etat = etat;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Enseignant getEnseigant() {
		return enseigant;
	}

	public void setEnseigant(Enseignant enseigant) {
		this.enseigant = enseigant;
	}
	
	@Override
	public String toString() {
		return "Demande  date=" + date + ", enseigant=" + enseigant + ", Objet=" + Objet + ", Etat=" + Etat
				+ ", Commentaire=" + Commentaire;
	}
		
}
