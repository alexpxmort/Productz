package com.lex.productz;
import static  org.junit.Assert.assertEquals;
import static  org.junit.Assert.assertFalse;

import java.util.Optional;

import org.junit.After;
import org.junit.Before;
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
public class ProdutoControllerTest {

	@Autowired
	private ProdutoRepository produtoRepositoryTest;
	
	



	@Test
	@Before
	public void createTest(){
		String nome = "TESTE CREATE";
		String cat  ="TESTE A";
		String cod = "10203050";
		String desc = "Teste Desc";
		int qtd = 1000;
		
		Produto p = new Produto();
		p.setId(1);
		p.setNome(nome);
		p.setCategoria(cat);
		p.setCodigoBarra(cod);
		p.setDescricao(desc);
		p.setQuantidade(qtd);
		
		Produto produto = produtoRepositoryTest.save(p);
		
		
		assertEquals(nome,produto.getNome());
		assertEquals(cat,produto.getCategoria());
		assertEquals(cod,produto.getCodigoBarra());
		assertEquals(qtd,produto.getQuantidade());
		assertEquals(desc,produto.getDescricao());
		
	}
	
	@Test
	@After
	public void findTest()  throws ProdutoNotFoundException{
		int id = 1;
		String cod = "10203050";
		Optional<Produto>  p = produtoRepositoryTest.findById(1);
		
			if(p.isPresent()) {
				assertEquals(cod,p.get().getCodigoBarra());
			}	
	}
	
	
	@Test
	@After
	public void updateTest()  throws ProdutoNotFoundException{
		int id = 1;
		Optional<Produto>  p = produtoRepositoryTest.findById(id);
		
		if(p.isPresent()) {
			String newCod  ="151515 1020";
			Produto prod = p.get();
			prod.setCodigoBarra(newCod);
			produtoRepositoryTest.save(prod);
						
			assertEquals(newCod,p.get().getCodigoBarra());
			
		}
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
