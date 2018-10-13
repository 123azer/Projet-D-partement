package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.EtatService;
import com.example.demo.entities.Service;

public interface ServiceRepository extends JpaRepository<Service, Integer> {
	List<Service> getItemByEtatS(EtatService validated);
	Service findByIdService(int id);

}
