package springIoc.myspring.test;

import java.util.Map;
import java.util.Map.Entry;

import springIoc.myspring.bean.Bean;
import springIoc.myspring.bean.Student;
import springIoc.myspring.bean.User;
import springIoc.myspring.core.BeanFactory;
import springIoc.myspring.core.ClassPathXmlApplicationContext;
import springIoc.myspring.util.XmlConfig;

public class Test01 {

	public static void main(String[] args) {
		//testConfig();
		testIoc();
	}
	
	/**
	 * 测试IOC容器
	 */
	private static void testIoc() {
		BeanFactory beanFactory=new ClassPathXmlApplicationContext("/ApplicationContext.xml");
		
		User user=(User) beanFactory.getBean("user");//实现了实例化和依赖注入
		System.out.println(user.getUserName());
		System.out.println("address hashcode:"+user.getAddress().hashCode());
		user.setUserName("hery");
		System.out.println("2:"+user.getUserName());
		Student student=(Student) beanFactory.getBean("student");//仅仅实现了实例化，并没有实现依赖注入
		System.out.println("student:"+student);
		student.setClassname("2班");
		student.setScore(99);
		student.setStuno("0001");
		System.out.println("student-info:"+student);
	}
	
	/**
	 * 测试读取配置文件
	 */
	private static void testConfig() {
		Map<String, Bean> map=XmlConfig.getConfig("/ApplicationContext.xml");
		for(Entry<String, Bean> entry:map.entrySet()) {
			System.out.println(entry.getKey()+"==="+entry.getValue());
		}
	}

}
