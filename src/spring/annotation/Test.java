package spring.annotation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test {
	
	public static void main(String[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		AttachEmlement emlement=new AttachEmlement();//初始化一个实例
		Method[] methods=AttachEmlement.class.getDeclaredMethods();//获取AttachElement的所有的方法
		
		for (Method method : methods) {
			AttachAnnotation annotation=null;
			System.out.println("method.getAnnotation(AttachAnnotation.class):"+method.getAnnotation(AttachAnnotation.class));
			if ((annotation=method.getAnnotation(AttachAnnotation.class))!=null) {
				method.invoke(emlement, annotation.paramValue());
			}else {
				method.invoke(emlement, "广州");
			}
		}
	}

}
