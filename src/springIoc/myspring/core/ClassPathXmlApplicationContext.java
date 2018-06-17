package springIoc.myspring.core;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import springIoc.myspring.bean.Bean;
import springIoc.myspring.bean.Property;
import springIoc.myspring.util.BeaUtil;
import springIoc.myspring.util.XmlConfig;

/**
 * 
 * Title: ClassPathXmlApplicationContext.java
 * Description: 实现beanFactory接口，初始化IOC容器，生成的对象放入该容器中
 * @author chengge
 * @date 2018年5月23日
 *
 */
public class ClassPathXmlApplicationContext implements BeanFactory {

	//定义一个IOC容器
	private Map<String, Object> ioc;
	
	private Map<String, Bean> config;
	
	/**
	 * 构造函数
	 * 1. 初始化IOC容器
	 * 2. 加载配置文件，生成Bean对象放入IOC容器
	 */
	public ClassPathXmlApplicationContext(String path) {
		//初始化IOC容器
		ioc=new HashMap<String, Object>();
		//读取配置文件
		config=XmlConfig.getConfig(path);
		if (config!=null) {
			for (Entry<String, Bean> entry: config.entrySet()) {
				String beanid=entry.getKey();
				Bean bean=entry.getValue();
				
				//根据bean生成相应的对象
				Object object=createBean(bean);
				ioc.put(beanid, object);
			}
		}
		
	}
	
	/**
	 * 
	 * Title: createBean
	 * Description: 根据bean生成相应的对象 
	 * @time 2018年5月23日 下午4:46:14
	 * @param bean
	 * @return
	 */
	private Object createBean(Bean bean) {
		String beanid=bean.getId();
		String className=bean.getClassName();//获取要生成的类名
		
		Class c=null;
		Object object=null;
		
		try {
			//根据bean的class属性生成对象
			c=Class.forName(className);//返回与带有给定字符串名的类或接口相关联的 Class 对象
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("您配置的class属性不合法："+className);
		}
		
		try {
			//该方法调用的是类的无参构造方法
			object=c.newInstance();
			//newInstance实际上是把new这个方式分解为两步,即，首先调用class的加载方法(forName())加载某个类，然后实例化。 
		} catch (Exception e) {
			throw new RuntimeException("该类缺少一个无参构造方法："+className);
		}
		//以上是实例化
		
		//以下是依赖注入，Spring的依赖注入使用的是类的反射机制
		//所谓的依赖注入就是通过spring将bean所需要的一些参数传递到bean实例对象的过程
		//将bean的属性封装到对象中
		if (bean.getProperties()!=null) {
			for(Property p:bean.getProperties()) {
				//情况一：配置文件使用的是value属性注入
				if (p.getValue()!=null) {
					//获取属性的对应的setter方法
					Method getMethod=BeaUtil.getSetterMethod(object, p.getName());
					try {
						//调用setter方法注入
						getMethod.invoke(object, p.getValue());
					} catch (Exception e) {
						throw new RuntimeException("属性名称不合法，或者没有相应的getter方法！");
					}
				}
				//情况二：配置文件中使用的是ref属性注入
				if (p.getRef()!=null) {
					//获取属性对应的setter方法
					Method getMethod=BeaUtil.getSetterMethod(object, p.getName());
					//从容器中找到依赖的对象
					Object obj=ioc.get(p.getRef());
					if (obj==null) {
						throw new RuntimeException("没有找到依赖的对象："+p.getRef());
					}else {
						//调用set方法注入
						try {
							getMethod.invoke(object, obj);
						} catch (Exception e) {
							throw new RuntimeException("属性名称不合法或者没有相应的get方法");
						}
					}
					
				}
				
			}
		}
		
		return object;
	}




	@Override
	public Object getBean(String beanName) {
		return ioc.get(beanName);//返回对应的对象
	}

}
