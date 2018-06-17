package springaop.myspring.test;

import org.junit.Test;

import springaop.myspring.core.BeanFactory;
import springaop.myspring.core.ClassPathXmlApplicationContext;
import springaop.myspring.dao.UserDao;

public class TestProxy {
	
	@Test
	public void testJDKProxy(){
		BeanFactory ac = new ClassPathXmlApplicationContext("/applicationContext.xml");
		UserDao userDao = (UserDao) ac.getBean("userDaoProxy");
		System.out.println(userDao.getClass());
		userDao.add("Jason");
		String user = userDao.getUser("132");
		System.out.println(user);
	}
}
