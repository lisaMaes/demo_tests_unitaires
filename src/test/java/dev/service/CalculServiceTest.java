package dev.service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dev.exception.CalculException;
import static org.assertj.core.api.Assertions.*;


public class CalculServiceTest {
	
	private static final Logger LOG = LoggerFactory.getLogger(CalculServiceTest.class);
	
	@Test
	public void testAdditionner() throws Exception{
		
		LOG.info("Etant donné, une instance de la classe CalculService");
		
		CalculService service = new CalculService();
		
		
		LOG.info("Lorsque j'évalue l'addition de l'expression 1+3+4");
		
		int result = service.additionner("1+3+4");
		
		int somme = 8;
		
		LOG.info("Alors j'obtiens le resultat 8");
		//version avec assertion junint
		//assertTrue("bien non passant", result == somme);
		
		//version avec assertj
		assertThat(somme).isEqualTo(8);
	}
	
	@Test(expected = CalculException.class)
	public void testAdditionnerInvalidExpression() throws CalculException {
		
		CalculService service = new CalculService();
		
		service.additionner("1-3-4");
		
	}
}
