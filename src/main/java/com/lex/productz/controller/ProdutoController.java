package com.lex.productz.controller;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	
	@RequestMapping(value = "/produtos", method =  RequestMethod.GET)
	@ApiOperation(value = "Listagem de produtos")
	public List<Produto> list() {
		List<Produto> produtos = produtoRepository.findAll();
		
		return produtos;
	}
	
	@RequestMapping(value = "/find/{id}", method =  RequestMethod.GET)
	@ApiOperation(value = "Procura de produtos")
	public ResponseEntity find(@PathVariable int id) {
	    
	    Optional<Produto> produto =  produtoRepository.findById(id);
	    
	    if(produto.isPresent()) {
		    return new ResponseEntity(produto,HttpStatus.OK);
	    }else
	    	return new ResponseEntity(HttpStatus.NOT_FOUND);
	    
	  }
	
	@RequestMapping(value = "/create", method =  RequestMethod.POST)
	@ApiOperation(value = "Cadastro de produtos")
	public ResponseEntity<Produto> create( @RequestBody Produto produtoBody) {
		Produto produto = produtoRepository.save(produtoBody);
		
		 return new ResponseEntity<Produto>(produto, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/update/{id}", method =  RequestMethod.PUT)
	@ApiOperation(value = "Atualização de produtos")
    public ResponseEntity<Produto> update(@PathVariable(value = "id") int id, @RequestBody Produto newProduto)
    {
        Optional<Produto> oldProduto = produtoRepository.findById(id);
        
        if(oldProduto.isPresent()){
            Produto produto = oldProduto.get();
            
            produto.setNome(newProduto.getNome());
            produto.setCategoria(newProduto.getCategoria());
            produto.setCodigoBarra(newProduto.getCodigoBarra());
            produto.setDescricao(newProduto.getDescricao());
            produto.setQuantidade(newProduto.getQuantidade());
            produto.setCreatedAt(newProduto.getCreatedAt());
            produto.setUpdateddAt(newProduto.getUpdateddAt());
            
            produtoRepository.save(produto);
            return new ResponseEntity<Produto>(produto, HttpStatus.OK);
        }
        else
            return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
	
	 @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	 @ApiOperation(value = "Remoção de produtos")
	    public ResponseEntity<Object> delete(@PathVariable(value = "id") int id)
	    {
	        Optional<Produto> produto = produtoRepository.findById(id);
	        if(produto.isPresent()){
	        	produtoRepository.delete(produto.get());
	            return new ResponseEntity<>(HttpStatus.OK);
	        }
	        else
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
}
