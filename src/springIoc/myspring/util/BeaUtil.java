package springIoc.myspring.util;

import java.lang.reflect.Method;

/**
 * 
 * Title: BeaUtil.java
 * Description: 
 * @author chengge
 * @date 2018年5月23日
 *
 */
public class BeaUtil {
	
	/**
	 * 
	 * Title: getSetterMethod
	 * Description: 获取obj类的name属性的setter方法 
	 * @time 2018年5月23日 下午5:07:46
	 * @param obj
	 * @param name
	 * @return
	 */
	
	public static Method getSetterMethod(Object obj,String name) {
		Method method=null;
		name="set"+name.substring(0,1).toUpperCase()+name.substring(1);
		
		try {
			Method[] methods=obj.getClass().getMethods();
			//遍历该类的所有的方法
			for (int i = 0; i < methods.length; i++) {
				Method m=methods[i];
				if (m.getName().equals(name)) {
					method=obj.getClass().getMethod(name, m.getParameterTypes());
					break;
				}
			}
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
		System.out.println(name +"的setter方法:"+method.toString());
		return method;
	}

}
