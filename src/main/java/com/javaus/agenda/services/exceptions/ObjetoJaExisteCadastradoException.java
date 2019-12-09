package com.javaus.agenda.services.exceptions;

/*** 
 *  Essa classe personalizada é responsavel por exibir mensagens do fluxo de exceções
 *   das regras de negocio em que os objetos ja existem cadastrados no BD 
 *    
 **/
public class ObjetoJaExisteCadastradoException extends RuntimeException {

		private static final long serialVersionUID = 1L;
		
		public ObjetoJaExisteCadastradoException(String msg){
			super(msg);
			
		}
		
		
		// Throwable - informa a causa do que aconteceu antes
		public ObjetoJaExisteCadastradoException(String msg, Throwable cause){
			super(msg, cause);
			
		}
		
		

}
