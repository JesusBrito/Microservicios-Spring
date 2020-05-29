package com.microservices.app.users.models.repository;

import org.springframework.data.repository.CrudRepository;

import com.microservices.app.users.models.entity.Alumno;

public interface AlumnoRepository extends CrudRepository<Alumno, Long> {

}
