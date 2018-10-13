package com.example.demo.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entities.Demande;
import com.example.demo.entities.Enseignant;
import com.example.demo.entities.EtatDemande;


public interface DemandeRepository extends JpaRepository<Demande, Integer> {

	@Query("select e from Demande e where e.IdDemande = :id")
	public Demande findByIdDemande(@Param("id")Integer id);
    //public Page<Enseignant> checherEnseignant(@Param("login")String login,@Param("pwd")String pwd,Pageable pageable);
	
	//List<Demande> findByEtat(EtatDemande Etat);
	//List<Demande> findByDate(LocalDate date);
	//List<Demande> findByObjet(String objet);
	@Query("select e from Demande e where e.enseigant.idEnseignant = :id")
	List<Demande> findByEnseigant(@Param("id")int id);

	
}
