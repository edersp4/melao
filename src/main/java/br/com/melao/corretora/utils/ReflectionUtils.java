package br.com.melao.corretora.utils;

import java.lang.reflect.Field;

public class ReflectionUtils {

	public ReflectionUtils() {
	}

	public static void nullifyStrings(Object object) {
		for (Field f : object.getClass().getDeclaredFields()) {
			f.setAccessible(true);

			try {
				if (f.getType().equals(String.class)) {
					String value = (String) f.get(object);
					if (value != null && value.trim().isEmpty()) {
						f.set(object, null);
					}

				}
			} catch (Exception e) {
				throw new RuntimeException();
			}
		}
	}

}
