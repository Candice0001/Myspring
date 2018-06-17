package springIoc.myspring.core;

/**
 * 
 * Title: BeanFactory.java
 * Description: bean工厂接口
 * @author chengge
 * @date 2018年5月23日
 *
 */
public interface BeanFactory {
	
	Object getBean(String beanName);

}
