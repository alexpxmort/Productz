package com.lex.productz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lex.productz.models.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto,Integer> {

}
