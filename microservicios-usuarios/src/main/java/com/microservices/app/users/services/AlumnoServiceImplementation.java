package com.microservices.app.users.services;

import org.springframework.stereotype.Service;
import com.microservices.app.users.models.entity.Alumno;
import com.microservices.app.users.models.repository.AlumnoRepository;
import com.microservices.commons.services.GenericServiceImplementation;

@Service
public class AlumnoServiceImplementation extends GenericServiceImplementation<Alumno, AlumnoRepository> implements AlumnoService {}
