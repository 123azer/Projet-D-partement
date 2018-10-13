package com.example.demo.Metier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import org.springframework.stereotype.Service;

import com.example.demo.dao.ArticleInvRepository;
import com.example.demo.entities.ArticleInv;

@Service
public class ArticleMetiertImpl implements ArticleMetier {
	@Autowired
    private ArticleInvRepository ArticleInvRepository;
	
	@Override
	public ArticleInv saveArticle(ArticleInv a) {
		// TODO Auto-generated method stub
		return ArticleInvRepository.save(a);
	}
	@Override
	public Page<ArticleInv> PageArticle(int p) {
		return ArticleInvRepository.findAll(new PageRequest(p,5));
	}
	public void delete(Long id) {
		ArticleInvRepository.deleteById(id);
   }
	public ArticleInv edit(Long id) {
		ArticleInv mt = ArticleInvRepository.getOne(id);
		
		return mt;
	}
	
}