package com.javaus.agenda.services.impl;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaus.agenda.models.Usuario;
import com.javaus.agenda.repository.UsuarioRepository;


/** Esta classe cria todas as instâncias dos objetos do modelo de dominio, e povoa
 *  automaticamente a base de BD com essas instancias. Afim de serem utilizadas em tempo de
 *  desenvolvimento, para confirmar as ação do sistema de persistencia e recuperação de dados
 *  em relação ao modelo conceitual proposto durante o desenvolvimento. 
 **/

@Service
public class InstanciacaoBDServiceImpl {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public void instanciaBD() throws ParseException {
		
	    usuarioRepository.deleteAll();
		
		Usuario user_1 = criarUsuario("usuarioddddd");
		Usuario user_2 = criarUsuario("usuario2");
		
		usuarioRepository.saveAll(Arrays.asList(user_1, user_2));
	}
	
	
	private Usuario criarUsuario(String name) {
		LocalDate hoje = LocalDate.now();
		DateTimeFormatter formatador = 
		DateTimeFormatter.ofPattern("dd/MM/yyyy")
		                 .withLocale(new Locale("pt", "BR"));
		
		hoje.format(formatador); // 08/04/2014
					
		return Usuario.builder().id(null)
								 .nome(name)
								 .email(name.concat("@email.com"))
				                 .senha("123")
				                 .ativo(false)
				                 .dataNascimento(hoje)
				                 .build();
	}
}
