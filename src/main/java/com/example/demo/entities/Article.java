package com.example.demo.entities;

import javax.persistence.*;

@Entity

public class Article {
	@Id
	@GeneratedValue
	private Integer idArticle;
	private String label;
	public Integer getIdArticle() {
		return idArticle;
	}

	public void setIdArticle(Integer idArticle) {
		this.idArticle = idArticle;
	}

	//@Enumerated(EnumType.STRING)
	@ManyToOne
    @JoinColumn(name="catArticle")
	private CatArticle catArticle;
	@Enumerated(EnumType.STRING)
	private typeArticle type;
	@Enumerated(EnumType.STRING)
	private EtatM EtatMat;
	private String commentaire;
	private int Quantite;
	@JoinColumn(referencedColumnName = "IdDemande")
	@ManyToOne(optional = false)
	private DemandeM demandemateriel;
	@Enumerated(EnumType.STRING)
	private EtatP mEtatP;
	public Article() {super();}
	
	public Article(CatArticle cat,String label, EtatP mEtatP,int quantite,DemandeM demandemateriel,String com) {
		super();
		this.label = label;
		this.catArticle = cat;
		this.mEtatP = mEtatP;
		Quantite = quantite;
		commentaire=com;
		this.setDemandemateriel(demandemateriel);
	}

	public Article(CatArticle cat, typeArticle type, String commentaire, int quantite,DemandeM demandemateriel) {
		super();
		this.catArticle = cat;
		this.type = type;
		this.commentaire = commentaire;
		Quantite = quantite;
		setDemandemateriel(demandemateriel);
	}

	public DemandeM getDemandemateriel() {
		return demandemateriel;
	}
	

	public CatArticle getCatArticle() {
		return catArticle;
	}

	public void setCatArticle(CatArticle catArticle) {
		this.catArticle = catArticle;
	}

	public void setDemandemateriel(DemandeM demandemateriel) {
		this.demandemateriel = demandemateriel;
	}

	public CatArticle getCat() {
		return catArticle;
	}

	public void setCat(CatArticle cat) {
		this.catArticle = cat;
	}
	
	

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public EtatP getmEtatP() {
		return mEtatP;
	}

	public void setmEtatP(EtatP mEtatP) {
		this.mEtatP = mEtatP;
	}

	public typeArticle getType() {
		return type;
	}

	public void setType(typeArticle type) {
		this.type = type;
	}
	
	public EtatM getEtatMat() {
		return EtatMat;
	}

	public void setEtatMat(EtatM etatMat) {
		EtatMat = etatMat;
	}

	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	public int getQuantite() {
		return Quantite;
	}

	public void setQuantite(int quantite) {
		Quantite = quantite;
	}

	@Override
	public String toString() {
		return "              Article ==> cat: " + catArticle + ", type: " + type + ", commentaire: " + commentaire + ", Quantite: " + Quantite
				+ "\n";
	}
	
}
