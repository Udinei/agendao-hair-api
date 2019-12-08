package com.javaus.agenda.services;

import com.javaus.agenda.dto.UsuarioDTO;
import com.javaus.agenda.models.Usuario;

public interface UsuarioService {

	//Usuario autenticar(String email, String senha);
	
	Usuario salvar(Usuario usuario);
	
	Usuario converteUsuarioDTOparaUsuario(UsuarioDTO dto);
	
	void validarEmail(String email);
	
	//Optional<Usuario> obterPorId(Long id);

}
