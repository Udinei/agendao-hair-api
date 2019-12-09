package com.javaus.agenda.resources.exception;

import java.io.Serializable;

import lombok.Builder;
import lombok.Data;

/** Classe auxiliar para tratamento das mensagens de erro, utilizada pela classe
 *  ResourceExceptionHandler
 *  @AllArgsConstructor - O lombock providenciara em tempo de execução a criação de todos os contrutores necessarios a classe  
 **/

@Data
@Builder
public class StandardError implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long timeStamp;
	private Integer status;
	private String error;
	private String message;
	private String path;
	
	
}
