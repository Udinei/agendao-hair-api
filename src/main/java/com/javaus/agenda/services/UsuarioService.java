package com.javaus.agenda.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaus.agenda.controllers.resources.dto.UsuarioDTO;
import com.javaus.agenda.models.entity.Usuario;
import com.javaus.agenda.models.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepositoriy;
	
	
	public Usuario insert(Usuario obj){
		return usuarioRepositoriy.insert(obj);
	}
	
 
	public Usuario converteUsuarioDTOparaUsuario(UsuarioDTO dto){
		return  Usuario.builder()
				.id(dto.getId())
				.nome(dto.getNome())
				.email(dto.getEmail())
				.senha(dto.getSenha())
				.build();
	}

}
