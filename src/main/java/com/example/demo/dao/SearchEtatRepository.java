package com.example.demo.dao;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entities.ArticleInv;
import com.example.demo.entities.EtatM;
import com.example.demo.entities.typeArticle;
public interface SearchEtatRepository extends  JpaRepository <ArticleInv,EtatM> {
	@Query("select e from ArticleInv e where e.etat =:x")
	public List<ArticleInv> chercherEtat(@Param("x")EtatM etat);
	@Query("select e from ArticleInv e where e.type =:x")
	public List<ArticleInv> chercherType(@Param("x")typeArticle type);
}
