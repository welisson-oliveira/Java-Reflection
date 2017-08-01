package br.com.welisson.reflection.carregandoClassesDinamicamente;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class Mapeador {
	
	private Map<Class<?>, Class<?>> mapa = new HashMap<Class<?>, Class<?>>();
	
	public void load(String nomeArquivo) throws FileNotFoundException, IOException, ClassNotFoundException{
		Properties p = new Properties();
		p.load(new FileInputStream(nomeArquivo));
		for(Object key : p.keySet()){
			Class<?> interf = Class.forName(key.toString());
			Class<?> impl = Class.forName(p.get(key).toString());
			
			if(!interf.isInterface()){
				throw new RuntimeException("O tipo "+interf.getName()+ " não é uma Interface.");
			}
			
			if(!interf.isAssignableFrom(impl)){
				throw new RuntimeException("A classe "+impl.getName()+" não implementa a Interface "+interf.getName());
			}
			mapa.put(interf, impl);
		}
	}
	
	public Class<?> getImplementacao(Class<?> interf){
		return mapa.get(interf);
	}
}
