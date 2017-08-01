package br.com.welisson.reflection.executandoMetodos;

public class Run {

	public static void main(String[] args) throws Exception {
		Usuario u = new Usuario();
		u.setSenha("senhasenha");
		u.setEmail("email");
		u.setLogin("loginMuitoGrande");
		
		boolean valido = Validador.validarObjeto(u);
		
		if(valido){
			System.out.println("O objeto é valido");
		}else{
			System.out.println("O objeto é invalido");
		}
		
		Usuario u2 = new Usuario();
		u2.setSenha("senhasenha");
		u2.setEmail("email@");
		u2.setLogin("loginOk");
		
		boolean valido2 = Validador.validarObjeto(u2);
		
		if(valido2){
			System.out.println("O objeto é valido");
		}else{
			System.out.println("O objeto é invalido");
		}
		
	}

}
