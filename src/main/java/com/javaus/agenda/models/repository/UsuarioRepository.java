package com.javaus.agenda.models.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.javaus.agenda.models.entity.Usuario;

public interface UsuarioRepository extends MongoRepository<Usuario, String> {
	
}