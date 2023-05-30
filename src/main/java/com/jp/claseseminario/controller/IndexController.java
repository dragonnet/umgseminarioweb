package com.jp.claseseminario.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jp.claseseminario.entity.Persona;
import com.jp.claseseminario.service.IPersonaService;

@RestController
@RequestMapping(value="/api")
public class IndexController {
	
	/*
	 * get	-> consultar
	 * post -> crear/insertar
	 * put 	-> actualizar/modificar
	 * delete	-> eliminar
	 * */
	
	@Autowired
	private IPersonaService personaService;

	@GetMapping(value = "/test/{nombre}", produces = MediaType.TEXT_PLAIN_VALUE)
	public String test(@PathVariable("nombre") String nombre, @RequestHeader("apellido") String apellido) {
		return "Hola funcionando desde el WS en la clase de Seminario " + nombre + " " + apellido;
	}
	
	@PostMapping(value = "/persona", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.TEXT_PLAIN_VALUE)
	public String savePersona(@RequestBody Persona persona) {
		return personaService.save(persona);
	}
	
	@GetMapping(value = "/personas", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Persona> findAll(){
		return personaService.findAll();
	}
	
	@GetMapping(value = "/persona/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Persona findById(@PathVariable("id") Integer id){
		return personaService.findById(id);
	}

}
