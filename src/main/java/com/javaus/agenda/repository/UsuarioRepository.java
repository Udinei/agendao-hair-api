package com.javaus.agenda.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.javaus.agenda.models.Usuario;

public interface UsuarioRepository extends MongoRepository<Usuario, String> {

	 boolean existsByEmail(String email);
	
	
}