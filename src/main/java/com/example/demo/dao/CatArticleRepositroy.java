package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entities.Article;
import com.example.demo.entities.CatArticle;
import com.example.demo.entities.EtatCat;
import com.example.demo.entities.EtatP;
import com.example.demo.entities.TypeService;

public interface CatArticleRepositroy extends JpaRepository<CatArticle, Integer>{
	List<CatArticle> getItemBymEtatCat(EtatCat validated);
	CatArticle getItemByIdCatArticle(int id);
	@Query("SELECT a FROM CatArticle a WHERE a.label = :label")
	public List<CatArticle> findByNom(@Param("label")String categorie);
}
