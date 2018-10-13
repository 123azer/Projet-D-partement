package com.example.demo.Metier;



import java.util.List;

import com.example.demo.dao.*;
import com.example.demo.entities.ArticleInv;
import com.example.demo.entities.EtatM;
import com.example.demo.entities.typeArticle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class SearchEtatImp implements SearchEtat {
	@Autowired
    private SearchEtatRepository SearchEtatRepository;
	@Override
	public List<ArticleInv> chercherE(EtatM etat) {
		return SearchEtatRepository.chercherEtat(etat);
	}
	public   List<ArticleInv> chercherT(typeArticle type){
		return SearchEtatRepository.chercherType(type);
	}
	
}
