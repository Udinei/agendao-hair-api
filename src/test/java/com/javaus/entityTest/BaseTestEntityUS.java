package com.javaus.entityTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.springframework.util.SerializationUtils;

public class BaseTestEntityUS {

	public BaseTestEntityUS() {
		super();
	}

	public void entityHeSerializavelDeserializavel(Object objeto) {
		byte[] data = SerializationUtils.serialize(objeto);
		Object objNew = SerializationUtils.deserialize(data);
	
		assertEquals(objNew.getClass().getName(), objeto.getClass().getName());
	}

	@SuppressWarnings("unchecked")
	public boolean metodosBasicosPadraoDoLombokImplementadosNaEntity(Object objeto) {
	
		// lista de metodos basicos implementados pelo lombok
		List<String> mts = new ArrayList<>();
		mts.add("equals");
		mts.add("toString");
		mts.add("hashCode");
		mts.add("builder");
		mts.add("canEqual");
	
		List<String> listMetodosPadrao = mts;
		List<String> listMetodosImplementados = new ArrayList<>();
	
		for (Method metodo : objeto.getClass().getDeclaredMethods()) {
	
			for (int i = 0; i < listMetodosPadrao.size(); i++) {
				if (metodo.getName().equals(listMetodosPadrao.get(i))) {
					listMetodosImplementados.add(metodo.getName());
				}
			}
		}
	
		boolean possuiMetodos = false;
		if (listMetodosPadrao.containsAll(listMetodosImplementados)
				&& (listMetodosPadrao.size() == listMetodosImplementados.size())) {
			possuiMetodos = true;
		}
	
		return possuiMetodos;
	}

	protected List<String> listAtributosImplentadosNaEntity(Object classe) {
		List<String> atributosNaEntidade = new ArrayList<>();
	
		String modif = "";
		String modif_static = "";
		String modif_final = "";
		String tipoAtributo = "";
		String nomeAtributo = "";
		String declaracaoFinal = "";
	
		for (Field atributo : classe.getClass().getDeclaredFields()) {
	
			//System.out.println(atributo.toString());
	
			if (!atributo.toString().contains("static final")) {
				String[] vetor_campos = atributo.toString().split(" ");
				modif = vetor_campos[0];
				tipoAtributo = vetor_campos[1].substring(vetor_campos[1].lastIndexOf(".") + 1);
				nomeAtributo = vetor_campos[2].substring(vetor_campos[2].lastIndexOf(".") + 1);
				declaracaoFinal = modif + " " + tipoAtributo + " " + nomeAtributo;
				//System.out.println(" " + declaracaoFinal);
	
			}
	
			if (atributo.toString().contains("static final")) {
				String[] vetor_campos_static = atributo.toString().split(" ");
				modif = vetor_campos_static[0];
				modif_static = vetor_campos_static[1];
				modif_final = vetor_campos_static[2];
				tipoAtributo = vetor_campos_static[3];
				nomeAtributo = vetor_campos_static[4].substring(vetor_campos_static[4].lastIndexOf(".") + 1);
				declaracaoFinal = modif + " " + modif_static + " " + modif_final + " " + tipoAtributo + " "
						+ nomeAtributo;
				//System.out.println(" " + declaracaoFinal);
	
			}
	
			atributosNaEntidade.add(declaracaoFinal);
		}
		return atributosNaEntidade;
	}

	protected boolean todosAtributosProjetasdoForamImplementados(List<String> atributosProjetados, List<String> atributosNaEntity) {
		 boolean atributosImplementados = false;
		 
		List<String> newList = new ArrayList<>();
		for (int i = 0; i < atributosNaEntity.size(); i++) {
	
			// pega um atributo que existe na entidade
			String atributoAtual = atributosNaEntity.get(i);
	
			for (int j = 0; j < atributosProjetados.size(); j++) {
	
				String str = atributosProjetados.get(j);
	
				if (str.equals(atributoAtual)) {
					newList.add(atributoAtual);
				}
			}
		}
	
		if (newList.containsAll(atributosProjetados) && (newList.size() == atributosProjetados.size())) {
			atributosImplementados = true;
		}
	
		return atributosImplementados;
	}
	
	public void deveTerUmaAnotacaoDeMapeamentoDeEntityDeBD(Object objeto) { 
		boolean temMapeamentoBDNaEntidade = false;
			
		for (Annotation anotation : objeto.getClass().getAnnotations()) {
		      
			if (anotation.toString().contains("mongodb")) {
				temMapeamentoBDNaEntidade = true;
				
			}else if(anotation.toString().contains("Entity")) {
				temMapeamentoBDNaEntidade = true;
			}
		}
          
		assertTrue(temMapeamentoBDNaEntidade);
	}


}