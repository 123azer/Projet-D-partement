package com.example.demo.entities;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
public class CatArticle {
	@Id
	@GeneratedValue
	private Integer idCatArticle;
	private String label;
	@Enumerated(EnumType.STRING)
	private EtatCat mEtatCat;
	public Integer getIdCatArticle() {
		return idCatArticle;
	}
	
	public void setIdCatArticle(Integer idCatArticle) {
		this.idCatArticle = idCatArticle;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public EtatCat getmEtatCat() {
		return mEtatCat;
	}
	public void setmEtatCat(EtatCat mEtatCat) {
		this.mEtatCat = mEtatCat;
	}
	public CatArticle() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CatArticle(String label, EtatCat mEtatCat) {
		super();
		this.label = label;
		this.mEtatCat = mEtatCat;
	}
}
  