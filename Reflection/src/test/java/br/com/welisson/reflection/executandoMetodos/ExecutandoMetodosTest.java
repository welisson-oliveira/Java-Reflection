package br.com.welisson.reflection.executandoMetodos;

import org.junit.Assert;
import org.junit.Test;

public class ExecutandoMetodosTest {
	
	@Test
	public void usuarioValido() throws Exception {
		Usuario u = new Usuario();
		u.setSenha("senhasenha");
		u.setEmail("email");
		u.setLogin("loginMuitoGrande");
		
		boolean valido = Validador.validarObjeto(u);
		
		Assert.assertTrue(!valido);
		
	}
	
	@Test
	public void usuarioInvalido() throws Exception{
		Usuario u = new Usuario();
		u.setSenha("senhasenha");
		u.setEmail("email@");
		u.setLogin("loginOk");
		
		boolean valido = Validador.validarObjeto(u);
		
		Assert.assertTrue(valido);
	}
}
