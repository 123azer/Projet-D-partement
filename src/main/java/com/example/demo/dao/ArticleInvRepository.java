package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.ArticleInv;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleInvRepository extends JpaRepository<ArticleInv, Long> {
	public Page<ArticleInv> findAll(Pageable pageable);
	//public void deleteById(Long id);
}
