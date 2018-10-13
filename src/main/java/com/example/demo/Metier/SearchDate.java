package com.example.demo.Metier;

import java.util.Date;
import java.util.List;

import com.example.demo.entities.ArticleInv;


public interface SearchDate {
	public   List<ArticleInv> chercherDateAC(Date dateACQ) ;
	public   List<ArticleInv> chercherDateSortie(Date DateSortie) ;
}
