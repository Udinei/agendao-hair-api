package com.javaus.entityTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.javaus.agenda.models.Usuario;


public class UsuarioEntityTest extends BaseTestEntityUS  {

	private Usuario usuario = new Usuario();

	protected void atributosProjetadosDaEntity(List<String> at) {
		at.add("private String id");
		at.add("private String nome");
		at.add("private String senha");
	}
	
	
	@Test
	public void TestaUsuarioEntity() {
		// lista dos atributos da entidade 
		List<String> at = new ArrayList<>();

		// metodo de declaração dos atributos da entidade
		atributosProjetadosDaEntity(at);

		List<String> listAtributosProjetados = at;
		List<String> listAtributosNaEntity = listAtributosImplentadosNaEntity(usuario);
		
		boolean atributosImplementados = todosAtributosProjetasdoForamImplementados(listAtributosProjetados, listAtributosNaEntity);
		assertTrue(atributosImplementados);
		
		
		boolean possuiMetodosLombok = metodosBasicosPadraoDoLombokImplementadosNaEntity(usuario);
		assertTrue(possuiMetodosLombok);
			
		entityHeSerializavelDeserializavel(usuario);
		
		deveTerUmaAnotacaoDeMapeamentoDeEntityDeBD(usuario);
	}

	
	
}
