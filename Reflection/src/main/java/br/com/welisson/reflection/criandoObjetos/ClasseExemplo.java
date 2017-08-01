package br.com.welisson.reflection.criandoObjetos;

public class ClasseExemplo implements InterfaceExemplo {
	private String s = "";
	
	public ClasseExemplo(String s) {
		this.s = s;
	}
	
	public ClasseExemplo(){
		super();
	}
	
	public String getS(){
		return s;
	}

}
