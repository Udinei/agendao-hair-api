package com.javaus.agenda.controllers.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/teste")
public class TestRest {

	@GetMapping
	public String listar() {
		return "Rest está funcionando!";
	}
	
}
