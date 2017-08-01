package br.com.welisson.reflection.criandoObjetos;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class Mapeador {
	
	private Map<Class<?>, Class<?>> mapa;
	
	public Mapeador() {
		mapa = new HashMap<Class<?>, Class<?>>();
	}
	
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
				System.err.println("A classe "+impl.getName()+" não implementa a Interface "+interf.getName());
			}else{
				mapa.put(interf, impl);
			}
		}
	}
	
	public Class<?> getImplementacao(Class<?> interf){
		return mapa.get(interf);
	}
	
	@SuppressWarnings("unchecked")
	public <E> E getInstancia(Class<E> interf) throws InstantiationException, IllegalAccessException{
		return ((E) mapa.get(interf).newInstance());
	}
	
	@SuppressWarnings("unchecked")
	public <E> E getInstancia(Class<E> interf, Object... params) throws Exception{
		Class<?> impl = mapa.get(interf);
		Class<?>[] tiposConstrutor = new Class<?>[params.length];
		//necessario pegar o tipo dos parametros
		for(int i =0; i < tiposConstrutor.length; i++){
			tiposConstrutor[i] = params[i].getClass();
		}
		Constructor<?> c = impl.getConstructor(tiposConstrutor);
		return ((E) c.newInstance(params));
	}
}
