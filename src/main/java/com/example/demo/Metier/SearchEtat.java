package com.example.demo.Metier;

import java.util.List;

import com.example.demo.entities.ArticleInv;
import com.example.demo.entities.EtatM;
import com.example.demo.entities.typeArticle;



public interface SearchEtat {

	public List<ArticleInv> chercherE(EtatM em);
	public   List<ArticleInv> chercherT(typeArticle type) ;
}
