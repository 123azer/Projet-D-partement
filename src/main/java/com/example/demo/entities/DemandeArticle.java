package com.example.demo.entities;

import javax.persistence.*;

@Entity

public class DemandeArticle {
	@Id
	@GeneratedValue
	private Integer IdDemandeArticle;
	@Enumerated(EnumType.STRING)
	private EtatM mEtatMat;
	private int Quantite;
	@JoinColumn(referencedColumnName = "IdDemande")
	@ManyToOne(optional = false)
	private DemandeM demandemateriel;
	
	@ManyToOne
    @JoinColumn(name="mArticle")
	private Article mArticle;
	
	public DemandeArticle() {super();}
	
	public DemandeArticle(Article mArticle, int quantite,DemandeM demandemateriel) {
		super();
		this.mArticle = mArticle;
		Quantite = quantite;
		this.demandemateriel = demandemateriel;
		this.mEtatMat = mEtatMat.MisEnService;
	}


	public Integer getIdDemandeArticle() {
		return IdDemandeArticle;
	}

	public void setIdDemandeArticle(Integer idDemandeArticle) {
		IdDemandeArticle = idDemandeArticle;
	}

	public EtatM getmEtatMat() {
		return mEtatMat;
	}

	public void setmEtatMat(EtatM mEtatMat) {
		this.mEtatMat = mEtatMat;
	}

	public DemandeM getDemandemateriel() {
		return demandemateriel;
	}

	public void setDemandemateriel(DemandeM demandemateriel) {
		this.demandemateriel = demandemateriel;
	}

	public Article getmArticle() {
		return mArticle;
	}

	public void setmArticle(Article mArticle) {
		this.mArticle = mArticle;
	}

	public int getQuantite() {
		return Quantite;
	}

	public void setQuantite(int quantite) {
		Quantite = quantite;
	}

	@Override
	public String toString() {
		return "              Article ==> cat: , type: "  +  ", Quantite: " + Quantite
				+ "\n";
	}
	
	
	
}
