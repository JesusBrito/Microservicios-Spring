package com.microservices.app.users.controller;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.app.users.models.entity.Alumno;
import com.microservices.app.users.services.AlumnoService;
import com.microservices.commons.controllers.GenericController;

@RestController
public class AlumnoController extends GenericController<Alumno, AlumnoService> {

	
	@PutMapping("/{id}")
	public ResponseEntity<?> edit(@RequestBody Alumno alumno, @PathVariable Long id){
		Optional<Alumno> bdResponse = service.findById(id);
		if(bdResponse.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		Alumno alumnoDB = bdResponse.get();
		alumnoDB.setNombre(alumno.getNombre());
		alumnoDB.setApellido(alumno.getApellido());
		alumnoDB.setEmail(alumno.getEmail());
		service.save(alumnoDB);
		return ResponseEntity.status(HttpStatus.CREATED).body(alumnoDB); 
	}
	
}
