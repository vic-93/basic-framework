package cn.cooperlink.framework.core.bean;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.cooperlink.framework.core.BaseEntity;
import cn.cooperlink.util.StringUtil;


public class ValueObject extends BaseEntity{
	
	
	private static final long serialVersionUID = 2862603023079464024L;
	
	
	private Map<String, Method> getterMap;
	private Map<String, Method> setterMap;
	private Map<String, Class<?>> typeMap;
	
	private Map<String, Object> valueMap = new HashMap<String, Object>();
	/**
	 * 通过Key-Value的方式设置属性
	 * @param key
	 * @param value
	 */
	public void setProperty(String key, Object value) {
		if (setterMap == null) {
			this.initProperties();
		}
		if (StringUtil.isBlank(key)) {
			return;
		}
		String setterMethodName = "set" + key.substring(0, 1).toUpperCase() + key.substring(1);
		Method setterMethod = setterMap.get(setterMethodName);
		
		if (setterMethod == null) {
			valueMap.put(key, value);
			if (value != null)
				typeMap.put(key, value.getClass());
			return;
		}
		try {
			setterMethod.invoke(this, new Object[]{value});
		} catch (IllegalArgumentException e) {
			System.out.println("参数格式不正确");
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}
	
	public Object getProperty(String key) {
		if (getterMap == null) {
			this.initProperties();
		}
		if (StringUtil.isBlank(key)) {
			return null;
		}
		String getterMethodName = "get" + key.substring(0, 1).toUpperCase() + key.substring(1);
		Method getterMethod = getterMap.get(getterMethodName);
		if (getterMethod == null) {
			return this.valueMap.get(key);
		} 
		try {
			Object value = getterMethod.invoke(this, new Object[0]);
			return value;
		} catch (IllegalArgumentException e) {
			System.out.println("参数格式不正确");
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Class<?> getType(String key) {
		if (this.typeMap == null) {
			this.initProperties();
		}
		if (StringUtil.isBlank(key)) {
			return null;
		}
		return this.typeMap.get(key);
	}
	
	public List<String> getFieldNames() {
		if (this.typeMap == null) {
			this.initProperties();
		}
		List<String> fieldNames = new ArrayList<String>();
		fieldNames.addAll(this.typeMap.keySet());
		fieldNames.addAll(this.valueMap.keySet());
		return fieldNames;
	}
	
	private void initProperties() {
		if (setterMap == null) {
			setterMap = new HashMap<String, Method>();
		}
		if (getterMap == null) {
			getterMap = new HashMap<String, Method>();
		}
		if (typeMap == null) {
			typeMap= new HashMap<String, Class<?>>();
		}
		Method[] methods = this.getClass().getDeclaredMethods();
		for (Method method : methods) {
			String methodName = method.getName();
			if (methodName.startsWith("set")) {
				setterMap.put(methodName, method);
			} else if (methodName.startsWith("get")) {
				getterMap.put(methodName, method);
			}
		}
		
		Field[] fields = this.getClass().getDeclaredFields();
		
		for (Field field : fields) {
			
			String fieldName = field.getName();
			if ("serialVersionUID".equals(fieldName)) {
				continue;
			}
			if ("getterMap".equals(fieldName)) {
				continue;
			}
			if ("setterMap".equals(fieldName)) {
				continue;
			}
			if ("typeMap".equals(fieldName)) {
				continue;
			}
			if ("valueMap".equals(fieldName)) {
				continue;
			}
			typeMap.put(fieldName, field.getType());
		}
	}
	
}
