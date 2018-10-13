package com.example.demo.Metier;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.*;
import com.example.demo.entities.ArticleInv;
@Service
public class SearchDateImp implements SearchDate {
	@Autowired
    private SearchDateRepository SearchDateRepository;
	public List<ArticleInv> chercherDateAC(Date dateACQ) {
		return SearchDateRepository.chercherDateACQ(dateACQ);
	}
	@Override
	public List<ArticleInv> chercherDateSortie(Date dateSortie) {
		return SearchDateRepository.chercherDateS(dateSortie);
	}
}
