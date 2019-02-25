package dev.service;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dev.exception.CalculException;


public class CalculService {
	
	private static final Logger LOG = LoggerFactory.getLogger(CalculService.class);

	
	public int additionner(String expression) throws CalculException{

		int result = 0;
		
		//TODO Ajouter un log en niveau DEBUG affichant "Evaluation de l'expression <expression>".

		//TODO par exemple "Evaluation de l'expression 1+4"
		
		LOG.debug("Evaluation de l'expression "+ expression);
		
		//Pattern PATTERN_INTEGER = Pattern.compile("[0-9\\+]+");
		boolean b = Pattern.matches("[0-9\\+]+",expression);
		
		if(b == false){
			throw new CalculException(expression);
		}
		
		//List<String> resultList = Splitter.on('+');
		List<String> items = Arrays.asList(expression.split("\\s*+\\s*"));

		for (String i: items){
			
			if(!i.equals("+")){
				System.out.println(i);
				int nb = Integer.parseInt(i);
				
				result = result+nb;
			}

		}
		System.out.println(result);
		return result;

		}

}
