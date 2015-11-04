package com.cube.util;

import java.lang.reflect.Field;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;


import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.util.Assert;

/**
 * 访问在当前类声明的private/protected成员变量及private/protected函数的BeanUtils.
 * 注意,因为必须为当前类声明的变量,通过继承获得的protected变量将不能访问, 需要转型到声明该变量的类才能访问. 反射的其他功能请使用Apache
 * Jarkarta Commons BeanUtils
 */
public class BeanUtil {
	private static final Logger log = Logger.getLogger(BeanUtil.class);   
	/**
	 * 获取当前类声明的private/protected变量
	 */
	public static Object getPrivateProperty(Object object, String propertyName)
			throws IllegalAccessException, NoSuchFieldException {
		Assert.notNull(object);
		Assert.hasText(propertyName);
		Field field = object.getClass().getDeclaredField(propertyName);
		field.setAccessible(true);
		return field.get(object);
	}

	/**
	 * 设置当前类声明的private/protected变量
	 */
	public static void setPrivateProperty(Object object, String propertyName,
			Object newValue) throws IllegalAccessException,
			NoSuchFieldException {
		Assert.notNull(object);
		Assert.hasText(propertyName);

		Field field = object.getClass().getDeclaredField(propertyName);
		field.setAccessible(true);
		field.set(object, newValue);
	}

	/**
	 * 调用当前类声明的private/protected函数
	 */
	public static Object invokePrivateMethod(Object object, String methodName,
			Object[] params) throws NoSuchMethodException,
			IllegalAccessException, InvocationTargetException {
		Assert.notNull(object);
		Assert.hasText(methodName);
		Class[] types = new Class[params.length];
		for (int i = 0; i < params.length; i++) {
			types[i] = params[i].getClass();
		}
		Method method = object.getClass().getDeclaredMethod(methodName, types);
		method.setAccessible(true);
		return method.invoke(object, params);
	}

	/**
	 * 调用当前类声明的private/protected函数
	 */
	static public Object invokePrivateMethod(Object object, String methodName,
			Object param) throws NoSuchMethodException, IllegalAccessException,
			InvocationTargetException {
		return invokePrivateMethod(object, methodName, new Object[] { param });
	}
	
	 /**  
	  * 从request中获取值填充bean对象  
	  *  
	  * @param objClass bean的类  
	  * @param request 请求对象  
	  * @return object对象  
	  */  
	 public static Object fillBean(Class objClass, HttpServletRequest request) throws Exception {   
	     Object objInstance = null;   
	     try {   
	         objInstance = objClass.newInstance();   
	     } catch (InstantiationException e1) {   
	         log.error(e1.getMessage(), e1);  
	         throw new Exception(e1);
	     } catch (IllegalAccessException e1) {   
	         log.error(e1.getMessage(), e1);
	         throw new Exception(e1);
	     }   

	     Field field;   
	     String fieldName;   
	     String fieldValue = "";   
	     int len;   
	     len = objClass.getDeclaredFields().length;   
	     for (int i = 0; i < len; i++) {   
	         field = objClass.getDeclaredFields()[i];   
	         fieldName = field.getName();   

	         try {   
	             fieldValue = request.getParameter(fieldName);   
	         } catch (Exception e1) {   
	             log.error(e1.getMessage(), e1);
	             throw new Exception(e1);
	         }   

	         if (StringUtils.isNotBlank(fieldValue)) {   
	             try {   
	                 setFieldValue(field, objInstance, fieldValue);   
	             } catch (IllegalAccessException e) {   
	                 log.error(e.getMessage(), e);
	                 throw new Exception(e);
	             }   
	         }   
	     }   
	     objClass = objClass.getSuperclass();   
	     return objInstance;   
	 }   

	 /**  
	  * 将数据赋值给指定对象的相应属性  
	  *  
	  * @param field 字段  
	  * @param objInstance 指定对象  
	  * @param value 数据  
	  * @throws IllegalAccessException  
	  */  
	 private static void setFieldValue(Field field, Object objInstance, String value) throws Exception {   
	     String fieldType = field.getType().getName();// 取字段的数据类型   
	     field.setAccessible(true);   
	     try {   
	         if (fieldType.equals("java.lang.String")) {   
	             field.set(objInstance, value);   
	         } else if (fieldType.equals("java.lang.Integer") || fieldType.equals("int")) {   
	             field.set(objInstance, Integer.valueOf(value));   
	         } else if (fieldType.equals("java.lang.Long") || fieldType.equals("long")) {   
	             field.set(objInstance, Long.valueOf(value));   
	         } else if (fieldType.equals("java.lang.Float") || fieldType.equals("float")) {   
	             field.set(objInstance, Float.valueOf(value));   
	         } else if (fieldType.equals("java.lang.Double") || fieldType.equals("double")) {   
	             field.set(objInstance, Double.valueOf(value));   
	         } else if (fieldType.equals("java.math.BigDecimal")) {   
	             field.set(objInstance, new BigDecimal(value));   
	         } else if (fieldType.equals("java.util.Date")) {   
	             SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");   
	             formatter.setLenient(false);   
	             field.set(objInstance, formatter.parse(value));   
	         } else if (fieldType.equals("java.sql.Date")) {   
	             SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");   
	             formatter.setLenient(false);   
	             Date date = formatter.parse(value);   
	             field.set(objInstance, new java.sql.Date(date.getTime()));   
	         } else if (fieldType.equals("java.lang.Boolean") || fieldType.equals("boolean")) {   
	             field.set(objInstance, Boolean.valueOf(value));   
	         } else if (fieldType.equals("java.lang.Byte") || fieldType.equals("byte")) {   
	              field.set(objInstance, Byte.valueOf(value));   
	          } else if (fieldType.equals("java.lang.Short") || fieldType.equals("short")) {   
	              field.set(objInstance, Short.valueOf(value));   
	          }   
	      } catch (NumberFormatException ex) {   
	          // field.set(objInstance, null); 当使用简单数据类型会抛出异常   
	          log.error(ex.getMessage(), ex);
	          throw new Exception(ex);
	      } catch (ParseException e) {   
	          log.error(e.getMessage(), e);      
	          field.set(objInstance, null);
	          throw new Exception(e);
	      } catch (Exception e) {   
	          log.error(e.getMessage(), e);      
	          field.set(objInstance, null);
	          throw new Exception(e);
	      }   
	  }   

}
