package com.example.demo.entities;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

@Entity
@DiscriminatorValue("DemandeMateriel")
public class DemandeM extends Demande implements Serializable  {
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "demandemateriel")
	private List<Article> article =new ArrayList<Article>();	
	
	public DemandeM() {super();}
	public DemandeM(Demande demande) {
		super();
		IdDemande = demande.IdDemande;
		date =  demande.date;
		enseigant = demande.enseigant;
		Objet = demande.Objet;
		Etat = demande.Etat;
		Commentaire = demande.Commentaire;
	}
	public DemandeM(Date date, Enseignant enseigant, String Objet, EtatDemande Etat,String Commentaire)
	    {
		super(date, enseigant, Objet, Etat,Commentaire);
		}
	
	public Article add(CatArticle cat,typeArticle type,String commentaire,int Quantite) {
		Article a= new Article(cat,type,commentaire,Quantite,this);
	    article.add(a);
	    return a;
	}
	
	public Article add(CatArticle cat,String label, EtatP mEtatP,int quantite,String com) {
		Article a= new Article(cat,label,mEtatP,quantite,this,com);
	    article.add(a);
	    return a;
	}

	public List<Article> getArticle() {
		return article;
	}
	public void setArticle(List<Article> article) {
		this.article = article;
	}
	@Override
	public String toString() {
		
		return ("    Demande de materiel: date:" + date + ", Objet: " + Objet + ", Etat: " + Etat + ", Commentaire: " + Commentaire + "\n        les articles de la demande sont: \n" + article) ;
	}	
	
}
