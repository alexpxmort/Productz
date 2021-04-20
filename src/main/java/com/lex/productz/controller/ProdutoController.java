package com.lex.productz.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

	@GetMapping
	public String hello() {
		return "HELLO PRODUTOS";
	}
}
