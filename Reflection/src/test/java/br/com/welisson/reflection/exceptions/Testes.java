package br.com.welisson.reflection.exceptions;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Assert;
import org.junit.Test;


public class Testes {
	
	@Test
	public void verificandoExceptionLancadaPeloMetodoInvocado() throws Exception{
		
		TesteErros obj = new TesteErros();
		Class<?> clazz = obj.getClass();

		Method m = clazz.getMethod("metodo", String.class);

		try {
			m.invoke(obj, "Teste");
		} catch (InvocationTargetException e) {// a exeção correta é a que esta
											   // dentro da
											   // InvocationTargetException
			
			Assert.assertEquals(RuntimeException.class, e.getTargetException().getClass());
		}
		
	}
	
}
