package com.hoyotech.prison.util;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.Date;

import org.apache.commons.beanutils.PropertyUtils;

public class ObjectUpdateUtil {
	
	/**
	 * 比较同类型对象实例的属性。新对象属性为空的，不更新到旧对象；不为空的，则更新到旧对象。
	 * 修改时调用
	 * @param newObj
	 * @param oldObj
	 */
	public static void compareProperty(Object newObj, Object oldObj) {
		try {
			if( newObj == null || oldObj == null){
				System.out.println("null object");
				return;
			}
			
			if(!(newObj.getClass().equals(oldObj.getClass()))){
				System.out.println("error object type#" +  newObj.getClass() + "-" + oldObj.getClass());
				return;
			}
			Class c = newObj.getClass();
			Field field[] = c.getDeclaredFields();
			
			for (Field f : field) {
				String fName = f.getName();
				Object obj = PropertyUtils.getProperty(newObj, fName);
				//System.out.println(fName+":"+nobj);
				if(obj != null){
					PropertyUtils.setProperty(oldObj, fName, obj);
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 判断引用的对象是否有实际意义，没有实际意义就返回null。
	 * @param obj
	 * @return
	 */
	public static Object checkObject(Object obj){
		try {
			if(obj != null){
				Object value = PropertyUtils.getProperty(obj, "id");
				//System.out.println("id:"+value);
				if(value == null || "".equals(value) || value.toString().equals("0")){
					obj = null;
				}
			}
		} catch (Exception e) {
//			e.printStackTrace();
			return null;
		}
		return obj;
	}
	
	/**
	 * 检查对象的属性引用的对象，解决外键引用的异常
	 * @param obj
	 */
	public static void checkProperty(Object obj){
		Class clazz = obj.getClass();
		Field[] field = clazz.getDeclaredFields();
		
		for (int i = 0; i < field.length; i++) {
			Class parameterType = field[i].getType();
//			System.out.println(parameterType+"------"+parameterType.getName());
			if(parameterType.isPrimitive()
					|| parameterType.isInterface()
					|| parameterType.equals(Integer.class)
					|| parameterType.equals(String.class) 
					|| parameterType.equals(Date.class) || parameterType.equals(BigDecimal.class)){
				
				continue;
			}else{
//				System.out.println(parameterType.toString());
				try {
					//Object value = field[i].get(obj);
					Object value = PropertyUtils.getProperty(obj, field[i].getName());
					if(value != null){
						Object newObj = checkObject(value);
//						System.out.println(field[i].getName()+"---------"+value+"+++++++"+newObj);
						PropertyUtils.setProperty(obj, field[i].getName(), newObj);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void main(String[] args) {

	}
}
