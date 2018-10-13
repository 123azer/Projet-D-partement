package com.example.demo.dao;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entities.ArticleInv;

public interface SearchRepository extends JpaRepository <ArticleInv,String> {
	@Query("select e from ArticleInv e where e.destinataire like :x")
	public List<ArticleInv> chercherDest(@Param("x")String mc);
	@Query("select e from ArticleInv e where e.marque like :x")
	public List<ArticleInv> chercherMarque(@Param("x")String mk);
	@Query("select e from ArticleInv e where e.ref like :x")
	public List<ArticleInv> chercherRef(@Param("x")String ref);
	@Query("select e from ArticleInv e where e.nom like :x")
	public List<ArticleInv> chercherArticle(@Param("x")String article);
	@Query("select e from ArticleInv e where e.local like :x")
	public List<ArticleInv> chercherLocal(@Param("x")String loc);
	@Query("select e from ArticleInv e where e.ressourceBeneficaire like :x")
	public List<ArticleInv> chercherBen(@Param("x")String ben);
	
	
	/*@Query("select e from Article e where ToString(e.etat) like :x")
	public List<Article> chercherEtat(@Param("x")EtatM etat);*/
}
