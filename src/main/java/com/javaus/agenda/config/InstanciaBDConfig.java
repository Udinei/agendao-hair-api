package com.javaus.agenda.config;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.javaus.agenda.services.impl.InstanciacaoBDServiceImpl;


/** Essa classe define as configuração em tempo de desenvolvimento 
 *  Classe de instanciação e população do BD Mysql, Postgress, MongoDB etc..
 *  Nota: A Classe de email, deve ser sempre executada com profile dev
 **/

@Configuration
@Profile("dev")
public class InstanciaBDConfig {
	
	@Autowired
	private InstanciacaoBDServiceImpl dbService;
	
	// obtem o status para criacao do bd, do arquivo application-dev.properties
	@Value("${instanciabd.config.mongodb.auto}")
	private String strategy;
	
	@Bean
	public boolean instanciaBD() throws ParseException{
		
		// somente cria novamente o banco de dados se for solicitado 
		if(!"create".equals(strategy)){
			return false;
		}
	
		// chama o servico para instanciação dos objetos da aplicação em banco de dados
		dbService.instanciaBD();
		return true;
		
	}
	

}