package com.jp.claseseminario.service;

import java.util.List;

import com.jp.claseseminario.entity.Persona;

public interface IPersonaService {
	public String save(Persona persona);
	public List<Persona> findAll();
	public Persona findById(Integer id);
}
