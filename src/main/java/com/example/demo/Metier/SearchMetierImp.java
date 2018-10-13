package com.example.demo.Metier;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.*;
import com.example.demo.entities.ArticleInv;
@Service
public class SearchMetierImp implements SearchMetier {
	@Autowired
    private SearchRepository SearchRepository;
	public List<ArticleInv> chercherD(String mc){
		return SearchRepository.chercherDest(mc);
	}
	@Override
	public List<ArticleInv> chercherM(String mk) {
		return SearchRepository.chercherMarque(mk);
	}
	@Override
	public List<ArticleInv> chercherR(String ref) {
		return SearchRepository.chercherRef(ref);
	}
	@Override
	public List<ArticleInv> chercherA(String article) {
		return SearchRepository.chercherArticle(article);
	}
	@Override
	public List<ArticleInv> chercherL(String local) {
		return SearchRepository.chercherLocal(local);
	}
	@Override
	public List<ArticleInv> chercherB(String ben) {
		return SearchRepository.chercherBen(ben);
	}
	/*@Override
	public List<Article> chercherT(String type) {
		return SearchRepository.chercherType(type);
	}*/
	
	
	
}
