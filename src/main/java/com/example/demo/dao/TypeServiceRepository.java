package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.TypeService;

public interface TypeServiceRepository extends JpaRepository<TypeService, Integer> {
	TypeService getItemByIdTypeService(Integer idTypeService);
}
