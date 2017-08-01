package br.com.welisson.reflection;

import org.junit.Assert;
import org.junit.Test;

import br.com.welisson.reflection.criandoObjetos.ClasseExemplo;
import br.com.welisson.reflection.criandoObjetos.InterfaceExemplo;
import br.com.welisson.reflection.criandoObjetos.Mapeador;

public class CriandoObjetosTest {
	
	@Test
	public void instancianoUmaClasseDeExemplo() throws  Exception{
		Mapeador m = new Mapeador();
		m.load("classes.properties");
		
		Object param = "Imprimir";
		InterfaceExemplo i = m.getInstancia(InterfaceExemplo.class, param );
		
		Assert.assertEquals(i.getS(), param);
		Assert.assertEquals(i.getClass(), ClasseExemplo.class);
		
	}
}
