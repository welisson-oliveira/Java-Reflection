package br.com.welisson.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class Exercicios {
	private Map<Class<?>, Class<?>> mapa = new HashMap<Class<?>, Class<?>>();

	public Class<?> getClass(String key) throws ClassNotFoundException {
		return mapa.get(Class.forName(key));
	}

	public Object getObject(String key) throws Exception {

		return getClass(key).newInstance();
	}

	public Object getObject(String key, Object[] params) throws Exception {

		Class<?> clazz = getClass(key);
		Class<?>[] tipeParams = new Class<?>[params.length];
		int i = 0;
		for (Object p : params) {
			tipeParams[i++] = p.getClass();
		}
		Constructor<?> constructor = clazz.getConstructor(tipeParams);

		return constructor.newInstance(params);
	}
	//invokation
	public Map<String, Object> getAttributeValues(Object obj) throws Exception{
		Map<String, Object> values = new HashMap<String, Object>();
		
		Field[] fields = obj.getClass().getDeclaredFields();
		for(Field f : fields){
			f.setAccessible(true);
			values.put(f.getName(), f.get(obj));
		}
		
		return values;
		
	}
	
	public static boolean validarObjeto(Object obj) throws Throwable {
		boolean resultado = true;

		
		try {
			Class<?> clazz = obj.getClass();
			
			for (Method m : clazz.getDeclaredMethods()) {
				if (m.getName().startsWith("test") && m.getReturnType() == void.class
						&& m.getParameterTypes().length == 0) {
					Boolean retorno = (Boolean) m.invoke(obj);
					resultado = resultado && retorno.booleanValue();
				}
			}
			
		} catch (InvocationTargetException e) {
			throw e.getTargetException();
		}

		return resultado;
	}
}
