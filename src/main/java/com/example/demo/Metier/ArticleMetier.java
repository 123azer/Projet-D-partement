package com.example.demo.Metier;
import org.springframework.data.domain.Page;

import com.example.demo.entities.ArticleInv;

public interface ArticleMetier {
public ArticleInv saveArticle(ArticleInv a);
public Page<ArticleInv> PageArticle(int p);
public void delete(Long id);
public ArticleInv edit(Long id);

}
