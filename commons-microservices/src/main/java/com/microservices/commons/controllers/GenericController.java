package com.microservices.commons.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.commons.services.GenericService;

@RestController
public class GenericController<E, S extends GenericService<E>> {
	@Autowired
	protected S service;
	
	@GetMapping
	public ResponseEntity<?> listar(){
		return ResponseEntity.ok().body(service.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> detalle(@PathVariable Long id){
		
		Optional<E> bdResponse = service.findById(id);
		if(bdResponse.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(bdResponse.get());
	}
	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody E entity){
		E alumnoSaved = service.save(entity);
		return ResponseEntity.status(HttpStatus.CREATED).body(alumnoSaved);
	}
	

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		service.deleteById(id);
		return ResponseEntity.noContent().build();
	}

}
