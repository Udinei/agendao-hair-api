package com.javaus.agenda.services.exceptions;

/*** Essa classe personalizada é responsavel por exibir mensagens do fluxo de exceções
 *   das regras de negocio em que os objetos que não foram encontrados
 *   */
public class AppAgendaObjectNotFoundException extends RuntimeException {

		private static final long serialVersionUID = 1L;
		
		public AppAgendaObjectNotFoundException(String msg){
			super(msg);
			
		}
		
		
		// Throwable - informa a causa do que aconteceu antes
		public AppAgendaObjectNotFoundException(String msg, Throwable cause){
			super(msg, cause);
			
		}
		
		

}
