package com.javaus.agenda.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.javaus.agenda.dto.UsuarioDTO;
import com.javaus.agenda.models.Usuario;
import com.javaus.agenda.repository.UsuarioRepository;
import com.javaus.agenda.services.UsuarioService;
import com.javaus.agenda.services.exceptions.ObjetoJaExisteCadastradoException;

@Service
public class UsuarioServiceImpl implements UsuarioService {
	
	
	@Autowired
	private UsuarioRepository usuarioRepositoriy;
	
	
	@Transactional 	
	public Usuario salvar(Usuario usuario) {
		// Garante a criacao de um novo objeto
		usuario.setId(null);
		
        validarEmail(usuario.getEmail());
		return usuarioRepositoriy.save(usuario);
	}
	
	

	@Override
	public void validarEmail(String email) {
        boolean existe = usuarioRepositoriy.existsByEmail(email);
        if(existe) {
        	throw new ObjetoJaExisteCadastradoException("Já existe um usuário cadastrado com este email.");
        }
		
	}
	
 
	public Usuario converteUsuarioDTOparaUsuario(UsuarioDTO dto){
		return  Usuario.builder()
				.id(dto.getId())
				.nome(dto.getNome())
				.email(dto.getEmail())
				.senha(dto.getSenha())
				.ativo(dto.isAtivo())
				.dataNascimento(dto.getDataNascimento())
       			.build();
	}



}
