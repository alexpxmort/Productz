package com.lex.productz;
import static  org.junit.Assert.assertEquals;
import static  org.junit.Assert.assertFalse;

import java.util.Optional;

import org.aspectj.lang.annotation.Before;
import org.junit.After;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.lex.productz.controller.ProdutoController;
import com.lex.productz.exceptions.ProdutoNotFoundException;
import com.lex.productz.models.Produto;
import com.lex.productz.repository.ProdutoRepository;

@SpringBootTest
@RunWith(SpringRunner.class)
@WebAppConfiguration
@Sql(scripts  ="/sql/produtoControllerTest.sql")
public class ProdutoControllerTest {

	@Autowired
	private ProdutoRepository produtoRepositoryTest;
	

	@Test
	@Before(value = "")
	public void findTest()  throws ProdutoNotFoundException{
		int id = 1;
		Optional<Produto>  p = produtoRepositoryTest.findById(id);
		
		assertEquals(id,p.get().getId());
		assertEquals("151515",p.get().getCodigoBarra());
	}
	

	@Test
	@After
	public void deleteTest()  throws ProdutoNotFoundException{
		int id = 1;
		Optional<Produto>  p = produtoRepositoryTest.findById(id);
		
		if(p.isPresent()) {
			produtoRepositoryTest.delete(p.get());
			
			Optional<Produto>  pDel = produtoRepositoryTest.findById(id);
			
			assertFalse(pDel.isPresent());
			
		}
	}
	
}
