package dev.exception;

public class CalculException extends Exception{
	
	public CalculException(){		
	}
	
	public CalculException(String expression){
		
		super ("L'expression "+expression+" est invalide");
	}
}
