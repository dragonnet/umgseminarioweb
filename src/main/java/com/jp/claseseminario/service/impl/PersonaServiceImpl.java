package com.jp.claseseminario.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.jp.claseseminario.entity.Persona;
import com.jp.claseseminario.service.IPersonaService;

@Service
public class PersonaServiceImpl implements IPersonaService {
	
	//Simular
	List<Persona> listPersonas = new ArrayList<>();

	@Override
	public String save(Persona persona) {
		listPersonas.add(persona);
		return "OK";
	}

	@Override
	public List<Persona> findAll() {
		return listPersonas;
	}

	@Override
	public Persona findById(Integer id) {
		//validamos que la lista no sea nula
		if(listPersonas != null) {
			//recorremos la lista completa
			for (Persona persona : listPersonas) {
				//validamos que el id de la persona sea igual al que estamos buscando
				if(persona.getId() == id)
					return persona;
			}
		}
		return null;
			
	}

	@Override
	public String update(Persona persona) {
		if(persona.getId() != null && listPersonas != null) {
			for (Persona elemento : listPersonas) {
				//validamos que el id de la persona sea igual al que estamos buscando
				if(persona.getId() == elemento.getId()) {
					elemento.setNombre(persona.getNombre());
					elemento.setPeso(persona.getPeso());
					return "Updated";
				}
			}
		}
			
		return null;
	}

}
