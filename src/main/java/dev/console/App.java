package dev.console;
import dev.exception.CalculException;
import dev.service.CalculService;
import dev.service.CalculServiceTest;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App {
	
	private Scanner scanner;	
	private CalculService calculatrice;
	
	private static final Logger LOG = LoggerFactory.getLogger(App.class);
	
	//constructeur de app
	public App(Scanner scanner, CalculService calculatrice) {
		
		this.scanner = scanner;
		this.calculatrice = calculatrice;
	}

	protected void afficherTitre() {
		LOG.info("**** Application Calculatrice ****");
	}
	//affiche le titre
	public void demarrer() {
		
		afficherTitre();
	}
	
	protected void evaluer(String expression) throws CalculException {
		
		int result = 0;
		
		try {
			
			result = calculatrice.additionner(expression);
			
		} catch (Exception e) {
			System.out.println(e);
		
			return;
		}

		
			System.out.println(expression+"="+result);
		
	
	}
}
