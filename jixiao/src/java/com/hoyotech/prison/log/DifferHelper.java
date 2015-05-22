package com.hoyotech.prison.log;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.beanutils.PropertyUtils;

public class DifferHelper {
	private static final String LINE_SEPERATOR = System.getProperty("line.separator");

	public String diffValues(Object n, Object o) {
		if (n == null && o == null) {
			System.out.println("null object both");
			return "";
		}
		if (n == null && o != null) {
			return "执行删除操作，" + this.showSingleObjectValues(o);
		}
		if (n != null && o == null) {
			return "执行新增操作，" + this.showSingleObjectValues(n);
		}

		if (!(n.getClass().equals(o.getClass()))) {
			System.out.println("error object type#" + n.getClass() + "-" + o.getClass());
			return "";
		}
		Class<?> c = n.getClass();
		Field field[] = c.getDeclaredFields();
		StringBuffer sb = new StringBuffer();
		sb.append("执行修改操作，");
		for (Field f : field) {
			PropertyName pName = f.getAnnotation(PropertyName.class);
			if (pName == null) {
				continue;
			}
			
			Class<?> parameterType = f.getType();
			String fName = f.getName();
			String aName = pName.name();
			String value1 = "";
			String value2 = "";
			
			if(parameterType.isPrimitive() || parameterType.equals(Integer.class) || parameterType.equals(String.class)){
				
				value1 = this.invokeMethod(n, fName);
				value2 = this.invokeMethod(o, fName);
				
			}else if(parameterType.equals(Date.class)){
				try {
					Object obj1 = PropertyUtils.getProperty(n, fName);
					Object obj2 = PropertyUtils.getProperty(o, fName);
					
					SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					value1 = format.format(obj1);
					value2 = format.format(obj2);
				} catch (Exception e) { }
			
			}else{
				try {
					Object obj1 = PropertyUtils.getProperty(n, fName);
					Object obj2 = PropertyUtils.getProperty(o, fName);
					value1 = obj1 != null?checkObjectId(obj1):"";
					value2 = obj2 != null?checkObjectId(obj2):"";
				} catch (Exception e) { }
			}
			
			if (isEquals(value1, value2)) {
				continue;
			}
			sb.append("属性[").append(aName).append("]:由'").append(value2).append("'修改为:'").append(value1).append("'").append(LINE_SEPERATOR);
		}
		return sb.toString();
	}

	private String showSingleObjectValues(Object obj) {
		if (obj == null) {
			//System.out.println("null object both");
			return null;
		}

		StringBuffer sb = new StringBuffer();
		Class<?> c = obj.getClass();
		Field field[] = c.getDeclaredFields();
		for (Field f : field) {
			PropertyName pName = f.getAnnotation(PropertyName.class);
			if (pName == null) {
				continue;
			}
			Class<?> parameterType = f.getType();
			String fName = f.getName();
			String aName = pName.name();
//			System.out.println(aName+"\t"+parameterType.getName());

			if(parameterType.isPrimitive() || parameterType.equals(Integer.class) || parameterType.equals(String.class)){
				// 基本数据类型、字符串、整型
				String value = this.invokeMethod(obj, fName);
				if (value == null || "".equals(value)) {
					continue;
				}
				sb.append("属性[").append(aName).append("]:'").append(value).append("'");
			
			}else if(parameterType.equals(Date.class)){
				// 将日期类型的值格式化
				try {
					Object obj1 = PropertyUtils.getProperty(obj, fName);
					if (obj1 == null) {
						continue;
					}
					SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					String value = format.format(obj1);
					sb.append("属性[").append(aName).append("]:'").append(value).append("'");
					
					sb.append(LINE_SEPERATOR);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}else{
				try {
//					System.out.println(parameterType.getName());
					Object obj1 = PropertyUtils.getProperty(obj, fName);
					if (obj1 == null) {
						continue;
					}				
					String value = showSingleObjectValues(obj1);
//					System.out.println(value);
					sb.append("属性["+aName+"]:'"+value+"'");
					
					sb.append(LINE_SEPERATOR);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return sb.toString();
	}
	
	
	/**
	 * 获取引用的对象的ID
	 * @param obj
	 * @return
	 */
	public String checkObjectId(Object obj){
		String returnValue = null;
		try {
			if(obj != null){
				Object value = PropertyUtils.getProperty(obj, "id");
				//System.out.println("id:"+value);
				if(value == null || value.toString().equals("0")){
					returnValue = null;
				}else{
					returnValue = "ID':'"+value.toString();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return returnValue;
	}

	private boolean isEquals(String value1, String value2) {

		if (value1 == null && value2 == null) {
			return true;
		} else {
			return value1.equals(value2);
		}

	}

	public String invokeMethod(Object owner, String field) {
		String value = "";
		try {
			Object obj = PropertyUtils.getProperty(owner, field);
			value = (obj == null) ? "" : obj.toString();
		} catch (Exception e) {
			e.printStackTrace();
			return " can't get " + field + " value";
		}
		return value;
	}

	public static void main(String[] args) {// 测试

	}

}
