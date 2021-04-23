package com.lex.productz.controller;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lex.productz.models.Produto;
import com.lex.productz.repository.ProdutoRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value  = "/api")
@Api(value =" API REST PRODUTOS" )
@CrossOrigin(origins = "*")
public class ProdutoController {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	@GetMapping("/produtos")
	@ApiOperation(value = "Lista de produtos")
	public List<Produto> listar() {
		List<Produto> produtos = produtoRepository.findAll();
		
		return produtos;
	}
}
