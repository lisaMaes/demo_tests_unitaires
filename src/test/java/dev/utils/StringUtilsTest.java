package dev.utils;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

/**
 * Classe de test !
 * @author Diginamic
 *
 */

//Sert à mettre en place l'utilisation des  paramètres de tests
@RunWith(Parameterized.class)
public class StringUtilsTest {

	//Tableau de parmetre a passer dans le premier test
	@Parameters
	public static Collection<Object[]> datas(){
		
		List<Object[]> datas = new ArrayList<Object[]>();
		datas.add(new Object[]{"Chien","Chine", 2});
		datas.add(new Object[]{"distance","instance", 2});
		datas.add(new Object[]{"Chien","Chiot", 2});
		datas.add(new Object[]{"Chien","Choix", 3});
		datas.add(new Object[]{"Chienne","Chine", 2});
	
		
		return datas;
	}
	
	//Definition des paramètres a réutiliser dans les test  
	@Parameter public String string1;
	@Parameter (value=1) public String string2;
	@Parameter (value=2) public int entier;
	
	
	@Test
	public void testLevenshteinDistance(){
		
		int result = StringUtils.levenshteinDistance(string1, string2);
		
		assertEquals("je dois obtenir "+entier, entier, result);
	}
	

	//Test attendant une nullPointerException
	
	@Test(expected = NullPointerException.class)
	public void testLevenshteinDistanceIfNull(){
		
		int result = StringUtils.levenshteinDistance("", "pinson");	

	}
	
	
}
