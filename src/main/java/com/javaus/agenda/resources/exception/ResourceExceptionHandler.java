package com.javaus.agenda.resources.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.javaus.agenda.services.exceptions.AppAgendaObjectNotFoundException;
import com.javaus.agenda.services.exceptions.ObjetoJaExisteCadastradoException;

/** Essa classe é um manipulador de exceção dos resources da aplicação.
 *  Invocara um metodo dessa classe sempre que uma exceção for lancada.
 *  O metodo devera conter a anotation @ExceptionHandler(NomeClasseException.class) e como 
 *  parametro o nome da  exceção que esta sendo lancada
 *
 *  */
@ControllerAdvice
public class ResourceExceptionHandler {
	
	// Chama o metodo objectNotFoundExcepciont, quando a classe for usada com - throw new AppAgendaObjectNotFoundException
	// Os atributos da classe StandardError serão preenchidos com os dados vindos da requisicao em HttpServletRequest
	@ExceptionHandler(AppAgendaObjectNotFoundException.class)
	public ResponseEntity<StandardError> objectNotFound(AppAgendaObjectNotFoundException e, HttpServletRequest request) {
		
		// preenche o objeto StandardError com as informações de erro fornecidas pelo request, e pelo metodo que lancou o erro, e o momento
		StandardError err = new StandardError(System.currentTimeMillis(), HttpStatus.NOT_FOUND.value(), "Não encontrado", e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
	}
	
	@ExceptionHandler(ObjetoJaExisteCadastradoException.class)
	public ResponseEntity<StandardError> objetoJaCadastrado(ObjetoJaExisteCadastradoException e, HttpServletRequest request) {
		  
    
		// preenche o objeto StandardError com as informações de erro fornecidas pelo request, e pelo metodo que lancou o erro, e o momento
		StandardError err = new StandardError(System.currentTimeMillis(), HttpStatus.CONFLICT.value(), "Objeto já existe cadastrado", e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(HttpStatus.CONFLICT).body(err);
	}
	
	
}
