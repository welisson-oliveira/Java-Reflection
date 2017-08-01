package br.com.welisson.reflection.acessandoAtributos;

import static org.hamcrest.CoreMatchers.equalTo;

import org.junit.Assert;
import org.junit.Test;

public class AcessandoAtributosTest {
	
	@Test
	public void gerarXMLViaReflection() throws Exception{
		Usuario u = new Usuario();
		u.setLogin("login");
		u.setSenha("senha");
		u.setEmail("email");
		u.setPapel("papel");
		u.setAtivo("ativo");
		
		String xml = GeradorXML.getXML(u);
		String modelo = "<Usuario>\n"+
						"<login>login</login>\n"+
						"<senha>senha</senha>\n"+
						"<email>email</email>\n"+
						"<papel>papel</papel>\n"+
						"<ativo>ativo</ativo>\n"+
						"</Usuario>\n";

		Assert.assertThat(xml, equalTo(modelo));
		
	}
	
}
