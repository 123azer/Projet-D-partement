package com.example.demo.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entities.ArticleInv;

public interface SearchDateRepository extends JpaRepository <ArticleInv,Date>{
	@Query("select e from ArticleInv e where e.dateEntree =:x")
	public List<ArticleInv> chercherDateACQ(@Param("x")Date dateACQ);
	@Query("select e from ArticleInv e where e.dateSortie =:x")
	public List<ArticleInv> chercherDateS(@Param("x")Date dateSortie);
}
