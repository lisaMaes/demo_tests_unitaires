package dev.console;
import dev.exception.CalculException;
import dev.service.CalculService;
import dev.service.CalculServiceTest;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class AppTest {
	
	@Rule
	public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

	private App app;
	private CalculService calculService;
	
	private static final Logger LOG = LoggerFactory.getLogger(CalculServiceTest.class);

	
	@Before
	//avant import de mockito
//	public void setUp() throws Exception {
//		
//		this.calculService = new CalculService();
//		this.app = new App(new Scanner(System.in), calculService);
//	}
	public void setUp() throws Exception { 
	
		Scanner sc = new Scanner(System.in); this.calculService = mock(CalculService.class);
		this.app = new App(sc, calculService);
	}
	@Test
	public void testEvaluer() throws Exception {
		
		LOG.info("Etant donné, un service CalculService qui retourne 35 à l'évaluation de l'expression 1+34");
		
		String expression = "1+34";
		
		when(calculService.additionner(expression)).thenReturn(35);
		
		LOG.info("Lorsque la méthode evaluer est invoquée");
		
		this.app.evaluer(expression);
		
		LOG.info("Alors le service est invoqué avec l'expression {}", expression);
		
		verify(calculService).additionner(expression);
		
		LOG.info("Alors dans la console, s'affiche 1+34=35");
		
		assertThat(systemOutRule.getLog()).contains("1+34=35");
	}

	@Test
	public void testAfficherTitre() throws Exception {
		
		this.app.afficherTitre();
		
		String logConsole = systemOutRule.getLog();
		
		assertThat(logConsole).contains("**** Application Calculatrice ****");
	}
	
	@Test
	public void testAdditionnerInvalidExpression() throws CalculException {
		

		String expression = "1-34";
		
		when(calculService.additionner(expression)).thenThrow(new CalculException(expression));
		
		this.app.evaluer(expression);
		
		verify(calculService).additionner(expression);
		
		String logConsole = systemOutRule.getLog();
		
		assertThat(logConsole).contains("L'expression "+expression+" est invalide");
		
	}
}