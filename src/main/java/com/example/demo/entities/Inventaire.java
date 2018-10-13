package com.example.demo.entities;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.persistence.*;

//@Entity
//@Table(name = "Inventaire")
public class Inventaire {
	//@Id
	//@GeneratedValue
	//@Column(name = "idInventaire")
	private int idInventaire;
	//@OneToMany(cascade = CascadeType.ALL, mappedBy = "Inventaire")
	private List<Article> articles =new ArrayList<Article>();
	
	public boolean add(Article arg0) {
		return articles.add(arg0);
	}

	public void add(int arg0, Article arg1) {
		articles.add(arg0, arg1);
	}

	public boolean equals(Object arg0) {
		return articles.equals(arg0);
	}

	public Article remove(int arg0) {
		return articles.remove(arg0);
	}

	public boolean remove(Object arg0) {
		return articles.remove(arg0);
	}

	public int size() {
		return articles.size();
	}
	
	

}
