package com.example.demo.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entities.Demande;
import com.example.demo.entities.Enseignant;
public interface EnseignantRepository extends JpaRepository<Enseignant, Integer>{
	
	public Enseignant findByIdEnseignant(Integer n);
	//public List<Enseignant> findByNom(String n);
	@Query("select e from Enseignant e where e.login = :login and e.pwd=:pwd")
    public Enseignant checherEnseignant(@Param("login")String login,@Param("pwd")String pwd);
	public Enseignant findByNom(String nomdemandeur);

}
