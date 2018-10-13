package com.example.demo.Metier;


import java.util.List;


import com.example.demo.entities.ArticleInv;


public interface SearchMetier {
	public   List<ArticleInv> chercherD(String mc) ;
	public   List<ArticleInv> chercherM(String mk) ;
	public   List<ArticleInv> chercherR(String ref) ;
	public   List<ArticleInv> chercherA(String article) ;
	public   List<ArticleInv> chercherL(String local) ;	
	public   List<ArticleInv> chercherB(String ben) ;
	//public   List<Article> chercherT(String type) ;
	/*public   List<Article> chercherE(EtatM etat) ;*/
}
