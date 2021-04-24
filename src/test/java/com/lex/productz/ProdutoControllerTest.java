package com.lex.productz;
import static  org.junit.Assert.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

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
	public void findTest()  throws ProdutoNotFoundException{
		Optional<Produto>  p = produtoRepositoryTest.findById(1);
		
		assertEquals(1,p.get().getId());
		assertEquals("151515",p.get().getCodigoBarra());
	}
	
}
