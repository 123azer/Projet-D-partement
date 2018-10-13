package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entities.Article;
import com.example.demo.entities.EtatP;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Integer> {
	public Page<Article> findAll(Pageable pageable);
	@Query("SELECT a FROM Article a WHERE  a.catArticle.idCatArticle = :idCat")
	List<Article> findArticleBytCat(@Param("idCat") int idCat);
	List<Article> getItemBymEtatP(EtatP mEtatP);
	Article getItemByIdArticle(int id);
}
