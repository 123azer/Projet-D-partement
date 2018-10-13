package com.example.demo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class TypeService {
	@Id
	@GeneratedValue
	private Integer idTypeService;
	private String nameTypeService;

	public TypeService(String nameTypeService) {
		this.nameTypeService = nameTypeService;
	}
	
	public TypeService() {}

	public String getNameTypeService() {
		return nameTypeService;
	}

	public void setNameTypeService(String nameTypeService) {
		this.nameTypeService = nameTypeService;
	}

	public Integer getIdTypeService() {
		return idTypeService;
	}

	public void setIdTypeService(Integer idTypeService) {
		this.idTypeService = idTypeService;
	}
	
	
	
}
