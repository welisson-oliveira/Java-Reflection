package br.com.welisson.reflection.carregandoClassesDinamicamente;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

public class CarregandoClassesDinamicamenteTest {
	
	@Test
	public void carregarClasses() throws Exception {
		Mapeador m = new Mapeador();
		m.load("classes.properties");
		
		System.out.println(m.getImplementacao(List.class));
		System.out.println(m.getImplementacao(Map.class));
		
		Assert.assertEquals(m.getImplementacao(List.class), ArrayList.class);
		Assert.assertEquals(m.getImplementacao(Map.class), HashMap.class);
	}
	
}
